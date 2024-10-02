import java.util.Objects;

/** to represent a list of books */
interface ILoB {

	/** produce a list of books from this list that produce
	 *  true for the given obj's check method
	 */
	ILoB select( IBookPredicate obj );
	

	/** produce a list of books from this list written by the given author */
	ILoB selectByAuthor(Author auth);
}


/** an empty list of books */
class MTLoB implements ILoB {
	MTLoB() {}

	
	public ILoB select( IBookPredicate obj ) {
		return this;
	}
	

	/** produce a list of books from this list written by the given author */
	public ILoB selectByAuthor(Author auth) {
		return this;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MTLoB;
	}

	@Override
	public int hashCode() {
		return MTLoB.class.hashCode();
	}

	@Override
	public String toString() {
		return "MTLoB []";
	}

}


/** to represent a book added to a list of books */
class ConsLoB implements ILoB {
	Book first;
	ILoB rest;

	ConsLoB(Book first, ILoB rest) {
		this.first = first;
		this.rest = rest;
	}


	// checking if something is true or false about the first book
	//   boolean check()
	
	public ILoB select( IBookPredicate obj ) {
		if ( obj.check( this.first ) ) {
			return new ConsLoB(this.first, this.rest.select(obj));
		} else {
			return this.rest.select(obj);
		}
	}
	

	/** produce a list of books from this list written by the given author */
	public ILoB selectByAuthor(Author auth) {
		if (this.first.writtenBy(auth)) {
			return new ConsLoB(this.first, this.rest.selectByAuthor(auth));
		} else {
			return this.rest.selectByAuthor(auth);
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
		ConsLoB other = (ConsLoB) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

	@Override
	public String toString() {
		return "ConsLoB [first=" + first + ", rest=" + rest + "]";
	}

}


interface IBookPredicate {
	boolean check(Book bk);
}

class AuthorPredicate implements IBookPredicate {
	
	Author auth;
	
	AuthorPredicate(Author auth) {
		this.auth = auth;
	}
	
	public boolean check(Book bk) {
		return bk.writtenBy(this.auth);
	}
}

class Under20Predicate implements IBookPredicate {
	public boolean check(Book bk) {
		return bk.salePrice() < 20;
	}
}

class IsNonFictionPredicate implements IBookPredicate {
	public boolean check(Book bk) {
		return bk.isNonFiction();
	}
}




