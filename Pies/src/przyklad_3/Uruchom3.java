package przyklad_3;

public class Uruchom3 {
	public static void main(String[] args) {
		Pies burek;
		Pointer cepp;
		Basset amik;
		
		cepp = new Pointer("Cepp", 5);
		amik = new Basset("Amik", 8);
		
		System.out.println(cepp.dajImie() + ". ");
		cepp.poluje();
		System.out.println(amik.dajImie() + " ma "+ amik.dajWiek() + " lat.");
		amik.poluje();
		
		//burek = cepp;
		//cepp = (Pointer)burek;
		//burek.poluje();
	}
}
