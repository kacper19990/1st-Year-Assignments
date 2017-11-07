import java.util.Random;
import java.util.Scanner;

public class HiLoCards
{
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    public static void main(String[] args)
    {
        int success = 0;
        Random randCard = new Random();
        int card = randCard.nextInt(13) + 2;
        do
        {

            if(card == JACK)
            {
                System.out.println("The card is a Jack");
            }
            else if(card == QUEEN)
            {
                System.out.println("The card is a Queen");
            }
            else if(card == KING)
            {
                System.out.println("The card is a King");
            }
            else if(card == ACE)
            {
                System.out.println("The card is an Ace");

            }
            else
            {
                System.out.println("The card is a " + card);
            }
            Scanner input = new Scanner(System.in);
            System.out.println("Do you think the next card is higher, lower, or equal?");
            String guess = input.next();
            int newCard = randCard.nextInt(13) +2;
            boolean correctEquals = guess.equals("equal");
            boolean correctHigher = guess.equals("higher");
            boolean correctLower = guess.equals("lower");
            boolean correctInput = guess.equals("lower") || guess.equals("higher") || guess.equals("equal");

            if((correctEquals && (newCard == card)) || (correctHigher && (newCard > card)) || (correctLower && (newCard < card)))
            {
                success++;
                System.out.println("So far you have " + success + " correct guesses.");


            }
            else if(correctInput)
            {
                success = 0;
                System.out.println("Sorry, that's an incorrect guess. Your score has been reset.");
            }
            else
            {
                System.out.println("Invalid input. Try again.");
            }
            card = newCard;



        } while(success < 5);
        System.out.println("Congratulations! You win the game!");

    }

}
