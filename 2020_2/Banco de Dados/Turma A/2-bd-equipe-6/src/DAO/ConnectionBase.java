package mysql;

import java.sql.*;

public class ConnectionBase {
	
	protected Connection conexao;
	
	public Connection open() {
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi_grupo6", "root", "admin");
			
			System.out.println("conex�o ok");
			return conexao;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
				if(conexao != null)
					conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


}
