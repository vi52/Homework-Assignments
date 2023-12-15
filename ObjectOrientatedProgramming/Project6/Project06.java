import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;


public class Project06 extends Frame implements ActionListener
{
		
	String command = "";
	int key;
	boolean found;
	Font f = new Font("SansSerif",Font.BOLD,12);
	Font f1 = new Font("SansSerif",Font.BOLD,16);
	int v;
	int p;
	int[] temp;
	int[][] tempMatrix;
	// define objects
	OneDArray originalArray;
	LinkedList list;
	TwoDArray original2D;
	
	public static void main(String[] args)
	{
		Frame frame = new Project06();	
		frame.setResizable(true);
		frame.setSize(1000,800);
		frame.setVisible(true);
	}
	
	public Project06()
	{
		setTitle("CSC 229 - Project 6 - 1D, 2D Arrays & Linked List");
		
		// Create Menu
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
		// 1D array
		Menu actionMenu = new Menu("One Dimensional Array");
		mb.add(actionMenu);
		
		MenuItem miCreate1D = new MenuItem("Create Array");
		miCreate1D.addActionListener(this);
		actionMenu.add(miCreate1D);
		
		Menu statsMenu1D = new Menu("Statistics");
		actionMenu.add(statsMenu1D);
		
		MenuItem miMinimum1D = new MenuItem("Array Minimum");
		miMinimum1D.addActionListener(this);
		statsMenu1D.add(miMinimum1D);
		
		MenuItem miMaximum1D = new MenuItem("Array Maximum");
		miMaximum1D.addActionListener(this);
		statsMenu1D.add(miMaximum1D);
		
		MenuItem miAverage1D = new MenuItem("Array Average");
		miAverage1D.addActionListener(this);
		statsMenu1D.add(miAverage1D);
		
		MenuItem miSort1D = new MenuItem("Sort Array");
		miSort1D.addActionListener(this);
		actionMenu.add(miSort1D);
		
		MenuItem miSearch1D = new MenuItem("Search Array");
		miSearch1D.addActionListener(this);
		actionMenu.add(miSearch1D);
		
		MenuItem miShuffle1D = new MenuItem("Shuffle Array");
		miShuffle1D.addActionListener(this);
		actionMenu.add(miShuffle1D);
		
		MenuItem miFill1D = new MenuItem("Fill Array");
		miFill1D.addActionListener(this);
		actionMenu.add(miFill1D);
		
		// Linked List
		Menu listMenu = new Menu("Linked List");
		mb.add(listMenu);
		
		MenuItem miCreateList = new MenuItem("Create List");
		miCreateList.addActionListener(this);
		listMenu.add(miCreateList);
		
		Menu statsMenuList = new Menu("Statistics");
		listMenu.add(statsMenuList);
		
		MenuItem miMinimumList = new MenuItem("List Minimum");
		miMinimumList.addActionListener(this);
		statsMenuList.add(miMinimumList);
		
		MenuItem miMaximumList = new MenuItem("List Maximum");
		miMaximumList.addActionListener(this);
		statsMenuList.add(miMaximumList);
		
		MenuItem miAverageList = new MenuItem("List Average");
		miAverageList.addActionListener(this);
		statsMenuList.add(miAverageList);
		
		Menu addMenuList = new Menu("Add Node");
		listMenu.add(addMenuList);
		
		MenuItem miBeginList = new MenuItem("to Beginning");
		miBeginList.addActionListener(this);
		addMenuList.add(miBeginList);
		
		MenuItem miEndList = new MenuItem("to End");
		miEndList.addActionListener(this);
		addMenuList.add(miEndList);
		
		MenuItem miPosList = new MenuItem("by Position");
		miPosList.addActionListener(this);
		addMenuList.add(miPosList);
		
		MenuItem miArrayList = new MenuItem("List to Array");
		miArrayList.addActionListener(this);
		listMenu.add(miArrayList);
		
		MenuItem miSortList = new MenuItem("Sort List");
		miSortList.addActionListener(this);
		listMenu.add(miSortList);
		
		MenuItem miSearchList = new MenuItem("Search List");
		miSearchList.addActionListener(this);
		listMenu.add(miSearchList);
		
		MenuItem miShuffleList = new MenuItem("Shuffle List");
		miShuffleList.addActionListener(this);
		listMenu.add(miShuffleList);
		
		MenuItem miFillList = new MenuItem("Fill List");
		miFillList.addActionListener(this);
		listMenu.add(miFillList);
		
		// 2D array (Matrix)
		Menu twoDMenu = new Menu("Two Dimensional Array");
		mb.add(twoDMenu);
		
		MenuItem miCreate2D = new MenuItem("Create Matrix");
		miCreate2D.addActionListener(this);
		twoDMenu.add(miCreate2D);
		
		Menu statsMenu2D = new Menu("Statistics");
		twoDMenu.add(statsMenu2D);
		
		MenuItem miMinimum2D = new MenuItem("Matrix Minimum");
		miMinimum2D.addActionListener(this);
		statsMenu2D.add(miMinimum2D);
		
		MenuItem miMaximum2D = new MenuItem("Matrix Maximum");
		miMaximum2D.addActionListener(this);
		statsMenu2D.add(miMaximum2D);
		
		MenuItem miAverage2D = new MenuItem("Matrix Average");
		miAverage2D.addActionListener(this);
		statsMenu2D.add(miAverage2D);
		
		MenuItem miSearch2D = new MenuItem("Search Matrix");
		miSearch2D.addActionListener(this);
		twoDMenu.add(miSearch2D);
		
		MenuItem miArray2D = new MenuItem("Matrix to Array");
		miArray2D.addActionListener(this);
		twoDMenu.add(miArray2D);
		
		MenuItem miShuffle2D = new MenuItem("Shuffle Matrix");
		miShuffle2D.addActionListener(this);
		twoDMenu.add(miShuffle2D);
		
		MenuItem miFill2D = new MenuItem("Fill Matrix");
		miFill2D.addActionListener(this);
		twoDMenu.add(miFill2D);
		
		// End program when window is closed
		
		WindowListener l = new WindowAdapter()
		{
						
			// window closed - exit program						
						public void windowClosing(WindowEvent ev)
						{
							System.exit(0);
						}
						// menu option selected - go to redraw and display method
						public void listener(WindowEvent ev)
						{
							repaint();
						}
						// window resized or refocused - redraw
						public void windowStateChanged(WindowEvent ev)
						{
							repaint();
						}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			// take action accordingly
		switch(command)
			{
		case "About":
			{
				repaint();
				break;
			}
		case "Exit":
			{
				System.exit(0);
				break;
			}
		case "Create Array":
			{
				originalArray = new OneDArray();
				originalArray.createArray();
				
				repaint();
				break;
			}
		case "Array Minimum":
		case "Array Maximum":
		case "Array Average":
			{
				repaint();
				break;
			}
		case "Sort Array":
			{
				repaint();
				break;
			}
		case "Search Array":
			{
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
						"Search Key",JOptionPane.QUESTION_MESSAGE);
			    key = Integer.parseInt(input);
				repaint();
				break;
			}
		case "Shuffle Array":
		{
			// copy original array into a temporary array
			int k = originalArray.getArray().length;
			temp = new int[k];
			for (int i = 0; i<k; i++)
			{
				temp[i] = originalArray.getArray()[i];
			}
			// shuffle original array
			originalArray.shuffle();
			repaint();
			break;
		}
		case "Fill Array":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Fill array:",
					"Fill Value",JOptionPane.QUESTION_MESSAGE);
		    v = Integer.parseInt(input);
		    // copy original array into a temporary array
		 	int k = originalArray.getArray().length;
			temp = new int[k];
			for (int i = 0; i<k; i++)
			{
				temp[i] = originalArray.getArray()[i];
			}
			// fill the array
			originalArray.fill(v);
			repaint();
			break;
		}
		// Linked List Operations
		case "Create List":
		{
			list = new LinkedList();
			list.createList();
			repaint();
			break; 
		}
		case "List Minimum":
		case "List Maximum":
		case "List Average":
		{
			repaint();
			break;
		}
		case "to Beginning":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number:",
					"Value of New Node",JOptionPane.QUESTION_MESSAGE);
		    v = Integer.parseInt(input);
			repaint();
			break;
		}
		case "to End":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number:",
					"Value of New Node",JOptionPane.QUESTION_MESSAGE);
		    v = Integer.parseInt(input);
			repaint();
			break;
		}
		case "by Position":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number:",
					"Value of New Node",JOptionPane.QUESTION_MESSAGE);
		    v = Integer.parseInt(input);
		    String input1 = JOptionPane.showInputDialog(null,"Please enter an integer Number:",
					"Position of New Node",JOptionPane.QUESTION_MESSAGE);
		    p = Integer.parseInt(input1);
			repaint();
			break;
		}
		case "List to Array":
		{
			repaint();
			break;
		}
		case "Sort List":
		{
			repaint();
			break;
		}
		case "Search List":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
					"Search Key",JOptionPane.QUESTION_MESSAGE);
		    key = Integer.parseInt(input);
			repaint();
			break;
		}
		case "Shuffle List":
		{
			repaint();
			break;
		}
		case "Fill List":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Fill linked list:",
					"Fill Value",JOptionPane.QUESTION_MESSAGE);
		    v = Integer.parseInt(input);
			repaint();
			break;
		}
		// 2D Array Operations
		case "Create Matrix":
		{
			original2D = new TwoDArray();
			original2D.createArray();
			repaint();
			break; 
		}
		case "Matrix Minimum":
		case "Matrix Maximum":
		case "Matrix Average":
		{
			repaint();
			break;
		}
		case "Search Matrix":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
					"Search Key",JOptionPane.QUESTION_MESSAGE);
		    key = Integer.parseInt(input);
			repaint();
			break;
		}
		case "Matrix to Array":
		{
			repaint();
			break;
		}
		case "Shuffle Matrix":
		{
			tempMatrix = original2D.getArray();
			repaint();
			break;
		}
		case "Fill Matrix":
		{
			String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Fill Matrix:",
					"Fill Value",JOptionPane.QUESTION_MESSAGE);
		    v = Integer.parseInt(input);
			tempMatrix = original2D.getArray();
			repaint();
			break;
		}
		
		}// end of switch
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
			
			// Check Command issued, take action accordingly
			int ww = this.getWidth();
			
			g.setFont(f);
			switch(command)
			{
			case "About":
			{
				g.drawString(" Data Structures",ww/2-85, 100);
				g.drawLine (100, 120, ww-100, 120);
				g.drawString(" This program supports the entry of values of primary attributes (size, minimum, and maximum) and " , ww/2-300, 140);
				g.drawString(" calculation/manipulation of attributes (minimum, maximum, average, sort, shuffle, and fill) of ", ww/2-300, 160);
				g.drawString(" the following data structures: " , ww/2-300, 180);
				g.drawString("  ", ww/2-300, 200);
				g.drawString(" 1.      1D Array", ww/2-90, 220);
				g.drawString(" 2.      Linked List", ww/2-90, 240);
				g.drawString(" 3.      2D Array", ww/2-90, 260);
				g.drawString("  ", ww/2-300, 280);
				g.drawString(" Linked List data structure also supports adding values to the beginning, end, and by position of ", ww/2-300, 300);
				g.drawString(" list. Both Linked List and 2D Array have the additional function of creating a 1D array from the ", ww/2-300, 320);
				g.drawString(" given primary attributes. The data structures as well as any calculations/manipulations will both ", ww/2-300, 340);
				g.drawString(" be outputted. ", ww/2-300, 360);
				break;
			}
			// 1D Array Operations
			case "Create Array":
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				break;
			}
			
			case "Array Minimum":
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 30;
				g.drawString("Minimum = "+Integer.toString(originalArray.getMinimum()), x, y);
				break;	
			}
			case "Array Maximum":
			{
				int x = 100;
				int y = 100;
				int currentY = displayArray(g, originalArray.getArray(), x, y, ww, "Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 30;
				g.drawString("Maximum = "+originalArray.getMaximum(), x, y);
				break;	
			}
			case "Array Average":
			{
				int x = 100;
				int y = 100;
				int currentY = displayArray(g, originalArray.getArray(), x, y, ww, "Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 30;
				g.drawString("Average = "+originalArray.getAverage(), x, y);
				break;	
			}
			case "Sort Array":
			{
				int x=100;
				int y = 100;
				// display original array
				int currentY = displayArray(g,originalArray.getArray(),x,y,ww,"Original Array");
				// Display the Sorted Array	
				originalArray.sort();
				x = 100;
				y = currentY + 25;
				currentY = displayArray(g,originalArray.getArray(),x,y,ww,"Sorted Array");
				break;
			}
			case "Search Array":
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				// Display the Original Array
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
		
				//Display the outcome of the search
				found = originalArray.search(key);
				g.setColor(Color.RED);
				g.setFont(f1);
				String result = "";
				if (found) result = "Found";
				else       result = "NOT Found";
				g.drawString("Search Key  **** "+Integer.toString(key)+" ****  " +result, ww/2-100, currentY+25);
				break;
			}
			case "Shuffle Array":
			{
				// display contents of temp
				int x = 100;
				int y = 100;
				int currentY = displayArray(g, temp, x, y, ww, "Original Array");
				// display contents of shuffled array
				y = currentY + 30;
				currentY = displayArray(g, originalArray.getArray(), x, y, ww, "Shuffled Array");
				break;
			}
			case "Fill Array":
			{
				// display contents of temp
				int x = 100;
				int y = 100;
				int currentY = displayArray(g, temp, x, y, ww, "Original Array");
				// display contents of filled array
				y = currentY + 30;
				currentY = displayArray(g, originalArray.getArray(), x, y, ww, "Filled Array");
				break;
			}
			// Linked List Operations 
			case "Create List":
			{
				int x = 100;
				int y = 100;
				int currentY = displayList(g, list, x, y, ww, "Original List");
				break;
			}
			case "List Minimum":
			{
				int x = 100;
				int y = 100;
				int currentY = displayList(g, list, x, y, ww, "Original List");
				y = currentY + 30;
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Minimum = "+Integer.toString(list.getMinimum()), ww/2-50, y);
				break;
			}
			case "List Maximum":
			{
				int x = 100;
				int y = 100;
				int currentY = displayList(g, list, x, y, ww, "Original List");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 30;
				g.drawString("Maximum = "+Integer.toString(list.getMaximum()), x, y);
				break;
			}
			case "List Average":
			{
				int x = 100;
				int y = 100;
				int currentY = displayList(g, list, x, y, ww, "Original List");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 30;
				g.drawString("Average = "+list.getAverage(), x, y);
				break;
			}
			case "to Beginning":
			{
				int x=100;
				int y = 100;
				// display original list
				int currentY = displayList(g,list,x,y,ww,"Original List");
				// Display the list with added node
				list.addBeginning(v);
				x = 100;
				y = currentY + 25;
				currentY = displayList(g,list,x,y,ww,"New Linked List");
				break;
			}
			case "to End":
			{
				int x=100;
				int y = 100;
				// display original list
				int currentY = displayList(g,list,x,y,ww,"Original List");
				// Display the list with added node
				list.addEnd(v);
				x = 100;
				y = currentY + 25;
				currentY = displayList(g,list,x,y,ww,"New Linked List");
				break;
			}
			case "by Position":
			{
				int x=100;
				int y = 100;
				// display original list
				int currentY = displayList(g,list,x,y,ww,"Original List");
				// Display the list with added node
				found = list.addByPosition(v, p);
				x = 100;
				y = currentY + 25;
				if (found)
				{
					currentY = displayList(g,list,x,y,ww,"New Linked List");
				}
				else 
				{
					g.setColor(Color.RED);
					g.setFont(f1);
					g.drawString("Position "+p+" is not a valid position.", ww/2-100, currentY+30);
				}
				break;
			}
			case "List to Array":
			{
				int x=100;
				int y = 100;
				// display original list
				int currentY = displayList(g,list,x,y,ww,"Original List");
				// Display the array
				temp = list.toArray();
				x = 100;
				y = currentY + 25;
				currentY = displayArray(g,temp,x,y,ww,"New Array");
				break;
			}
			case "Sort List":
			{
				int x=100;
				int y = 100;
				// display original list
				int currentY = displayList(g,list,x,y,ww,"Original List");
				// Display the array
				list.sort();
				x = 100;
				y = currentY + 30;
				currentY = displayList(g,list,x,y,ww,"Sorted Linked List");
				break;
			}
			case "Search List":
			{
				int x=100;
				int y = 100;
				// display original list
				int currentY = displayList(g,list,x,y,ww,"Original List");
				//Display the outcome of the search
				found = list.search(key);
				g.setColor(Color.RED);
				g.setFont(f1);
				String result = "";
				if (found) result = "Found";
				else       result = "NOT Found";
				g.drawString("Search Key  **** "+Integer.toString(key)+" ****  " +result, ww/2-100, currentY+30);
				break;
			}
			case "Shuffle List":
			{
				// display contents of list
				int x = 100;
				int y = 100;
				int currentY = displayList(g, list, x, y, ww, "Original List");
				// display contents of shuffled array
				list.shuffle();
				y = currentY + 30;
				currentY = displayList(g, list, x, y, ww, "Shuffled List");
				break;
			}
			case "Fill List":
			{
				// display contents of list
				int x = 100;
				int y = 100;
				int currentY = displayList(g, list, x, y, ww, "Original List");
				// display contents of filled list
				list.fill(v);
				y = currentY + 30;
				currentY = displayList(g, list, x, y, ww, "Filled List");
				break;
			}
			
			// Matrix operations
			case "Create Matrix":
			{
				
				int x= (ww-original2D.getColumns()*35)/2;
				int y = 75;
				int currentY = display2DArray( g, original2D.getArray(),  x, y, ww, "Original Matrix");
				break;
			}
			case "Matrix Minimum":
			{
				int x=(ww-original2D.getColumns()*35)/2;
				int y = 75;
				int currentY = display2DArray(g, original2D.getArray(),x,y,ww,"Original Matrix");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 25;
				g.drawString("Minimum = "+Integer.toString(original2D.getMinimum()), x, y);
				break;	
			}
			case "Matrix Maximum":
			{
				int x = (ww-original2D.getColumns()*35)/2;
				int y = 75;
				int currentY = display2DArray(g, original2D.getArray(), x, y, ww, "Original Matrix");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 50;
				y = currentY + 25;
				g.drawString("Maximum = "+original2D.getMaximum(), x, y);
				break;
			}
			case "Matrix Average":
			{
				int x = (ww-original2D.getColumns()*35)/2;
				int y = 75;
				int currentY = display2DArray(g, original2D.getArray(), x, y, ww, "Original Matrix");
				g.setFont(f1);
				g.setColor(Color.RED);
				x = ww/2 - 55;
				y = currentY + 25;
				g.drawString("Average = "+original2D.getAverage(), x, y);
				break;
			}
			case "Search Matrix":
			{
				int x = (ww-original2D.getColumns()*35)/2;
				int y = 75;
				// Display the Original Array
				int currentY = display2DArray(g,original2D.getArray(),x,y,ww,"Original Matrix");
		
				//Display the outcome of the search
				found = original2D.search(key);
				g.setColor(Color.RED);
				g.setFont(f1);
				String result = "";
				if (found) result = "Found";
				else       result = "NOT Found";
				g.drawString("Search Key  **** "+Integer.toString(key)+" ****  " +result, (ww/2-original2D.getColumns()*10), currentY+25);
				break;
			}
			case "Matrix to Array":
			{
				int x = (ww-original2D.getColumns()*35)/2;
				int y = 75;
				// display original matrix
				int currentY = display2DArray(g,original2D.getArray(),x,y,ww,"Original Matrix");
				// Display the array
				temp = original2D.toArray();
				y = currentY + 25;
				currentY = displayArray(g,temp,x,y,ww,"New Array");
				break;
			}
			case "Shuffle Matrix":
			{
				// display contents of temp
				int x = (ww-original2D.getColumns()*35)/2;
				int y = 75;
				int currentY = display2DArray(g, tempMatrix, x, y, ww, "Original Matrix");
				// display contents of shuffled array
				original2D.shuffle();
				y = currentY + 25;
				currentY = display2DArray(g, original2D.getArray(), x, y, ww, "Shuffled Matrix");
				break;
			}
			case "Fill Matrix":
			{
				// display contents of temp
				int x = (ww-original2D.getColumns()*35)/2;
				int y = 75;
				int currentY = display2DArray(g, tempMatrix, x, y, ww, "Original Matrix");
				// display contents of shuffled array
				original2D.fill(v);
				y = currentY + 25;
				currentY = display2DArray(g, original2D.getArray(), x, y, ww, "Filled Matrix");
				break;
			}
			
			}// end of switch
			
		}
		public int displayArray(Graphics g, int[] a, int x, int y, int ww, String title)
		{
			// display title
			g.setFont(f1);;
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50, y);
			// display array
			g.setFont(f);
			g.setColor(Color.BLACK);
			y = y + 25;
			int xs = x;
			for (int i=0; i<a.length; i++)
			{
				g.drawString(Integer.toString(a[i]), x, y);
				x = x + 35;
				if (x > ww - xs)
				{
					x = xs;
					y = y+25;
				}
			}
			return y;
		}
		public int displayList(Graphics g, LinkedList l, int x, int y, int ww, String title)
		{
			// display title
			g.setFont(f1);
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50, y);
			// display list
			g.setFont(f);
			g.setColor(Color.BLACK);
			y = y + 30;
			Node t = list.getHead();
			int xs = x;
			while (t!=null)
			{
				g.drawString(Integer.toString(t.getData()),x,y);
				g.drawRect(x-5, y-15, 30, 20);
				g.drawString("→", x+30, y);
				t = t.getNext();
				x = x + 50;
				if (x > ww - xs)
				{
					x = xs;
					y = y+30;
				} 
			}
			g.drawString("End", x, y);
			return y;
		}
		public int display2DArray(Graphics g, int[][] t, int x, int y, int ww, String title)
		{
			// display title
			g.setFont(f1);;
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50, y);
			// display matrix
			g.setFont(f);
			g.setColor(Color.BLACK);
			y = y + 25;
			int b = y;
			x = ww/2-(t[0].length*14);
			int xs = x;
			for (int i=0; i<t.length; i++)
			{
				
				for (int j=0; j<t[i].length; j++)
				{
					// vertical lines
					g.drawLine(x-5, y-15, x-5, y+6);
					// horizontal lines
					g.drawLine(x-5, y-15, x+23, y-15);
					// values
					g.drawString(Integer.toString(t[i][j]), x, y);
					x = x + 28;
					
				}
				x = xs;
				y = y+21;
			}
			g.drawLine(x-5+(28*t[0].length), b-15, x-5+(28*t[0].length), b-15+(21*t.length));
			g.drawLine(x-5, y-15, x-5+(28*t[0].length), y-15);
			return y;
		}
	}
