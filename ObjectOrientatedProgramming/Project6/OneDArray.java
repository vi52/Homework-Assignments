import javax.swing.JOptionPane;

public class OneDArray 
{
	private int[] array;
	private int low;
	private int high;
	
public OneDArray(int s, int l, int h)
{
	array = new int[s];
	for (int i=0; i<s; i++)
    	array[i] = l + (int)((h-l+1)*Math.random());
}
public OneDArray()
{
	low = 1;
	high = 100;
	array = new int[100];
	for (int i=0; i<100; i++)
    	array[i] = low + (int)((high-low+1)*Math.random());
}
public void createArray()
{
	String input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Size of One-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    int size=Integer.parseInt(input);
    array = new int[size];
    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
			"Lowest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    low = Integer.parseInt(input);
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Highest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    high = Integer.parseInt(input);
    for (int i=0; i<size; i++)
    	array[i] = low + (int)((high-low+1)*Math.random());
}
public int getMaximum()
{
	int max = array[0];
	for (int i=1; i<array.length; i++)
		if (max < array[i])
			max = array[i];
	return max;
}
public int getMinimum()
{
	int min = array[0];
	for (int i=1; i<array.length; i++)
		if (min > array[i])
			min = array[i];
		return min;
}
public double getAverage()
{
	double average = 0;
	for (int i=0; i<array.length; i++)
		average = average + array[i];
	average = average/array.length;
	return average;
}

public boolean search(int key)
{
	
	for (int i=0; i<array.length; i++)
	{
		if(array[i] == key)
			return true;
	}
	return false;
}
public void sort()
{
	java.util.Arrays.sort(array);
}
public int[] getArray() { return array;}
public int getLow() { return low;}
public int getHigh() { return high;}
public void shuffle()
{
	
	for(int i=0; i<array.length; i++)
	{
		int j = (int) (Math.random()*(array.length));
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
public void fill(int k)
{
	for(int i=0; i<array.length; i++)
	{
		array[i] = k;
	}
}
}