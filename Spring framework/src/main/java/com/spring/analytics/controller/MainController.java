package com.spring.analytics.controller;

/*
 * version: November 15, 2018 03:24 PM
 * Last revision: February 19, 2020 03:12 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */


import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.analytics.dto.ItemsResponse;
import com.spring.analytics.dto.ItemsResponseData;
import com.spring.analytics.model.Json_generation;
import com.spring.analytics.model.request.UserType;
import com.spring.analytics.service.ItemsService;
//import com.spring.analytics.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

	@Autowired
	ItemsService itemsService;
	
	
//	private final HttpServletRequest request;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
//	@Autowired
//	public MainController(UserService userService, HttpServletRequest request) {
//					
//		this.request = request;
//
//	}
	
	@RequestMapping(value = "/test/{username}", method = RequestMethod.GET)	
	ResponseEntity<?> sentNameByName(@PathVariable String username) throws Exception {
		
		System.out.println("Test username:"+username);		
		
		Json_generation GJ = new Json_generation();
		JSONArray jjgen = new JSONArray();
		String reponse_str = null;
		reponse_str = GJ.return_Json().toString();
		
		return new ResponseEntity<>(reponse_str, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/api/sample/get/{username}", method = RequestMethod.GET)	
//	ResponseEntity<?> userDataGET(@PathVariable String username) throws Exception {
//				
//		List<User> usersinfo = userService.findUserByUserId(username);		
//		
//		Map<String, Object> response = new HashMap<>();
//		response.put("statusMsg", "SUCCESS");
//		response.put("size", usersinfo.size());
//		
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/api/sample/post", method = RequestMethod.POST)							
	ResponseEntity<Map<String, Object>> userDataPOST(
			@ApiParam(name = "user data", value = "user's information", required = true) @RequestBody UserType logRequest) {
				
		Map<String, Object> response = new HashMap<>();
		
		System.out.println("id:	"+logRequest.getUserId());
		System.out.println("name:	"+logRequest.getUserName());
		
		// Response
		if(logRequest !=null) {
			response.put("status", "success");
			response.put("data", logRequest);
		}else {
			response.put("status", "error");
		}		
		
		System.out.println(response);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// Insert (PUT)
	@RequestMapping(value = "/insert/items/", method = RequestMethod.PUT)	
	ResponseEntity<?> insertItems(
			@ApiParam(name = "title", value = "title", required = true) @RequestParam(required = true) String title,
			@ApiParam(name = "body", value = "body", required = true) @RequestParam(required = true) String body) throws Exception {						

		logger.info("[" + this.getClass().getName() + "] : Insert Items() - begin");							
		//ItemsResponse response = itemsService.updatedItems(title, body);
		ItemsResponseData response = itemsService.updatedItem(title, body);
		logger.info("[" + this.getClass().getName() + "] : Insert Items() - end");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}

