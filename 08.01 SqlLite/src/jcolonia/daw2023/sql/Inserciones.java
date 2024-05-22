package jcolonia.daw2023.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserciones {

	public static void main(String[] args) {
		String fuente = "jdbc:sqlite:ejemplo001.db";
		try (
				Connection conexión = DriverManager.getConnection(fuente);
				Statement sentenciaSQL = conexión.createStatement();
				){
				// Conexión fallida: ¿conexión == null? ¿try/catch?
				{
				// …obrar en consecuencia
				}
				sentenciaSQL.setQueryTimeout(5);
				sentenciaSQL.executeUpdate("DROP TABLE IF EXISTS Personal");
				sentenciaSQL.executeUpdate(
				"CREATE TABLE Personal (Id INTEGER PRIMARY KEY, Nombre TEXT NOT NULL)");
			} catch (SQLException e) {
				System.err.printf("<<Error: %s%n\t-%s-%n","No se ha creado la base de fatos SQLote", e.getLocalizedMessage());
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
				System.exit(1);
			}
		
		try (
			Connection conexión = DriverManager.getConnection(fuente);
			PreparedStatement preparaciónSQL = conexión.prepareStatement("INSERT INTO Personal values(?,?)");
			){
			// Conexión fallida: ¿conexión == null? ¿try/catch?
			{
			// …obrar en consecuencia
			}
		
			int ids[] = { 1, 2, 3, 4, 5 };
			String nombres[] = { "África", "Björn", "Cristina", "Delfín", "Elena" };
			
			for (int i = 0; i < ids.length; i++) {
				preparaciónSQL.setInt(1, ids[i]);
				preparaciónSQL.setString(2, nombres[i]);
				preparaciónSQL.setQueryTimeout(5);
				preparaciónSQL.executeUpdate(); // ¡INSERTAMOS, por fin!
			}
		} catch (SQLException e) {
			System.err.printf("<<Error: %s%n\t-%s-%n","No se ha creado la base de fatos SQLote", e.getLocalizedMessage());
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public Inserciones() {
		// TODO Esbozo de constructor generado automáticamente
	}

}
