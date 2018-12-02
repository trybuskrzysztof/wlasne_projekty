class Money {
	private int financialAmount;
	private Currency financialCurrency;

	public Money(int amount, Currency currency) {
		financialAmount = amount;
		financialCurrency = currency;
	}

	public int amount() {
		return financialAmount;
	}

	public Currency getCurrency() {
		return financialCurrency;
	}

	public Money add(Money m) {
		
		if (!m.getCurrency().equals(getCurrency())) {
			throw new IllegalArgumentException("Currents");
		}
		return new Money(amount() + m.amount(), getCurrency());
	}
	
	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;

			return a.getCurrency().equals(getCurrency()) && amount() == a.amount();
		}
		return false;
	}
	
	public Money multi(int e){
		return new Money(amount() * e, getCurrency());
	}
	
	public Money addDifferent(Money m, Currency c){
		int amount = (amount() * getCurrency().getConverter() + m.amount() * m.getCurrency().getConverter())/c.getConverter();
		return new Money(amount, c);
	}
	
	public boolean compareMoney(Money m){
		if(amount( )* getCurrency().getConverter() == m.amount( )* m.getCurrency().getConverter())
			return true;
		else 
			return false;
	}
}
