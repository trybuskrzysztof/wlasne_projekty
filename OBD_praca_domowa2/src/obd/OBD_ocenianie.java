package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OBD_ocenianie {

	private static Connection connection;
	private static String url ="jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	private static String uzytkownik = "xktrybus";
	private static String haslo = "xktrybus";

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager
						.getConnection(url, uzytkownik, haslo);
			} catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				System.out.println("KONIEC PROGRAMU");
				System.exit(0);
			}
		}
		return connection;
	}

	public static void ocen(Connection connection, int idn, int idu, int idp,
			int ido, String ocena) {
		if (!OBD_ocenianie.nauczycielExist(connection, idn)) {
			System.out.println("Nauczyciel o idn:" + idn + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.uczenExist(connection, idu)) {
			System.out.println("Uczen o idu:" + idu + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.przedmiotExist(connection, idp)) {
			System.out.println("Przedmiot o idp:" + idp + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.ocenaExist(connection, ido)) {
			System.out.println("Ocena o ido:" + ido + " nie istnieje");
			return;
		}

		if (!(ocena.equals("C") || ocena.equals("S") || ocena.equals("c") || ocena
				.equals("s"))) {
			System.out.println("Niepoprawna warto��!");
			return;
		}
		insertOcenianie(connection, idn, idu, idp, ido, ocena);
	}

	private static void insertOcenianie(Connection connection, int idn,
			int idu, int idp, int ido, String ocena) {
		String sql = "INSERT INTO OCENIANIE (idn, idu, idp, ido, rodzaj_oceny) values(?,?,?,?,upper(?))";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idn);
			statement.setInt(2, idu);
			statement.setInt(3, idp);
			statement.setInt(4, ido);
			statement.setString(5, ocena);
			statement.execute();

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return;
		}

		System.out.println("Sukces.");
	}

	public static boolean nauczycielExist(Connection connection, int id) {
		boolean rowExists = false;
		String sql = "SELECT 1 cnt from NAUCZYCIEL WHERE idn = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rowExists = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela NAUCZYCIEL zostala utworzona");
//			e.printStackTrace();
		}

		return rowExists;
	}

	public static boolean ocenaExist(Connection connection, int id) {
		boolean rowExists = false;
		String sql = "SELECT 1 cnt from OCENA WHERE ido = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rowExists = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela OCENA zostala utworzona");
//			e.printStackTrace();
		}

		return rowExists;
	}

	public static boolean uczenExist(Connection connection, int id) {
		boolean rowExists = false;
		String sql = "SELECT 1 cnt from UCZEN WHERE idu = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rowExists = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela UCZEN zostala utworzona");
//			e.printStackTrace();
		}

		return rowExists;
	}

	public static boolean przedmiotExist(Connection connection, int id) {
		boolean rowExists = false;
		String sql = "SELECT 1 cnt from PRZEDMIOT WHERE idp = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rowExists = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela PRZEDMIOT zostala utworzona");
			e.printStackTrace();
		}

		return rowExists;
	}

}
