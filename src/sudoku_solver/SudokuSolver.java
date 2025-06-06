package sudoku_solver;

public class SudokuSolver {

    public static boolean solve(char[][] board){

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, i, j, d)) {
                            board[i][j] = d;             // place it
                            if (solve(board)) return true; // recurse
                            board[i][j] = '.';           // backtrack
                        }
                    }
                    return false; // no valid digit found
                }
            }
        }
        return true; // board solved (no empty cells left)
    }


    public static boolean isValid(char[][] board, int i, int j, char c){

        int boxStartX = j - (j % 3);
        int boxStartY = i - (i % 3);

        for (int x = 0; x < board.length; x++){
            char boxChar = board[boxStartY + (x / 3)][boxStartX + (x % 3)];
            if(board[i][x] == c || board[x][j] == c || boxChar == c) return false;
        }

        return true;

    }

}
