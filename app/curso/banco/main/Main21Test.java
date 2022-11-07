package app.curso.banco.main;

import java.util.ArrayList;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;
import app.curso.banco.util.Database;

public class Main21Test {

	public static void main(String[] args) {
		Database database = new Database();
		
		//Obtener Gestores
		System.out.println("Lista de Gestores");
		ArrayList<Gestor> gestores = database.getGestores();
		System.out.println(gestores);
		
		//Insertar Gestor
		System.out.println("Insertar Gestor");
		Gestor gestor = new Gestor(1, "gestor2", "gestor2", "gestor2@gmail.com");
		database.insertarGestor(gestor);
		
		//Obtener gestores
		System.out.println("Lista de Gestores");
		gestores = database.getGestores();
		System.out.println(gestores);
		
		
		
		
		
		
		//Obtener Clientes
		System.out.println("Lista de Clientes");
		ArrayList<Cliente> clientes = database.getClientes();
		System.out.println(clientes);
				
		//Insertar Cliente
		System.out.println("Insertar Cliente");
		Cliente cliente = new Cliente(1, 1, "cliente1", "cliente1", "cliente1@gmail.com", 0);
		database.insertarCliente(cliente);
				
		//Obtener gestores
		System.out.println("Lista de Cliente");
		clientes = database.getClientes();
		System.out.println(clientes);
	}

}
