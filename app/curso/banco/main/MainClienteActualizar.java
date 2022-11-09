package app.curso.banco.main;

import java.util.Scanner;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.util.DatabaseCliente;

public class MainClienteActualizar {

	public static void main(String[] args) {
		DatabaseCliente databaseCliente = new DatabaseCliente();
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id del cliente a actualizar: ");
		int id = keyboard.nextInt();
		
		
		
		Cliente cliente = null;
		
		cliente = databaseCliente.getCliente(id);
		
		if(cliente!=null) {
			System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
			System.out.print("Ingrese nuevo id del gestor: ");
			int id_gestor = keyboard.nextInt();
			
			System.out.print("Ingrese nuevo username: ");
			String username = keyboard.next();
			
			System.out.print("Ingrese nuevo password: ");
			String password = keyboard.next();
			
			System.out.print("Ingrese nuevo correo: ");
			String correo = keyboard.next();
			
			System.out.print("Ingrese nuevo saldo: ");
			Double saldo = keyboard.nextDouble();
			
			if(!username.equals("0")) {
				cliente.setUsuario(username);
			}
			
			if(!password.equals("0")) {
				cliente.setPassword(password);
			}
			
			if(!correo.equals("0")) {
				cliente.setCorreo(correo);
			}
			
			if(saldo != 0) {
				cliente.setSaldo(saldo);
			}
			
			if(id_gestor != 0) {
				cliente.setId_gestor(id_gestor);
			}
			
			boolean clienteActualizado = databaseCliente.actualizarCliente(cliente);

			if(clienteActualizado) {
				System.out.println("Se actualizo el cliente! \n Datos actualizado:");
				cliente.showInfo();
			}else {
				System.out.println("No se actualizo");
			}
			
			keyboard.close();
		}else {
			System.out.println("No hay un cliente con esa id");
		}
		
		

	}

}
