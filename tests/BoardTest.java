import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

    @Test
    public void testHasWinnerWhenThereIsAWinner() {
        Board board = new Board();
        
        // Set up a winning scenario for 'X' in the first row
        board.makeMove(new Player('X'), 1); // Player 'X' moves to cell 1
        board.makeMove(new Player('O'), 5); // Player 'O' moves to cell 4
        board.makeMove(new Player('X'), 2); // Player 'X' moves to cell 2
        board.makeMove(new Player('O'), 6); // Player 'O' moves to cell 5
        board.makeMove(new Player('X'), 3); // Player 'X' moves to cell 3
        assertTrue(board.hasWinner());
    }
    
    @Test
    public void testHasWinnerWhenThereIsNoWinner() {
        Board board = new Board();
        
        // Set up a scenario with no winner
        board.makeMove(new Player('X'), 1); // Player 'X' moves to cell 1
        board.makeMove(new Player('O'), 4); // Player 'O' moves to cell 4
        board.makeMove(new Player('X'), 2); // Player 'X' moves to cell 2
        board.makeMove(new Player('O'), 5); // Player 'O' moves to cell 5
        board.makeMove(new Player('X'), 8); // Player 'X' moves to cell 8
        assertFalse(board.hasWinner());
    }

}
