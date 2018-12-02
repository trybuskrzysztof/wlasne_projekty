import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest2 {
	private Money m12CHF;
	private Money m14CHF;
	private Money m42PLN;
	private Money m14PLN;
	private Money m14EUR;
	private Currency currencyCHF;
	private Currency currencyPLN;
	private Currency currencyEUR;

	@Before
	public void setUp() throws Exception {
		currencyCHF = new Currency("CHF", 2);
		currencyPLN = new Currency("PLN", 4);
		currencyEUR = new Currency("EUR", 3);
		m12CHF = new Money(12, currencyCHF);
		m14CHF = new Money(14, currencyCHF);
		m42PLN = new Money(42, currencyPLN);
		m14PLN = new Money(14, currencyPLN);
		m14EUR = new Money(14, currencyEUR);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simpleAddTest() {
		Money expected = new Money(26, currencyCHF);
		Money result = m12CHF.add(m14CHF); //
		assertTrue(expected.equals(result)); //
	}
		
	@Test
	public void simpleEqualsTest() {
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, currencyCHF));
		assertTrue(!m12CHF.equals(m14CHF));
		
		assertTrue(m42PLN.equals(m42PLN));		
		assertTrue(!m14CHF.equals(m14PLN));
		assertTrue(!m14CHF.equals(new Double(14)));
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void givenMoneyWithDifferentCurrencies_WhenAddingThem_ThenExceptionIsThrow()
	{
		m42PLN.add(m12CHF);
	}
	
	@Test
	public void multiplicatioTest() {
		Money expected = new Money(12*2, currencyCHF);
		Money result = m12CHF.multi(2); //
		
		assertTrue(expected.equals(result)); //
	}
	
	@Test
	public void multiplicactionByZeroTest() {
		Money expected = new Money(14*0, currencyPLN);
		Money result = m14PLN.multi(0);
		
		assertTrue(expected.equals(result));
		assertTrue(!result.equals(new Money(0, currencyCHF)));
	}
	
	@Test
	public void addDifferentMoneyWhenTheSameCurrencyTest() {
		Money expected = new Money(12+14,currencyCHF);
		Money result = m12CHF.addDifferent(m14CHF, currencyCHF);
		assertEquals(expected, result);
		assertEquals(m14PLN, m14PLN.addDifferent(new Money(0,currencyPLN), currencyPLN));
	}
	
	@Test
	public void addDifferentMoneyWhenDifferentCurrencyTest() {
		Money expected = new Money((12*currencyCHF.getConverter()+14*currencyPLN.getConverter())/currencyPLN.getConverter(),currencyPLN);
		Money result = m12CHF.addDifferent(m14PLN, currencyPLN);
		assertEquals(expected,result);
	}
	
	@Test
	public void compareMoneyTest() {
		Money expected1 = new Money(10, new Currency("TEST",3));
		Money expected2 = new Money(5, new Currency("TEST",6));
		
		assertTrue(expected1.compareMoney(expected2));
		assertTrue(!expected1.compareMoney(m14PLN));
		
	}
}
