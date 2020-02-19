package com.spring.analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.analytics.model.Been.User;
import com.spring.analytics.repository.UserRepository;


import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import javax.security.auth.login.LoginException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

@Service
public class UserService {
	
  private final UserRepository userRepository;
  
	@Autowired
	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    public List<User> findUserByUserId(String username){
    	return userRepository.findByUsername(username);
    }
    
}
