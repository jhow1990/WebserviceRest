package br.com.webserviceRestFull.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Class responsible for containing methods to create and close database.
 *
 * @author Daniel Moraes <ddmoraes8@gmail.com>
 * @since  20/02/2019
 * @version 1.0
 */
public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/projectcities";
	private static final String USUARIO = "root";
	private static final String SENHA = "dadm1914";
	

	/**
	 * 
	 * Method responsible for creating a connection to the bank
	 *
	 * @return
	 * @author Daniel Moraes <ddmoraes8@gmail.com>
	 * @since  20/02/2019
	 * @version 1.0
	 */
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com o banco: " + URL);
		}
	}
}

