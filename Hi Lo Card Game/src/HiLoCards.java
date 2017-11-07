import java.util.Random;
import javax.swing.JOptionPane;

public class HiLoCards
{

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    public static void main(String[] args)
    {
        Object[] options = {"Higher", "Lower", "Equal", "Quit"};
        int success = 0;
        Random randCard = new Random();
        int card = randCard.nextInt(13) + 2;
        String faceValue = "";
        do
        {

            if(card == JACK)
            {
                faceValue = "Jack";
            }
            else if(card == QUEEN)
            {
                faceValue = "Queen";
            }
            else if(card == KING)
            {
                faceValue = "King";
            }
            else if(card == ACE)
            {
                faceValue = "Ace";

            }
            else
            {
                faceValue = Integer.toString(card);
            }
            int option = JOptionPane.showOptionDialog(null,
                    "Your score so far is " + success + ". \nThe card is a " + faceValue + "\n Do you think the next card is: ",
                    "Card Game",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            int newCard = randCard.nextInt(13) +2;


            if((option == 0 && (newCard > card)) || (option == 1 && (newCard < card)) || (option == 2 && (newCard == card)))
            {
                success++;

            }
            else if(option == 3)
            {
                JOptionPane.showMessageDialog(null, "Exiting. \nThanks for playing.");
                System.exit(0);
            }

            else
            {
                success = 0;

            }
            card = newCard;

        } while(success < 5);
        JOptionPane.showMessageDialog(null, "Congratulations! You win the game!");

    }

}
