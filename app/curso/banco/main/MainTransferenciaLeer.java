package app.curso.banco.main;

import app.curso.banco.util.DatabaseTransferencia;
import app.curso.banco.entidad.Transferencia;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTransferenciaLeer {
	public static void main(String[] args) {
		DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
		
		
		ArrayList<Transferencia> transferencias = null;		
		transferencias = databaseTransferencia.getTransferencias();
			
		if(transferencias != null) {
			System.out.println("--------------------------------------------------");
			System.out.println("Todas las transferencias");
			System.out.println("--------------------------------------------------");
			transferencias.forEach((transferencia)-> {
				transferencia.showInfo();
			});
		}
				
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Buscar por id");
		System.out.println("--------------------------------------");
		System.out.print("Ingrese el id de la transferencia: ");
		int id = keyboard.nextInt();
		
		keyboard.close();
		
		Transferencia transferencia = null;
	
		transferencia = databaseTransferencia.getTransferencia(id);
		if(transferencia != null) {
			transferencia.showInfo();
		}else {
			System.out.print("La transferencia solicitada no existe");
		}
	}

}
