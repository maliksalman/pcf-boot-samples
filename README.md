# CloudFoundry/SpringBoot sample applications

## amqp-source

This sample spring-boot application produces 'grape' messages into RabbitMQ topic(s) using spring-cloud-streams abstraction. It demonstrates how to setup serialization for date/time objects to JSON - which is the format it produces the 'grape' messages in. Also demenstrates producing multiple types of message on a single topic. Use the `amqp-sink` app to consume the 'grape' messages.      

## amqp-sink

This sample spring-boot application consumes 'grape' messages from RabbitMQ topic(s) using the spring-cloud-streams abstraction. It shows how to properly consume messages using either the `MessageHandler` or `@StreamListener` mechanisms exposed by spring-cloud-streams. It also demonstrates how to setup deserialization for date/time objects from JSON - which is the format it expects the 'grape' messages on the topics to be in. In addition, it also shows how to use headers to consumer multiple type of events from a single topic. Use the `amqp-source` to generate different kind of 'grape' messages.      

## discovery-a

Sample spring-boot application that registers with eureka-server with its registration status depending on a healthcheck. Also, shows example of making a call to the `discovery-b` app by first locating it through the eureka-server.

## discovery-b

Sample spring-boot application that registers with eureka-server using `direct` registration. This type of registration means that clients connecting to this application will not go through the go-router in a CF environment.

## discovery-bg

Sample spring-boot application that registers with eureka-server in the `STARTING` status. This can be useful in a scenario where some external process wants to orchestrate when the app is marked `UP` or `DOWN` during a B/G deployment. Includes a basic bash scrip that can mark the app as `UP` by directly contacting the eureka-server in a PCF environment.

## simple-router

Sample spring-boot app that includes the netflix-zuul server and configuration in `application.yml` to route traffic another app.

## sql-data

Sample spring-boot app that shows how to use spring-data-jpa `Repository` to interact with a SQL database. Also, includes some spring MVC controller mapping examples.

## the-basics
 
Sample spring-boot app that shows loading of beans depending on the spring profile. Also, includes basic spring MVC controller mapping examples. Includes an example concourse CI pipeline that builds the app on source code changes, saves the artifacts in S3 with semantic versioning, and deploys the app to CF when a new artifact version is discovered in S3.
