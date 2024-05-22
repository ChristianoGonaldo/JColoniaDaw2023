package jcolonia.daw2023.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class MorosSinPapeles {

	public static void main(String[] args) {
		String fuente = "jdbc:sqlite:withoutpapers.db";
		
		try (
			Connection conexión = DriverManager.getConnection(fuente);
			Statement sentenciaSQL = conexión.createStatement();
			){
			// Conexión fallida: ¿conexión == null? ¿try/catch?
			{
			// …obrar en consecuencia
			}
			sentenciaSQL.setQueryTimeout(5);
			sentenciaSQL.executeUpdate("DROP TABLE IF EXISTS Moros");
			sentenciaSQL.executeUpdate(
			"CREATE TABLE Moros (Id INTEGER PRIMARY KEY,Papeles TEXT NOT NULL, Nombre TEXT NOT NULL)");
		} catch (SQLException ex) {
			System.err.printf("<<Error: %s%n\t-%s-%n","No se ha creado la base de fatos SQLote", ex.getLocalizedMessage());
			// TODO Bloque catch generado automáticamente
			ex.printStackTrace();
			System.exit(1);
		}
		
		try (
				Connection conexión = DriverManager.getConnection(fuente);
				PreparedStatement preparaciónSQL = conexión.prepareStatement("INSERT INTO Moros values(?,?,?)");
				){
				// Conexión fallida: ¿conexión == null? ¿try/catch?
				{
				// …obrar en consecuencia
				}
				
				int ids[] = { 1, 2, 3, 4, 5 };
				String papeles[] = {"Si","No"}; 
				String nombres[] = { "África", "Björn", "Cristina", "Delfín", "Elena" };
				String[] nombresMarroquies = {
					    "Mohamed", "Fatima","Ahmed", "Khadija", "Youssef", "Aicha", "Hassan", "Zineb", "Abdelkader", "Meriem", 
					    "Mustapha", "Leila", "Rachid", "Nadia",  "Saad",  "Asma",  "Hicham", "Imane", "Tarek", "Samira"
					};

				Random numero = new Random(); 
				int aleatorio;
				
				for (int i = 0; i < nombresMarroquies.length; i++) {
					aleatorio = numero.nextInt(2);
					preparaciónSQL.setInt(1, i);
					preparaciónSQL.setString(2, papeles[aleatorio]);
					preparaciónSQL.setString(3, nombresMarroquies[i]);
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
	
	public MorosSinPapeles() {
		// TODO Esbozo de constructor generado automáticamente
	}
	
	public void preparacion(String fuente) {
		try (
				Connection conexión = DriverManager.getConnection(fuente);
				Statement sentenciaSQL = conexión.createStatement();
				PreparedStatement preparaciónSQL = conexión.prepareStatement("INSERT INTO Moros values(?,?,?)");
				){
				// Conexión fallida: ¿conexión == null? ¿try/catch?
				{
				// …obrar en consecuencia
				}
				sentenciaSQL.setQueryTimeout(5);
				sentenciaSQL.executeUpdate("DROP TABLE IF EXISTS Moros");
				sentenciaSQL.executeUpdate(
				"CREATE TABLE Moros (Id INTEGER PRIMARY KEY,Papeles TEXT NOT NULL, Nombre TEXT NOT NULL)");
				
				int ids[] = { 1, 2, 3, 4, 5 };
				String papeles[] = {"Si","No"}; 
				String nombres[] = { "África", "Björn", "Cristina", "Delfín", "Elena" };
				String[] nombresMarroquies = {
					    "Mohamed",
					    "Fatima",
					    "Ahmed",
					    "Khadija",
					    "Youssef",
					    "Aicha",
					    "Hassan",
					    "Zineb",
					    "Abdelkader",
					    "Meriem",
					    "Mustapha",
					    "Leila",
					    "Rachid",
					    "Nadia",
					    "Saad",
					    "Asma",
					    "Hicham",
					    "Imane",
					    "Tarek",
					    "Samira"
					};

				Random numero = new Random(); 
				int aleatorio = numero.nextInt(1);
				
				for (int i = 0; i < nombresMarroquies.length; i++) {
					preparaciónSQL.setInt(1, i);
					preparaciónSQL.setString(2, papeles[aleatorio]);
					preparaciónSQL.setString(3, nombresMarroquies[i]);
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

}
