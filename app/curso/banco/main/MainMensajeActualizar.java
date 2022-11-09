package app.curso.banco.main;

import java.util.Scanner;

import app.curso.banco.entidad.Mensaje;
import app.curso.banco.util.DatabaseMensaje;

public class MainMensajeActualizar {

	public static void main(String[] args) {
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id del mensaje a actualizar: ");
		int id = keyboard.nextInt();
		
		
		
		Mensaje mensaje = null;
		
		mensaje = databaseMensaje.getMensaje(id);
		
		if(mensaje!=null) {
			System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
			System.out.print("Ingrese nuevo texto: ");
			String texto = keyboard.next();
			
			if(!texto.equals("0")) {
				mensaje.setTexto(texto);
			}
			
			boolean mensajeActualizado = databaseMensaje.actualizarMensaje(mensaje);

			if(mensajeActualizado) {
				System.out.println("Se actualizo el mensaje! \n Datos actualizado:");
				mensaje.showInfo();
			}else {
				System.out.println("No se actualizo");
			}
			
			keyboard.close();
		}else {
			System.out.println("No hay un mensaje con esa id");
		}
		
		

	}

}
