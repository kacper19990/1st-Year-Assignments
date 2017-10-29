/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5
   3. Did I indent the code appropriately?
       Mark out of 10: 10
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10:  10
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  20
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30:  30
   8. How well did I complete this self-assessment?
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class Incremental
{

    public static void main(String[] args)
    {
        double averagePrevious = 0;
        double variancePrevious = 0;
        int totalNumbers = 0;
        boolean finished = false;

        do
        {
            Scanner input = new Scanner( System.in );
            System.out.print("Enter a number (or type 'exit'): ");
            if(input.hasNextDouble())
            {
                totalNumbers++;
                double numberN = input.nextDouble();
                double averageN = averagePrevious + ((numberN - averagePrevious) / totalNumbers);
                double varianceN = ((variancePrevious * (totalNumbers -1)) + (numberN - averagePrevious) * (numberN - averageN)) / totalNumbers;
                variancePrevious = varianceN;
                averagePrevious = averageN;
                System.out.println("So far the average is " + averageN + " and the variance is " + varianceN);
            }
            else if(input.hasNext("exit"))
            {
                System.out.println("Goodbye.");
                finished = true;
            }
            else
                System.out.println("Please enter a valid number");

        }
        while(!finished);

    }

}
