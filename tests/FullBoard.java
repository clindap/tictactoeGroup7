import static org.junit.Assert.*;

import org.junit.Test;

public class FullBoard {

    @Test
    public void testIsFullWhenBoardIsEmpty() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    public void testIsFullWhenBoardIsFull() {
        Board board = new Board();
        // Fill the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.makeMove(new Player('X'), i * 3 + j + 1);
            }
        }

        assertTrue(board.isFull());
    }

    @Test
    public void testIsFullWhenBoardIsNotFull() {
        Board board = new Board();
        // Make some moves, leaving some cells empty
        board.makeMove(new Player('X'), 1);
        board.makeMove(new Player('O'), 5);
        board.makeMove(new Player('X'), 2);

        assertFalse(board.isFull());
    }

}
