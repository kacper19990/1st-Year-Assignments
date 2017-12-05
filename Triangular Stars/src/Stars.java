/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5           Comment: All variables are easy to read and in proper format
 2. Did I indent the code appropriately?
        Mark out of 5: 5           Comment: Yes
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20          Comment: determineStar is functioning correctly, and properly invoked
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20          Comment: Returns true or false when comparing the two numbers
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15: 15          Comment: Formula used from the question
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10: 10          Comment: All numbers went through, until the number overflows into negative.
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20: 20          Comment: All numbers are printed and accounted for.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5           Comment: All well.
 Total Mark out of 100 (Add all the previous marks):100
*/

public class Stars
{

    public static int COUNTER = 1;
    public static boolean isStarNumber(int starNumber, int triangleNumber)
    {
        return ((starNumber % triangleNumber) == 0);


    }

    public static int determineStarNumber(int triangle)
    {
        int starNumber = 0;
        int currentNumber = 1;
        int previousNumber = 0;
        do {
            starNumber = (6 * currentNumber * previousNumber) + 1;
            previousNumber = currentNumber;
            currentNumber++;
        }while (starNumber < triangle);

        return starNumber;
    }


    public static void main(String[] args)
    {
        int triangleNumber = 0;
        System.out.println("The numbers that are the same are:");
        do {
            triangleNumber = COUNTER + triangleNumber;
            if(isStarNumber(determineStarNumber(triangleNumber), triangleNumber))
                System.out.println(triangleNumber);
            COUNTER++;
        }while (triangleNumber >= 0);
    }
}

