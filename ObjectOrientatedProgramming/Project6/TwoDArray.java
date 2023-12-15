import javax.swing.JOptionPane;

public class TwoDArray 
{
	private int[][] array;
	private int rows;
	private int columns;
	private int low;
	private int high;
	
public TwoDArray(int r, int c, int l, int h)
{
	rows = r;
	columns = c;
	low = l;
	high = h;
	array = new int[rows][columns];
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
    	array[i][j] = low + (int)((high-low+1)*Math.random());
}
public TwoDArray()
{
	rows = 10;
	columns = 10;
	low = 10;
	high = 99;
	array = new int[rows][columns];
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
    	  array[i][j] = low + (int)((high-low+1)*Math.random());
}
public void createArray()
{
	String input = JOptionPane.showInputDialog(null,"Please enter an integer < 100:",
			"# Rows in Two-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    rows=Integer.parseInt(input);
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 100:",
			"# Columns in Two-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    columns = Integer.parseInt(input);
    array = new int[rows][columns];
    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
			"Lowest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    low = Integer.parseInt(input);
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Highest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    high = Integer.parseInt(input);
    for (int r=0; r<array.length; r++)
    	for (int c=0; c<array[r].length; c++)
    	{
    		array[r][c] = low + (int)((high-low+1)*Math.random());
    	}
}
public int getMaximum()
{
	int max = array[0][0];
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		  if (max < array[i][j])
			   max = array[i][j];
	return max;
}
public int getMinimum()
{
	int min = array[0][0];
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		  if (min > array[i][j])
			   min = array[i][j];
	return min;
}
public double getAverage()
{
	double average = 0;
	// find total
	int sum = 0;
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		  sum = sum + array[i][j];
	// calculate average
	average = sum/(rows*columns);
	return average;
}
public int[][] getArray()
{
	return array;
}
public boolean search(int key)
{
	// search for the key, return true as soon as you find it	
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		  if (array[i][j] == key)
			   return true;
	return false;
}

public int getColumns() { return columns;}
public int getRows() { return rows;}
public void shuffle()
{
	// shuffle the elements
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		{
			int r = (int)(Math.random()*rows);
			int c = (int)(Math.random()*columns);
			int temp = array[i][j];
			array[i][j] = array[r][c];
			array[r][c] = temp;
		}
}
public void fill(int v)
{
	// fill the entire array with v
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		  array[i][j] = v;
}
public int[] toArray()
{
	int[] t = new int[rows*columns];
	int c = 0;
	for (int i=0; i<rows; i++)
		for (int j=0; j<columns; j++)
		{
			t[c] = array[i][j];
			c++;
		}
	return t;
}
}