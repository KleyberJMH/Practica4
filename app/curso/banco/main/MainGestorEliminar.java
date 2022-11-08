package app.curso.banco.main;

import java.util.Scanner;
import app.curso.banco.util.DatabaseGestor;

public class MainGestorEliminar {

	public static void main(String[] args) {
		DatabaseGestor databaseGestor = new DatabaseGestor();
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id del gestor a eliminar: ");
		int id = keyboard.nextInt();
		
		boolean gestorBorrado = databaseGestor.borrarGestor(id);
		
		if (gestorBorrado) {
			System.out.print("Se ha eliminado el gestor " + id);
		}else {
			System.out.print("No se ha eliminado el gestor " + id);
		}
		keyboard.close();

	}

}
