package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OBD_namiary {
	static Connection polaczenie;
	static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	static String uzytkownik = "xktrybus";
	static String haslo = "xktrybus";
	
	public static Connection sprawdzPolaczenie() {
		if (polaczenie == null) {
			try {
				polaczenie = DriverManager
						.getConnection(url, uzytkownik, haslo);
				System.out.println("Nawiazano polaczenie z baza danych");
			} catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				System.out.println("THE END");
//				System.exit(0);
			}
		}
		return polaczenie;
	}
}
