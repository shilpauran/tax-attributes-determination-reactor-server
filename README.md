
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

## Reactive Rabbitmq:

	Producer:

	To support aynchronous input/output, the Rabbitmq producer uses ```AsyncRabbitTemplate``` . This template makes the communication to the consumer in a non-blocking stream.
	please find the client implementaion example here : 
<https://github.com/shilpauran/tax-attributes-determination-reactor-client>
	
	Consumer:

	The consumer accepts the messages and replies to the messages using a listener. ```@RabbitListner``` supports the asychronous input/output in non blocking data stream in an Manual acknowledgement mode, starting with version 2.1. But the return types are restricted to ```Mono<?>``` or ```Listenable<Future>```
	for more information please visit the page : <https://docs.spring.io/spring-amqp/docs/2.2.5.RELEASE/reference/html/#async-returns>
	
## Reactive Redis:

	Reactive Redis has rich set of libraries which includes ```ReactiveRedisConnectionFactory``` - a thread safe factory for reactive redis connections,
	```ReactiveRedisTemplate``` - a central abstraction for reactive Redis data access . This template performs automatic serialization/deserialization between the
	given objects,
	```ReactiveRedisOperations``` - an Interface that supports basic set of Redis operation. it is also useful option for extensibility and testability.
	
	
	
