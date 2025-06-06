package valid_sudoku;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSudoku {
    /**
     * Validates a partially-filled 9x9 Sudoku board.
     * Only filled cells are considered, and the method does not check for solvability.
     */
    public static boolean isValidSudoku(char[][] board) {

        if (board.length == 0 || board[0].length == 0) return true;

        final int ROWS = 9, COLS = 9;

        boolean[][] vert = new boolean[ROWS][9];
        boolean[][] horiz = new boolean[COLS][9];
        boolean[][] box = new boolean[ROWS][9];

        for(int i = 0; i < board.length; i++){

            for (int j = 0; j < board[i].length; j++){

                char c = board[i][j];

                if(c == '.') continue;

                int index = c - '1';

                int boxIndex = i / 3 * 3 + (j / 3);

                if (vert[i][index] || horiz[j][index] || box[boxIndex][index])
                    return false;

                vert[i][index] = true;
                horiz[j][index] = true;
                box[boxIndex][index] = true;

            }

        }

        return true;
    }



}
