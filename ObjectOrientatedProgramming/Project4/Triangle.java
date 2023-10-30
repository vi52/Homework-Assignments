import javax.swing.JOptionPane;

public class Triangle 
{
	// data members
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	
	// constructors
	public Triangle() //no-arg constructor
	{
		x1 = 0;
		y1 = 0;
		x2 = 50;
		y2 = 50;
		x3 = 100;
		y3 = 100;
	}
	public Triangle(int a1, int b1, int a2, int b2, int a3, int b3)
	{
		x1 = a1;
		y1 = b1;
		x2 = a2;
		y2 = b2;
		x3 = a3;
		y3 = b3;
	}
	
	// accessors
	public int getX1() {return x1;}
	public int getY1() {return y1;}
	public int getX2() {return x2;}
	public int getY2() {return y2;}
	public int getX3() {return x3;}
	public int getY3() {return y3;}
	
	// other methods
	// calculate perimeter of triangle
	public double getPerimeter() 
	{
		double d1, d2, d3, perimeter;
		// find length of sides
		d1 = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		d2 = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2));
		d3 = Math.sqrt(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2));
		perimeter = d1+d2+d3;
		return perimeter;
	}
	// calculate area of triangle
	public double getArea() 
	{
		return Math.abs(0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)));
	}
	// prompt user for coordinates of vertices
	public void getAttributes()
	{
		String input;
		
		// x1
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter X1 (X Coordinate of the First Point)",
			JOptionPane.QUESTION_MESSAGE);
		x1 = Integer.parseInt(input);
		// y1
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter Y1 (Y Coordinate of the First Point)",
			JOptionPane.QUESTION_MESSAGE);
		y1 = Integer.parseInt(input);
		// x2
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter X2 (X Coordinate of the Second Point)",
			JOptionPane.QUESTION_MESSAGE);
		x2 = Integer.parseInt(input);
		// y2
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter Y2 (Y Coordinate of the Second Point)",
			JOptionPane.QUESTION_MESSAGE);
		y2 = Integer.parseInt(input);
		// x3
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter X3 (X Coordinate of the Third Point)",
			JOptionPane.QUESTION_MESSAGE);
		x3 = Integer.parseInt(input);
		// y3
		input = JOptionPane.showInputDialog(null,
			"Please enter an integer:",
			"Enter Y3 (Y Coordinate of the Third Point)",
			JOptionPane.QUESTION_MESSAGE);
		y3 = Integer.parseInt(input);
	}
	
	// toString
	public String toString()
	{
		return
			"      Triangle Properties"+"\n"+
			"__________________________"+"\n"+
			"       Point 1      = ("+x1+","+y1+")"+"\n"+
			"       Point 2      = ("+x2+","+y2+")"+"\n"+
			"       Point 3      = ("+x3+","+y3+")"+"\n"+
			"       Perimeter = "+(float)getPerimeter()+"\n"+
			"       Area           = "+getArea()+"\n"+
			"__________________________";
	}
	
}
