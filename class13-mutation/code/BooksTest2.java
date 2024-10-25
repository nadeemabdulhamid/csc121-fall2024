
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BooksTest2 {

	Author knuth = new Author("Donald", "Knuth", 1938);
	Book taocp1 =
			new Book("The Art of Computer Programming (volume 1)", 100, 2, knuth);
	Book taocp2 =
			new Book("The Art of Computer Programming (volume 2)", 129, 3, knuth);
	
	Author tardos = new Author("Eva", "Tardos", 1975);
	Book algs =
		    new Book("Algorithm Design", 120, 3, this.tardos);

	@Test
	public void testAuths() {
		assertEquals( true,  this.knuth.books.contains(this.taocp1) );
		assertEquals( true,  this.knuth.books.contains(this.taocp2) );
		assertEquals( false,  this.knuth.books.contains(this.algs) );
		
		assertEquals( true,  this.taocp1.author.books.contains(this.taocp1) );
		assertEquals( true,  this.taocp1.author.books.contains(this.taocp2) );
		assertEquals( true,  this.taocp2.author.books.contains(this.taocp2) );
		assertEquals( false,  this.taocp1.author.books.contains(this.algs) );
		
		assertEquals( 2, this.knuth.books.length() );
		this.knuth.addBook(taocp1);
		assertEquals( 2, this.knuth.books.length() );
		
		assertEquals( 1, this.tardos.books.length() );
		assertThrows(RuntimeException.class, () -> this.tardos.addBook(taocp2));
		assertEquals( 1, this.tardos.books.length() );

	}


}
