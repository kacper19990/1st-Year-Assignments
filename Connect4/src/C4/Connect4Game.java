/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win.
Comment: Most of the functions are implemented

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: All methods implemented

Connect4Grid2DArray class (25 marks)
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: Doesn't check for diagonal wins

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method.
Comment: Assigns a sign to the player

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: A sign is assigned to the user

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality.
Comment: A sign is assigned to the AI

Total Marks out of 100: 75

*/



package C4;

import java.util.Scanner;

public class Connect4Game {

    public static void Main(String[] args){
        boolean end = false;
        C4HumanPlayer c4HumanPlayer = new C4HumanPlayer();
        C4RandomAIPlayer c4RandomAIPlayer = new C4RandomAIPlayer();
        System.out.println("Would you like to start? Y/N");
        Scanner input = new Scanner(System.in);
        if (input.hasNext("Y")){
            Connect4Grid2DArray connect4Grid2DArray = new Connect4Grid2DArray();
            connect4Grid2DArray.emptyGrid();
            while (!end){
                System.out.println("Where do you want to drop your piece? X");
                Scanner column = new Scanner(System.in);
                int drop = column.nextInt();
                if (column.hasNextInt()) {
                    if (connect4Grid2DArray.isColumnFull(drop)){
                        System.out.println("Column full. Try different one please.");
                    }
                    else {
                        connect4Grid2DArray.dropPiece(c4HumanPlayer, drop);
                        if (connect4Grid2DArray.didLastPieceConnect4()){
                            System.out.println("You win!");
                            end = true;
                        }
                        int aiCol = (int) (Math.random() * 6);
                        if (connect4Grid2DArray.isColumnFull(aiCol)){
                            aiCol--;
                            connect4Grid2DArray.dropPiece(c4RandomAIPlayer, aiCol);
                            if (connect4Grid2DArray.didLastPieceConnect4()){
                                System.out.println("You lose!");
                                end = true;
                            }
                        }

                    }
                }
                else {
                    System.out.println("Enter a valid row in integer form");
                }
            }
        }
        else {
            System.out.println("Quitting");
            System.exit(1);
        }



    }


}
