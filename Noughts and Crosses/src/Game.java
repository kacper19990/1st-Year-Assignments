

public class Game {
    public static String NOUGHT = "O";
    public static String CROSS = "X";

    public static void main(String[] args){
        Game game = new Game();
        char[][] board = new char[6][6];


    }

    void clearBoard(char[][] board){

        //TODO use correct method definition
        //TODO use loops to set each position to the BLANK character
    }

    void printBoard(char[][] board){
        //TODO use correct method definition
        //TODO loop through the array and print out the board in a way that it looked like a board
    }

    boolean canMakeMove(char[][] board, int row, int column){
        //TODO have correct function def and return the correct item
        //TODO check if a specified location was BLANK
    }

    void makeMove(char[][] board, char currentPlayerPiece, int row, int column){
        //TODO have correct function def
        //TODO set the currentPlayerPiece in the specified location
    }
    boolean isBoardFull(char[][] board){
        //TODO have correct function def
        //TODO loop through the board to check for BLANK characters
    }

    char winner(char[][] board){
        //TODO have correct function def and return the winning character
        //TODO identify all horizontal, diagonal and vertical possibilities of winning
    }


}



