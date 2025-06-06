package valid_sudoku;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidSudokuTest {

    @Test
    public void testValidBoard() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertTrue(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testInvalidRow() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','5'}, // Duplicate '5' in row
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','2'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testInvalidColumn() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'5','9','8','.','.','.','.','6','.'}, // Duplicate '5' in column 0
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testInvalidSubBox() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','3','1','9','5','.','.','.'}, // Duplicate '3' in top-left box
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testEmptyBoard() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            java.util.Arrays.fill(board[i], '.');
        }
        assertTrue(ValidSudoku.isValidSudoku(board));
    }
}
