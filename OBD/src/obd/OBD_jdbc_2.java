package obd;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * OBD - Obs�uga Baz Danych
 * 
 * Politechnika Warszawska
 * Wydzia� Elektroniki i Technik Informacyjnych
 * Instytut Informatyki
 * 
 * Studia podyplomowe
 * Java EE � produkcja oprogramowania
 * 
 * @author Wojciech Kami�ski
 * 
 * �adowanie/rejestracja sterownika JDBC.
 */



public class OBD_jdbc_2 {
	
	static class Namiary {
		static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
		static String uzytkownik = "xktrybus";
		static String haslo = "xktrybus";
	}

	public static void main(String[] args) {

		String nazwaSterownika = "oracle.jdbc.driver.OracleDriver"; 			// for Oracle
		// String driverName = "com.ibm.db2.jcc.DB2Driver"; 					// for DB2
		// String driverName = "jdbc.gupta.sqlbase.SqlbaseDriver"; 				// for Gupta
		// String driverName = "com.informix.jdbc.IfxDriver"; 					// for Informix
		// String driverName = "com.ingres.jdbc.IngresDriver"; 					// for Ingres
		// String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";			// for MS Access
		// String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";					// for ...
		// String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	// for MS SQL Server
		// String driverName = "com.mysql.jdbc.Driver"; 						// for MySql
		// String driverName = "org.postgresql.Driver";							// for PostgreSQL
		// String driverName = "com.progress.sql.jdbc.JdbcProgressDriver";		// for Progress
		
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
		
		try {
		String sql = "SELECT nr_dzialu, nazwa_dzialu, siedziba FROM dzialy";
			
		Connection polaczenie = DriverManager.getConnection(Namiary.url, Namiary.uzytkownik, Namiary.haslo);
		System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
		Statement polecenie = polaczenie.createStatement();
		ResultSet rs = polecenie.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("nr_dzialu") + "|" + rs.getString("nazwa_dzialu") + "|" + rs.getString("nazwa_dzialu") + "|" + rs.getString("siedziba"));
		}
//		System.out.println("execute: " + polecenie.execute(sql));
		rs.close();
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
