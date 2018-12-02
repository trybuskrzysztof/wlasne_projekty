package przeciazanie;

public class Main {
    public static void main(String[] args) {
        Klasy klasy = new Klasy();
        System.out.println(klasy.dodaj(1,2));
        System.out.println(klasy.dodaj(3,5,4));
        System.out.println(klasy.dodaj(1.2,2.4, 5.9));
        System.out.println(klasy.dodaj("poz","er"));
    }
}
