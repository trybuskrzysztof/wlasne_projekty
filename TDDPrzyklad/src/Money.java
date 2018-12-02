
class Money {
	private int fAmount;
	private String currency;

	private int exchangeValue;
	public Money(int amount, String currency) {
		fAmount = amount;
		this.currency = currency;
	}


	public int amount() {
	
		return fAmount;
	}

	public String currency() {
		return currency;
	}

   
	public Money multiply(int d)
    {
    	return new Money(amount()*d,currency);
    }
   
    public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;
			return a.currency().equals(currency()) && amount() == a.amount();
		}
		return false;

	}
    public int kurs(String c) {
    	if(c.equals(currency())) exchangeValue=1;
    	else 
    	{
    		if(c =="PLN" && currency=="CHF") exchangeValue=4;
    		else if(c =="PLN" && currency =="EUR") exchangeValue=5;
    		else throw new IllegalArgumentException("Nie mamy takiego kursu");
    	}
    	
		return exchangeValue;
    }
    public Money exchangeCurrency(String c)
    {
    	
    	return new Money(amount()*kurs(c),c);
    }
    
   public Money addExchange(Money m)
    {
	  
		Money n = m.exchangeCurrency(currency());
      	return new Money(amount()+n.amount(),currency);
	
	}
		
	public Money minusExchange(Money m){
		Money n = m.exchangeCurrency(currency());
		return new Money(amount()-n.amount(),currency);
	}
	
	public Money compareWith(Money m)
	{
	if(m.currency().equals(currency()))
	{
		if(m.amount()>=amount()) return new Money(m.amount(),currency);
		else return new Money(amount(),currency);
	}
	
	else throw new IllegalArgumentException("Różne waluty");
	}
	
	public Money compareWithOtherCurrency(Money m)
	{
	Money n = m.exchangeCurrency(currency());
	if(compareWith(n).equals(n)) return m;
	else 	return compareWith(n);
	
	}
    
	
}