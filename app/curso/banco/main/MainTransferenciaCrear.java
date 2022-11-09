package app.curso.banco.main;

import app.curso.banco.util.DatabaseTransferencia;
import app.curso.banco.entidad.Transferencia;

import java.sql.Timestamp;
import java.util.Scanner;

public class MainTransferenciaCrear {
	public static void main(String[] args) {
		DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Ingrese el id del ordenante: ");
		int id_ordenante = keyboard.nextInt();
		
		System.out.print("Ingrese el id del beneficiario: ");
		int id_beneficiario = keyboard.nextInt();
		
		System.out.print("Ingrese el importe: ");
		Double importe = keyboard.nextDouble();
		
		System.out.print("Ingrese el concepto: ");
		String concepto = keyboard.next();
		
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		
		keyboard.close();
		
		
		Transferencia transferencia = new Transferencia(1, id_ordenante, id_beneficiario, importe, concepto, fecha);
		databaseTransferencia.insertarTransferencia(transferencia);
		
	}

}
