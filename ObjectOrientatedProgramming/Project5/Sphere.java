import javax.swing.JOptionPane;

public class Sphere 
{
	// data members
	private int xCenter;
	private int yCenter;
	private int radius;
	
	// constructors
	public Sphere() //no-arg constructor
	{
		xCenter = 200;
		yCenter = 200;
		radius = 100;
	}
	public Sphere(int x, int y, int r)
	{
		xCenter = x;
		yCenter = y;
		radius = r;
	}
	
	// accessors
	public int getXCenter() {return xCenter;}
	public int getYCenter() {return yCenter;}
	public int getRadius() {return radius;}
	
	// other methods
	// calculate surface area
	public double getSurfaceArea() 
	{
		return 4*Math.PI*Math.pow(radius, 2);
	}
	// calculate volume
	public double getVolume() 
	{
		return 1.33333333*Math.PI*Math.pow(radius, 3);
	}
	// prompt user for diamond attributes
	public void getAttributes()
	{
		String input;
		
		// xCenter
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"X-Coordinate of the Center",
			JOptionPane.QUESTION_MESSAGE);
		xCenter = Integer.parseInt(input);
		// yCenter
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Y-Coordinate of the Center",
			JOptionPane.QUESTION_MESSAGE);
		yCenter = Integer.parseInt(input);
		// radius
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Radius",
			JOptionPane.QUESTION_MESSAGE);
		radius = Integer.parseInt(input);
	}
	
	// toString
	public String toString()
	{
		return
			"        Sphere Properties"+"\n"+
			"_______________________________"+"\n"+
			"              Center = ("+xCenter+
			","+yCenter+")"+"\n"+
			"              Radius = "+radius+"\n"+
			"    Surface Area = "+(float)getSurfaceArea()+"\n"+
			"              Volume = "+(float)getVolume()+"\n"+
			"_______________________________";
	}
	
}
