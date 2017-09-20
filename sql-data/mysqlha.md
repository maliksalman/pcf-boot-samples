# Testing with a MySQL Cluster

## Prerequisites

1. Installed docker
1. Access to public dockerhub images
1. A recent MySQL binary in `tar.gz` format

## MySQL cluster setup

With these instruction you can setup a MySQL cluster with one master node and one read-only slave node. Both of the nodes will be running inside a single docker container. This setup is **HIGHLY** insecure and only meant for testing. The nodes are available on the following ports:

 | Node   | Port  |
 |--------|:-----:|
 | Master | 28012 |
 | Slave  | 28013 |
 
 The username/password is `msandbox`/`msandbox` for connecting to this cluster.

## Create the MySQL cluster

1. Download a MySQL linux binary - in this example it is `mysql-5.5.57-linux-glibc2.12-x86_64.tar.gz` and is placed in a temp folder `/tmp/mysqlha`
1. Start the docker container:
```
docker run --rm -d --name mysqlha -p 28012:28012 -p 28013:28013 -v /tmp/mysqlha:/opt/mysql datacharmer/mysql-sb-base sleep infinity
```
3. Shell into container
```
docker exec -it mysqlha bash
```
4. Once inside the container, create the MySQL cluster:
```
make_replication_sandbox --remote_access='%' --how_many_slaves=1 /opt/mysql/mysql-5.5.57-linux-glibc2.12-x86_64.tar.gz
```

## Start/Stop cluster nodes

To start/stop the master node, run the following (inside the container):
```
sandboxes/rsandbox_mysql-5_5_57/master/start
sandboxes/rsandbox_mysql-5_5_57/master/stop
```
To start/stop the slave node, run the following (inside the container):
```
sandboxes/rsandbox_mysql-5_5_57/node1/start
sandboxes/rsandbox_mysql-5_5_57/node1/stop
```

## Testing with Sample app
This sample app can be used to add "person" records to the DB via REST endpoint. Also, there is a REST endpoint to list all the person records in the DB. See the [application-mysqlha.properties](src/main/resources/application-mysqlha.properties) for how to configure the MySQL driver to connect to MySQL cluster running in docker. Run the app with the `mysqlh` profile to accomplish this:

```
SPRING_PROFILES_ACTIVE=mysqlha mvn spring-boot:run
```
To add a couple of people:
```
curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"BruceWayne", "age":35}' --silent | jq .
curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"ClarkKent", "age":25}' --silent | jq .
```
To get the list of users:
```
curl -X GET "http://localhost:8080/person" --silent | jq .
```
One can bring the master node up/down in the docker container while testing with the above `curl` commands. The command to get list of people should always succeed even when the master node is down. Adding a person will only work when the master node is up since the salve node is running in readonly mode.
 
## Cleanup

To cleanup and remove the MySQL cluster, simply stop the container:

```
docker stop mysqlha
```