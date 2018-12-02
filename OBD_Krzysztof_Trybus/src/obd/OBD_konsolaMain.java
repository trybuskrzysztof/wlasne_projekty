package obd;

import java.sql.*;
import java.util.Scanner;

public class OBD_konsolaMain {
	public static void main(String[] args) throws SQLException {
		
		String nazwaSterownika = "oracle.jdbc.driver.OracleDriver"; 			// for Oracle
		
		try {
		// �aduj sterownik JDBC
		Class c = Class.forName(nazwaSterownika);
		System.out.println("Pakiet     : " + c.getPackage());
		System.out.println("Nazwa klasy: " + c.getName());
		System.out.println("Sterownik JDBC zaladowany poprawnie.");
		uruchomMenu();
			
		} catch (Exception e) {
		System.out.println("Sterownik niedostepny");
		System.out.println("Exception: " + e.getMessage());
		System.out.println("Zaladuj odpowiedni sterownik JDBC i uruchom ponownie program");
//		e.printStackTrace();
		return;
		}

		
		}
	private static void uruchomMenu() {
		System.out.println("......................");

		String opcja = "";
		boolean zakoncz = false;
		Scanner scn = new Scanner(System.in);
		String menu = new String("\nWybierz opcje:"
				+ "\n1 - wykonaj ocene"
				+ "\n2 - utworz baze danych"
				+ "\n3 - usun baze danych"
				+ "\n4 - wyswietl baze danych"
				+ "\n0 - zakoncz program"
				);

		System.out.println("OBD - WYSTAWIANIE OCEN");
		System.out.println(menu);
		while (!zakoncz) {

			opcja = "";
			try {
				opcja = scn.next();
			} catch (Exception e) {
				System.out.println("Niepoprawna wartosc");
			}
			
			switch (opcja) {
			case "0":
				zakoncz = true;
				System.out.println("THE END");
				scn.close();
				break;
			case "1":
				try {
				ocenianie(scn);
				System.out.println(menu);
				} catch (Exception e) {
					
				}
				break;
			case "2":
				try {
				OBD_tworzenie_db.tworzenie();
				System.out.println(menu);
				} catch (Exception e) {
				}
				break;
			case "3":
				try {
				OBD_usuwanie_db.usuwanie();
				System.out.println(menu);
				} catch (Exception e) {
					System.out.println("Baza danych nie istnieje");
				}
				break;
			case "4":
				try {
				OBD_wyswietlanie_db.wyswietlanie();
				System.out.println(menu);
				} catch (Exception e) {
					System.out.println("Baza danych nie istnieje");
				}
				break;
			default:
				System.out.println("Niepoprawna wartosc");
				break;
			}
		}
	}

	private static void ocenianie(Scanner scn) {
		int idp, idn, ido, idu;
		String ocena;
		try {
			System.out.println("Podaj id przedmiotu:");
			idp = scn.nextInt();

			System.out.println("Podaj id nauczyciela:");
			idn = scn.nextInt();

			System.out.println("Podaj id oceny:");
			ido = scn.nextInt();

			System.out.println("Podaj id ucznia:");
			idu = scn.nextInt();

			System.out.println("Podaj rodzaj oceny (C lub S):");
			ocena = scn.next();

			OBD_ocenianie.wystawOcene(idp, idn, ido, idu, ocena);

		} catch (Exception e) {
			System.out.println("Niepoprawna wartosc");
		}
	}
}