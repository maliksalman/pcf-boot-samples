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
1. Shell into container
```
docker exec -it mysqlha bash
```
1. Once inside the container, create the MySQL cluster:
```
make_replication_sandbox --remote_access='%' --how_many_slaves=1 /opt/mysql/mysql-5.5.57-linux-glibc2.12-x86_64.tar.gz
```

## Start/Stop cluster nodes

To start/stop the master node, run the following (inside the container):
```
sandboxes/rsandbox_mysql-5_5_57/master/start
sandboxes/rsandbox_mysql-5_5_57/master/stop
```
1. To start/stop the slave node, run the following (inside the container):
```
sandboxes/rsandbox_mysql-5_5_57/node1/start
sandboxes/rsandbox_mysql-5_5_57/node1/stop
```

## Starting the app
Run the app with the `mysqlh` profile to connect with this MySQL cluster:
```
SPRING_PROFILES_ACTIVE=mysqlha mvn spring-boot:run
```

## Cleanup

To cleanup and remove the MySQL cluster, simply stop the container:

```
docker stop mysqlha
```