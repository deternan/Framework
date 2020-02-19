package com.spring.analytics.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.analytics.dto.ItemsResponse;
import com.spring.analytics.entity.ItemsEntity;

public interface ItemsSaveRepository extends MongoRepository<ItemsEntity, String> {

	@Query(value = "{$and:[{'_id': ?0 }]}")
	ItemsEntity findById(String id);
	
	@Query(value = "{$and:[{'_id': ?0 }]}")
	ItemsEntity save();
	
	@Query(value = "{}")
	List<ItemsResponse> findItemsByPaging(Pageable pageable);
	
}
