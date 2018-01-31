/* SELF ASSESSMENT
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5: 5
Comment: Yes
Did I use loops to set each position to the BLANK character?
Mark out of 5: 5
Comment: Clears the board as intended
   2. printBoard
Did I use the correct method definition?
Mark out of 5: 5
Comment: Yes
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5: 5
Comment: The board does look like a board
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: yes
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment: Checks if the posiition is free
   4. makeMove
Did I have the correct function definition?
Mark out of 5: 5
Comment: Yes
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5: 5
Comment:    Yes
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:        yes
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5: 5
Comment: loops through to check for any empty spaces
   6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5: 5
Comment:     yes
Did I identify all possible horizontal, vertical and diagonal winners
Mark out of 15: 15
Comment: yes
   7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3: 3
Comments: yes
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5: 2
Comments: kind of works, but prints invalid input
Did I call all of the methods above?
Mark out of 5: 3
Comments: kind of
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3: 2
Comments: prints error and loops again when presented with an invalid input
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3: 0
Comments: unable to test since gets blocked
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3: 0
Comments: unable to check

   8. Overall
Is my code indented correctly?
Mark out of 3: 3
Comments: code indented
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3: 3
Comments: yes
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:Yes
      Total Mark out of 100 (Add all the previous marks): 80
*/

import java.util.Scanner;

public class Game {
    static final int ROWS = 3;
    static final int COLS = 3;
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int NOUGHT = 2;

    public static int currentPlayer;
    public static int currentState;

    public static final int CROSS_WON = 2;
    public static final int NOUGHT_WON = 3;

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        char[][] board = new char[3][3];
        game.clearBoard(board);
        boolean finished = false;
        do {
            game.printBoard(board);
            boolean validInput = false;
            do {
                if (currentPlayer == CROSS) {
                    System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
                } else {
                    System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
                }
                int row = in.nextInt() - 1;
                int col = in.nextInt() - 1;
                if (game.canMakeMove(board, row,col)) {
                    game.makeMove(board, (char) currentPlayer, row, col);
                    validInput = true;
                } else {
                    System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                            + ") is not valid. Try again...");
                }
            } while (!validInput);
            if (currentState == CROSS_WON) {
                System.out.println("'X' won! Bye!");
                finished = true;
            } else if (currentState == NOUGHT_WON) {
                System.out.println("'O' won! Bye!");
                finished = true;
            } else if (game.isBoardFull(board)) {
                System.out.println("It's a Draw! Bye!");
                finished = true;
            }
            currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
        } while (!finished);

    }




    void clearBoard(char[][] board) {
        boolean cleared = false;
        while (!cleared) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = 0;
                }
            }
            cleared = true;
        }
        /*
        TODO use correct method definition
        TODO use loops to set each position to the BLANK character
        */
    }

    void printBoard(char[][] board) {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                printCell(board[row][col]);
                if (col != COLS - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();

        //TODO use correct method definition
        //TODO loop through the array and print out the board in a way that it looked like a board
    }




    boolean canMakeMove(char[][] board, int row, int column){
        return board[row][column] == ' ';
        //TODO have correct function def and return the correct item
        //TODO check if a specified location was BLANK
    }

    void makeMove(char[][] board, char currentPlayerPiece, int row, int column){
        if(canMakeMove(board, row, column)) {
            board[row][column] = currentPlayerPiece;
        }
        //TODO have correct function def
        //TODO set the currentPlayerPiece in the specified location
    }
    boolean isBoardFull(char[][] board){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
        //TODO have correct function def
        //TODO loop through the board to check for BLANK characters

    }

    boolean winner(char[][] board, int currentRow, int currentCol, char theSeed){
        return (board[currentRow][0] == theSeed        // 3-in-the-row
                && board[currentRow][1] == theSeed
                && board[currentRow][2] == theSeed
                || board[0][currentCol] == theSeed      // 3-in-the-column
                && board[1][currentCol] == theSeed
                && board[2][currentCol] == theSeed
                || currentRow == currentCol            // 3-in-the-diagonal
                && board[0][0] == theSeed
                && board[1][1] == theSeed
                && board[2][2] == theSeed
                || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
                && board[0][2] == theSeed
                && board[1][1] == theSeed
                && board[2][0] == theSeed);
    }


        //TODO have correct function def and return the winning character
        //TODO identify all horizontal, diagonal and vertical possibilities of winning

    public static void printCell(int content) {
        switch (content) {
            case EMPTY:  System.out.print("   "); break;
            case NOUGHT: System.out.print(" O "); break;
            case CROSS:  System.out.print(" X "); break;
        }
    }
// some code adapted from https://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html
}



