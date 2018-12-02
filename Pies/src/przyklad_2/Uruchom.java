package przyklad_2;

public class Uruchom {
	public static void main(String[] args) {
		Pies burek;
		burek = new Pies("Burek", 12);
		
		Pies ares = new Pies("Ares", 1);
		ares.urodziny();

		if (ares.stary())
			System.out.println(ares.dajImie() + " jest "
			+ "stary");
			burek.zmienImie("Azor");
			System.out.println(burek.dajImie() + " ma " +
			burek.dajWiek() + " lat.");
			
		System.out.println("Burek == Ares: " + (burek == ares));
		System.out.println("burek.equals(ares): " + burek.equals(ares));
		
		System.out.println("burek.toString(): " + burek);
		System.out.println("ares.toString(): " + ares);
		
		System.out.println("Burek's hashcode: " + burek.hashCode());
		System.out.println("Ares's hashcode: " + ares.hashCode());
		}
}