import java.awt.*;

public class GBC extends GridBagConstraints {	
	
	private int gridx, gridy;
	private int gridwidth, gridheight;
	private int anchor;
	private int fill;
	private double weightx, weighty;
	private int ipadx, ipady;
	
	public GBC(int grX, int grY)
	{
		grX= gridx;
		grY= gridy;		
	}
	
	public GBC(int grX, int grY, int grW, int grH)
	{
		grX= gridx;
		grY= gridy;
		grW = gridwidth;
		grH = gridheight;
	}
	
	public GBC setAnchor(int anch)
	{
		anch = anchor;
		return this;
	}
	
	public GBC setFill(int fi)
	{
		fi= fill;
		return this;
	}
	
	public GBC setWeight(double weX, double weY)
	{
		weX = weightx;
		weY = weighty;
		return this;
	}
	
	public GBC setInsets(int distance)
	{
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	public GBC setInsets(int top, int left, int bottom, int right)
	{
		this.insets= new Insets(top, left, bottom, right);
		return this;
	}
	
	public GBC setIpad(int ipX, int ipY)
	{
		ipX= ipadx;
		ipY= ipady;
		return this;
	}
}