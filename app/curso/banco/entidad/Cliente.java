package app.curso.banco.entidad;

public class Cliente {
//Atributos
	private int id;
	private int id_gestor;
	private String usuario;
	private String password;
	private String correo;
	private double saldo;
	
//Constructores
	public Cliente () {
		
	}
	
	public Cliente(int id, int id_gestor, String usuario, String password, String correo,double saldo) {
		this.id = id;
		this.id_gestor = id_gestor;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.saldo = saldo;
	}
	
//Metodos
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_gestor() {
		return id_gestor;
	}

	public void setId_gestor(int id_gestor) {
		this.id_gestor = id_gestor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void showInfo() {
		System.out.println("Cliente id " + this.getId());
		System.out.println("Id Gestor: " + this.getId_gestor());
		System.out.println("Usuario: " + this.getUsuario());
		System.out.println("Contraseña: " + this.getPassword());
		System.out.println("Correo: " + this.getCorreo());
		System.out.println("Saldo: " + this.getSaldo());
	}
	
	
}