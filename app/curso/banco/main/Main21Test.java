package app.curso.banco.main;

import java.sql.Timestamp;
import java.util.ArrayList;

import app.curso.banco.entidad.Mensaje;
import app.curso.banco.util.DatabaseGestor;
import app.curso.banco.util.DatabaseMensaje;

public class Main21Test {

	public static void main(String[] args) {
		DatabaseGestor databaseGestor = new DatabaseGestor();
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		
		

//		
//		//Insertar Gestor
//		Gestor gestor = new Gestor(1, "gestor2", "gestor2", "gestor2@gmail.com");
//		databaseGestor.insertarGestor(gestor);
		
		//Insertar Mensaje
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Mensaje mensaje = new Mensaje(1, 2, 3, "Mensaje de prueba a ver si funciona2",timestamp);
		databaseMensaje.insertarMensaje(mensaje);
		
		
//		//Obtener gestores
//		System.out.println("Lista de Gestores");
//		gestores = databaseGestor.getGestores();
//		System.out.println(gestores);
		
		//Obtener Mensajes
		System.out.println("Lista de Mensajes");
		System.out.println("----------------------------");
		ArrayList<Mensaje> mensajes = databaseMensaje.getMensajes();
		for(int i = 0 ; i<mensajes.size(); i++)
		{
			mensajes.get(i).showInfo();;
		}
		
//		
		
		//Obetener gestor id 11
//		Gestor gestor = databaseGestor.getGestor(11);
//		gestor.showInfo();
		
//		//Obetener mensaje id 1
//		Mensaje mensaje = databaseMensaje.getMensaje(1);
//		mensaje.showInfo();
		
//		//Eliminar Gestor id 10
//		boolean gestorBorrado = databaseGestor.borrarGestor(10);
//		
//		if (gestorBorrado) {
//			System.out.print("Se ha eliminado el gestor 10");
//		}else {
//			System.out.print("No se ha borrado el gestor 10");
//		}
		
		
//		//Actualizar gestor id 11
//		gestor.setCorreo("CorreoCambiado@gmail.com");
//		
//		boolean gestorActualizado = databaseGestor.actualizarGestor(gestor);
//		
//		if(gestorActualizado) {
//			System.out.println("Gestor id " + gestor.getId());
//			System.out.println("Usuario: " + gestor.getUsuario());
//			System.out.println("Contraseña: " + gestor.getPassword());
//			System.out.println("Correo: " + gestor.getCorreo());
//		}else {
//			System.out.println("No se actualizo");
//		}
		
		
//		//Actualizar mensaje id 1
//		mensaje.setTexto("Se cambio el mensaje con el actualizar");
//		
//		boolean mensajeActualizado = databaseMensaje.actualizarMensaje(mensaje);
//		
//		if(mensajeActualizado) {
//		System.out.println("Mensaje id " + mensaje.getId());
//		System.out.println("Id Origen: " + mensaje.getId_origen());
//		System.out.println("Id Destinatario: " + mensaje.getId_destino());
//		System.out.println("Mensaje: " + mensaje.getTexto());
//		System.out.println("Fecha: " + mensaje.getFecha());	
//		}else {
//			System.out.println("No se actualizo");
//		}
		
		
		

		
		
		
	}
}
