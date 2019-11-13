package br.com.webserviceRestFull.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;
import java.io.*;

import br.com.webserviceRestFull.factory.ConnectionFactory;
import br.com.webserviceRestFull.model.City;

/**
 * 
 * Class responsible for containing CRUD methods
 *
 * @author Daniel Moraes <ddmoraes8@gmail.com>
 * @since  20/02/2019
 * @version 1.0
 */
public class CityDAO extends ConnectionFactory {

	private static CityDAO instance;
	
	
	/**
	 * 
	 * Method responsible for creating an instance of the CityDAO class (Singleton)
	 *
	 * @return
	 * @author Daniel Moraes <ddmoraes8@gmail.com>
	 * @since  20/02/2019
	 * @version 1.0
	 */
	public static CityDAO getInstance(){
		if(instance == null)
			instance = new CityDAO();
		return instance;
	}
	
	/**
	 * 
	 * Method responsible for listing all bank 
	 *
	 * @return ArrayList<City> City
	 * @author Daniel Moraes <ddmoraes8@gmail.com>
	 * @since  20/02/2019
	 * @version 1.0
	 */
	public ArrayList<City> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<City> cities = null;
		
		conexao = criarConexao();
		cities = new ArrayList<City>();
		try {
			pstmt = conexao.prepareStatement("select * from city order by nameCity");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				City city = new City();
				
				city.setId(rs.getInt("idCity"));
				city.setName(rs.getString("nameCity"));
				city.setLatitude(rs.getDouble("latitudeCity"));
				city.setLongitude(rs.getDouble("longitudeCity"));
				
				cities.add(city);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todas as cidades: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return cities;
	}
	
	public ArrayList<City> listaNome(String NomeCidade, int UnidadeMedida){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<City> cities = null;
		
		conexao = criarConexao();
		
		cities = new ArrayList<City>();
		
		System.out.println("TipoMedida - " + UnidadeMedida);
		try {
			
			String Query = "select * from city where upper(nameCity) like '%" + NomeCidade + 
                    "%' order by nameCity";
			
			pstmt = conexao.prepareStatement(Query);
			rs = pstmt.executeQuery();
			City city = new City();
			
			while(rs.next()){
				
				
				city.setId(rs.getInt("idCity"));
				city.setName(rs.getString("nameCity"));
				city.setLatitude(rs.getDouble("latitudeCity"));
				city.setLongitude(rs.getDouble("longitudeCity"));
				city.setDistancia(0);
				
				
				//cities.add(city);
			}
			
			
			System.out.println("ID - " + city.getId());
			int NumID = city.getId();
			String Query2 = "select * from city where idCity <> " + NumID + " order by idCity asc";
			
			System.out.println("Saida Query - " + Query2);
			
			//
			double latitudeSelecao = city.getLatitude();
			double longitudeSelecao = city.getLongitude();
			String nomeCidadeSelecao = city.getName();
			
			//
			double latitudeComp = 0;
			double longitueComp = 0;
			String selecaoComp  = null;
			//
			PreparedStatement pstmt2 = null;
			ResultSet rs2 = null;
			pstmt2 = conexao.prepareStatement(Query2);
			System.out.println("Preparou Query");
			rs2 = pstmt2.executeQuery();
			System.out.println("Executou Query");
			
			while(rs2.next()) {
				City city2 = new City();
				
				System.out.println("Entrou Looping");
				
				System.out.println("Id Selecao - " + rs2.getInt("idCity"));
				
				city2.setId(rs2.getInt("idCity"));
				city2.setName(rs2.getString("nameCity"));
				city2.setLatitude(rs2.getDouble("latitudeCity"));
				city2.setLongitude(rs2.getDouble("longitudeCity"));
				
				//System.out.println("Teste - " + distance(latitudeSelecao,longitudeSelecao,city2.getLatitude(), city2.getLongitude(),"K"));
				
				System.out.println("Unidade de Medida escolha - " + UnidadeMedida );
				city2.setDistancia(distance(latitudeSelecao,longitudeSelecao,city2.getLatitude(), city2.getLongitude(),UnidadeMedida));
				
				
				
				cities.add(city2);
				System.out.println("Entrou Looping - Inclui Cities");
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todas as cidades: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return cities;
	}
	
    private static double distance(double lat1, double lon1, double lat2, double lon2, int unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        
        System.out.println("unit - " + unit);
        
        System.out.println("dist vazio - " + dist);
        
        if (unit == 0) { //KM
            dist = dist * 1.609344;
            System.out.println("Dist K - " + dist);
        } else if (unit == 1) { // Mi
            dist = dist * 0.8684;
            System.out.println("Dist N - " + dist);
        }

        return (dist);
    }


    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }


    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }    
	
}
