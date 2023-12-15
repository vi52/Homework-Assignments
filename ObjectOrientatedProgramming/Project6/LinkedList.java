import javax.swing.JOptionPane;

public class LinkedList 
{
	private Node head;
	private Node tail;
	private int size;
	private int low;
	private int high;
	
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
		low =  100;
		high = 500;
	}
	public LinkedList(Node h, Node t, int s, int l, int hi)
	{
		head = h;
		tail = t;
		for(int i = 1; i<=s; i++)
		{
			int v = l + (int)((hi-l+1)*Math.random());
			addBeginning(v);
		}
	}
	public void createList()
	{
		// prompt for parameters
		String input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
				"Size of Linked List",JOptionPane.QUESTION_MESSAGE);
	    int s=Integer.parseInt(input);
	    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
				"Lowest Value in the List",JOptionPane.QUESTION_MESSAGE);
	    low = Integer.parseInt(input);
	    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
				"Highest Value in the List",JOptionPane.QUESTION_MESSAGE);
	    high = Integer.parseInt(input);
		// create a list with user parameters
		head = null;
		tail = null;
		size = 0;
		for(int i = 1; i<=s; i++)
		{
			int v = low + (int)((high-low+1)*Math.random());
			addBeginning(v);
		}
	}
	public void addBeginning(int v)
	{
		Node t = new Node();
		t.setData(v);
		t.setNext(null);
		if (head == null)
		{
			head = t;
			tail = t;
		}
		else
		{
			t.setNext(head);
			head = t;
		}
		size++;
	}
	public void addEnd(int v)
	{
		Node t = new Node();
		t.setData(v);
		t.setNext(null);
		if (head == null)
		{
			head = t;
			tail = t;
		}
		else
		{
			tail.setNext(t);
			tail = t;
		}
		size++;
	}
	public boolean addByPosition(int v, int p)
	{
		Node t = head;
		Node temp = new Node();
		temp.setData(v);
		for (int i=1; i<=size; i++)
		{
			if(i == p-1)
			{
				
				temp.setNext(t.getNext());
				t.setNext(temp);
				size++;
				return true;
			}
			else
			{t = t.getNext();}
		}
		return false;
	}
	public int getMinimum()
	{
		int min = head.getData();
		Node t = head;
		while (t != null)
		{
			if (min > t.getData())
				min = t.getData();
			t = t.getNext();
		}
		return min;
	}
	public int getMaximum()
	{
		int max = head.getData();
		Node t = head;
		while (t != null)
		{
			if (max < t.getData())
				max = t.getData();
			t = t.getNext();
		}
		return max;
	}
	public double getAverage()
	{
		double average = 0;
		Node t = head;
		while (t != null)
		{
			average = average + t.getData();
			t = t.getNext();
		}
		average = average/size;
		return average;
	}
	public boolean search(int key)
	{
		Node t = head;
		for (int i=0; i<size; i++)
		{
			if(t.getData() == key)
				return true;
			t = t.getNext();
		}
		return false;
	}
	public void sort()
	{
		int[] a = toArray();
		// sort a
		java.util.Arrays.sort(a);
		// create a new list pointed by head
		Node t = head;
		for(int i=0; i<a.length; i++)
		{
			t.setData(a[i]);
			t = t.getNext();
		}
	}
	
	public int[] toArray()
	{
		int[] t = new int[size];
		Node x = head;
		int index = 0;
		while(x != null)
		{
			t[index] = x.getData();
			index++;
			x = x.getNext();
		}
		return t;
	}
	public void shuffle()
	{
		int[] a = toArray();
		// shuffle array
		for(int i=0; i<a.length; i++)
		{
			int j = (int) (Math.random()*(a.length));
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		// convert array into a linked list
		Node t = head;
		for(int i=0; i<a.length; i++)
		{
			t.setData(a[i]);
			t = t.getNext();
		}
	}
	public void fill(int v)
	{
		Node t = head;
		for (int i=0; i<size; i++)
		{
			t.setData(v);
			t = t.getNext();
		}
	}
	public Node getHead() {return head;}
	public int getSize() {return size;}
}