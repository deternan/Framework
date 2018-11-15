package com.deltaww.analytics.controller;

/*
 * version: November 16, 2018 03:24 PM
 * Last revision: November 16, 2018 03:24 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deltaww.analytics.model.Json_generation;
import com.deltaww.analytics.model.User;
import com.deltaww.analytics.model.request.UserType;
import com.deltaww.analytics.service.UserService;

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
public class UserController {

	private final UserService userService;
	private final HttpServletRequest request;
	
	@Autowired
	public UserController(UserService userService, HttpServletRequest request) {

		this.userService= userService;
		this.request = request;

	}
	
	@RequestMapping(value = "/test/{username}", method = RequestMethod.GET)	
	ResponseEntity<?> sentNameByName(@PathVariable String username) throws Exception {
		
		System.out.println("Test username:"+username);
		//List<User> users = userService.findUserByUserId(username);
		
		Json_generation GJ = new Json_generation();
		JSONArray jjgen = new JSONArray();
		String reponse_str = null;
		reponse_str = GJ.return_Json().toString();
		
		return new ResponseEntity<>(reponse_str, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/sample/get/{username}", method = RequestMethod.GET)	
	ResponseEntity<?> sentEmailByUserId(@PathVariable String username) throws Exception {
		
		System.out.println("username:"+username);
		List<User> users = userService.findUserByUserId(username);
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusMsg", "SUCCESS");
		response.put("size", users.size());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/api/sample/post", method = RequestMethod.POST)							
	ResponseEntity<Map<String, Object>> userData(
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
	
}

