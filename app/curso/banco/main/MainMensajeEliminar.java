package app.curso.banco.main;

import java.util.Scanner;
import app.curso.banco.util.DatabaseMensaje;

public class MainMensajeEliminar {

	public static void main(String[] args) {
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id del mensaje a eliminar: ");
		int id = keyboard.nextInt();
		
		boolean mensajeBorrado = databaseMensaje.borrarMensaje(id);
		
		if (mensajeBorrado) {
			System.out.print("Se ha eliminado el mensaje " + id);
		}else {
			System.out.print("No se ha eliminado el mensaje " + id);
		}
		keyboard.close();

	}

}