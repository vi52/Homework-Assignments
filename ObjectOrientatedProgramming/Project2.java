/* Name: Vicky Hu
 * Class: CSC 229-02
 * Project 2: Services
 *
 * This is the main class. It takes input for personal information: first
 * name, last name, address, city, state, and zip code. It also takes input
 * for services selected in the following order: a phone plan, a service 
 * plan,and/or an entertainment plan. Then, the following is output: the 
 * entered personal information; the selected phone, service, and 
 * entertainment plans; and the total cost, discount (if user selects 2 
 * plans there is a 15% discount and if user selects 3 plans, there is a 
 * 20% discount), and final cost after any discounts. 
 */

import javax.swing.JOptionPane;

public class Project02 
{
	public static void main(String[] args)
	{
		// personal information variables
		String firstName,
			lastName,
			address,
			city,
			state,
			zipCode;
		
		// input variables
		String input;
		int nServices = 0;
		int phoneCode, serviceCode, entertainmentCode;
		String phoneName = " ";
		String serviceName = " ";
		String entertainmentName = " ";
		double phoneCost = 0.0;
		double serviceCost = 0.0;
		double entertainmentCost = 0.0;
		double totalCost, finalCost = 0;
		int discount = 0;
		
		// input personal information variables
		firstName = JOptionPane.showInputDialog
		(null, "Please Enter Your First Name:", 
				"First name", 
				JOptionPane.QUESTION_MESSAGE);
		
		lastName = JOptionPane.showInputDialog
				(null, "Please Enter Your Last Name:", 
						"Last name", 
						JOptionPane.QUESTION_MESSAGE);
		address = JOptionPane.showInputDialog
				(null, "Please Enter Your Address:", 
						"Address", 
						JOptionPane.QUESTION_MESSAGE);
		city = JOptionPane.showInputDialog
				(null, "Please Enter Your City:", 
						"City name", 
						JOptionPane.QUESTION_MESSAGE);
		state = JOptionPane.showInputDialog
				(null, "Please Enter Your State:", 
						"Two Letter State Code", 
						JOptionPane.QUESTION_MESSAGE);
		zipCode = JOptionPane.showInputDialog
				(null, "Please Enter Your Zip Code:", 
						"Zip Code", 
						JOptionPane.QUESTION_MESSAGE);
		
		// prompt user for phone services
		input = JOptionPane.showInputDialog(
				null, 
				"           Please Select Your Smart Phone"+"\n"+
				"                   Price/Month for 24 Months"+"\n"+
				"_____________________________________________"+"\n"+
				"   1. Apple iPhone 14 Pro                            $ 98.35"
				+"\n"+
				"   2. Samsung Galaxy S20 FE 5g UW          $ 73.55"
				+"\n"+
				"   3. Google Pixel 6 Pro                               $47.75"
				+"\n"+
				"   4. Motorola Moto g pure                          $38.55"
				+"\n"+"\n"+
				"   5. NO Service"
				+"\n"+
				"_________________________________________",
				"Smart Phone", JOptionPane.QUESTION_MESSAGE);
		phoneCode = Integer.parseInt(input);
		switch(phoneCode)
		{
			case 1:
			{
				phoneName = "Apple iPhone 14 Pro";
				phoneCost = 98.35;
				nServices++;
				break;
			}
			case 2:
			{
				phoneName = "Samsung Galaxy S20 FE 5g UW";
				phoneCost = 73.55;
				nServices++;
				break;
			}
			case 3:
			{
				phoneName = "Google Pixel 6 Pro";
				phoneCost = 47.75;
				nServices++;
				break;
			}
			case 4:
			{
				phoneName = "Motorola Moto g pure";
				phoneCost = 38.55;
				nServices++;
				break;
			}
			case 5:
			{
				phoneName = "No Service";
				phoneCost = 0;
				break;
			}
		}
		
		// prompt user for service plan
		input = JOptionPane.showInputDialog(
				null, 
				"       Please Select Your Service Plan"+"\n"+
				"                        Monthly Cost"+"\n"+
				"___________________________________"+"\n"+
				"     Unlimited"+"\n"+
				"        1. Start                         $ 34.00"
				+"\n"+
				"        2. Play More                $ 58.00"
				+"\n"+
				"        3. Get More                 $ 68.00"
				+"\n"+"\n"+
				"     Shared Data"
				+"\n"+
				"        4. S (5GB)                    $ 65.00"
				+"\n"+
				"        5. M (10GB)                 $ 75.00"
				+"\n"+"\n"+
				"        6. NO Service"
				+"\n"+
				"____________________________________",
				"Service Plan", JOptionPane.QUESTION_MESSAGE);
		serviceCode = Integer.parseInt(input);
		switch(serviceCode)
		{
			case 1:
			{
				serviceName = "Unlimited (Start)";
				serviceCost = 34.00;
				nServices++;
				break;
			}
			case 2:
			{
				serviceName = "Unlimited (Play More)";
				serviceCost = 58.00;
				nServices++;
				break;
			}
			case 3:
			{
				serviceName = "Unlimited (Get More)";
				serviceCost = 68.00;
				nServices++;
				break;
			}
			case 4:
			{
				serviceName = "Shared Data (S - 5GB)";
				serviceCost = 65.00;
				nServices++;
				break;
			}
			case 5:
			{
				serviceName = "Shared Data (M - 10GB)";
				serviceCost = 75.00;
				nServices++;
				break;
			}
			case 6:
			{
				serviceName = "No Service";
				serviceCost = 0;
				break;
			}
		}
		
		// prompt user for entertainment services
		input = JOptionPane.showInputDialog(
				null, 
				"       Please Select Your Entertainment Service"+"\n"+
				"                               Monthly Cost"+"\n"+
				"_________________________________________"+"\n"+
				"  	      1. Disney                                         $ 7.99"
				+"\n"+
				"         2. Hulu                                            $ 9.99"
				+"\n"+
				"         3. Sport + Disney + Hulu              $12.99"
				+"\n"+"\n"+
				"         4. NO Service"
				+"\n"+
				"_________________________________________",
				"Entertainment Service", JOptionPane.QUESTION_MESSAGE);
		entertainmentCode = Integer.parseInt(input);
		switch(entertainmentCode)
		{
			case 1:
			{
				entertainmentName = "Disney";
				entertainmentCost = 7.99;
				nServices++;
				break;
			}
			case 2:
			{
				entertainmentName = "Hulu";
				entertainmentCost = 9.99;
				nServices++;
				break;
			}
			case 3:
			{
				entertainmentName = "Sport + Disney + Hulu";
				entertainmentCost = 12.99;
				nServices++;
				break;
			}
			case 4:
			{
				entertainmentName = "No Service";
				entertainmentCost = 0;
				break;
			}
		}
		
		// calculate final costs
		totalCost = phoneCost+serviceCost+entertainmentCost;
		switch(nServices)
		{
			case 0:
			{
				discount = 0;
				finalCost = 
						totalCost-(totalCost*(discount*0.01));
				break;
			}
			case 1:
			{
				discount = 0;
				finalCost = 
					totalCost-(totalCost*(discount*0.01));
				break;
			}
			case 2:
			{
				discount = 15;
				finalCost = 
					totalCost-(totalCost*(discount*0.01));
				break;
			}
			case 3:
			{
				discount = 20;
				finalCost = 
					totalCost-(totalCost*(discount*0.01));
				break;
			}
		}
		
		// output message
		JOptionPane.showMessageDialog(
				null, 
				"                                 CSC 229 - Project02"+"\n"+
				"_______________________________________________________"
				+"\n"+
				"             First Name   :  "+firstName
				+"\n"+
				"             Last Name    :  "+lastName
				+"\n"+
				"             Address        :  "+address
				+"\n"+
				"                                      "+city+
				", "+state+" "+zipCode+"\n"+
				"_______________________________________________________"
				+"\n"+
				"                                      Service List"+"\n"+
				"_______________________________________________________"
				+"\n"+
				"Phone                               : "+phoneName+
				"          ---"+phoneCost+"\n"+
				"Service Plan                    : "+serviceName+
				"                  ---"+serviceCost+"\n"+
				"Entertainment Service   : "+entertainmentName+
				"                                  ---"+entertainmentCost
				+"\n"+
				"_______________________________________________________"
				+"\n"+
				"                             Total Cost    : $ "
				+Math.round(totalCost)+"\n"+
				"                             % Discount  : % "
				+discount+"\n"+
				"                             Final Cost     : $ "
				+Math.round(finalCost)+"\n"+
				"_______________________________________________________",
				"Final Cost of Services",
				JOptionPane.INFORMATION_MESSAGE
				);
	}
}
