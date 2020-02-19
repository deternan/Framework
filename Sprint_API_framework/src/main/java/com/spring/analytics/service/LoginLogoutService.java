package com.spring.analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.analytics.model.Been.LoginLogout;
import com.spring.analytics.repository.LoginLogoutRepository;


import java.util.List;


@Service
public class LoginLogoutService {
	
  //private final UserRepository userRepository;
	private final LoginLogoutRepository loginlogoutRepository;
  
	@Autowired
	LoginLogoutService(LoginLogoutRepository loginlogoutRepository) {
		//this.userRepository = userRepository;
		this.loginlogoutRepository = loginlogoutRepository;
	}

//    public List<UserType> findAllUsers() {
//    	return loginlogoutRepository.findAll();        
//    }
    
    public List<LoginLogout> findUserByUserId(String openId){
    	
    	return loginlogoutRepository.findByopenIdAndDate(openId);
    	//return userRepository.findByUsername(username);
    }
    
}
