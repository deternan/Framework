package com.spring.analytics.dao;


import java.util.List;

import com.spring.analytics.dto.ItemsResponse;
import com.spring.analytics.entity.ItemsEntity;

public interface ItemsDao {

	public void findById(String id);
	
	public void saveItemsEntity(ItemsEntity popular);
	
	List<ItemsResponse> getItemsByPaging(int pageSize, int pageIndex);
		
}
