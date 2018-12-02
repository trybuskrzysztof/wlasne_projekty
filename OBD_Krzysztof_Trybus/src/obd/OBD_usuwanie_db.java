package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OBD_usuwanie_db {
	public static void usuwanie() {

		try {
			
			String sqlDropPrzedmiot = "DROP TABLE przedmiot";
			String sqlDropNauczyciel = "DROP TABLE nauczyciel";
			String sqlDropOcena = "DROP TABLE ocena";
			String sqlDropUczen = "DROP TABLE uczen";
			String sqlDropOcenianie = "DROP TABLE ocenianie";

			
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();
			polecenie.execute(sqlDropPrzedmiot);
			polecenie.execute(sqlDropNauczyciel);
			polecenie.execute(sqlDropOcena);
			polecenie.execute(sqlDropUczen);
			polecenie.execute(sqlDropOcenianie);
			System.out.println("Baza danych zostala usunieta.");
											
			polaczenie.close();
			
			}
			
			catch (SQLException e) {
//			System.out.println("Baza danych nie istnieje");
			e.printStackTrace();

			return;
			}
			
			System.out.println("Sukces.");		
					
	}

}



