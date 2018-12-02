public class Jamnik extends Pies{
	private int dlugosc;
	
	public Jamnik(String i, int w, int dl) {
		super(i,w);
		dlugosc = dl;
	}
	
	public void rosnie (int oIle) {
		if (oIle <= 0)
		return;
		else dlugosc += oIle;
		}
	
	public int dajDlugosc() {
		return dlugosc;
	}
}