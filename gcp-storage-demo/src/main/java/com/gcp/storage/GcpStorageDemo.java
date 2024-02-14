package com.gcp.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GcpStorageDemo implements CommandLineRunner{

	@Value("${filePath}")
	private String filePath;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		System.out.println("**************** file path cl ******************* : " + filePath);
		System.out.println("**************** projID cl ******************* : " );
	}

}
