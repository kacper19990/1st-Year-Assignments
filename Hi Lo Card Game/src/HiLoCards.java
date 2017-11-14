/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment: Yeah probs
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: Yeah they're in caps
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10 
       Comment: Looks alright
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5:
       Comment:  Looks g
   5. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment:  Auto-indent FTW
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20: 20
       Comment:  Do While is useful
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 10
       Comment:  No room for invalid input
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment: Random number gene
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment:  It works
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10: 10
       Comment:  The user wins after 5, resets after loss
   11. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment:  Not bad at all
   Total Mark out of 100 (Add all the previous marks): 0101010101
 */

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
				faceValue = "Jack";
			else if(card == QUEEN)
				faceValue = "Queen";
			else if(card == KING)
				faceValue = "King";
			else if(card == ACE)
				faceValue = "Ace";
			else
				faceValue = Integer.toString(card);
			int option = JOptionPane.showOptionDialog(null,
					"Your score so far is " + success + ". \nThe card is a " + faceValue + "\nDo you think the next card is: ",
					"Card Game",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[0]);

			int newCard = randCard.nextInt(13) +2;

			if((option == 0 && (newCard > card)) || (option == 1 && (newCard < card)) || (option == 2 && (newCard == card)))
				success++;
			else if(option == 3)
			{
				JOptionPane.showMessageDialog(null, "Exiting. \nThanks for playing.");
				System.exit(0);
			}
			else
				success = 0;
			card = newCard;

		} while(success < 5);
		JOptionPane.showMessageDialog(null, "Congratulations! You win the game!");

	}

}
