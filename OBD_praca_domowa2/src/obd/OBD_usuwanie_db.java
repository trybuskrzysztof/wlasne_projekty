package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OBD_usuwanie_db {
	public static void usuwanie() {

		String nazwaSterownika = "oracle.jdbc.driver.OracleDriver"; 			// for Oracle
		
		try {
			
			String sqlDropPrzedmiot = "DROP TABLE przedmiot";
			String sqlDropNauczyciel = "DROP TABLE nauczyciel";
			String sqlDropOcena = "DROP TABLE ocena";
			String sqlDropUczen = "DROP TABLE uczen";
			String sqlDropOcenianie = "DROP TABLE ocenianie";

			
			Connection polaczenie = DriverManager.getConnection(Namiary.url, Namiary.uzytkownik, Namiary.haslo);
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
				
			System.out.println("Nieudane połączenie z bazą danych! Baza danych nie istnieje");

			return;
			}
			
			System.out.println("Sukces.");		
					
	}

}



