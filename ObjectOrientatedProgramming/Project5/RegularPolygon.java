import javax.swing.JOptionPane;

public class RegularPolygon 
{
	// data members
	private int xCenter;
	private int yCenter;
	private int nSides;
	private int radius;
	
	// constructors
	public RegularPolygon() //no-arg constructor
	{
		xCenter = 50;
		yCenter = 50;
		nSides = 4;
		radius = 100;
	}
	public RegularPolygon(int x, int y, int n, int r)
	{
		xCenter = x;
		yCenter = y;
		nSides = n;
		radius = r;
	}
	
	// accessors
	public int getXCenter() {return xCenter;}
	public int getYCenter() {return yCenter;}
	public int getSides() {return nSides;}
	public int getRadius() {return radius;}
	
	// other methods
	//calculate side length
	public double getSideLength()
	{
		return 2*radius*Math.sin(Math.PI/nSides);
	}
	// calculate perimeter
	public double getPerimeter() 
	{
		double sideLength;
		sideLength = 2*radius*Math.sin(Math.PI/nSides);
		return sideLength*nSides;
	}
	// calculate area
	public double getArea() 
	{
		return nSides*Math.pow(radius*Math.cos(Math.PI/nSides), 2)*Math.tan(Math.PI/nSides);
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
		// nSides
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Number of Sides",
			JOptionPane.QUESTION_MESSAGE);
		nSides = Integer.parseInt(input);
		// radius
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Radius of Bounding Circle",
			JOptionPane.QUESTION_MESSAGE);
		radius = Integer.parseInt(input);
	}
	
	// toString
	public String toString()
	{
		return
			"     Regular Polygon Properties"+"\n"+
			"_______________________________"+"\n"+
			"              Center = ("+xCenter+
			","+yCenter+")"+"\n"+
			"              # Sides = "+nSides+"\n"+
			"               Radius = "+radius+"\n"+
			"      Side Length = "+(float)getSideLength()+"\n"+
			"          Perimeter = "+(float)getPerimeter()+"\n"+
			"                   Area = "+(float)getArea()+"\n"+
			"_______________________________";
	}
	
}
