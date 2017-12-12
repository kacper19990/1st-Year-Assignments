import java.util.Arrays;
import java.util.Scanner;

public class HighScores
{
    public static void initialiseHighScores(int[] highScores)
    {
        Arrays.fill(highScores, 0);
    }

    public static void printHighScores(int[] scores)
    {
        int i = 0;
        System.out.println("The high scores are");
        do {
            for(int index = 0; i < scores.length; i++) {
                scores[index] = scores[index] * -1;
            }

            System.out.print(scores[i]);
            i++;
        }while (i < scores.length);
    }

    public static boolean higherThan(int[] scores, int newScore)
    {
        System.out.println("Error8");
        return(newScore > scores[scores.length -1]);


    }
    public static void insertScore(int[] scores, int newScore)
    {
        while (scores != null)
        {
            int[] tempArray = new int[(scores.length + 1)];
            System.arraycopy(scores, 0, tempArray, 0, (scores.length));
            if (higherThan(scores, newScore))
            {
                int i = 0;
                do {
                    if (scores[i] > newScore)
                    {
                        i++;
                    }
                    else
                    {
                        tempArray[i] = newScore;
                        scores = tempArray;
                        break;
                    }
                }while (i < scores.length);
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many high scored do you want to add?");
        int number = input.nextInt();
        int[] highScores = new int[number];
        initialiseHighScores(highScores);
        boolean finished = false;
        do {
            System.out.println("Insert the next score.");
            int score = input.nextInt();
            if(higherThan(highScores, score))
            {
                insertScore(highScores, score);
                printHighScores(highScores);
            }
            else
            {
                System.out.println("Invalid input. Try again? Y/N");
                if(input.hasNext("N"))
            }
        }while(!finished);
    }
}
