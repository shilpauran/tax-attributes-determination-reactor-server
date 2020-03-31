package com.sap.slh.tax.attributes.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.slh.tax.attributes.service.TaxLineService;
import com.sap.slh.tax.attributes.util.JsonUtil;
import com.sap.slh.tax.model.TaxDetails;
import com.sap.slh.tax.model.TaxLine;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TaxAttributesDeterminationConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaxAttributesDeterminationConsumer.class);

	@Autowired
	private TaxLineService taxLineService;
	@RabbitListener(queues = "${rabbitmq.txs.queue}", containerFactory = "rabbitListenerContainerFactory", returnExceptions = "true")
	public Mono<TaxLine> handleTaxAttributesDeterminationMessage(
			Message taxAttributesDeterminationRequestMessage) {
		LOGGER.error("TaxAttributesDeterminationConsumer request : {}", taxAttributesDeterminationRequestMessage);
			TaxDetails taxAttributesDeterminationRequest = JsonUtil.toObjectFromByte(
					taxAttributesDeterminationRequestMessage.getBody(), TaxDetails.class);
			
			Flux<TaxLine> responseFlux = taxLineService.determineTaxLines(taxAttributesDeterminationRequest);
			Mono<TaxLine> response = responseFlux.next();
		LOGGER.error("response is{}",JsonUtil.toJsonString(response));
		return response;
	}

}
