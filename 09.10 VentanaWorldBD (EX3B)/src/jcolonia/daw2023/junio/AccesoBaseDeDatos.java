package jcolonia.daw2023.junio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.sqlite.SQLiteDataSource;

public class AccesoBaseDeDatos {

	private String país;

	private Connection conexión;
	private String pais;

	SQLiteDataSource ds;
	
	public AccesoBaseDeDatos(){
		String fuente = String.format("jdbc:sqlite:world2.db");
		this.ds = new SQLiteDataSource();
		ds.setUrl(fuente);
	}

	public String[] query(int id) {
		String[] datos = {"","",""};
		
		try (Connection conn = ds.getConnection()){
			PreparedStatement preparaciónSQL = conn.prepareStatement("SELECT * FROM Country  limit 1 offset ?");
			preparaciónSQL.setInt(1,id);
			ResultSet loteDatos = preparaciónSQL.executeQuery();
			
			if (loteDatos.next()) {
				datos[0] = loteDatos.getString("Name");
				datos[1] = loteDatos.getString("Capital");
				datos[2] = loteDatos.getString("Language");
			}else {
				System.out.println("No hay datos que recabar");
			}
		} catch (SQLException e) {
			String mensaje = "No se pudo abrir el archivo";
			mensaje = String.format("%s - «%s»", mensaje, e.getLocalizedMessage());
		}
		return datos;
	}

	public static void configurar(String rutaArchivo) {
		Properties configuración = new Properties();
		configuración.setProperty("jdbc.nombreDB", "world2.db");
		configuración.setProperty("jdbc.ubicación", ".");
		configuración.setProperty("jdbc.user", "");
		configuración.setProperty("jdbc.password", "🙁");

		try (FileOutputStream out = new FileOutputStream(rutaArchivo)) {
			configuración.storeToXML(out, "Configuración BD");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties importarConfiguracion(String rutaArchivo) throws BaseDatosException {
		Properties configuración = new Properties();
		try (FileInputStream in = new FileInputStream(rutaArchivo)) {
			configuración.loadFromXML(in);
		} catch (IOException e) {
			String mensaje = "No se pudo leer la configuración";
			mensaje = String.format("%s - «%s»", mensaje, e.getLocalizedMessage());
			throw new BaseDatosException(mensaje, e);
		}
		return configuración;
	}

}
