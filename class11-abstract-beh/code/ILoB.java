import java.util.Objects;

/** to represent a list of books */
interface ILoB {

	/** produce a list of only the non-fiction books from this list */
	ILoB selectNonfiction();

	/** produce a list of books from this list whose sale price is less than $20 */
	ILoB selectUnder20();

	/** produce a list of books from this list written by the given author */
	ILoB selectByAuthor(Author auth);
}


/** an empty list of books */
class MTLoB implements ILoB {
	MTLoB() {}

	/** produce a list of only the non-fiction books from this list */
	public ILoB selectNonfiction() {
		return this;
	}

	/** produce a list of books from this list whose sale price is less than $20 */
	public ILoB selectUnder20() {
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

	/** produce a list of only the non-fiction books from this list */
	public ILoB selectNonfiction() {
		if (this.first.isNonFiction()) {
			return new ConsLoB(this.first, this.rest.selectNonfiction());
		} else {
			return this.rest.selectNonfiction();
		}
	}

	/** produce a list of books from this list whose sale price is less than $20 */
	public ILoB selectUnder20() {
		if (this.first.isUnder20()) {
			return new ConsLoB(this.first, this.rest.selectUnder20());
		} else {
			return this.rest.selectUnder20();
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



