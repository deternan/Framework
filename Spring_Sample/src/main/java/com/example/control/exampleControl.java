package com.example.control;



import java.util.HashMap;
import java.util.Map;

/*
 * Control 
 * version: December 15, 2018 09:34 PM
 * Last revision: December 15, 2018 09:34 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class exampleControl {

	@Autowired
	public exampleControl() {
		
	}
	
	// Get Course list	
	@RequestMapping(value = "/api/hello", method = RequestMethod.GET)
	ResponseEntity<?> getCourseList() throws Exception {

		Map<String, Object> response = new HashMap<>();
		 response.put("statusMsg", "SUCCESS");
		//response.put("itemType", "course");
		

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
}
