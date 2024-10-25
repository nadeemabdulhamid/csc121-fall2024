
import java.util.Objects;

/** represents a list of things of the 'same' type */
public interface ILoX<T> {

	/** produces a list with only those items from this list
	 	that satisfy the given predicate */
	ILoX<T> select(IPredicate<T> pred);

	/** produces the length of this list */
	int length();
	
	/** does this list contain the given item */
	boolean contains(T item);

}


interface IPredicate <T> {
    boolean satisfiedBy(T a);
}


/** represents an empty
 * list of anything */
class MT<T> implements ILoX<T> {

	public ILoX<T> select(IPredicate<T> pred) {
		return this;
	}
	
	public int length() {
		return 0;
	}
	
	public boolean contains(T item) {
		return false;
	}

	@Override
	public boolean equals(Object other) {
		return this.getClass() == other.getClass();
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

	@Override
	public String toString() {
		return "MT []";
	}

}


/** to represent a list
 * with something added to it */
class Cons<T> implements ILoX<T> {
	T first;
	ILoX<T> rest;

	Cons(T first, ILoX<T> rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public ILoX<T> select(IPredicate<T> pred) {
		if (pred.satisfiedBy(this.first)) {
			return new Cons<T>(this.first, this.rest.select(pred));
		} else {
			return this.rest.select(pred);
		}
	}
	
	public int length() {
		return 1 + this.rest.length();
	}
	
	public boolean contains(T item) {
		return this.first.equals(item) || this.rest.contains(item);
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
		Cons<T> other = (Cons) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

	@Override
	public String toString() {
		return "Cons [first=" + first + ", rest=" + rest + "]";
	}

}




