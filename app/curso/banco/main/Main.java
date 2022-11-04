package app.curso.banco.main;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			System.out.println("Version del drive: " + conexion.getMetaData().getDriverVersion());
		}catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}

}
