
/*
 +-----------------------------+
 | Coffee                      |
 +-----------------------------+
 | String kind                 |
 | int price                   |
 | int weight                  |
 +-----------------------------+  
 | int cost()                  |
 | boolean moreCents(int)      |
 | boolean lighterThan(Coffee) |
 +-----------------------------+  
 */


//-------------------------------------------------------------------------
/** Represents a coffee sale; at which price, how much coffee was sold */
class Coffee {
	String kind;
	int price;   // in cents per pound
	int weight;  // in pounds

	Coffee(String kind, int price, int weight) {
		this.kind = kind;
		this.price = price;
		this.weight = weight;
	}

	/* TEMPLATE:
	  /** purpose * /
	  ??? coffeeMethod(...) {
	    ... this.kind ...            -- String
	    ... this.price ...           -- int
	    ... this.weight ...          -- int
	
	    ... this.cost()              -- int
	    ... this.moreCents(int)      -- boolean
	    ... this.lighterThan(Coffee) -- boolean
	  }
	 */

	/** computes the total cost of this coffee purchase */
	int cost() {
		return this.price * this.weight;
	}

	/** determines whether this coffee's price is more than amt */
	boolean moreCents(int amt) {
		return this.price > amt;
	}

	/** determines whether this coffee sale involves 
   	  less weight than that coffee sale */
	boolean lighterThan(Coffee that) {
		return this.weight < that.weight;
	}
}

