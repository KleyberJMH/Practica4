package app.curso.banco.main;

import app.curso.banco.util.DatabaseGestor;
import app.curso.banco.entidad.Gestor;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGestorLeer {
	public static void main(String[] args) {
		DatabaseGestor databaseGestor = new DatabaseGestor();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Todos los gestores");
		System.out.println("--------------------------------------------------");
				ArrayList<Gestor> gestores = databaseGestor.getGestores();
				for(int i = 0 ; i<gestores.size(); i++)
				{
					gestores.get(i).showInfo();;
				}
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Buscar por id");
		System.out.println("--------------------------------------");
		System.out.print("Ingrese el id del gestor: ");
		int id = keyboard.nextInt();
		
		keyboard.close();
		
		Gestor gestor = null;
	
		gestor = databaseGestor.getGestor(id);
		if(gestor != null) {
			gestor.showInfo();
		}else {
			System.out.print("El gestor solicitado no existe");
		}
	}

}