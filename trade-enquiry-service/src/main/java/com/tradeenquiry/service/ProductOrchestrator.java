package com.tradeenquiry.service;

import com.tradeenquiry.service.dto.DatabaseDto;
import com.tradeenquiry.service.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductOrchestrator {

	Flux<ProductDto> getAllProductsNew();

	Mono<ProductDto> getProductById(Integer id);

	Mono<DatabaseDto> getDBdetails();

}
