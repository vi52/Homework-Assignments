/* Name: Vicky Hu
 * Class: CSC 229-02
 * Project 1: Triangular Prism
 *
 * This is the main class. It takes input for the three coordinate points of
 * the triangular face of the prism as well as the height, and outputs
 * corresponding information about the triangular prism. This information
 * includes the inputed information, side lengths, perimeter, area, surface
 * area, and volume. 
 */

// import modules
import javax.swing.JOptionPane;

public class Project01 {

public static void main(String[] args)
{
	// variables
	String input;
	int x1, y1;
	int x2, y2;
	int x3,y3;
	int height;

	// base attributes
	double side1, side2, side3;
	double perimeter;
	double area;

	// prism attributes
	double surfaceArea;
	double volume;

	// prompt user for basic variables
	// variable x1
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "X1", JOptionPane.QUESTION_MESSAGE);
	x1 = Integer.parseInt(input);
	// variable y1
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "Y1", JOptionPane.QUESTION_MESSAGE);
	y1 = Integer.parseInt(input);
	// variable x2
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "X2", JOptionPane.QUESTION_MESSAGE);
	x2 = Integer.parseInt(input);
	// variable y2
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "Y2", JOptionPane.QUESTION_MESSAGE);
	y2 = Integer.parseInt(input);
	// variable x3
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "X3", JOptionPane.QUESTION_MESSAGE);
	x3 = Integer.parseInt(input);
	// variable y3
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "Y3", JOptionPane.QUESTION_MESSAGE);
	y3 = Integer.parseInt(input);
	// variable height
	input = JOptionPane.showInputDialog
			(null, "Enter an Integer", "Height", JOptionPane.QUESTION_MESSAGE);
	height = Integer.parseInt(input);

	// calculate base attributes
	// calculate for the 3 sides of the face
	side1 = Math.sqrt(
			Math.pow((x2-x1),2) +
			Math.pow((y2-y1),2)
			);
	side2 = Math.sqrt(
			Math.pow((x3-x2),2) +
			Math.pow((y3-y2),2)
			);
	side3 = Math.sqrt(
			Math.pow((x1-x3),2) +
			Math.pow((y1-y3),2)
			);
	// calculate perimeter
	perimeter = side1+side2+side3;
	// calculate area
	area = Math.sqrt(
			(perimeter/2)*((perimeter/2)-side1)*
			((perimeter/2)-side2)*((perimeter/2)-side3)
			);

	// calculate prism attributes
	// calculate surface area
	surfaceArea = 2*area+height*perimeter;
	// calculate volume
	volume = height*area;

	// output attributes
	JOptionPane.showMessageDialog(null,
			"         CSC 229 - Project1"+"\n"+
			"_____________________________"+"\n"+
			"          Triangular Prism	"+"\n"+
			"_____________________________"+"\n"+
			"         Primary Attributes	"+"\n"+
			"_____________________________"+"\n"+
			"          First Point = ("+x1+","+y1+")"+"\n"+
			"     Second Point = ("+x2+","+y2+")"+"\n"+
			"         Third Point = ("+x3+","+y3+")"+"\n"+
			"                 Height = "+height+"\n"+
			"_____________________________"+"\n"+
			"             Base Attributes	"+"\n"+
			"_____________________________"+"\n"+
			"               Side 1 = "+Math.round(side1)+"\n"+
			"               Side 2 = "+Math.round(side2)+"\n"+
			"               Side 3 = "+Math.round(side3)+"\n"+
			"         Perimeter = "+Math.round(perimeter)+"\n"+
			"                  Area = "+Math.round(area)+"\n"+
			"_____________________________"+"\n"+
			"             Prism Attributes	"+"\n"+
			"_____________________________"+"\n"+
			"       Surface Area = "+Math.round(surfaceArea)+"\n"+
			"                 Volume = "+Math.round(volume)+"\n",
			"Project 1 - Triangular Prism",
					JOptionPane.INFORMATION_MESSAGE);
}}
