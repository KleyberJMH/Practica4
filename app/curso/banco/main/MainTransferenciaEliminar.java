package app.curso.banco.main;

import java.util.Scanner;
import app.curso.banco.util.DatabaseTransferencia;

public class MainTransferenciaEliminar {

	public static void main(String[] args) {
		DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id de la transferencia a eliminar: ");
		int id = keyboard.nextInt();
		
		boolean transferenciaBorrado = databaseTransferencia.borrarTransferencia(id);
		
		if (transferenciaBorrado) {
			System.out.print("Se ha eliminado la transferencia " + id);
		}else {
			System.out.print("No se ha eliminado la transferencia " + id);
		}
		keyboard.close();

	}

}