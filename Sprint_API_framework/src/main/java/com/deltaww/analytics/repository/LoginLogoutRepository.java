package com.deltaww.analytics.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.deltaww.analytics.model.Been.LoginLogout;
import com.deltaww.analytics.model.request.UserType;


public interface LoginLogoutRepository extends MongoRepository<LoginLogout, String>{
	
//	/**
//   	 * Find users with substring "key"
//   	 * @param username
//   	 * @return 
//   	 */	    	
//    @Query(value = "{$and:[{'username': {$regex: ?0, $options: 'i'}} ]}")
//   	List<UserType> findByUserId(String userId);

        
	//@Query("{'actor.openId':?0,'actor.name':?1}")
    @Query("{'actor.openId':?0}")
    List<LoginLogout> findByopenIdAndDate(String openId);
    //List<LoginLogout>  findByuserNameAndDate(String name,String date);
    
    
    
}
