/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:  10
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  	5
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  	5
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 	10
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
   6. Did I indent the code appropriately?
       Mark out of 10:  10
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  10
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  10
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
   10. How well did I complete this self-assessment?
       Mark out of 10:  10
   Total Mark out of 100 (Add all the previous marks):
*/

import java.util.Scanner;
import javax.swing.JOptionPane;

public class PoundConverter {
    public static final int OLD_PENNY = 1;
    public static final int OLD_SHILLING = OLD_PENNY*12;
    public static final int OLD_POUND = OLD_SHILLING*20;
    public static final int TOTAL_POUNDS = (OLD_PENNY*67) / 100;

    public static void main(String args[]){
        mainLoop:																					//Starts a new loop

        while(true) {																			//Starts a loop so that the question window will pop up once again
            String inputPounds = JOptionPane.showInputDialog("How many pounds do you have?");	// if user doesn't input in an integer
            Scanner poundUser = new Scanner(inputPounds);

            if(poundUser.hasNextInt()) { 														//Checks if user inputs an integer, otherwise goes back to top
                int pounds = poundUser.nextInt();
                poundUser.close();
                while(true) {
                    String inputShilling = JOptionPane.showInputDialog("How many shillings do you have?");
                    Scanner shillingUser = new Scanner(inputShilling);

                    if(shillingUser.hasNextInt()) {
                        int shillings = shillingUser.nextInt();
                        shillingUser.close();
                        while(true) {
                            String inputPennies = JOptionPane.showInputDialog("How many pennies do you have?");
                            Scanner pennyUser = new Scanner(inputPennies);

                            if(pennyUser.hasNextInt()) {
                                int pennies = pennyUser.nextInt();
                                pennyUser.close();
                                double totalPennies = ((shillings * OLD_SHILLING) + (pennies * OLD_PENNY) + (pounds * OLD_POUND));
                                double totalPounds = (totalPennies*67) / 100;
                                String formattedPounds = String.format("%.02f", totalPounds); 	//Formats the line to output the total in the form #X.XX
                                JOptionPane.showMessageDialog(null, pounds + " old pound, " + shillings + " old shilling, " +
                                        pennies + " old pence = £" + formattedPounds);
                                break mainLoop; 												//Breaks out of the loop completely, closing the program.
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Input an integer please.");//Prompts the user to input an integer
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Input an integer please.");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Input an integer please.");
        }
    }
}

// Kacper Maczka 10/10/2017
