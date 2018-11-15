package com.deltaww.analytics.controller;

/*
 * version: November 15, 2018 03:24 PM
 * Last revision: November 15, 2018 06:45 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * Reference
 * https://codertw.com/%E8%B3%87%E6%96%99%E5%BA%AB/128143/
 * https://www.zifangsky.cn/926.html
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
import com.deltaww.analytics.model.Been.LoginLogout;
import com.deltaww.analytics.model.Been.User;
import com.deltaww.analytics.model.request.UserType;
import com.deltaww.analytics.service.LoginLogoutService;
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
public class MainController {

	private final UserService userService;
	private final LoginLogoutService loginlogoutService;
	private final HttpServletRequest request;
	
	@Autowired
	public MainController(UserService userService, LoginLogoutService loginlogoutService, HttpServletRequest request) {
		
		this.userService= userService;
		this.loginlogoutService = loginlogoutService;
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
	ResponseEntity<?> userDataGET(@PathVariable String username) throws Exception {
				
		List<User> usersinfo = userService.findUserByUserId(username);		
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusMsg", "SUCCESS");
		response.put("size", usersinfo.size());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

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
	
	// -----------------------------------------------------------------------
	@RequestMapping(value = "/api/test/{openId}", method = RequestMethod.GET)	
	ResponseEntity<?> sentDataByUserName(@PathVariable String openId) throws Exception {
				
		System.out.println("openId:	"+openId);		
		List<LoginLogout> loginlogout = loginlogoutService.findUserByUserId(openId);
						
		
		System.out.println(loginlogout.get(0).toString());
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusMsg", "SUCCESS");
		response.put("size", loginlogout.size());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}

