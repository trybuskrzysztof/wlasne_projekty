package classTest;

public class Pielegniarka extends Pracownik {
    private int nadgodziny;

    public Pielegniarka(String imie, String nazwisko, double wyplata){
        super(imie, nazwisko, wyplata);
        nadgodziny = 0;
    }

    public int getNadgodziny() {
        return nadgodziny;
    }

    public void setNadgodziny(int n) {
        nadgodziny += n;
    }

}
