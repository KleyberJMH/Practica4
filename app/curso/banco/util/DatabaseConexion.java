package app.curso.banco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConexion {
	private Connection conexion;
	private static final String SERVER = "localhost";
	private static final String PORT = "3306";
	private static final String DB_NAME = "banco";
	private static final String USER_DB = "banco";
	private static final String PASS_DB = "banco";
	
	public DatabaseConexion(){
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME,USER_DB,PASS_DB);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
}
