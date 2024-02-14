package com.gcp.storage.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gcp.storage.dto.DatabaseDto;
import com.gcp.storage.dto.ProductDto;
import com.gcp.storage.service.GcpStorageOrchestrator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GcpStorageHandler {

private static final Logger logger = LoggerFactory.getLogger(GcpStorageHandler.class);
	
	@Autowired
	private GcpStorageOrchestrator gcpStorageOrchestrator;	
	
	public Mono<ServerResponse> getProductsNew(ServerRequest serverRequest){
		logger.info("getProductsNew-----service----triggered");
		Flux<ProductDto> products = gcpStorageOrchestrator.getAllProductsNew();
		logger.info("getProductsNew-----service----end");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products,ProductDto.class);
	}
	
	public Mono<ServerResponse> getProductById(ServerRequest serverRequest){
		logger.info("getProductById-----service----triggered");
		Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
		Mono<ProductDto> products = gcpStorageOrchestrator.getProductById(id);
		logger.info("getProductById-----service----end");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products,ProductDto.class);
	}
	
	
	public Mono<ServerResponse> dbDetails(ServerRequest serverRequest){
		logger.info("saveProduct-----service----triggered");
		Mono<DatabaseDto> dataMono = gcpStorageOrchestrator.getDBdetails();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(dataMono,DatabaseDto.class);
	}
	
}
