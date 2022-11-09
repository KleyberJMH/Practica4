package app.curso.banco.main;

import java.util.Scanner;
import app.curso.banco.util.DatabaseCliente;

public class MainClienteEliminar {

	public static void main(String[] args) {
		DatabaseCliente databaseCliente = new DatabaseCliente();
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id del cliente a eliminar: ");
		int id = keyboard.nextInt();
		
		boolean clienteBorrado = databaseCliente.borrarCliente(id);
		
		if (clienteBorrado) {
			System.out.print("Se ha eliminado el cliente " + id);
		}else {
			System.out.print("No se ha eliminado el cliente " + id);
		}
		keyboard.close();

	}

}