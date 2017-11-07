import java.util.Random;
import java.util.Scanner;

public class HiLoCards
{
    public static void main(String[] args)
    {
        int success = 0;
        Random randCard = new Random();
        int card = randCard.nextInt(13) + 2;
        do
        {

            if(card == 11)
            {
                System.out.println("The card is a Jack");
                //card = newCard;
                //return;
            }
            else if(card == 12)
            {
                System.out.println("The card is a Queen");
                //card = newCard;
                //return;
            }
            else if(card == 13)
            {
                System.out.println("The card is a King");
                //card = newCard;
                //return;
            }
            else if(card == 14)
            {
                System.out.println("The card is an Ace");
                //card = newCard;

            }
            else
            {
                System.out.println("The card is a " + card);
                //card = newCard;
            }
            Scanner input = new Scanner(System.in);
            System.out.println("Do you think the next card is higher, lower, or equal?");
            String guess = input.next();
            int newCard = randCard.nextInt(13) +2;
            boolean correctEquals = guess.equals("equal");
            boolean correctHigher = guess.equals("higher");
            boolean correctLower = guess.equals("lower");

            if((correctEquals && (newCard == card)) || (correctHigher && (newCard > card)) || (correctLower && (newCard < card)))
            {
                success++;
                System.out.println("So far you have " + success + " correct guesses.");


            }
            else
            {
                success = 0;
                System.out.println("Sorry, that's an incorrect guess. Your score has been reset.");
            }
            card = newCard;



        } while(success < 5);
        System.out.println("Congratulations! You win the game!");

    }

}
