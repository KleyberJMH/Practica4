package app.curso.banco.util;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.entidad.Mensaje;

public class DatabaseMensaje {
	
	private Connection conexion;
	
	//Constructor
	public DatabaseMensaje(){
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//Metodos
	
	//Create
	public boolean insertarMensaje(Mensaje mensaje) {
		PreparedStatement instruccion =null;
		
		try {
			instruccion = conexion.prepareStatement("INSERT INTO mensaje (id_origen, id_destino, texto, fecha) VALUES (?,?,?,?)");
			
			instruccion.setInt(1, mensaje.getId_origen());
			instruccion.setInt(2, mensaje.getId_destino());
			instruccion.setString(3, mensaje.getTexto());
			instruccion.setTimestamp(4, mensaje.getFecha());
			
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

	public ArrayList<Mensaje> getMensajes() {
		Statement instruccion = null;
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		
		try {
			instruccion = conexion.createStatement();
		
		ResultSet resultados = instruccion.executeQuery("SELECT * FROM mensaje");
		
		while(resultados.next()) {
			int id = resultados.getInt("id");
			int id_origen = resultados.getInt("id_origen");
			int id_destino = resultados.getInt("id_destino");
			String texto = resultados.getString("texto");
			Timestamp fecha = resultados.getTimestamp("fecha");
			
			Mensaje mensaje = new Mensaje(id, id_origen, id_destino, texto, fecha);
			mensajes.add(mensaje);
		}
		instruccion.close();
		
		return mensajes;
		
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

	public Mensaje getMensaje(int id) {
		PreparedStatement instruccion = null;
		Mensaje mensaje = null;
		
		try {
			instruccion =  conexion.prepareStatement("SELECT * FROM mensaje WHERE id = ?");
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if (resultados.next()) {
				mensaje = new Mensaje();
				mensaje.setId(resultados.getInt("id"));
				mensaje.setId_origen(resultados.getInt("id_origen"));
				mensaje.setId_destino(resultados.getInt("id_destino"));
				mensaje.setTexto(resultados.getString("texto"));
				mensaje.setFecha(resultados.getTimestamp("fecha"));
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
		return mensaje;
	}

	public boolean borrarMensaje(int id) {
		PreparedStatement instruccion = null;
		
		try {
			instruccion = conexion.prepareStatement("DELETE FROM mensaje WHERE id = ?");
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

	public boolean actualizarMensaje(Mensaje mensaje) {
		PreparedStatement instruccion = null;
		
		try {
			instruccion = conexion.prepareStatement("UPDATE mensaje SET id_origen = ?, id_destino = ?, texto = ?, fecha = ? WHERE id = ?");
			
			instruccion.setInt(1, mensaje.getId_origen());
			instruccion.setInt(2, mensaje.getId_destino());
			instruccion.setString(3, mensaje.getTexto());
			instruccion.setTimestamp(4, mensaje.getFecha());
			instruccion.setInt(5, mensaje.getId());
			
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