import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HighScores
{
    public static int[] initialiseHighScores(int[] highScores)
    {
        Arrays.fill(highScores, 0);
        return highScores;
    }

    public static String printHighScores(int[] scores)
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
        return null;
    }

    public static boolean higherThan(int[] scores, int newScore)
    {
        boolean truth = false;
        int i = 0;
        do {
            if(newScore > scores[i])
                truth = true;
            else if(i < scores.length)
                i++;
            else
                truth = false;
        }while (i < scores.length);
        return(truth);
    }
    public static void insertScore(int[] scores, int newScore)
    {
        while (scores != null)
        {
            int[] tempArray = new int[(scores.length + 1)];
            System.arraycopy(scores, 0, tempArray, 0, (scores.length + 1));
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
            else
            {
                tempArray[scores.length] = newScore;
                scores = tempArray;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many high scored do you want to add?");
        int number = input.nextInt();
        System.out.println("Insert the high scores with ',' in between each value");
        int i = 0;
        int[] highScores = {};
        do {
            int score = input.nextInt();
            highScores[i] = score;
            i++;
        }while(i < number);
        initialiseHighScores(highScores);
        boolean loop = true;
        do {
            System.out.println("Input the next high score.");
            input = new Scanner(System.in);
            if(input.hasNextInt())
            {
                int score = input.nextInt();
                insertScore(highScores, score);

            }
            else
                loop = false;
        }while(loop);
        printHighScores(highScores);
    }

}
