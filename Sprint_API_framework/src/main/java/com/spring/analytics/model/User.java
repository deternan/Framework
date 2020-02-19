package com.deltaww.analytics.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "user")		// DB collection name
public class User {

	@Id
	// @JsonIgnore
	private String userId;
	private String username; 		// account name	
	@JsonIgnore
	private String userName;	
	

	public User() {
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUserName() {
		return this.username;
	}

	public User(String username) {
		this.username = username;
	}

	public void setUserId(String newUserId) {
		this.userId = newUserId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// =========================	

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return String.format("User[userId=%s, username='%s']", userId, username);
	}

}
