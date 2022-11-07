package app.curso.banco.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;

public class Database {
	
	private Connection conexion;
	
	//Constructor
	public Database(){
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//Metodos
	
	public boolean insertarGestor(Gestor gestor) {
		Statement instruccion =null;
		
		try {
			instruccion = conexion.createStatement();
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO gestor (usuario, password, correo) VALUES (?,?,?)");
			
			ps.setString(1, gestor.getUsuario());
			
			ps.setString(2, gestor.getPassword());
			
			ps.setString(3, gestor.getCorreo());
			
			ps.executeUpdate();
			
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
			
			Gestor gestor = new Gestor(id, usuario, password, correo);
			gestores.add(gestor);
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
	
	
	
	
	
	
	
	
	
	public boolean insertarCliente(Cliente cliente) {
		Statement instruccion =null;
		
		try {
			instruccion = conexion.createStatement();
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO cliente (id_gestor, usuario, password, correo, saldo) VALUES (?,?,?,?,?)");
			
			ps.setInt(1, cliente.getId_gestor());
			
			ps.setString(2, cliente.getUsuario());
			
			ps.setString(3, cliente.getPassword());
			
			ps.setString(4, cliente.getCorreo());
			
			ps.setDouble(5, cliente.getSaldo());
			
			ps.executeUpdate();
			
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
	
	

	public ArrayList<Cliente> getClientes() {
		Statement instruccion = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			instruccion = conexion.createStatement();
		
		ResultSet resultados = instruccion.executeQuery("SELECT * FROM cliente");
		
		while(resultados.next()) {
			int id = resultados.getInt("id");
			int id_gestor = resultados.getInt("id_gestor");
			String usuario = resultados.getString("usuario");
			String password = resultados.getString("password");
			String correo = resultados.getString("correo");
			Double saldo = resultados.getDouble("saldo");
			
			Cliente cliente = new Cliente(id, id_gestor, usuario, password, correo, saldo);
			clientes.add(cliente);
		}
		instruccion.close();
		
		return clientes;
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
}
