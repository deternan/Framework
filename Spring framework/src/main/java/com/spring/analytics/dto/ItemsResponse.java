package com.spring.analytics.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ItemsResponse {
		
	// Array
	private List<ItemsResponseData> items;
	private Date timestamp;

	
}
