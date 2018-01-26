import java.util.Arrays;
import java.util.Scanner;

public class highscore {
    public static int[] initialiseHighScore(int[] array) {
        Arrays.fill(array, 0);
        return array;
    }

    public static void printHighScores(int[] array) {
        System.out.print("The high scores are ");
        int arrayLength = (array.length) - 1;
        for (int count = 0; count < array.length; count++) {
            System.out.print(array[arrayLength] + ",");
            if (arrayLength > 0) {
                arrayLength--;
            }
            if (array[arrayLength] == 0) {
                return;
            }
        }
        return;
    }

    public static boolean higherThan(int[] array, int inputNumber) {
        if (inputNumber > array[0]) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] insertScore(int[] array, int highScore) {
        int entry = 0;
        array[entry] = 0;
        array[entry] = highScore;
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Please enter how many highscores you want to put in: ");
        if (inputScanner.hasNextInt()) {
            int arrayLength = inputScanner.nextInt();
            int[] HighScoreArray = new int[arrayLength];
            HighScoreArray = initialiseHighScore(HighScoreArray);
            boolean finished = false;
            do {
                System.out.println("\nPlease enter the highscore you wish to put in: ");
                if (inputScanner.hasNextInt()) {
                    int highScore = inputScanner.nextInt();
                    if (higherThan(HighScoreArray, highScore)) {
                        insertScore(HighScoreArray, highScore);
                        printHighScores(HighScoreArray);
                    }
                }
                else if (inputScanner.hasNext("exit")) {
                    System.out.println("Goodbye");
                    finished = true;
                } else {
                    System.out.println("You've entered in an invalid input, please try again: ");
                }
            } while (!(finished));
        } else if (inputScanner.hasNext()) {
            System.out.println("You've enterd something that isn't a number, try again");
        }
    }
}