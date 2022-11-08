package app.curso.banco.entidad;
import java.sql.Timestamp;

public class Transferencia {
	private int id;
	private int id_ordenante;
	private int id_beneficiario;
	private Double importe;
	private String concepto;
	private Timestamp fecha;
	
	//Constructor
	public Transferencia(int id, int id_ordenante, int id_beneficiario, Double importe, String concepto, Timestamp fecha) {
		this.id = id;
		this.id_ordenante = id_ordenante;
		this.id_beneficiario = id_beneficiario;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = fecha;
	}
	
	public Transferencia() {
		
	}
	
	
	//Metodos

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ordenante() {
		return id_ordenante;
	}

	public void setId_ordenante(int id_ordenante) {
		this.id_ordenante = id_ordenante;
	}

	public int getId_beneficiario() {
		return id_beneficiario;
	}

	public void setId_beneficiario(int id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	public void showInfo() {
		System.out.println("Transferencia id " + this.getId());
		System.out.println("Id Ordenante: " + this.getId_ordenante());
		System.out.println("Id Beneficiario: " + this.getId_beneficiario());
		System.out.println("Importe: " + this.getImporte());
		System.out.println("Concepto: " + this.getConcepto());
		System.out.println("Fecha: " + this.getFecha());
		System.out.println("--------------------------------------------------");
	}

	
}
