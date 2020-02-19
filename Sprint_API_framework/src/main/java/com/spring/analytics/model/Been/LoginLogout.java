package com.spring.analytics.model.Been;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Document(collection = "logActionLoginLogout")		// DB collection name
public class LoginLogout {

	@Id	
	private String openId;		// userId
	private String name; 		// userName	
	
	// @JsonIgnore
	

//	public LoginLogout() {
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getName() {
//		return this.name;
//	}
//
//	public void setOpenId(String openId) {
//		this.openId = openId;
//	}
//
//	public String getOpenId() {
//		return openId;
//	}
	
	

//	@Override
//	public String toString() {
//		return String.format("User[userId=%s, username='%s']", openId, name);
//	}

}
