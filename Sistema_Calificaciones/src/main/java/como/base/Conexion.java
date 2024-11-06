package como.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion;
	private static Conexion instancia;
	
	private static final String BASE_DATOS_URL = "jdbc:mysql://localhost/prueba";
	private static final String BASE_DATOS_NOMBRE = "root";
	private static final String BASE_DATOS_CONTRASEÑA = "";
	
	public Conexion() {
		
		
		
	}
	
	public Connection conectar() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(BASE_DATOS_URL, BASE_DATOS_NOMBRE, BASE_DATOS_CONTRASEÑA);
			
			System.out.println("Conexion Exitosa");
			
			return conexion;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Conexion Fallida");
		}
		
		return conexion;
		
	}
	
	public void cerrarConexion() throws SQLException{
		
		try {
			conexion.close();
			System.out.println("Conexion Cerrada exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
			conexion.close();
		}finally {
			conexion.close();
			
		}
		
	}
	
	public static Conexion getInstance() {
		
		if(instancia == null) {
			
			instancia = new Conexion();
			
		}
		
		return instancia;
		
	}
	
}
