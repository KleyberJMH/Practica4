package app.curso.banco.main;

import app.curso.banco.util.DatabaseGestor;
import app.curso.banco.entidad.Gestor;
import java.util.Scanner;

public class MainGestorCrear {
	public static void main(String[] args) {
		DatabaseGestor databaseGestor = new DatabaseGestor();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Ingrese el usuario del gestor: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese el contraseña del gestor: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese el correo del gestor: ");
		String correo = keyboard.next();
		
		keyboard.close();
		
		
		Gestor gestor = new Gestor(1, username, password, correo);
		databaseGestor.insertarGestor(gestor);
		
	}

}
