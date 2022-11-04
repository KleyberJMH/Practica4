package app.curso.banco.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connection conexion = null;
		PreparedStatement instruccion = null;
		ResultSet resultados = null;
		
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			System.out.println("Version del driver: " + conexion.getMetaData().getDriverVersion());
			
			conexion.setAutoCommit(false);
//			//Creamos el Statement "instruccion" para manejar la base de datos
//			Statement instruccion = conexion.createStatement();
//			
//			//Creamos la instruccion para insertar un gestor con valores
//			String crearGestor = "INSERT INTO gestor (usuario, password, correo) VALUES ('admin1','admin1', 'admin1@correo.com')";
			
//			//Ejecutando la instruccion con executeQuery (R) del CRUD
//			boolean resultado = instruccion.executeQuery(crearGestor);
//			
//			if(!resultado) {
//				System.out.println("Registro insertado: "+ instruccion.getUpdateCount());
//			}
			
//			//Ejecutando la instruccion con executeUpdate (CUD) del CRUD
//			int registrosInsertados = instruccion.executeUpdate(crearGestor);
//			System.out.println("Registros insertados: " + registrosInsertados);
			
//			//Creamos la instruccion para buscar todos los gestores
//			String query = "SELECT * FROM gestor";
			
//			//Ejecutamos la instruccion executeQuery para buscar los resultados y guardarlos como un ResultSet
//			ResultSet resultados1 = instruccion.executeQuery(query);
//			System.out.println("Listado de gestores (con executeQuery): ");
//			//Recorremos el while con la variable de resultado .next() que busca el siguiente			
//			while (resultados1.next()) {
//				System.out.println("Gestor " + resultados1.getInt("id"));
//				System.out.println("Usuario: " + resultados1.getString("usuario"));
//				System.out.println("Password: " + resultados1.getString("password"));
//				System.out.println("Correo: " + resultados1.getString("correo"));
//				System.out.println("...");
//				}
			
			
 			//Preparamos el insert con perparedStatement
			instruccion = conexion.prepareStatement("INSERT INTO gestor(usuario,password, correo) VALUES (?,?,?)");
			instruccion.setString(1, "gestorPrueba");
			instruccion.setString(2, "gestorPrueba");
			instruccion.setString(3, "gestorPrueba@correo.com");
			
			//Ejecutamos l
			instruccion.executeUpdate();
			
			instruccion = conexion.prepareStatement("INSERT INTO gestor(usuario,password, correo) VALUES (?,?,?)");
			instruccion.setString(1, "gestorPrueba1");
			instruccion.setString(2, "gestorPrueba1");
			instruccion.setString(3, "gestorPrueba1@correo.com");
			
			//Ejecutamos l
			instruccion.executeUpdate();
			
			conexion.commit();

//				
//				//Preparamos la busqueda
//				instruccion = conexion.prepareStatement("SELECT * from gestor WHERE id BETWEEN ? AND ?");
//				//Llenamos los datos faltantes en la instruccion con "?"
//				instruccion.setInt(1, 1);
//				instruccion.setInt(2, 5);
//				//Quedando como resultado "SELECT * from gestor WHERE id BETWEEN 1 AND 5"
//
//				resultados = instruccion.executeQuery();
//				System.out.println("Gestores entre el 1 y el 5: ");
//				
//				while (resultados.next()) {
//				System.out.println("Gestor " + resultados.getInt("id"));
//				System.out.println("Usuario: " + resultados.getString("usuario"));
//				System.out.println("Password: " + resultados.getString("password"));
//				System.out.println("Correo: " + resultados.getString("correo"));
//				System.out.println("----------------------------------------------------------");
//				}

			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.rollback();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}

			if(conexion != null) {
				conexion.close();
			}
			
			if(instruccion != null) {
				instruccion.close();
			}
			if(resultados != null) {
				resultados.close();
			}
			
			
			
		}
		
		

	}

}
