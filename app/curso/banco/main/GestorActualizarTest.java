package app.curso.banco.main;

import java.util.Scanner;

import app.curso.banco.entidad.Gestor;
import app.curso.banco.util.DatabaseGestor;

public class GestorActualizarTest {

	public static void main(String[] args) {
		DatabaseGestor databaseGestor = new DatabaseGestor();
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Ingrese id del gestor a actualizar: ");
		int id = keyboard.nextInt();
		
		
		
		Gestor gestor = null;
		
		gestor = databaseGestor.getGestor(id);
		
		if(gestor!=null) {
			System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
			System.out.print("Ingrese nuevo username: ");
			String username = keyboard.next();
			
			System.out.print("Ingrese nuevo password: ");
			String password = keyboard.next();
			
			System.out.print("Ingrese nuevo correo: ");
			String correo = keyboard.next();
			
			if(!username.equals("0")) {
				gestor.setUsuario(username);
			}
			
			if(!password.equals("0")) {
				gestor.setPassword(password);
			}
			
			if(!correo.equals("0")) {
				gestor.setCorreo(correo);
			}
			
			boolean gestorActualizado = databaseGestor.actualizarGestor(gestor);

			if(gestorActualizado) {
				System.out.println("Se actualizo el gestor! \n Datos actualizado:");
				gestor.showInfo();
			}else {
				System.out.println("No se actualizo");
			}
			
			keyboard.close();
		}else {
			System.out.println("No hay un gestor con esa id");
		}
		
		

	}

}
