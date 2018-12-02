package obd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OBD_ocenianie {

	public static void wystawOcene(Connection polaczenie, int idp, int idn, int ido,
			int idu, String ocena) {
		if (!OBD_ocenianie.przedmiotIstnieje(polaczenie, idp)) {
			System.out.println("Przedmiot o id: " + idp + " nie istnieje");
			return;
		}
		
		if (!OBD_ocenianie.nauczycielIstnieje(polaczenie, idn)) {
			System.out.println("Nauczyciel o id: " + idn + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.ocenaIstnieje(polaczenie, ido)) {
			System.out.println("Ocena o id: " + ido + " nie istnieje");
			return;
		}

		if (!OBD_ocenianie.uczenIstnieje(polaczenie, idu)) {
			System.out.println("Uczen o id: " + idu + " nie istnieje");
			return;
		}


		if (!(ocena.equals("C") || ocena.equals("S") || ocena.equals("c") || ocena
				.equals("s"))) {
			System.out.println("Niepoprawna wartosc!");
			return;
		}
		insertOcenianie(polaczenie, idp, idn, ido, idu, ocena);
	}

	private static void insertOcenianie(Connection polaczenie, int idp,
			int idn, int ido, int idu, String ocena) {
		String sqlInsertOcenianie = "INSERT INTO OCENIANIE (idp, idn, ido, idu, rodzaj_oceny) values(?,?,?,?,upper(?))";

		try {
			PreparedStatement polecenie = polaczenie.prepareStatement(sqlInsertOcenianie);
			polecenie.setInt(1, idp);
			polecenie.setInt(2, idn);
			polecenie.setInt(3, ido);
			polecenie.setInt(4, idu);
			polecenie.setString(5, ocena);
			polecenie.execute();

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return;
		}

		System.out.println("Sukces.");
	}
	
	public static boolean przedmiotIstnieje(Connection polaczenie, int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT * from PRZEDMIOT WHERE idp = ?";
		try {
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs != null) {
					rzadIstnieje = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela PRZEDMIOT zostala utworzona");
//			e.printStackTrace();
		}

		return rzadIstnieje;
	}

	public static boolean nauczycielIstnieje(Connection polaczenie, int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT * from NAUCZYCIEL WHERE idn = ?";
		try {
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs !=null) {
					rzadIstnieje = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela NAUCZYCIEL zostala utworzona");
//			e.printStackTrace();
		}
		
		return rzadIstnieje;
	}

	public static boolean ocenaIstnieje(Connection polaczenie, int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT * from OCENA WHERE ido = ?";
		try {
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs != null) {
					rzadIstnieje = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela OCENA zostala utworzona");
//			e.printStackTrace();
		}

		return rzadIstnieje;
	}

	public static boolean uczenIstnieje(Connection polaczenie, int id) {
		boolean rzadIstnieje = false;
		String sql = "SELECT * from UCZEN WHERE idu = ?";
		try {
			PreparedStatement polecenie = polaczenie.prepareStatement(sql);
			polecenie.setInt(1, id);
			ResultSet rs = polecenie.executeQuery();
			while (rs.next()) {
				if (rs != null) {
					rzadIstnieje = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Sprawdz czy tabela UCZEN zostala utworzona");
//			e.printStackTrace();
		}

		return rzadIstnieje;
	}
}
