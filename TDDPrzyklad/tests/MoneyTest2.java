
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest2 {
	private Money m12CHF;
	private Money m14CHF;
	private Money m71PLN;
	private Money m12PLN;
	private Money m5EUR;
	
	@Before
	public void setUp() throws Exception {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
		m71PLN = new Money(71, "PLN");
		m12PLN = new Money(12, "PLN");
		m5EUR = new Money(5, "EUR"); //
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testEquals1() {
	
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		
	}
	@Test
	public void testEquals2() {
			
		assertTrue(!m12CHF.equals(m14CHF));
		assertTrue(!m12CHF.equals(m71PLN));
		assertTrue(!m12CHF.equals(5));
	
	}

	@Test
	public void testMultiply(){
		int d=4;
		Money expected = new Money(48, "CHF");
		Money result = m12CHF.multiply(d);
		assertTrue(expected.equals(result)); 
		
	}
	@Test
	public void testKursValue1(){
		int kurs = 1;
		int result = m71PLN.kurs("PLN");
		assertTrue(kurs == result);
	}
	@Test
	public void testKursValue2(){
		int kurs = 4;
		int result = m12CHF.kurs("PLN");
		assertTrue(kurs == result);
	}
	@Test
	public void testKursValue3(){
		int kurs = 5;
		int result = m5EUR.kurs("PLN");
		assertTrue(kurs == result);
	}


	 @Test
	 public void testExchangeCurrency(){
	 Money expected = new Money(48,"PLN");
	Money result = m12CHF.exchangeCurrency("PLN");	
	assertTrue(expected.equals(result)); 
	 }
	
	 @Test(expected=IllegalArgumentException.class)
	    public void testExchangeException() {       
	        m12PLN.kurs("CHF");
	    }
	
	
	 @Test
	
	public void testAddExchange() {
		Money expected = new Money(60,"PLN");
		Money result = m12PLN.addExchange(m12CHF);
		assertTrue(expected.equals(result)); 
		
	}
	@Test
	public void testAddExchange2() {
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.addExchange(m14CHF); //
		assertTrue(expected.equals(result)); //
	}

	
	@Test
	public void testMinusExchange1() {
		Money expected = new Money(-13,"PLN");
		Money result = m12PLN.minusExchange(m5EUR);
		assertTrue(expected.equals(result)); 
			}  
	@Test
	public void testMinusExchange2() {
		Money expected = new Money(59,"PLN");
		Money result = m71PLN.minusExchange(m12PLN);
		assertTrue(expected.equals(result)); 
			}  
	
	@Test
	public void testCompareWith(){
		Money expected = new Money(14,"CHF");
		Money result = m12CHF.compareWith(m14CHF);
		Money result2 = m14CHF.compareWith(m12CHF);
		
		assertTrue(expected.equals(result));
		assertTrue(expected.equals(result2));
		
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void testCompareWithException() {       
        m12CHF.compareWith(m12PLN);
    }
	
	@Test
	public void testCompareWithOtherCurrency(){
		Money expected = new Money(14,"CHF");
		Money result = m12PLN.compareWithOtherCurrency(m14CHF);
		assertTrue(expected.equals(result));
		
	}
	@Test
	public void testCompareWithOtherCurrency2(){
		Money expected = new Money(71,"PLN");
		Money result = m71PLN.compareWithOtherCurrency(m5EUR);
		assertTrue(expected.equals(result));
		
	}
}
