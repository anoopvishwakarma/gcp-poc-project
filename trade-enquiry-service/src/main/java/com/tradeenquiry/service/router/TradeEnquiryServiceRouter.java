package com.tradeenquiry.service.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tradeenquiry.service.handler.TradeEnquiryServiceHandler;

@Configuration
public class TradeEnquiryServiceRouter {

	@Autowired
	private TradeEnquiryServiceHandler tradeEnquiryServiceHandler;
	
	@Bean
    WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }
	
	@Bean
	RouterFunction<ServerResponse> routerFunction() {

		return RouterFunctions.route()
				.GET("/v3/products",tradeEnquiryServiceHandler::getProductsNew)
				.GET("/v3/products/{id}", tradeEnquiryServiceHandler::getProductById)
				.GET("/v3/getDBdetails", tradeEnquiryServiceHandler::dbDetails)
				.build();		
	}
	
}
