import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WeatherRecordTest {
	  Date d1 = new Date(2, 9, 1959);
	  Date d2 = new Date(8, 8, 2004);
	  Date d3 = new Date(12, 12, 1999);
	  
	  TempRange tr1 = new TempRange(66, 88);
	  TempRange tr2 = new TempRange(70, 99);
	  TempRange tr3 = new TempRange(28, 31);
	  
	  WeatherRecord r1 = new WeatherRecord(d1, tr1, tr2, tr3, 0);
	  WeatherRecord r2 = new WeatherRecord(d2, tr2, tr3, tr1, 10);
	  WeatherRecord r3 = new WeatherRecord(d3, tr3, tr1, tr2, 9);

	  @Test
	  void testDifferential() {
	    assertEquals(22, r1.differential());
	    assertEquals(29, r2.differential());
	    assertEquals(3, r3.differential());
	  }
	  
	  @Test
	  void testDifference() {
	    assertEquals(22, tr1.difference());
	    assertEquals(29, tr2.difference());
	    assertEquals(3, tr3.difference());
	  }

}
