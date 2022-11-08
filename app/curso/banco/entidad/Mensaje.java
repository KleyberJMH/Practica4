package app.curso.banco.entidad;

import java.sql.Timestamp;

public class Mensaje {
	private int id;
	private int id_origen;
	private int id_destino;
	private String texto;
	private Timestamp fecha;
	
	//Constructor
	public Mensaje(int id, int id_origen, int id_destino, String texto, Timestamp fecha) {
		this.id = id;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public Mensaje() {
		
	}
	//Metodos
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_origen() {
		return id_origen;
	}

	public void setId_origen(int id_origen) {
		this.id_origen = id_origen;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	public void showInfo() {
		System.out.println("Mensaje id " + this.getId());
		System.out.println("Id Origen: " + this.getId_origen());
		System.out.println("Id Destinatario: " + this.getId_destino());
		System.out.println("Mensaje: " + this.getTexto());
		System.out.println("Fecha: " + this.getFecha());
		System.out.println("--------------------------------------------------");
	}
	
}
