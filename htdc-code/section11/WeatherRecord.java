
// Examples from Section 11

// represents a record of weather events for a single day
class WeatherRecord {
	Date d;
	TempRange today;
	TempRange normal;
	TempRange record;
	double precipitation;  // in inches

	WeatherRecord(Date d, TempRange today, TempRange normal, 
			TempRange record, double precipitation) {
		this.d = d;
		this.today = today;
		this.normal = normal;
		this.record = record;
		this.precipitation = precipitation;
	}  

	/*
  public ??? wrMethod(...) {
    ... this.d                  -- Date
    ... this.today              -- TempRange
    ... this.normal             -- TempRange 
    ... this.record             -- TempRange  
    ... this.precipitation      -- int

    ... this.differential()     -- int

    ... this.d.dateMethod(...)   -- ???
    ... this.today.trMethod(...) -- ???
    ... this.normal.trMethod(...) -- ???
    ... this.record.trMethod(...) -- ???
  }
	 */

	/* ... Design a method that computes today's temperature differentials
     from a weather record. */

	// to compute today's temperature differential
	public int differential() {
		return this.today.difference();
	}

}


// represents a low-high range of temperatures
class TempRange {
	int low;
	int high;

	TempRange(int low, int high) {
		this.low = low;
		this.high = high;
	}

	/*
  public ??? trMethod(...) {
    ... this.high               -- int
    ... this.low                -- int

    ... this.difference()       -- int
  }
	 */

	// to compute the difference between high and low in the range
	public int difference() {
		return this.high - this.low;
	}
}


// represents a date
class Date {
	int day;
	int month;
	int year;

	Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/*
  ??? dateMethod(...) {
    ... this.day                -- int
    ... this.month              -- int
    ... this.year               -- int
  }
	 */
}

