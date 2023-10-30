import javax.swing.JOptionPane;

public class Cube 
{
	// data members
	private int xTopLeft;
	private int yTopLeft;
	private int width;
	private int height;
	private int depth;
	
	// constructors
	public Cube() //no-arg constructor
	{
		xTopLeft = 0;
		yTopLeft = 0;
		width = 100;
		height = 100;
		depth = 100;
	}
	public Cube(int x, int y, int w, int h, int d)
	{
		xTopLeft = x;
		yTopLeft = y;
		width = w;
		height = h;
		depth = d;
	}
	
	// accessors
	public int getXTopLeft() {return xTopLeft;}
	public int getYTopLeft() {return yTopLeft;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getDepth() {return depth;}

	
	// other methods
	// calculate surface area
	public float getSurfaceArea() 
	{
		return 2*(height*depth+height*width+depth*width);
	}
	//calculate volume
	public float getVolume() 
	{
		return width*height*depth;
	}
	// prompt user for rectangle attributes
	public void getAttributes()
	{
		String input;
		
		// xTopLeft
		input = JOptionPane.showInputDialog(null,
			"Please Enter a Positive Integer",
			"X-Coordinate of the TopLeft Corner",
			JOptionPane.QUESTION_MESSAGE);
		xTopLeft = Integer.parseInt(input);
		// yTopLeft
		input = JOptionPane.showInputDialog(null,
			"Please Enter a Positive Integer",
			"Y-Coordinate of the TopLeft Corner",
			JOptionPane.QUESTION_MESSAGE);
		yTopLeft = Integer.parseInt(input);
		// width
		input = JOptionPane.showInputDialog(null,
			"Please Enter a Positive Integer",
			"Width of the Cube",
			JOptionPane.QUESTION_MESSAGE);
		width = Integer.parseInt(input);
		// height
		input = JOptionPane.showInputDialog(null,
			"Please Enter a Positive Integer",
			"Height of the Cube",
			JOptionPane.QUESTION_MESSAGE);
		height = Integer.parseInt(input);
		// depth
		input = JOptionPane.showInputDialog(null,
			"Please Enter a Positive Integer",
			"Depth of the Cube",
			JOptionPane.QUESTION_MESSAGE);
		depth = Integer.parseInt(input);
	}
	
	// toString
	public String toString()
	{
		return
			"            Cube Properties"+"\n"+
			"____________________________"+"\n"+
			"   TopLeft Corner = ("+xTopLeft+
			","+yTopLeft+")"+"\n"+
			"                     Width = "+width+"\n"+
			"                   Height = "+height+"\n"+
			"                     Depth = "+depth+"\n"+
			"                  Surface = "+getSurfaceArea()+"\n"+
			"                   Volume = "+getVolume()+"\n"+
			"____________________________";
	}
	
}
