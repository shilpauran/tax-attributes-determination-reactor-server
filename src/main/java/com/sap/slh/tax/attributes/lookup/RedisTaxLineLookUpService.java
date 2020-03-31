package com.sap.slh.tax.attributes.lookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;

import com.sap.slh.tax.attributes.util.JsonUtil;
import com.sap.slh.tax.model.RedisRepo;
import com.sap.slh.tax.model.TaxDetails;
import com.sap.slh.tax.model.TaxLine;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RedisTaxLineLookUpService {
	private static final Logger log = LoggerFactory.getLogger(RedisTaxLineLookUpService.class);

	@Autowired
	private ReactiveRedisOperations<TaxDetails, TaxLine> redisOperations;

	public Flux<TaxLine> get(TaxDetails taxDetails) {
		
		log.info("going to call redis to fetch tax lines{}", JsonUtil.toJsonString(taxDetails));
		
//		return redisOperations.keys(taxDetails).map(redisOperations.opsForValue()::get);
		return redisOperations.keys(taxDetails).flatMap(redisOperations.opsForValue()::get);

	}

	public Mono<RedisRepo> set(RedisRepo redisRepo) {
		log.info("going to call redis to save tax lines{}", JsonUtil.toJsonString(redisRepo.getTaxDetails()));
		return redisOperations.opsForValue().set(redisRepo.getTaxDetails(), redisRepo.getTaxLine())
				.map(__ -> redisRepo);
	}

}
