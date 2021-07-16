package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection estabelecerConexao() {
		
		String url = "jdbc:postgresql://localhost:5432/BD_IMPOSTOS";
		String usuario = "postgres";
		String senha = "0000";
		
		try {			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {	
			e.printStackTrace();
			return null;
		}
	}
	
}