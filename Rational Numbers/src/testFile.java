/* SELF ASSESSMENT

Class Rational
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment:Yes, they are declared

Constructor 1
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: exception thrown

Constructor 2
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: Does so

Add Method
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: none of the parameters are overwritten

Subtract Method
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8).
Comment: Did so

Multiply Method
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8).
Comment: Working

Divide Method
I have implemented this the same as add method, except it implements divide (marks out of 8: 8).
Comment: Working

Equals Method
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: ).
Comment: In order to see id they are both the same i use multiplication as said

isLessThan
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
Comment: same as in previous

Simplify Method
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment:  does as expected

gcd function
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
Comment: working order

toString Method
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
Comment: yes

Test Client Class
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 15).
Comment: Kind of does
*/

import java.util.Scanner;

public class testFile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input your first fraction");
        if (input.hasNext()) {
            String inputs = input.next();
            String[] temp = inputs.split("/");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            Rational first = new Rational(a, b);
            System.out.println("Input your second fraction");
            if (input.hasNext()) {
                String input2 = input.next();
                String[] temp2 = input2.split("/");
                int a2 = Integer.parseInt(temp2[0]);
                int b2 = Integer.parseInt(temp2[1]);
                first.add(a2, b2);
                first.simplify();
                first.toStrings();
                first.subtract(a2, b2);
                first.simplify();
                first.toStrings();
                first.divide(a2, b2);
                first.simplify();
                first.toStrings();
                first.multiply(a2, b2);
                first.simplify();
                first.toStrings();
                if (first.equals(a2, b2)) {
                    System.out.println("The two fractions are the same");
                }
                else {
                    System.out.println("The two fractions are different");
                }
                if (first.isLessThan(a2, b2)) {
                    System.out.println("The second fraction is greater than the first one");
                }
                else{
                    System.out.println("The second fraction is less than the first one");
                }
                first.simplify();
                first.toStrings();
            }
        }
    }
}
