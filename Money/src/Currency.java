public class Currency {
	private String currencySymbol;
	private int currencyConverter;
	
	public Currency(String symbol, int converter){
		currencySymbol = symbol;
		currencyConverter = converter;
	}
	
	public String getSymbol(){
		return currencySymbol;
	}
	
	public int getConverter(){
		return currencyConverter;
	}
	
	public void setSymbol(String symbol){
		currencySymbol = symbol;
	}
	
	public void setConverter(int converter){
		currencyConverter = converter;
	}
	
	public boolean equals(Object anObject) {
		if (anObject instanceof Currency) {
			Currency a = (Currency) anObject;
			
			return a.getSymbol().equals(getSymbol()) && a.getConverter() == getConverter();
		}
		return false;
	}
		
	
}
