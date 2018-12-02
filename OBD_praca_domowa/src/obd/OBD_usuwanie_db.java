package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OBD_usuwanie_db {
	public static void main(String[] args) {

		String nazwaSterownika = "oracle.jdbc.driver.OracleDriver"; 			// for Oracle
		
		try {
		// �aduj sterownik JDBC
		Class c = Class.forName(nazwaSterownika);
		System.out.println("Pakiet     : " + c.getPackage());
		System.out.println("Nazwa klasy: " + c.getName());
			
		} catch (Exception e) {
		// Sterownik nieodnaleziony
		System.out.println("Exception: " + e.getMessage());
		e.printStackTrace();
		return;
		}

		System.out.println("Sukces.");
		
		// Tworzenie bazy danych i wypełnianie danymi
		try {
			
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String uzytkownik = "xktrybus";
			String haslo = "xktrybus";
			String sqlDropPrzedmiot = "DROP TABLE przedmiot";
			String sqlDropNauczyciel = "DROP TABLE nauczyciel";
			String sqlDropOcena = "DROP TABLE ocena";
			String sqlDropUczen = "DROP TABLE uczen";
			String sqlDropOcenianie = "DROP TABLE ocenianie";

			
			Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();
			System.out.println("execute: "  
											+ polecenie.execute(sqlDropPrzedmiot)
											+ polecenie.execute(sqlDropNauczyciel)
											+ polecenie.execute(sqlDropOcena)
											+ polecenie.execute(sqlDropUczen)
											+ polecenie.execute(sqlDropOcenianie)
											);
											
			polaczenie.close();
			
			}
			
			catch (SQLException e) {
				
			System.out.println("Nieudane połączenie z bazą danych!");
			e.printStackTrace();
			return;
			}
			
			System.out.println("Sukces.");		
					
	}

}



