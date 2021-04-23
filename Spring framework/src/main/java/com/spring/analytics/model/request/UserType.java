package com.spring.analytics.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserType {

	private String eventCategory = "";
	
	// @JsonIgnore
	private String userId = "";
	private String userName = "";
		
	
	public void cleanField() {
				
		
//		super.cleanField(setting);
	}
	
}
