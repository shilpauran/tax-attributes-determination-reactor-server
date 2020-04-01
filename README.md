
# POC Project for Reactive Programming :
This project is to demonstrate how to use Spring Webflux, a reactive-stack web framework a parallel version of Spring MVC which supports fully non-blocking reactive streams.
It runs on Netty server and uses project reactor as reactive library.
## Reactive Programming :
Reactive Programming is a paradigm that promotes, an asynchronous input and output, non blocking data streams, data flow as an event/message driven stream, support of back pressure technique
For more information on Reactive Programming or spring webflux please refer to : 
<https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html>

## Project OverView:
This demo project acts as a consumer application and accepts the requests as messages. The communication to the client is also established in a non-blocking stream by using Rabbitmq.
once the message is received, this application communicates with Reactive Redis to fetch the required information and the data stream is returned to client application in a non-blocking way.

##Reactive Rabbitmq:
	To support aynchronous input/output, the Rabbitmq producer uses ```AsyncRabbitTemplate``` . This template makes the communication to the consumer in a non-blocking stream.
	please find the client implementaion example here : <https://github.com/shilpauran/tax-attributes-determination-reactor-client>
	
