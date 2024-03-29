package app.curso.banco.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.entidad.Gestor;

public class DatabaseGestor {
	
	private Connection conexion;
	
	//Constructor
	public DatabaseGestor(){
		conexion = new DatabaseConexion().getConexion();
	}
	
	//Metodos
	
	//Create
	public boolean insertarGestor(Gestor gestor) {
		PreparedStatement instruccion =null;
		
		try {
			instruccion = conexion.prepareStatement("INSERT INTO gestor (usuario, password, correo) VALUES (?,?,?)");
			
			instruccion.setString(1, gestor.getUsuario());
			
			instruccion.setString(2, gestor.getPassword());
			
			instruccion.setString(3, gestor.getCorreo());
			
			instruccion.executeUpdate();
			
			instruccion.close();
			
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(instruccion !=null) {
				try {
					instruccion.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public ArrayList<Gestor> getGestores() {
		Statement instruccion = null;
		ArrayList<Gestor> gestores = new ArrayList<Gestor>();
		
		try {
			instruccion = conexion.createStatement();
		
		ResultSet resultados = instruccion.executeQuery("SELECT * FROM gestor");
		
		while(resultados.next()) {
			int id = resultados.getInt("id");
			String usuario = resultados.getString("usuario");
			String password = resultados.getString("password");
			String correo = resultados.getString("correo");
			
			Gestor result = new Gestor(id, usuario, password, correo);
			gestores.add(result);
		}
		instruccion.close();
		
		return gestores;
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(instruccion != null) {
				try {
					instruccion.close();
				}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
		return null;
	}

	public Gestor getGestor(int id) {
		PreparedStatement instruccion = null;
		Gestor gestor = null;
		
		try {
			instruccion =  conexion.prepareStatement("SELECT * FROM gestor WHERE id = ?");
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if (resultados.next()) {
				gestor = new Gestor();
				gestor.setId(resultados.getInt("id"));
				gestor.setUsuario(resultados.getString("usuario"));
				gestor.setPassword(resultados.getString("password"));
				gestor.setCorreo(resultados.getString("correo"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(instruccion != null) {
				try {
					instruccion.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return gestor;
	}

	public boolean borrarGestor(int id) {
		PreparedStatement instruccion = null;
		
		try {
			instruccion = conexion.prepareStatement("DELETE FROM gestor WHERE id = ?");
			instruccion.setInt(1, id);
			
			int filasBorradas = instruccion.executeUpdate();
			
			return filasBorradas!=0;
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(instruccion  != null) {
				try {
					instruccion.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	public boolean actualizarGestor(Gestor gestor) {
		PreparedStatement instruccion = null;
		
		try {
			instruccion = conexion.prepareStatement("UPDATE gestor SET usuario = ?, password = ?, correo = ? WHERE id = ?");
			instruccion.setString(1, gestor.getUsuario());
			instruccion.setString(2, gestor.getPassword());
			instruccion.setString(3, gestor.getCorreo());
			instruccion.setInt(4, gestor.getId());
			
			int filasActualizadas = instruccion.executeUpdate();
			
			return filasActualizadas!=0;
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(instruccion  != null) {
				try {
					instruccion.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
}
