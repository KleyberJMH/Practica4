package app.curso.banco.main;

import app.curso.banco.util.DatabaseMensaje;
import app.curso.banco.entidad.Mensaje;
import java.util.Scanner;
import java.sql.Timestamp;

public class MainMensajeCrear {
	public static void main(String[] args) {
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Ingrese el id del origen: ");
		int id_origen = keyboard.nextInt();
		
		System.out.print("Ingrese el id del destino: ");
		int id_destino = keyboard.nextInt();
		
		System.out.print("Ingrese el texto: ");
		String texto = keyboard.next();
		
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		
		keyboard.close();
		
		
		Mensaje mensaje = new Mensaje(1, id_origen, id_destino, texto, fecha);
		databaseMensaje.insertarMensaje(mensaje);
		
	}

}
