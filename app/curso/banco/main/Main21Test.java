package app.curso.banco.main;

import java.util.ArrayList;

import app.curso.banco.entidad.Gestor;
import app.curso.banco.util.DatabaseGestor;

public class Main21Test {

	public static void main(String[] args) {
		DatabaseGestor database = new DatabaseGestor();
		
//		//Obtener Gestores
//		System.out.println("Lista de Gestores");
//		ArrayList<Gestor> gestores = database.getGestores();
//		System.out.println(gestores);
//		
//		//Insertar Gestor
//		System.out.println("Insertar Gestor");
//		Gestor gestor = new Gestor(1, "gestor2", "gestor2", "gestor2@gmail.com");
//		database.insertarGestor(gestor);
//		
//		//Obtener gestores
//		System.out.println("Lista de Gestores");
//		gestores = database.getGestores();
//		System.out.println(gestores);
		
		//Obetener gestor id 11

		Gestor gestor = database.getGestor(11);
		System.out.println("Gestor id " + gestor.getId());
		System.out.println("Usuario: " + gestor.getUsuario());
		System.out.println("Contraseña: " + gestor.getPassword());
		System.out.println("Correo: " + gestor.getCorreo());
		
		
//		//Eliminar Gestor id 10
//		boolean gestorBorrado = database.borrarGestor(10);
//		
//		if (gestorBorrado) {
//			System.out.print("Se ha eliminado el gestor 10");
//		}else {
//			System.out.print("No se ha borrado el gestor 10");
//		}
		
		
		//Actualizar gestor id 11
		gestor.setCorreo("CorreoCambiado@gmail.com");
		
		boolean gestorActualizado = database.actualizarGestor(gestor);
		
		if(gestorActualizado) {
			System.out.println("Gestor id " + gestor.getId());
			System.out.println("Usuario: " + gestor.getUsuario());
			System.out.println("Contraseña: " + gestor.getPassword());
			System.out.println("Correo: " + gestor.getCorreo());
		}else {
			System.out.println("No se actualizo");
		}
		

		
		
		
	}

}
