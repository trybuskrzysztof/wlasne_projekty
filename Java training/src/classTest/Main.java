package classTest;

public class Main {

    public static void main(String[] args) {
        Pracownik mietek = new Pracownik("Mieczyslaw", "Tokarski", 3000);
        System.out.println("imie = " + mietek.getImie());
        System.out.println("Nazwisko = " + mietek.getNazwisko());
        System.out.println("Wyplata = " + mietek.getWyplata());

        Pielegniarka hela = new Pielegniarka("Halina", "Kindziuk", 2000);
        System.out.println("imie = " + hela.getImie());
        System.out.println("Nazwisko = " + hela.getNazwisko());
        System.out.println("Wyplata = " + hela.getWyplata());
        System.out.println("Nadgodziny = " + hela.getNadgodziny());
        hela.setNadgodziny(4);
        System.out.println("Nadgodziny = " + hela.getNadgodziny());

        Lekarz zenek = new Lekarz("Zenon", "Asus", 8000);
        System.out.println("Imie = " + zenek.getImie());
        System.out.println("Nazwisko = " + zenek.getNazwisko());
        System.out.println("Wyplata = " + zenek.getWyplata());
        System.out.println("Premia = " + zenek.getPremia());
        zenek.setPremia(4000);
        System.out.println("Premia = " + zenek.getPremia());
        zenek.setWyplataPoPremii();
        System.out.println("Wypata po premii= " + zenek.getWyplata());

    }
}
