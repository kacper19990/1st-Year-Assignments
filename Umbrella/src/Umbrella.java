/* SELF ASSESSMENT 
1. Did I use easy-to-understand meaningful variable names?
Mark out of 10: 10
2. Did I format the variable names properly (in lowerCamelCase)?
Mark out of 10: 10
3. Did I indent the code appropriately?
Mark out of 10: 10
4. Did I read the input correctly from the user using appropriate questions?
Mark out of 20: 20
5. Did I use an appropriate (i.e. not more than necessary) series of if statements?
Mark out of 30: 30
6. Did I output the correct answer for each possibility in an easy to read format?
Mark out of 15: 15
7. How well did I complete this self-assessment?
Mark out of 5: 5
Total Mark out of 100 (Add all the previous marks): 99
*/

import javax.swing.JOptionPane;

public class Umbrella {

    public static void main(String[] args) {
        int rain = JOptionPane.showConfirmDialog(null, "Is it raining?");								//Value of "Yes" is 0
        if(rain == 0)																					//If the user pressed "Yes" then then it proceeds to the next point
            JOptionPane.showMessageDialog(null, "Bring an umbrella.");
        else if(rain == 2)
            System.exit(0);
        else {
            int possibleRain = JOptionPane.showConfirmDialog(null, "Does it look like it will rain?");
            if(possibleRain == 0)
                JOptionPane.showMessageDialog(null, "Bring an umbrella.");
            else if(possibleRain == 2) {
                System.exit(0);
            }
            else
                JOptionPane.showMessageDialog(null, "Don't bring an umbrella.");
        }
    }
}
