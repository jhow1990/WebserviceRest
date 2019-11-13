package br.com.webserviceRestFull.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.webserviceRestFull.controller.CityController;
import br.com.webserviceRestFull.model.City;

import com.google.gson.Gson;

/**
 * 
 * Class responsible for containing the REST methods of accessing the webservice
 *
 * @author Daniel Moraes <ddmoraes8@gmail.com>
 * @since  20/02/2019
 * @version 1.0
 */

@Path("/city")
public class CityResource {

	/**
	 * 
	 * Method responsible for calling the controller
	 *
	 * @return ArrayList<City> 
	 * @author Daniel Moraes <ddmoraes8@gmail.com>
	 * @since  20/02/2019
	 * @version 1.0
	 */
	@GET
	@Path("/listAll")
	@Produces("application/json")
	public ArrayList<City> listarTodos(){
		return new CityController().listarTodos();
	}
	
	 @GET
	 @Path("/listName")
	 @Produces("application/json")
//	 public ArrayList<City> listaNome(@QueryParam("nameCidade") String nameCidade, @QueryParam("teste") String teste){
//	 public ArrayList<City> listaNome(@QueryParam("nameCidade") String nameCidade){	 
//		 return new CityController().listaNome(nameCidade);
	 
	 
	 
	 
	 public ArrayList<City> listaNome(@QueryParam("nameCidade") String nameCidade,@QueryParam("unidadeMedida") int unidadeMedida) {
		 System.out.println("nameCidade - " + nameCidade);
		 System.out.println("unidadeMedida - " + unidadeMedida);
		 return new CityController().listaNome(nameCidade,unidadeMedida);
	 }
	 
	 
	 
	 
	 
	 
//	 public String listaNome(@QueryParam("nameCidade") String nameCidade, @QueryParam("unidadeMedida") String unidadeMedida){
//		 System.out.println(nameCidade);
//		 System.out.println(unidadeMedida);
//		 
//		 return nameCidade;
	 //}
}
