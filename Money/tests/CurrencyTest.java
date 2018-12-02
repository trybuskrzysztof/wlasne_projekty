import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {

	private Currency cCHF2;
	private Currency cPLN4;
	private Currency cEUR3;
	private Currency cPLN15;
	private Currency cEUR4;

	@Before
	public void setUp() throws Exception {
		cCHF2 = new Currency("CHF", 2);
		cPLN4 = new Currency("PLN", 4);
		cEUR3 = new Currency("EUR", 3);
		cPLN15 = new Currency("PLN", 15);
		cEUR4 = new Currency("EUR", 4);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setSymbolTest() {
		Currency expected = cPLN4;
		Currency result = cEUR4;
		result.setSymbol("PLN");
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void setConverterTest() {
		Currency expected = cPLN4;
		Currency result = cPLN15;
		expected.setConverter(15);
		
		assertTrue(expected.equals(result));
	}
	

	@Test
	public void currencyEqualsTest() {
		assertTrue(!cCHF2.equals(null));
		assertEquals(cCHF2, cCHF2);
		assertEquals(cPLN4, new Currency("PLN", 4));
		assertTrue(!cPLN4.equals(cPLN15));
		
		assertTrue(cPLN15.equals(cPLN15));		
		assertTrue(!cPLN4.equals(cEUR4));
		assertTrue(!cPLN4.equals(new Double(14)));
	}
	
	
	
}
