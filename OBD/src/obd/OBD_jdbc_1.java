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

public class OBD_jdbc_1 {

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
			
		String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
		String uzytkownik = "xktrybus";
		String haslo = "xktrybus";
		String sql1 = "CREATE TABLE dzialy ("
				+ "nr_dzialu integer not null,"
				+ " nazwa_dzialu varchar2(30),"
				+ "siedziba varchar2(50) not null)";
		String sql2_1 = "INSERT INTO dzialy (nr_dzialu, nazwa_dzialu, siedziba)"
					+	"VALUES (1, 'DYREKCJA', 'UL. 1 STYCZNIA 23')";
		String sql2_2 = "INSERT INTO dzialy (nr_dzialu, nazwa_dzialu, siedziba)"
				+	"VALUES (2, 'HR', 'UL. DOMANIEWSKA 3')";
		String sql2_3 = "INSERT INTO dzialy (nr_dzialu, nazwa_dzialu, siedziba)"
				+	"VALUES (3, 'FINANSE', 'UL. 1 MAJA 9')";
		String sql2_4 = "INSERT INTO dzialy (nr_dzialu, nazwa_dzialu, siedziba)"
				+	"VALUES (4, 'IT', 'UL. RAKIETNIKOW 5')";
			
		String sql3 = "UPDATE dzialy SET nr_dzialu = 10 WHERE nr_dzialu = 1";
		String sql4 = "DELETE FROM dzialy WHERE nr_dzialu = 10";
			
		Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
		System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
		Statement polecenie = polaczenie.createStatement();
		System.out.println("execute: " + polecenie.execute(sql2_1)
									   + polecenie.execute(sql2_2)
									   + polecenie.execute(sql2_3)
									   + polecenie.execute(sql2_4));
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

