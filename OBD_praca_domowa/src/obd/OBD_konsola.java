package obd;

import java.sql.*;
import java.util.Scanner;

public class OBD_konsola {
	public static void main(String[] args) {

		String nazwaSterownika = "oracle.jdbc.driver.OracleDriver"; 			// for Oracle
		
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
		
		// Tworzenie bazy danych i wypełnianie danymi
		
		try {
			
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String uzytkownik = "xktrybus";
			String haslo = "xktrybus";

			
			Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();	
			
			Scanner scanner = new Scanner(System.in);
			
			while (true) {
				
					System.out.print("Podaj id przedmiotu: ");
					String idp = scanner.nextLine();
					int idpi = Integer.parseInt(idp);
					if (idp.equals("0")) {
						break;
					}
					else if (idpi < 1 || idpi > 8) {
						System.out.println("Nie ma takiego przedmiotu" + "\n");
						continue;
					}
					
					else
						System.out.print("Podaj id nauczyciela: ");
						String idn = scanner.nextLine();
						int idni = Integer.parseInt(idn);
						if (idn.equals("0"))
							break;
						else if (idni < 1 || idni > 8) {
							System.out.println("Nie ma takiego nauczyciela" + "\n");
							continue;
						}
						
						else
							System.out.print("Podaj id oceny: ");
							String ido = scanner.nextLine();
							int idoi = Integer.parseInt(ido);
							if (ido.equals("0"))
								break;
							else if (idoi < 1 || idoi > 6) {
								System.out.println("Nie ma takiej oceny"  + "\n");
								continue;
							}
							else
								System.out.print("Podaj id ucznia: ");
								String idu = scanner.nextLine();
								int idui = Integer.parseInt(idu);
								if (idu.equals("0"))
									break;
								else if (idui < 1 || idui > 15) {
									System.out.println("Nie ma takiego ucznia" + "\n");
									continue;
									}
								else
									System.out.print("Podaj  rodzaj oceny (C,S): ");
									String idoc = scanner.nextLine();
									if (idoc.equals("0"))
										break;
									else if (!idoc.equals("C") && !idoc.equals("S")) {
										System.out.println("Nie wprowadzono poprawnego rodzaju oceny" + "\n");
										continue;
									}
									
									else
									
										System.out.println("Rodzaj oceny " + idoc + " wprowadzono do bazy danych" + "\n");
									
				}
				
			}
			
		catch (SQLException e) {
				
			System.out.println("Nieudane połączenie z bazą danych!");
			e.printStackTrace();
			return;
		}
			
		System.out.println("Sukces.");
			
		//Dane wejsciowe z konsoli
			
			
	}

}
