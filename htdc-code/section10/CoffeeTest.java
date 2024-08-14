import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffeeTest {

	// collect examples of coffee sales

	Coffee kona = new Coffee("Kona", 2095, 100);
	Coffee ethi = new Coffee("Ethiopian", 800, 1000);
	Coffee colo = new Coffee("Columbian", 950, 20);

	// test the cost method in the Coffee class
	@Test
	void testCost() {
		assertEquals(209500, this.kona.cost());
		assertEquals(800000, this.ethi.cost());
		assertEquals(19000, this.colo.cost());
	} 

	// test the moreCents method in the Coffee class
	@Test
	void testMoreCents() {
		assertEquals(false, this.kona.moreCents(3000));
		assertEquals(true, this.kona.moreCents(1000));
	}

	// test the lighterThan method in the Coffee class
	@Test
	void testLighterThan() {
		assertEquals(true, this.kona.lighterThan(this.ethi));
		assertEquals(false, this.ethi.lighterThan(this.colo));
		assertEquals(false, this.ethi.lighterThan(this.kona));
		assertEquals(false, this.colo.lighterThan(this.colo));
	}
}
