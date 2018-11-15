package com.deltaww.analytics.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.deltaww.analytics.model.Been.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {


    
    /**
   	 * Find users with substring "key"
   	 * @param username
   	 * @return 
   	 */	    	
    @Query(value = "{$and:[{'username': {$regex: ?0, $options: 'i'}} ]}")
   	List<User> findByUsername(String username);
    
}