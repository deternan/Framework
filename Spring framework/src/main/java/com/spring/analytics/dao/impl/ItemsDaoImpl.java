package com.spring.analytics.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.spring.analytics.dao.ItemsDao;
import com.spring.analytics.dto.ItemsResponse;
import com.spring.analytics.entity.ItemsEntity;
import com.spring.analytics.repository.ItemsSaveRepository;


@Component
public class ItemsDaoImpl implements ItemsDao {

	@Autowired
	ItemsSaveRepository itemsRepository;
		
	@Override
	public void findById(String id) {
		itemsRepository.findById(id);
	}
	
		
	@Override
	public List<ItemsResponse> getItemsByPaging(int pageSize, int pageIndex) {				
		Pageable pageable = new PageRequest(pageIndex, pageSize, Sort.Direction.DESC, "timestamp");
		
		return itemsRepository.findItemsByPaging(pageable);
	}

	@Override
	public void saveItemsEntity(ItemsEntity items) {
		// TODO Auto-generated method stub
		itemsRepository.save(items);
	}
		
	
}
