package com.tradeenquiry.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatabaseDto {

	private String dbname;
	
	private String dbusername;
	
	private String dbpwd;
	
}
