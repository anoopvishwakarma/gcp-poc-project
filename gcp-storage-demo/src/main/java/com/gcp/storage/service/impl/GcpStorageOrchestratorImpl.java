package com.gcp.storage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gcp.storage.dto.DatabaseDto;
import com.gcp.storage.dto.ProductDto;
import com.gcp.storage.service.GcpStorageOrchestrator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GcpStorageOrchestratorImpl implements GcpStorageOrchestrator{

private static final Logger logger = LoggerFactory.getLogger(GcpStorageOrchestratorImpl.class);
	 
	
	@Override
	public Flux<ProductDto> getAllProductsNew() {
		logger.info("getAllProductsNew-----ProductOrchestratorImpl----start");
		ProductDto productDto = new ProductDto(1, "Pendrive", "PD", "pendrive", 1500, 500);
		logger.info("Product info : " + productDto.toString());
		return Flux.just(productDto);
	}

	@Override
	public Mono<ProductDto> getProductById(Integer id) {
		logger.info("getProductById-----ProductOrchestratorImpl----start");		
		return Mono.just(new ProductDto(1, "Pendrive", "PD", "pendrive", 1500, 500));		
	}

	@Override
	public Mono<DatabaseDto> getDBdetails() {
		logger.info("getDBdetails-----ProductOrchestratorImpl----start");
		logger.info("Database details : " + "dbname" + " : " + "dbusername" + " " + "dbpwd");		
		return Mono.just(new DatabaseDto("dbname", "dbusername", "dbpwd"));
	}
	
}
