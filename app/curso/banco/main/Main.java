package app.curso.banco.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			System.out.println("Version del driver: " + conexion.getMetaData().getDriverVersion());
			
			Statement instruccion = conexion.createStatement();
			
			String crearGestor = "INSERT INTO gestor (usuario, password, correo) VALUES ('admin1','admin1', 'admin1@correo.com')";
			
			//Ejecutando la QUERY con execute (CRUD)
//			boolean resultado = instruccion.execute(crearGestor);
//			
//			if(!resultado) {
//				System.out.println("Registro insertado: "+ instruccion.getUpdateCount());
//			}
			
			//Ejecutando la QUERY con executeUpdate (Crear, Actualizar y Eliminar)
//			int registrosInsertados = instruccion.executeUpdate(crearGestor);
//
//			System.out.println("Registros insertados: " + registrosInsertados);
			
			String query = "SELECT * FROM gestor";
			ResultSet resultados1 = instruccion.executeQuery(query);
			System.out.println("Listado de gestores (con executeQuery): ");
			
			while (resultados1.next()) {
				System.out.println("Gestor " + resultados1.getInt("id"));
				System.out.println("Usuario: " + resultados1.getString("usuario"));
				System.out.println("Password: " + resultados1.getString("password"));
				System.out.println("Correo: " + resultados1.getString("correo"));
				System.out.println("...");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
