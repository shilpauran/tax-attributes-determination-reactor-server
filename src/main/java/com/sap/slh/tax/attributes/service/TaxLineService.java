package com.sap.slh.tax.attributes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.slh.tax.attributes.lookup.RedisTaxLineLookUpService;
import com.sap.slh.tax.attributes.util.JsonUtil;
import com.sap.slh.tax.model.RedisRepo;
import com.sap.slh.tax.model.TaxDetails;
import com.sap.slh.tax.model.TaxLine;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaxLineService {
	private static final Logger log = LoggerFactory.getLogger(TaxLineService.class);
	
	@Autowired
	private RedisTaxLineLookUpService redisTaxLineLookUpService;
	
	public Flux<TaxLine> determineTaxLines(TaxDetails taxDetails)
	{
		log.info("determining tax lines for{}",JsonUtil.toJsonString(taxDetails));
		return redisTaxLineLookUpService.get(taxDetails);	

	}

	public Mono<RedisRepo> saveTaxLines(RedisRepo redisRepo) {
		log.info("saving tax lines for{}",JsonUtil.toJsonString(redisRepo));
		return redisTaxLineLookUpService.set(redisRepo);
	}

}
