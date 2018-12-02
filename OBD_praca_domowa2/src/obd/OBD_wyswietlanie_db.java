package obd;

import java.sql.*;

public class OBD_wyswietlanie_db {
	
	public static void wyswietlanie() {
		try {
		String sqlSelectPrzedmiot = "SELECT idp, nazwa_przedmiotu FROM przedmiot";
		String sqlSelectNauczyciel = "SELECT idn, nazwisko_nauczyciela, imie_nauczyciela FROM nauczyciel";
		String sqlSelectOcena = "SELECT ido, wartosc_opisowa, wartosc_numeryczna FROM ocena";
		String sqlSelectUczen = "SELECT idu, nazwisko_ucznia, imie_ucznia FROM uczen";
		String sqlSelectOcenianie = "SELECT * FROM ocenianie";
		
		Connection polaczenie = DriverManager.getConnection(Namiary.url, Namiary.uzytkownik, Namiary.haslo);
		Statement polecenie = polaczenie.createStatement();
		
		ResultSet rs1 = polecenie.executeQuery(sqlSelectPrzedmiot);
		System.out.println("\nZawartosc tabeli PRZEDMIOT:");
		while (rs1.next()) {
			System.out.println(rs1.getInt("idp") + "|" + rs1.getString("nazwa_przedmiotu"));
			}	
		
		ResultSet rs2 = polecenie.executeQuery(sqlSelectNauczyciel);
		System.out.println("\nZawartosc tabeli NAUCZYCIEL:");
		while (rs2.next()) {
			System.out.println(rs2.getInt("idn") + "|"
							 + rs2.getString("nazwisko_nauczyciela") + "|"
							 + rs2.getString("imie_nauczyciela"));
		}
			
		ResultSet rs3 = polecenie.executeQuery(sqlSelectOcena);
		System.out.println("\nZawartosc tabeli OCENA:");
		while (rs3.next()) {
			System.out.println(rs3.getInt("ido") + "|"
							 + rs3.getString("wartosc_opisowa") + "|"
							 + rs3.getString("wartosc_numeryczna")
						);
		}
		ResultSet rs4 = polecenie.executeQuery(sqlSelectUczen);
		System.out.println("\nZawartosc tabeli UCZEN:");
		while (rs4.next()) {
			System.out.println(rs4.getInt("idu") + "|"
							 + rs4.getString("nazwisko_ucznia") + "|"
							 + rs4.getString("imie_ucznia")
						);
		}
		ResultSet rs5 = polecenie.executeQuery(sqlSelectOcenianie);
		System.out.println("\nZawartosc tabeli OCENIANIE:");
		while (rs3.next()) {
			System.out.println(rs5.getString("rodzaj_oceny")
						);
		}
		
		polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Blad bazy danych");
		}
		
		}
	}

		
	


