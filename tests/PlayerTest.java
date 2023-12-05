import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
        Player player = new Player('X');
        assertEquals('X', player.getSymbol());
	}

}
