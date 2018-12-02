package przyklad_2;

import java.util.*;

public class Pies {

	private String imie;
	private int wiek;
	
	public Pies (String i, int w) {
		imie = i;
		wiek = w;
	}
	
	public boolean stary() {
		if (wiek > 10)
		return true;
		return false;	
	}
	
	public String dajImie () {
		return imie;
	}
	public int dajWiek () {
		return wiek;
	}
	
	public void zmienImie (String nowe) {
		imie = nowe;
	}
	
	public void zmienWiek (int nowy) {
		wiek = nowy;
	}
	
	public void urodziny() {
		wiek++;
	}
	
	public boolean equals(Object otherObject)
	   {
	      // a quick test to see if the objects are identical
	      if (this == otherObject) return true;

	      // must return false if the explicit parameter is null
	      if (otherObject == null) return false;

	      // if the classes don't match, they can't be equal
	      if (getClass() != otherObject.getClass()) return false;

	      // now we know otherObject is a non-null Employee
	      Pies other = (Pies) otherObject;

	      // test whether the fields have identical values
	      return Objects.equals(imie, other.imie) && Objects.equals(wiek, other.wiek);
	   }

	   public int hashCode()
	   {
	      return Objects.hash(imie, wiek); 
	   }

	   public String toString()
	   {
	      return getClass().getName() + "[Imie=" + imie + ",wiek=" + wiek + "]";
	   }
}
