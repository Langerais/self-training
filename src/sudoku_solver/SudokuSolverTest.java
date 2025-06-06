package sudoku_solver;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SudokuSolverTest {

    @Test
    public void testSolve_ValidIncompleteBoard() {
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

        boolean solved = SudokuSolver.solve(board);
        assertTrue(solved, "The Sudoku should be solvable");

        // Validate fully solved board - no empty cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertTrue(board[i][j] >= '1' && board[i][j] <= '9', "All cells should be filled with digits 1-9");
            }
        }
    }

    @Test
    public void testSolve_AlreadySolvedBoard() {
        char[][] solvedBoard = {
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
        };

        boolean solved = SudokuSolver.solve(solvedBoard);
        assertTrue(solved, "Already solved board should be valid and return true");
    }

    @Test
    public void testSolve_InvalidBoard() {
        // Invalid because of repeated '5' in first row
        char[][] invalidBoard = {
                {'5','3','5','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        boolean solved = SudokuSolver.solve(invalidBoard);
        assertFalse(solved, "Invalid board should return false");
    }

    @Test
    public void testIsValid_ValidPlacement() {
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
        assertTrue(SudokuSolver.isValid(board, 0, 2, '4'), "Placing '4' at (0,2) should be valid");
        assertFalse(SudokuSolver.isValid(board, 0, 2, '5'), "Placing '5' at (0,2) should be invalid (row conflict)");
        assertFalse(SudokuSolver.isValid(board, 4, 4, '6'), "Placing '6' at (4,4) should be invalid (box conflict)");
    }

    @Test
    public void testIsValid_EmptyCell() {
        char[][] emptyBoard = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        assertTrue(SudokuSolver.isValid(emptyBoard, 4, 4, '7'), "Any digit on empty board should be valid");
    }
}
