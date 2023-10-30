import javax.swing.JOptionPane;

public class Project04
{
	public static void main(String[] args)
	{
		menu();
	}

	public static void menu()
	{
		// display information on program
		JOptionPane.showMessageDialog(null,
			"This application allows the user to select"+"\n"+
			"one of the six Shapes and enter the primary"+"\n"+
			"attributes of the shape, it then calculates"+"\n"+
			"the secondary attributes of the shape and"+"\n"+
			"         reports all attributes"+"\n"+
			"___________________________________________"+"\n"+
			"                Two-Dimensional Shapes"+"\n"+
			"___________________________________________"+"\n"+
			"                        1) Triangle"+"\n"+
			"                        2) Rectangle"+"\n"+
			"                        3) Diamond"+"\n"+
			"                        4) Regular Polygon"+"\n"+
			"___________________________________________"+"\n"+
			"                 Three-Dimensional Shapes"+"\n"+
			"___________________________________________"+"\n"+
			"                        5) Cube"+"\n"+
			"                        6) Sphere",
			"Geometric Shapes", JOptionPane.INFORMATION_MESSAGE)
		;
		// variables
		String input;
		int userSelection = 0;

		// loop through menu selection
		while(userSelection !=7)
		{
			input =JOptionPane.showInputDialog(null,
				"                 Geometric Shapes"
				+"\n"+"_____________________________________  "
				+"\n"+"         Select a Shape by Entering"+"\n"+
				"      the Number Associated with Shape"+"\n"+
				"         Press 7 to Exit the Program"
				+"\n"+"_____________________________________  "
				+"\n"+
				"           Two-Dimensional Shapes"+"\n"+
				"_____________________________________  "+"\n"+
				"                     1) Triangle"+"\n"+
				"                     2) Rectangle"+"\n"+
				"                     3) Diamond"+"\n"+
				"                     4) Regular Polygon"+"\n"+
				"_____________________________________  "+"\n"+
				"            Three-Dimensional Shapes"+"\n"+
				"_____________________________________  "+"\n"+
				"                     5) Cube"+"\n"+
				"                     6) Sphere"+"\n"+
				"_____________________________________  "+"\n"+
				"                     7) Exit"+"\n"+
				"_____________________________________  ",
				"Geometric Shapes",
				JOptionPane.QUESTION_MESSAGE);
			userSelection = Integer.parseInt(input);
			// create object, get attributes, and display characteristics
			switch(userSelection)
			{
				case 1: // triangle
				{
					Triangle t = new Triangle();
					t.getAttributes();
					displayResults(userSelection,t);
					break;
				}
				case 2: // rectangle
				{
					Rectangle r = new Rectangle();
					r.getAttributes();
					displayResults(userSelection,r);
					break;
				}
				case 3: // diamond
				{
					Diamond d = new Diamond();
					d.getAttributes();
					displayResults(userSelection,d);
					break;
				}
				case 4: // regular polygon
				{
					RegularPolygon p = new RegularPolygon();
					p.getAttributes();
					displayResults(userSelection,p);
					break;
				}
				case 5: // cube
				{
					Cube c = new Cube();
					c.getAttributes();
					displayResults(userSelection,c);
					break;
				}
				case 6: // sphere
				{
					Sphere s = new Sphere();
					s.getAttributes();
					displayResults(userSelection,s);
					break;
				}
				case 7: // exit
				{
					JOptionPane.showMessageDialog(null,
						"             Good Bye",
						"Thank You For Using Geometric Shapes",
						JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
					break;
				}
				default: // any input outside 1-7
				{
					JOptionPane.showMessageDialog(null,
						"Incorrect input Value, Please Enter Numbers Between 1 and 7",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		}
	}

	// get object characteristics to display
	public static void displayResults(int userSelection,Object o)
	{
		switch(userSelection)
		{
			case 1: // triangle
			{
				Triangle temp = (Triangle)o;
				JOptionPane.showMessageDialog(null,
						temp.toString(),
						"Geometric Shapes",
						JOptionPane.INFORMATION_MESSAGE);
			break;
			}
			case 2: // rectangle
			{
				Rectangle temp = (Rectangle)o;
				JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 3: // diamond
			{
				Diamond temp = (Diamond)o;
				JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 4: // regular polygon
			{
				RegularPolygon temp = (RegularPolygon)o;
				JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 5: // cube
			{
				Cube temp = (Cube)o;
				JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 6: // sphere
			{
				Sphere temp = (Sphere)o;
				JOptionPane.showMessageDialog(null,
					temp.toString(),
					"Geometric Shapes",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
}
