
/** represent a falling star on a 100 x 100 canvas */
class Star {
	int x = 20;
	int y;
	int DELTA = 5;

	Star(int y) {
		this.y = y;
	}

	/* TEMPLATE:
  ??? starMethod(...) {
    ... this.x ...             -- int
    ... this.y ...             -- int
    ... this.DELTA ...         -- int

    ... this.drop() ...        -- Star
  }
	 */

	/** drop this Star by DELTA pixels, unless it is on
      (or close to) the ground */
	Star drop() {
		if (this.y + this.DELTA >= 100) {
			return new Star(100);
		} else {
			return new Star(this.y + this.DELTA);
		}
	}
	
	/** produce a string representing this star */
	public String toString() {
		return "[" + x + ", " + y + ": " + DELTA + "]";
	}

}
