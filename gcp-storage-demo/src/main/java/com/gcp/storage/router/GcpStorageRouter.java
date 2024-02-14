package com.gcp.storage.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gcp.storage.handler.GcpStorageHandler;

import brave.Tracing;
import brave.http.HttpTracing;


@Configuration
public class GcpStorageRouter {

	@Autowired
	private GcpStorageHandler gcpStorageHandler;
	
	@Bean
	public HttpTracing create(Tracing tracing) {
	    return HttpTracing
	        .newBuilder(tracing)
	        .build();
	}
	
	@Bean
	RouterFunction<ServerResponse> routerFunction() {

		return RouterFunctions.route()
				.GET("/v3/products",gcpStorageHandler::getProductsNew)
				.GET("/v3/products/{id}", gcpStorageHandler::getProductById)
				.GET("/v3/getDBdetails", gcpStorageHandler::dbDetails)				
				.build();		
	}
	
}
