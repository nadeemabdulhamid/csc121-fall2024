package class08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTests {

	Book b1 = new Book();
	Book b2 = new Book();
	Book b3 = new Book();
	
	
	ILoB mtlob = new MTLoB();
	ILoB list1 = new ConsLoB( b2, mtlob );
	//ILoB list1 = new ConsLoB( b2, new MTLoB() );
	
	
	//ILoB list2 = new ConsLoB( b1, new ConsLoB( b2, mtlob ) );
	ILoB list2 = new ConsLoB( b1, list1 );
			// [ b1, b2 ]
	
	ILoB list3 = new ConsLoB( b3, list2 );
			// [ b3, b1, b2 ]
	
	
	
	@Test
	void test() {
		assertEquals( mtlob,    new MTLoB() );
		assertEquals( list1,   list2 );
	}

}
