package step2;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BooksTest2 {

	Author knuth = new Author("Donald", "Knuth", 1938);
	Book taocp1 =
			new Book("The Art of Computer Programming (volume 1)", 100, 2, knuth);
	Book taocp2 =
			new Book("The Art of Computer Programming (volume 2)", 129, 3, knuth);
	
	Author wings = new Author("J", "W", 1975);
	Book bk2 =
		    new Book("Comp Think", 120, 3, this.wings);

	@Test
	public void testAuths() {
		assertEquals( true,  this.knuth.books.contains(this.taocp1) );
		assertEquals( true,  this.knuth.books.contains(this.taocp2) );
		assertEquals( false,  this.knuth.books.contains(this.bk2) );
		
		assertEquals( true,  this.taocp1.author.books.contains(this.taocp1) );
		assertEquals( true,  this.taocp1.author.books.contains(this.taocp2) );
		assertEquals( true,  this.taocp2.author.books.contains(this.taocp2) );
		assertEquals( false,  this.taocp1.author.books.contains(this.bk2) );
		
		assertEquals( 2, this.knuth.books.length() );
		this.knuth.addBook(taocp1);
		assertEquals( 2, this.knuth.books.length() );
		
		assertEquals( 1, this.wings.books.length() );
		assertThrows(RuntimeException.class, () -> this.wings.addBook(taocp2));
		assertEquals( 1, this.wings.books.length() );

	}


}
