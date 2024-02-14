package com.gcp.storage;

import org.springframework.beans.factory.annotation.Value;

import com.google.cloud.spring.logging.LoggingAppender;


public class CustomeLoggingAppender extends LoggingAppender{

	@Value("${filePath}")
	private String filePathNew;
	
	@Value("${spring.application.name}")
	private String projId;
	
	@Override
	public void setCredentialsFile(String credentialsFile) {
		
		System.out.println("**************** projId **************** : " + projId);
		System.out.println("**************** file path LoggingAppender ******************* : "+ filePathNew);
		System.out.println("**************** credentialsFile path ***************** : " + credentialsFile);
		super.setCredentialsFile(credentialsFile);
	}
	
}
