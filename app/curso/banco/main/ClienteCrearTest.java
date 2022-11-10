package app.curso.banco.main;

import app.curso.banco.util.DatabaseCliente;
import app.curso.banco.entidad.Cliente;
import java.util.Scanner;

public class ClienteCrearTest {
	public static void main(String[] args) {
		DatabaseCliente databaseCliente = new DatabaseCliente();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Ingrese el id del gestor: ");
		int id_gestor = keyboard.nextInt();
		
		System.out.print("Ingrese el usuario del cliente: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese el contraseña del cliente: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese el correo del cliente: ");
		String correo = keyboard.next();
		
		System.out.print("Ingrese el saldo del cliente: ");
		Double saldo = keyboard.nextDouble();
		
		keyboard.close();
		
		
		Cliente cliente = new Cliente(1, id_gestor, username, password, correo, saldo);
		boolean clienteInsertado = databaseCliente.insertarCliente(cliente);
		
		if(clienteInsertado) {
			System.out.println("El cliente se inserto correctamente");
		}else {
			System.out.println("No se pudo insertar el cliente");
		}
	}

}