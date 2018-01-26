import java.util.Scanner;

public class Frequencies {
    public static void countDigitFrequencies(int number, int[] frequencies)
    {
        int i = 0;
        do{
            int lastNumber = number % 10;
            int zero = 0;
            int one = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            int five = 0;
            int six = 0;
            int seven = 0;
            int eight = 0;
            int nine = 0;
            switch (lastNumber)
            {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;

            }frequencies[0] = zero;
            frequencies[1] = one;
            frequencies[2] = two;
            frequencies[3] = three;
            frequencies[4] = four;
            frequencies[5] = five;
            frequencies[6] = six;
            frequencies[7] = seven;
            frequencies[8] = eight;
            frequencies[9] = nine;

            i++;
        }while (i < frequencies.length);
    }
    public static void printDigitFrequencies(int[] frequencies)
    {
        System.out.println("Digit Frequencies> ");
        for(int i = 0; i < 10; i++)
        {
            if(frequencies[0] != 0)
            {
                System.out.print("0 (" + frequencies[0] + ")");
            }

        }
    }
    public static void main(String[] args)
    {
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt())
        {

        }
        else
        {
            System.out.println("Incorrect input. Try again.");
            return;
        }
    }
}
