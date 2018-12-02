package classTest;

public class Lekarz extends Pracownik {
    private double premia;

    public Lekarz(String imie, String nazwisko, double wyplata) {
        super(imie, nazwisko, wyplata);
        premia = 0;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(double d) {
        premia = d;
    }

    public void setWyplataPoPremii() {
        double wypl = getWyplata();
        double premia = getPremia();
        double w = wypl + premia;
        setWyplata(w);
 //       System.out.println("Wyplata po premii = " +w);
    }
}
