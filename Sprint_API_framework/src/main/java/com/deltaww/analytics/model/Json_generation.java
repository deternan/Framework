package com.deltaww.analytics.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Json_generation 
{

	private JSONArray json_array = new JSONArray();
	private JSONObject obj = new JSONObject(); 
	
	private String userId_str = "aaa";
	private String national = "TW";
	
	public Json_generation() throws JSONException
	{
		// userId
		obj.put("userId", userId_str);
		obj.put("national", national);		
		
		json_array.put(obj);
		//System.out.println(json_array);
	}
	
	public JSONArray return_Json()
	{
		return json_array;
	}
	
}
