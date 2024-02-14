package com.gcp.storage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("code")
	private String code;

	@JsonProperty("description")
	private String description;

	@JsonProperty("cost")
	private Integer cost;

	@JsonProperty("qty")
	private Integer qty;
	
	@Override
	public String toString() {
		return this.name+ " : "+ this.code+ " : "+ this.description + " : "+ this.cost+ " : " + this.qty;
		
	}

}
