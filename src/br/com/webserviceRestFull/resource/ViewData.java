package br.com.webserviceRestFull.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.webserviceRestFull.controller.CityController;
import br.com.webserviceRestFull.model.City;

import com.google.gson.Gson;


@Path("/lista")
public class ViewData {

	
	 @GET
	 @Path("login/{login}")
	  public String login(@QueryParam("login") String login) {
	   return "login do cara : " + login;
	  }
}
