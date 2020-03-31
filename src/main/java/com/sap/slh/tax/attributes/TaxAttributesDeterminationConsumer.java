package com.sap.slh.tax.attributes;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.sap.slh.tax.model.TaxDetails;
import com.sap.slh.tax.model.TaxLine;

@Component
public class TaxAttributesDeterminationConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaxAttributesDeterminationConsumer.class);

	@RabbitListener(queues = "${rabbitmq.txs.queue}", returnExceptions = "true")
	public TaxLine handleTaxAttributesDeterminationMessage(
			Message taxAttributesDeterminationRequestMessage) {
		LOGGER.error("TaxAttributesDeterminationConsumer request : {}", taxAttributesDeterminationRequestMessage);
			TaxDetails taxAttributesDeterminationRequest = JsonUtil.toObjectFromByte(
					taxAttributesDeterminationRequestMessage.getBody(), TaxDetails.class);
			TaxLine taxAttributesDeterminationResponse = new TaxLine();
			taxAttributesDeterminationResponse.setId(taxAttributesDeterminationRequest.getTaxableCountry());
			taxAttributesDeterminationResponse.setDueCategoryCode("duecat");
			taxAttributesDeterminationResponse.setIsReverseChargeRelevant(true);
			taxAttributesDeterminationResponse.setIsTaxDeferred(true);
			taxAttributesDeterminationResponse.setNonDeductibleTaxRate(new BigDecimal(1));
			taxAttributesDeterminationResponse.setTaxRate(new BigDecimal(5));
			taxAttributesDeterminationResponse.setTaxTypeCode("tax type");
		LOGGER.error("TaxAttributesDeterminationConsumer response: {}",
				JsonUtil.toJsonString(taxAttributesDeterminationResponse));
		return taxAttributesDeterminationResponse;
	}

}
