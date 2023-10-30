import javax.swing.JOptionPane;

public class Diamond 
{
	// data members
	private int xCenter;
	private int yCenter;
	private int width;
	private int height;
	
	// constructors
	public Diamond() //no-arg constructor
	{
		xCenter = 50;
		yCenter = 50;
		width = 100;
		height = 100;
	}
	public Diamond(int x, int y, int w, int h)
	{
		xCenter = x;
		yCenter = y;
		width = w;
		height = h;
	}
	
	// accessors
	public int getXCenter() {return xCenter;}
	public int getYCenter() {return yCenter;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	// other methods
	// calculate perimeter
	public double getPerimeter() 
	{
		double p, q;
		p = height*0.5;
		q = width*0.5;
		return 4*Math.sqrt(Math.pow(p, 2)+Math.pow(q, 2));
	}
	// calculate area
	public double getArea() {return width*height*0.5;}
	// prompt user for diamond attributes
	public void getAttributes()
	{
		String input;
		
		// xCenter
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter X (X Coordinate of the Center of the Diamond)",
			JOptionPane.QUESTION_MESSAGE);
		xCenter = Integer.parseInt(input);
		// yCenter
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter Y (Y Coordinate of the Center of the Diamond)",
			JOptionPane.QUESTION_MESSAGE);
		yCenter = Integer.parseInt(input);
		// width
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter the Width of the Diamond",
			JOptionPane.QUESTION_MESSAGE);
		width = Integer.parseInt(input);
		// height
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter the Height of the Diamond",
			JOptionPane.QUESTION_MESSAGE);
		height = Integer.parseInt(input);
	}
	
	// toString
	public String toString()
	{
		return
			"        Diamond Properties"+"\n"+
			"__________________________"+"\n"+
			"        Center = ("+xCenter+
			","+yCenter+")"+"\n"+
			"           Width = "+width+"\n"+
			"          Height = "+height+"\n"+
			"    Perimeter = "+(float)getPerimeter()+"\n"+
			"              Area = "+getArea()+"\n"+
			"__________________________";
	}
	
}
