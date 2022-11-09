package app.curso.banco.main;

import app.curso.banco.util.DatabaseCliente;
import app.curso.banco.entidad.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClienteLeer {
	public static void main(String[] args){
		DatabaseCliente databaseCliente = new DatabaseCliente();
		
		
		ArrayList<Cliente> clientes = null;		
		clientes = databaseCliente.getClientes();
				
		if(clientes != null) {
			System.out.println("--------------------------------------------------");
			System.out.println("Todos los clientes");
			System.out.println("--------------------------------------------------");
			clientes.forEach((cliente)-> {
				cliente.showInfo();
			});
		}else {
			System.out.println("No hay clientes en la base de datos");
		}
				

		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Buscar por id");
		System.out.println("--------------------------------------");
		System.out.print("Ingrese el id del cliente: ");
		int id = keyboard.nextInt();
		
		keyboard.close();
		
		Cliente cliente = null;
	
		cliente = databaseCliente.getCliente(id);
		if(cliente != null) {
			cliente.showInfo();
		}else {
			System.out.print("El cliente solicitado no existe");
		}
	}

}
