
import java.awt.*;

public class gbcMethods extends GridBagConstraints 
{	
	public gbcMethods(int gridx, int gridy, int gridwidth, int gridheight)
	{
		this.gridx= gridx;
		this.gridy= gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}

	public gbcMethods setInsets(int distance)
	{
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	public gbcMethods setWeight(double weightx, double weighty)
	{
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	public gbcMethods setFill(int fill)
	{
		this.fill= fill;
		return this;
	}

}
