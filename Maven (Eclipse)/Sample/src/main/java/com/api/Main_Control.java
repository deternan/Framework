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
	@Path("/query/{param}")
	@Produces("application/json; charset=UTF-8")
	public Response getMsg(@PathParam("param") String msg) {
	

		return Response.status(200).entity(msg.toString()).build();
	}
}
