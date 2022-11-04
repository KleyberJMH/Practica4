package app.curso.banco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.entidad.Gestor;

public class Database {
	
	private Connection conexion;
	
	public Database(){
		try {
			//conexion a la base de datos
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(this.conexion != null) {
					this.conexion.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//Metodos
	public ArrayList<Gestor> verGestores() {
		
		return null;
		
	}

}
