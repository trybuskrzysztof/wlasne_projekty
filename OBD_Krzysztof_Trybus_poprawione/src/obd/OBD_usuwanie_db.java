package obd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OBD_usuwanie_db {
	
	public static void usuwanie(Connection polaczenie) {

		try {
			
			String sqlDropPrzedmiot = "DROP TABLE przedmiot";
			String sqlDropNauczyciel = "DROP TABLE nauczyciel";
			String sqlDropOcena = "DROP TABLE ocena";
			String sqlDropUczen = "DROP TABLE uczen";
			String sqlDropOcenianie = "DROP TABLE ocenianie";

			Statement polecenie = polaczenie.createStatement();
			polecenie.execute(sqlDropPrzedmiot);
			polecenie.execute(sqlDropNauczyciel);
			polecenie.execute(sqlDropOcena);
			polecenie.execute(sqlDropUczen);
			polecenie.execute(sqlDropOcenianie);
			System.out.println("Baza danych zostala usunieta.");
			
			}
			
			catch (SQLException e) {
			System.out.println("Check error message:");
			e.printStackTrace();

			return;
			}
			
			System.out.println("Sukces.");		
					
	}

}



