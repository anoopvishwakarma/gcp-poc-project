package com.tradeenquiry.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tradeenquiry.service.ProductOrchestrator;
import com.tradeenquiry.service.dto.DatabaseDto;
import com.tradeenquiry.service.dto.ProductDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class TradeEnquiryServiceHandler {

	@Autowired
	private ProductOrchestrator productOrchestrator;	
	
	public Mono<ServerResponse> getProductsNew(ServerRequest serverRequest){
		log.info("getProductsNew-----service----triggered");
		Flux<ProductDto> products = productOrchestrator.getAllProductsNew();
		log.info("getProductsNew-----service----end");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products,ProductDto.class);
	}
	
	public Mono<ServerResponse> getProductById(ServerRequest serverRequest){
		log.info("getProductById-----service----triggered");
		Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
		Mono<ProductDto> products = productOrchestrator.getProductById(id);
		log.info("getProductById-----service----end");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products,ProductDto.class);
	}
	
	public Mono<ServerResponse> dbDetails(ServerRequest serverRequest){
		log.info("saveProduct-----service----triggered");
		Mono<DatabaseDto> dataMono = productOrchestrator.getDBdetails();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(dataMono,DatabaseDto.class);
	}
	
}
