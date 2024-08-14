import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StarTest {
	Star s = new Star(10);
	Star t = new Star(100);

	@Test
	void testDrop() {
		assertEquals("[20, 15: 5]", this.s.drop().toString());
		assertEquals("[20, 100: 5]", this.t.drop().toString());
		assertEquals("[20, 100: 5]", new Star(98).drop().toString());
	}
}
