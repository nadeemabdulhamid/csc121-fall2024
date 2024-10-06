import java.util.Objects;


interface IAuthorComparator {
	/* produces a negative # if author a is "less than" author b according to some
	 * 						criteria
	 * produces 0 (zero) if the authors are the same according to some characteristic
	 * produces a positive # if author a is "greater than" b according to some characteristic
	 */
	int compare(Author a, Author b);
}

class YoBComparator implements IAuthorComparator {
	public int compare(Author a, Author b) {
		return a.yob - b.yob;
	}
}




/** to represent a list of authors */
interface ILoA {
	
	/** produce the author with the minimum value based on some
	 * comparison characteristic
	 */
	public Author min( IAuthorComparator m );   // <---- earliestYoB() and shortestName()
	public Author minSoFar(IAuthorComparator m, Author minSoFarCandidate );
	

	
	/** produce the author with the shortest name in this list */
	public Author shortestName();

	/** produce the author with the shortest name between this list 
    	and the given shortestSoFar */
	public Author shortestNameSoFar(Author shortestSoFar);
}


/** an empty list of authors */
class MTLoA implements ILoA {
	MTLoA() {}
	
	/** produce the author with the minimum value based on some
	 * comparison characteristic in this list
	 */
	public Author min( IAuthorComparator m ) {
		throw new RuntimeException("no authors in the list");
	}
	
	
	public Author minSoFar( IAuthorComparator m, Author minSoFarCandidate ) {
		return minSoFarCandidate;
	}

	
	
	/** produce the author with the shortest name in this list */
	public Author shortestName() {
		throw new RuntimeException("no authors in the list");		
	}

	/** produce the author with the shortest name between this list 
		and the given shortestSoFar */
	public Author shortestNameSoFar(Author shortestSoFar) {
		return shortestSoFar;
	}



	@Override
	public boolean equals(Object other) {
		return other instanceof MTLoA;
	}

	@Override
	public int hashCode() {
		return MTLoA.class.hashCode();
	}

	@Override
	public String toString() {
		return "MTLoA []";
	}
}


/** to represent an author added to a list of authors */
class ConsLoA implements ILoA {
	Author first;
	ILoA rest;

	ConsLoA(Author first, ILoA rest) {
		this.first = first;
		this.rest = rest;
	}
	
	/** produce the author with the minimum value based on some
	 * comparison characteristic in this list
	 */
	public Author min( IAuthorComparator m ) {
		return this.rest.minSoFar(m, this.first);
	}
	
	
	/** produce the author with the shortest name in this list */
	public Author shortestName() {
		return this.rest.shortestNameSoFar(this.first);
	}
	
	
	
	public Author minSoFar( IAuthorComparator m,       Author minSoFarCandidate ) {
		if (m.compare( this.first, minSoFarCandidate ) < 0) {
				// this.first......... < minSoFarCandidate..........) {
			return this.rest.minSoFar(m, this.first);
		} else {
			return this.rest.minSoFar(m, minSoFarCandidate);
		}
		
	}
	


	/** produce the author with the shortest name between this list 
		and the given shortestSoFar */
	public Author shortestNameSoFar(Author shortestSoFar) {
		if (this.first.name.length() < shortestSoFar.name.length()) {
			return this.rest.shortestNameSoFar(this.first);
		} else {
			return this.rest.shortestNameSoFar(shortestSoFar);
		}
	}

	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoA other = (ConsLoA) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

	@Override
	public String toString() {
		return "ConsLoA [first=" + first + ", rest=" + rest + "]";
	}
}