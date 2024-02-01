package com.tradeenquiry.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tradeenquiry.service.ProductOrchestrator;
import com.tradeenquiry.service.dto.DatabaseDto;
import com.tradeenquiry.service.dto.ProductDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductOrchestratorImpl implements ProductOrchestrator{

	@Value("${dbname}")
	private String dbname;
	
	@Value("${dbusername}")
	private String dbusername;
	
	@Value("${dbpwd}")
	private String dbpwd;
	
	@Override
	public Flux<ProductDto> getAllProductsNew() {
		log.info("getAllProductsNew-----ProductOrchestratorImpl----start");
		return Flux.just(new ProductDto(1, "Pendrive", "PD", "pendrive", 1500, 500));
	}

	@Override
	public Mono<ProductDto> getProductById(Integer id) {
		log.info("getProductById-----ProductOrchestratorImpl----start");
		return Mono.just(new ProductDto(1, "Pendrive", "PD", "pendrive", 1500, 500));		
	}

	@Override
	public Mono<DatabaseDto> getDBdetails() {
		log.info("getDBdetails-----ProductOrchestratorImpl----start");
		return Mono.just(new DatabaseDto(dbname, dbusername, dbpwd));
	}

}
