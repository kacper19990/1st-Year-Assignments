package C4;

import java.awt.*;
import java.util.Arrays;

public class Connect4Grid2DArray implements Connect4Grid{

    public String[][] grid = new String[5][6];
    protected int win = 0;

    @Override
    public void emptyGrid() {
        Arrays.fill(grid, null);
    }

    @Override
    public boolean isValidColumn(int column) {
        int row = 0;
        String piece;
        int same = 1;
        do {
            if (grid[row][column] != null){
                piece = grid[row][column];
                if (grid[row+1][column].equals(piece)){
                    same++;
                    row++;
                }
                if (same == 4){
                    win = 1;
                    return true;
                }
                else{
                    same = 1;
                    row++;
                }
            }
            else {
                return true;
            }
        }while (row < 6);

        return false;
    }

    @Override
    public boolean isColumnFull(int column) {
        for (int i = 0; i < 6; i++){
            if (grid[i][column] == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void dropPiece(ConnectPlayer player, int column) {
        if(!isColumnFull(column)){
            int i = 6;
            do {
                grid[i][column] = player.getSign();
                if (grid[i-1][column] == null){
                    i--;
                    grid[i][column] = null;
                }
            }while (grid[i][column] == null);
        }
        else{
            System.out.println("Cannot drop the piece here. Try again.");
        }

    }

    @Override
    public boolean didLastPieceConnect4() {
        return win == 1;
    }

    public boolean isGridFull(){
        boolean full = false;
        for(int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                if (i == 5 && j == 6){
                    if (grid[i][j] != null){
                        full = true;
                    }
                }
                else if(grid[i][j] == null){
                    full = false;
                    break;
                }
            }
            if (full){
                break;
            }
        }
        return full;
    }
}
