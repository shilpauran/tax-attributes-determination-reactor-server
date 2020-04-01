
# POC Project for Reactive Programming :
This project is to demonstrate how to use Spring Webflux, a reactive-stack web framework a parallel version of Spring MVC which supports fully non-blocking reactive streams.
It runs on Netty server and uses project reactor as reactive library.
## Reactive Programming :
Reactive Programming is a paradigm that promotes, an asynchronous input and output, non blocking data streams, data flow as an event/message driven stream, support of back pressure technique
For more information on Reactive Programming or spring webflux please refer to : 
<https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html>

## Project Overview:
This demo project acts as a consumer application and accepts the requests as messages. The communication to/from the client is also established in a non-blocking stream by using Rabbitmq(spring amqp).
once the message is received, this application communicates with Reactive Redis to fetch the required information and the data stream is returned to client application in a non-blocking way.
