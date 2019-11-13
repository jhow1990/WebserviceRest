package br.com.webserviceRestFull.controller;

import java.util.ArrayList;

import br.com.webserviceRestFull.dao.CityDAO;
import br.com.webserviceRestFull.model.City;

/**
 * 
 * Class responsible for the controller between the resource and the DAO layer
 *
 * @author Daniel Moraes <ddmoraes8@gmail.com>
 * @since  20/02/2019
 * @version 1.0
 */
public class CityController {
	
	public ArrayList<City> listarTodos(){
		System.out.println("Enviando para o GIT");
		return CityDAO.getInstance().listarTodos();
	}
	
	public ArrayList<City> listaNome(String NomeCidade, int UnidadeMedida){
		System.out.println("NomeCidade    = " + NomeCidade);
		System.out.println("UnidadeMedida = " + UnidadeMedida);
		
		return CityDAO.getInstance().listaNome(NomeCidade,UnidadeMedida);
	}
}
