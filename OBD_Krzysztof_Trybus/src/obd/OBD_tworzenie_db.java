package obd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OBD_tworzenie_db {
	public static void tworzenie() {
		
		// Tworzenie bazy danych i wypełnianie danymi
		try {

			String sqlCreatePrzedmiot = "CREATE TABLE przedmiot (idp integer not null, nazwa_przedmiotu char(20) not null)";
			String sqlCreateNauczyciel = "CREATE TABLE nauczyciel (idn integer not null, nazwisko_nauczyciela char(30) not null, imie_nauczyciela char(20) not null)";
			String sqlCreateOcena = "CREATE TABLE ocena (ido integer not null, wartosc_opisowa char(20) not null, wartosc_numeryczna float not null)";
			String sqlCreateUczen = "CREATE TABLE uczen (idu integer not null, nazwisko_ucznia char(30) not null, imie_ucznia char(20) not null)";
			String sqlCreateOcenianie = "CREATE TABLE ocenianie (idp integer not null, idn integer not null, ido integer not null, idu integer not null, rodzaj_oceny char(1)not null)";
			
			String sqlInsertPrzedmiot1 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (1, 'Matematyka')";
			String sqlInsertPrzedmiot2 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (2, 'Jezyk Polski')";
			String sqlInsertPrzedmiot3 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (3, 'Jezyk Angielski')";
			String sqlInsertPrzedmiot4 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (4, 'Fizyka')";
			String sqlInsertPrzedmiot5 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (5, 'Chemia')";
			String sqlInsertPrzedmiot6 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (6, 'Geografia')";
			String sqlInsertPrzedmiot7 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (7, 'Historia')";
			String sqlInsertPrzedmiot8 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (8, 'W-F')";

			String sqlInsertNauczyciell = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (1, 'Fartuch', 'Roman')";
			String sqlInsertNauczyciel2 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (2, 'Nowak', 'Arkadiusz')";
			String sqlInsertNauczyciel3 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (3, 'Sokolowska', 'Krzysztof')";
			String sqlInsertNauczyciel4 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (4, 'Laptop', 'Maciej')";
			String sqlInsertNauczyciel5 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (5, 'Czubowna', 'Krystyna')";
			String sqlInsertNauczyciel6 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (6, 'Bak', 'Arkadia')";
			String sqlInsertNauczyciel7 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (7, 'Blok', 'Maciej')";
			String sqlInsertNauczyciel8 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (8, 'Topinski', 'Krzysztof')";
			
			String sqlInsertOcenal = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (1, 'jeden', '1')";
			String sqlInsertOcena2 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (2, 'dwa', '2')";
			String sqlInsertOcena3 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (3, 'trzy', '3')";
			String sqlInsertOcena4 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (4, 'cztery', '4')";
			String sqlInsertOcena5 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (5, 'piec', '5')";
			String sqlInsertOcena6 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (6, 'szesc', '6')";
			
			String sqlInsertUczenl = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (1, 'Lesniewski', 'Jozef')";
			String sqlInsertUczen2 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (2, 'Skrocki', 'Piotr')";
			String sqlInsertUczen3 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (3, 'Stankiewicz', 'Zenon')";
			String sqlInsertUczen4 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (4, 'Cieslukowska', 'Karolina')";
			String sqlInsertUczen5 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (5, 'Kalinowski', 'Zygmunt')";
			String sqlInsertUczen6 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (6, 'Stachowiak', 'Jozef')";
			String sqlInsertUczen7 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (7, 'Peczak', 'Anna')";
			String sqlInsertUczen8 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (8, 'Lesniewska', 'Dominika')";
			String sqlInsertUczen9 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (9, 'Grabarczyk', 'Kalina')";
			String sqlInsertUczen10 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (10, 'Grabowski', 'Jan')";
			String sqlInsertUczenl1 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (11, 'Kasprzyk', 'Jozef')";
			String sqlInsertUczenl2 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (12, 'Umultowska', 'Teodora')";
			String sqlInsertUczenl3 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (13, 'Pankiewicz', 'Malgorzata')";
			String sqlInsertUczenl4 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (14, 'Maslak', 'Irena')";
			String sqlInsertUczenl5 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (15, 'Bartczak', 'Sebastian')";
			

			
			Connection polaczenie = DriverManager.getConnection(OBD_namiary.url, OBD_namiary.uzytkownik, OBD_namiary.haslo);
			System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();
			polecenie.execute(sqlCreatePrzedmiot);
			polecenie.execute(sqlCreateNauczyciel);
			polecenie.execute(sqlCreateOcena);
			polecenie.execute(sqlCreateUczen);
			polecenie.execute(sqlCreateOcenianie);
											
			polecenie.execute(sqlInsertPrzedmiot1);
			polecenie.execute(sqlInsertPrzedmiot2);
			polecenie.execute(sqlInsertPrzedmiot3);
			polecenie.execute(sqlInsertPrzedmiot4);
			polecenie.execute(sqlInsertPrzedmiot5);
			polecenie.execute(sqlInsertPrzedmiot6);
			polecenie.execute(sqlInsertPrzedmiot7);
			polecenie.execute(sqlInsertPrzedmiot8);
											
			polecenie.execute(sqlInsertNauczyciell);
			polecenie.execute(sqlInsertNauczyciel2);
			polecenie.execute(sqlInsertNauczyciel3);
			polecenie.execute(sqlInsertNauczyciel4);
			polecenie.execute(sqlInsertNauczyciel5);
			polecenie.execute(sqlInsertNauczyciel6);
			polecenie.execute(sqlInsertNauczyciel7);
			polecenie.execute(sqlInsertNauczyciel8);
										
			polecenie.execute(sqlInsertOcenal);
			polecenie.execute(sqlInsertOcena2);
			polecenie.execute(sqlInsertOcena3);
			polecenie.execute(sqlInsertOcena4);
			polecenie.execute(sqlInsertOcena5);
			polecenie.execute(sqlInsertOcena6);
											
			polecenie.execute(sqlInsertUczenl);
			polecenie.execute(sqlInsertUczen2);
			polecenie.execute(sqlInsertUczen3);
			polecenie.execute(sqlInsertUczen4);
			polecenie.execute(sqlInsertUczen5);
			polecenie.execute(sqlInsertUczen6);
			polecenie.execute(sqlInsertUczen7);
			polecenie.execute(sqlInsertUczen8);
			polecenie.execute(sqlInsertUczen9);
			polecenie.execute(sqlInsertUczen10);
			polecenie.execute(sqlInsertUczenl1);
			polecenie.execute(sqlInsertUczenl2);
			polecenie.execute(sqlInsertUczenl3);
			polecenie.execute(sqlInsertUczenl4);
			polecenie.execute(sqlInsertUczenl5);
			
			System.out.println("Baza danych zostala utworzona");
			
			polaczenie.close();
			
			}
			
			catch (SQLException e) {
				
			System.out.println("Baza danych juz istnieje");

			return;
			}
			
			System.out.println("Sukces.");		
	}

}
