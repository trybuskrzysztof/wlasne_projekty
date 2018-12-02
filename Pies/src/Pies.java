public class Pies {

	private String imie;
	private int wiek;
	
	public Pies (String i, int w) {
		imie = i;
		wiek = w;
	}
	
	public boolean stary() {
		if (wiek > 10)
		return true;
		return false;	
	}
	
	public String dajImie () {
		return imie;
	}
	public int dajWiek () {
		return wiek;
	}
	
	public void zmienImie (String nowe) {
		imie = nowe;
	}
	
	public void zmienWiek (int nowy) {
		wiek = nowy;
	}
	
	public void urodziny() {
		wiek++;
	}
}
