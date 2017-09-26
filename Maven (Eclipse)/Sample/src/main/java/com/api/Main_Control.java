package com.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Main_Control {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/autocomplete")
	@Produces("application/json")
	public Response getTest() {
		
		Test tt = new Test();
		int get_return = tt.Return_result();
		
	    return Response.status(200).entity(get_return).build();
	}

}
