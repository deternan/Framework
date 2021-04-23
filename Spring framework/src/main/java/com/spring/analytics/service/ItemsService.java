package com.spring.analytics.service;

/*
 * version: February 19, 2020 10:20 AM
 * Last revision: February 19, 2020 04:45 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.analytics.dao.impl.ItemsDaoImpl;
import com.spring.analytics.dto.ItemsResponse;
import com.spring.analytics.dto.ItemsResponseData;
import com.spring.analytics.entity.ItemsEntity;


@Service
public class ItemsService 
{
	
	@Autowired
	ItemsDaoImpl itemsImpl;
	
//	public ItemsResponse updatedItems(String title, String body){
//				
//		List<ItemsResponseData> items = new ArrayList<>();
//		
//		ItemsResponseData item = new ItemsResponseData(); 
//		item.setTitle(title);
//		item.setBody(body);
//			
//		items.add(item);
//		
//		
//		ItemsResponse itemsResponse = new ItemsResponse();
//		itemsResponse.setItems(items);
//		itemsResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
//		
//		saveItemsToDB(items);
//		
//		return itemsResponse;
//	}
//	
//	private void saveItemsToDB(List<ItemsResponseData> items) 
//	{
//		ItemsEntity itemsentity = new ItemsEntity();	
//		itemsentity.setItems(items);
//		itemsentity.setTimestamp(new Timestamp(System.currentTimeMillis()));
//		
//		itemsImpl.saveItemsEntity(itemsentity);
//	}
	
	public ItemsResponseData updatedItem(String title, String body){
		
		//List<ItemsResponseData> items = new ArrayList<>();		
		//ItemsResponseData item = new ItemsResponseData(); 
		//item.setTitle(title);
		//item.setBody(body);			
		//items.add(item);
		
		ItemsResponseData item = new ItemsResponseData(); 
		item.setTitle(title);
		item.setBody(body);
		
		
		// Response display
		ItemsResponseData itemsResponse = new ItemsResponseData();
		itemsResponse.setTitle(title);
		itemsResponse.setBody(body);
		//itemsResponse.setItems(items);
		//itemsResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		saveItemsToDB(item);
		
		return itemsResponse;
	}
	
	
	private void saveItemsToDB(ItemsResponseData item) 
	{
		ItemsEntity itemsentity = new ItemsEntity();			
		//itemsentity.setItem(item);				
		itemsentity.setTitle(item.getTitle());
		itemsentity.setBody(item.getBody());
		itemsentity.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		itemsImpl.saveItemsEntity(itemsentity);		
	}
	
	
	
}
