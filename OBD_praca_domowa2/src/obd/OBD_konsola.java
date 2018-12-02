package obd;

import java.sql.*;
import java.util.Scanner;

public class OBD_konsola {
	public static void main(String[] args) throws SQLException {

		Connection connection = OBD_ocenianie.getConnection();
		String opcja = "";
		boolean koniec = false;
		Scanner scn = new Scanner(System.in);

		printWelcomeInfo();
		printMenu();
		while (!koniec) {

			opcja = "";
			try {
				opcja = scn.next();
			} catch (Exception e) {
				System.out.println("Niepoprawna wartosc");
			}
			
			switch (opcja) {
			case "0":
				koniec = true;
				break;
			case "1":
				try {
				ocenianie(scn, connection);
				printMenu();
				} catch (Exception e) {
					
				}
				break;
			case "2":
				try {
				OBD_tworzenie_db.tworzenie();
				printMenu();
				} catch (Exception e) {
				}
				break;
			case "3":
				try {
				OBD_usuwanie_db.usuwanie();
				printMenu();
				} catch (Exception e) {
					System.out.println("Baza danych nie istnieje");
				}
				break;
			case "4":
				try {
				OBD_wyswietlanie_db.wyswietlanie();
				printMenu();
				} catch (Exception e) {
					System.out.println("Baza danych nie istnieje");
				}
				break;
			default:
				System.out.println("Niepoprawna wartosc");
				break;
			}
		}

		System.out.println("KONIEC PROGRAMU");
		scn.close();
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dropDB();
	}

	private static void ocenianie(Scanner scn, Connection connection) {
		int idn, idu, idp, ido;
		String ocena;
		try {
			System.out.println("Podaj id nauczyciela:");
			idn = scn.nextInt();

			System.out.println("Podaj id ucznia:");
			idu = scn.nextInt();

			System.out.println("Podaj id przedmiotu:");
			idp = scn.nextInt();

			System.out.println("Podaj id oceny:");
			ido = scn.nextInt();

			System.out.println("Podaj rodzaj oceny (C lub S):");
			ocena = scn.next();

			OBD_ocenianie.ocen(connection, idn, idu, idp, ido, ocena);

		} catch (Exception e) {
			System.out.println("Niepoprawna wartosc");
		}

	}


	private static void printWelcomeInfo() {
		System.out.println("OBD - PRACA DOMOWA - OCENIANIE");

	}

	private static void printMenu() {
		System.out.println("\nWybierz opcje:");
		System.out.println("0 - zakoncz program");
		System.out.println("1 - wykonaj ocene");
		System.out.println("2 - utworz baze danych");
		System.out.println("3 - usun baze danych");
		System.out.println("4 - wyswietl baze danych");
	}
}