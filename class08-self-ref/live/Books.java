package class08;

import java.util.Objects;

interface ILoB {
	
}

class MTLoB implements ILoB {


	// default constructor:  
	/*public MTLoB() {
		super();
	}*/
	
	@Override
	public boolean equals(Object other) {
	    return other instanceof MTLoB;
	}

	@Override
	public int hashCode() {
	    return MTLoB.class.hashCode();
	}
}

class ConsLoB implements ILoB {
	Book first;
	ILoB rest;
	
	public ConsLoB(Book first, ILoB rest) {
		super();
		this.first = first;
		this.rest = rest;
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

class Book {
	
}


