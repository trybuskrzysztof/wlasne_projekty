
public class Uruchom2 {

	public static void main(String[] args) {
		Pies burek;
		Jamnik bagsio;
	
		burek = new Pies("Burek", 12);
		bagsio = new Jamnik("Bagsio", 8, 113);
		
		System.out.println(burek.dajImie() + " ma " + burek.dajWiek());
		
		bagsio.urodziny();
		bagsio.rosnie(12);
		
		if (bagsio.stary())
			System.out.println(bagsio.dajImie()+ " jest "
			+ "stary");
			System.out.println(bagsio.dajImie() + " ma " +
			bagsio.dajDlugosc() + " cm.");
		}

}
