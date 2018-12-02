
import java.awt.*;
/*
 * klasa upraszcza korzystanie z klasy GridBagConstaints
 */

public class GBC extends GridBagConstraints 
{	
	
	/**
	 * Tworzy obiekt typu GBC z podanymi wartościami grdix igrdy oraz pozostałymi
	 * parametrami ustawionymi na wartości domyślne
	 * @param gridx współrzędna gridx
	 * @param gridy współrzędna drdy
	 */

	public GBC(int gridx, int gridy)
	{
		this.gridx= gridx;
		this.gridy= gridy;
		
	}
	
	/**
	 * Tworzy obiekt typu GBC z podanymi wartościami gridx , gridy, gridwidth,gridheight
	 * oraz z resztą parametrów ustawionych na wartości domyślne
	 * @param gridwidth liczba zajmowanych komórek w poziomie
	 * @param gridheight liczba zajmowanych komórek w pionie
	 */
	public GBC(int gridx, int gridy, int gridwidth, int gridheight)
	{
		this.gridx= gridx;
		this.gridy= gridy;
		this.gridwidth = gridwidth; // ilość kolumn zajmowanych przez komórkę
		this.gridheight = gridheight; // ilość wierszy zajmowanych przez komórkę
	}
	
	/**
	 * Ustawia parametr archor.
	 * @param return this obiekt do dalszej modyfikacji
	 */
	public GBC setAnchor(int anchor) // typ GBC bo zwraca obiekt
	{
		this.anchor = anchor;
		return this; //zwraca GBC
	}
	
	/**
	 * Ustawia kierunek zapełniania.
	 * @param fill kierunek zapełniania
	 * return this obiekt do dalszej modyfikacji
	 */
	public GBC setFill(int fill)
	{
		this.fill= fill;
		return this;
	}
	
	/**
	 * Ustawia parametry weight komórek
	 * @param weightx parametr weight w poziomie
	 * @param weighty parametr weight w pionie
	 * @return this obiekt do dalszych modyfikacji
	 */
	public GBC setWeight(double weightx, double weighty)
	{
		this.weightx = weightx; //zdolność komórki do powiększania się
		this.weighty = weighty; //zdolność komórki do powiększania się
		return this;
	}
	
	/**
	 * Ustawia dodatkową pustą przestrzeń w komórce
	 * @param distance dopełnienie we wszystkich kierunkach
	 * @return this obiekt do dalszej modyfikacji
	 */
	public GBC setInsets(int distance)
	{
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	/**
	 * Ustawia dopełniena w komórce 
	 * @param top odstęp od górnej krawędzi
	 * @param left odstęp od lewej krawędzi
	 * @param right odstęp od prawej krawędzi
	 * @param bottom odstęp od dolnej krawędzi
	 * @return this obiekt do dalszej modyfikacji
	 */
	public GBC  setInsets(int top, int left, int bottom, int right)
	{
		this.insets= new Insets(top, left, bottom, right);
		return this;
	}
	/**
	 * ustawia dopełnienie wewnętrzne 
	 * @param ipadx dopełnienie wewnętrzne poziome
	 * @param ipdy dopełnienie wewnętrzne pionowe
	 */
	public GBC setIpad(int ipadx, int ipady)
	{
		this.ipadx= ipadx;
		this.ipady= ipady;
		return this;
	}
}
