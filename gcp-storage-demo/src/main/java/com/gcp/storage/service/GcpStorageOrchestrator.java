package com.gcp.storage.service;



import com.gcp.storage.dto.DatabaseDto;
import com.gcp.storage.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GcpStorageOrchestrator {

	Flux<ProductDto> getAllProductsNew();

	Mono<ProductDto> getProductById(Integer id);

	Mono<DatabaseDto> getDBdetails();
	
}
