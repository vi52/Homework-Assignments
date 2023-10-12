/* Name: Vicky Hu
 * Class: CSC 229-02
 * Project 3: Math Series
 *
 * This project has options to calculate 4 mathematical sequences:
 * 	1) 1+2+3...+N
 *  2) 1+8+27...+N^3
 *  3) 4+16+64...+4^N
 *  4) 2/1!+4/2!...+2^N/N!
 * The user inputs their desired number for variable "n" and the
 * result is calculated.
 *
 * This is the main class. All of the methods are in this class. It has
 * the following methods: main, menu, method1, method2, method3, method4,
 * and displayResult. Main calls the menu method which will initialize
 * the entire program. Menu takes no inputs and returns no outputs. It has
 * a loop that continually displays the menu options and prompts users for
 * an input until the user selects option 5 to exit. It also utilizes
 * switch to call the corresponding method depending on the user's
 * selection, asks user for a value for n, and calls displayResult.
 * Method1, method2, method3, and method4 are all methods that calculate
 * the math series that corresponds to the user's selection. They each take
 * N as an int argument passed to them and return the final result of the
 * calculation as a double. DisplayResult is passed user's menu selection
 * (int), user's input value for n (int), and the final calculated result
 * (double). It utilizes switch on user's selection to display different
 * dialogues that output the math series chosen, value for n, and final
 * result.
 */

import javax.swing.JOptionPane;

public class Project03
{
	public static void main(String[] args)
	{
		menu();
	}

	// method that defines math series menu
	public static void menu()
	{
		// variables
		String input;
		int userSelection = 0;
		int n = 0;
		double result;

		// loop menu options
		while(userSelection != 5)
		{
			input =JOptionPane.showInputDialog(null,
				"                   CSC 229 - Project 03 (Math Series)"
				+"\n"+"____________________________________________________"
				+"\n"+"  Select a series by pressing the number key Associated"
				+"\n"+"                                  5 to Exit the program"
				+"\n"+"____________________________________________________"
				+"\n"+
				"                     1) 1+2+3          +......... +N"+"\n"+
				"                     2) 1+8+27        +......... +N^3"+"\n"+
				"                     3) 4+16+64      +......... +4^N"+"\n"+
				"                     4) 2/1!+4/2!       +......... +2^N/N!"
				+"\n"+"\n"+"                     5) EXIT","Math Series",
				JOptionPane.QUESTION_MESSAGE);
			userSelection = Integer.parseInt(input);
			System.out.println(userSelection);

			// menu selection
			switch(userSelection)
			{
				case 1: // for +N
				{
					input =JOptionPane.showInputDialog(null,
						"Enter a Positive Integer Number for N",
						"1+2+3+...+N",
						JOptionPane.QUESTION_MESSAGE);
					n = Integer.parseInt(input);
					result = method1(n);
					displayResult(userSelection, n, result);
					break;
				}
				case 2: // for N^3
				{
					input =JOptionPane.showInputDialog(null,
						"Enter a Positive Integer Number for N",
						"1+8+27+...+N^3",
						JOptionPane.QUESTION_MESSAGE);
					n = Integer.parseInt(input);
					result = method2(n);
					displayResult(userSelection, n, result);
					break;
				}
				case 3: // for 4^N
				{
					input =JOptionPane.showInputDialog(null,
						"Enter a Positive Integer Number for N",
						"4+16+64+...+4^N",
						JOptionPane.QUESTION_MESSAGE);
					n = Integer.parseInt(input);
					result = method3(n);
					displayResult(userSelection, n, result);
					break;
				}
				case 4: // for 2^N/N!
				{
					input =JOptionPane.showInputDialog(null,
						"Enter a Positive Integer Number for N",
						"2/1!+4/2!+8/3!+...+2^N/N!",
						JOptionPane.QUESTION_MESSAGE);
					n = Integer.parseInt(input);
					result = method4(n);
					displayResult(userSelection, n, result);
					break;
				}
				case 5: // for exit
				{
					JOptionPane.showMessageDialog(null,
						"              Good Bye",
						"Thank You For Using Math Series",
						JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
					break;
				}
				default: // for any input outside 1-5
				{
					JOptionPane.showMessageDialog(null,
						"Please Enter Numbers Between 1 and 5",
						"Incorrect Selection",
						JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		}
	}

	// method for +N
	public static double method1(int n)
	{
		double sum = 0;
		for(int i=1; i<=n; i++)
		{
			sum = sum + i;
		}
		return sum;
	}

	// method for N^3
	public static double method2(int n)
	{
		double sum = 0;
		for(int i=1; i<=n; i++)
		{
			sum = sum + Math.pow(i, 3);
		}
		return sum;
	}

	// method for 4^N
	public static double method3(int n)
	{
		double sum = 0;
		for(int i=1; i<=n; i++)
		{
			sum = sum + Math.pow(4, i);
		}
		return sum;
	}

	// method for 2^N/N!
	public static double method4(int n)
	{
		double sum = 0;
		double denominator = 1;
		for(int i=1; i<=n; i++)
		{
			denominator = denominator*i;
			sum = sum + (double)(Math.pow(2, i)/denominator);
		}
		return sum;
	}

	// method to display calculation results
	public static void displayResult(int userSelection, int n, double result)
	{
		switch(userSelection)
		{
			case 1:
			{
				JOptionPane.showMessageDialog(null,
					"     CSC 229 - Project03 (Math Series)"
					+"\n"+"___________________________________"
					+"\n"+"              1 + 2 + 3 + ........ +"+n
					+" = "+(long)result
					+"\n"+"___________________________________",
					"Math Series",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 2:
			{
				JOptionPane.showMessageDialog(null,
					"       CSC 229 - Project03 (Math Series)"
					+"\n"+"___________________________________"
					+"\n"+"           1 + 8 + 27 + ........ + "
					+(int)Math.pow(n,3)+" = "+(long)result
					+"\n"+"___________________________________",
					"Math Series",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 3:
			{
				JOptionPane.showMessageDialog(null,
					"        CSC 229 - Project03 (Math Series)"
					+"\n"+"_____________________________________"
					+"\n"+"          4 + 16 + 64 + ........ + "
					+(int)Math.pow(4, n)+" = "+(long)result
					+"\n"+"_____________________________________",
					"Math Series",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 4:
			{
				JOptionPane.showMessageDialog(null,
					"            CSC 229 - Project03 (Math Series)"
					+"\n"+"__________________________________________"
					+"\n"+"       2/1! + 4/2! + 8/3! + ......... + "
					+(int)Math.pow(2, n)+"/"+n+"! = "+(long)result
					+"\n"+"__________________________________________",
					"Math Series",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
}
