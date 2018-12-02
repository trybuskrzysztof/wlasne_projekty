package classTest;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private double wyplata;

    public Pracownik(String imie, String nazwisko, double wyplata){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
    }

    String getImie() {
        return imie;
    }

    String getNazwisko() {
        return nazwisko;
    }

    double getWyplata() {
        return wyplata;
    }

    public void setWyplata(double w) {
        wyplata = w;
    }
}
