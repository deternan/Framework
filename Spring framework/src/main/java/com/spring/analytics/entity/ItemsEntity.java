package com.spring.analytics.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.analytics.dto.ItemsResponse;
import com.spring.analytics.dto.ItemsResponseData;

import lombok.Data;

@Data
@Document(collection = "item")
public class ItemsEntity {
		
	List<ItemsResponseData> items;
	
	ItemsResponseData item;
	
	private String title;
	private String body;
	
	@JsonIgnore
	private Date timestamp;
	
//	public void setItems(List<ItemsResponse> items) {
//		
//	}
	
//	public void setItems(ItemsResponseData items) {
//		
//	}
	
//	public void setItems(ItemsResponse items) {
//		
//	}
	
}
