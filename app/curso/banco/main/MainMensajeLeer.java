package app.curso.banco.main;

import app.curso.banco.util.DatabaseMensaje;
import app.curso.banco.entidad.Mensaje;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMensajeLeer {
	public static void main(String[] args) {
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		
		
		ArrayList<Mensaje> mensajes = null;		
		mensajes = databaseMensaje.getMensajes();
			
		if(mensajes != null) {
			System.out.println("--------------------------------------------------");
			System.out.println("Todos los mensajes");
			System.out.println("--------------------------------------------------");
			mensajes.forEach((mensaje)-> {
				mensaje.showInfo();
			});
		}
				
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Buscar por id");
		System.out.println("--------------------------------------");
		System.out.print("Ingrese el id del mensaje: ");
		int id = keyboard.nextInt();
		
		keyboard.close();
		
		Mensaje mensaje = null;
	
		mensaje = databaseMensaje.getMensaje(id);
		if(mensaje != null) {
			mensaje.showInfo();
		}else {
			System.out.print("El mensaje solicitado no existe");
		}
	}

}
