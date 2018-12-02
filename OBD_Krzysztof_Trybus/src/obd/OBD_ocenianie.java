package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OBD_ocenianie {

	public static void wystawOcene(int idp, int idn, int ido,
			int idu, String ocena) {
		if (!OBD_ocenianie.przedmiotIstnieje(idp)) {
			System.out.println("Przedmiot o id: " + idp + " nie istnieje");
			return;
		}
		
		if (!OBD_ocenianie.nauczycielIstnieje(idn)) {
			System.out.println("Nauczyciel o id: " + idn + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.ocenaIstnieje(ido)) {
			System.out.println("Ocena o id: " + ido + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.uczenIstnieje(idu)) {
			System.out.println("Uczen o id: " + idu + " nie istnieje");
			return;
		}


		if (!(ocena.equals("C") || ocena.equals("S") || ocena.equals("c") || ocena
				.equals("s"))) {
			System.out.println("Niepoprawna wartosc!");
			return;
		}
		insertOcenianie(idp, idn, ido, idu, ocena);
	}

	private static void insertOcenianie(int idp,
			int idn, int ido, int idu, String ocena) {
		String sqlInsertOcenianie = "INSERT INTO OCENIANIE (idp, idn, ido, idu, rodzaj_oceny) values(?,?,?,?,upper(?))";

		try {
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(sqlInsertOcenianie);
			polecenie.setInt(1, idp);
			polecenie.setInt(2, idn);
			polecenie.setInt(3, ido);
			polecenie.setInt(4, idu);
			polecenie.setString(5, ocena);
			polecenie.execute();
			polaczenie.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return;
		}

		System.out.println("Sukces.");
	}
	
	public static boolean przedmiotIstnieje(int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT 1 cnt from PRZEDMIOT WHERE idp = ?";
		try {
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rzadIstnieje = true;
				}
			}
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela PRZEDMIOT zostala utworzona");
//			e.printStackTrace();
		}

		return rzadIstnieje;
	}

	public static boolean nauczycielIstnieje(int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT 1 cnt from NAUCZYCIEL WHERE idn = ?";
		try {
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rzadIstnieje = true;
				}
			}
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela NAUCZYCIEL zostala utworzona");
//			e.printStackTrace();
		}
		
		return rzadIstnieje;
	}

	public static boolean ocenaIstnieje(int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT 1 cnt from OCENA WHERE ido = ?";
		try {
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rzadIstnieje = true;
				}
			}
			polaczenie.close();
			
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela OCENA zostala utworzona");
//			e.printStackTrace();
		}

		return rzadIstnieje;
	}

	public static boolean uczenIstnieje(int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT 1 cnt from UCZEN WHERE idu = ?";
		try {
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					rzadIstnieje = true;
				}
			}
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela UCZEN zostala utworzona");
//			e.printStackTrace();
		}

		return rzadIstnieje;
	}
}
