package app.curso.banco.main;

import app.curso.banco.util.DatabaseMensaje;
import app.curso.banco.entidad.Mensaje;
import java.util.Scanner;
import java.sql.Timestamp;

public class MensajeCrearTest {
	public static void main(String[] args) {
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Ingrese el id del origen: ");
		int id_origen = keyboard.nextInt();
		
		System.out.print("Ingrese el id del destino: ");
		int id_destino = keyboard.nextInt();
		
		System.out.print("Ingrese el texto: ");
		keyboard.nextLine();
		String texto = keyboard.nextLine();
		
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		
		keyboard.close();
		
		
		Mensaje mensaje = new Mensaje(1, id_origen, id_destino, texto, fecha);
		
		
		boolean mensajeInsertado = databaseMensaje.insertarMensaje(mensaje);
		
		if(mensajeInsertado) {
			System.out.println("El mensaje se inserto correctamente");
		}else {
			System.out.println("No se pudo insertar el mensaje");
		}
		
	}

}
