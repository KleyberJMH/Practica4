package app.curso.banco.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.entidad.Cliente;

public class DatabaseCliente {
	
	private Connection conexion;
	
	//Constructor
	public DatabaseCliente(){
		conexion = new DatabaseConexion().getConexion();
	}
	
	//Metodos
	
	//Create
	public boolean insertarCliente(Cliente cliente) {
		PreparedStatement instruccion =null;
		
		try {
			instruccion = conexion.prepareStatement("INSERT INTO cliente (id_gestor, usuario, password, correo, saldo) VALUES (?,?,?,?,?)");
			
			instruccion.setInt(1, cliente.getId_gestor());
			instruccion.setString(2, cliente.getUsuario());
			instruccion.setString(3, cliente.getPassword());
			instruccion.setString(4, cliente.getCorreo());
			instruccion.setDouble(5, cliente.getSaldo());
			
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

	public Cliente getCliente(int id) {
		PreparedStatement instruccion = null;
		Cliente cliente = null;
		
		try {
			instruccion =  conexion.prepareStatement("SELECT * FROM cliente WHERE id = ?");
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if (resultados.next()) {
				cliente = new Cliente();
				cliente.setId(resultados.getInt("id"));
				cliente.setId_gestor(resultados.getInt("id_gestor"));
				cliente.setUsuario(resultados.getString("usuario"));
				cliente.setPassword(resultados.getString("password"));
				cliente.setCorreo(resultados.getString("correo"));
				cliente.setSaldo(resultados.getDouble("saldo"));
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
		return cliente;
	}

	public boolean borrarCliente(int id) {
		PreparedStatement instruccion = null;
		
		try {
			instruccion = conexion.prepareStatement("DELETE FROM cliente WHERE id = ?");
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

	public boolean actualizarCliente(Cliente cliente) {
		PreparedStatement instruccion = null;
		
		try {
			instruccion = conexion.prepareStatement("UPDATE cliente SET id_gestor = ?, usuario = ?, password = ?, correo = ?, saldo = ? WHERE id = ?");
			
			instruccion.setInt(1, cliente.getId_gestor());
			instruccion.setString(2, cliente.getUsuario());
			instruccion.setString(3, cliente.getPassword());
			instruccion.setString(4, cliente.getCorreo());
			instruccion.setDouble(5, cliente.getSaldo());
			instruccion.setInt(6, cliente.getId());
			
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
