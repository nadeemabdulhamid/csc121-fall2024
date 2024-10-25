# Classwork 13 - Mutation

Create an Eclipse project named `class13-mutation`.

## Authors & Books

- Add these class definitions to your project:

```
/** Represents authors of books */
class Author {
	String name;
	int yob;
	Book book;
		
}


/** Represent books */
class Book {
	String title;
	int price;
	int quantity;
	Author author;
	
}
```

1. Add constructors using Eclipse.

2. Create a tests/examples class.

    Define examples of an author (`Author knuth = ...`) and book (`Book taocp  = ...`) based on this:

    > Donald E. Knuth, born in 1938.
    *The Art of Computer Programming (volume 1).* (Addison Wesley, Reading, Massachusetts.  1968.) $100, we have 2 copies in stock.

    What happens?
    
3. Add another example. Eva Tardos (*EH-vah TAR-dohsh*, born in 1957. *Algorithm Design*. $150, 3 copies.

4. Define methods `sameAuthor(Author that)` and `sameBook(Book that)` in `Author` and `Book`, respectively. Make another pair of definitions, `knuth1` and `taocp1` to test the methods.

    What happens? e.g.:

    ```
    assertEquals(true, taocp.sameBook(taocp1));
    assertEquals(true, knuth.sameAuthor(knuth1));
    assertEquals(false, tardos.sameAuthor(knuth1));
    ```
    * Shortcut: can use `assertTrue( <test-exp> )` instead of `assertEquals( true, <test-exp> )`.

5. Generate the normal `equals()` method using Eclipse. How does that work with cyclic data? Let's go over exactly how Eclipse's definitions of `equals()` work. Fix it.

---

## Non-determinism

Add this class to your project:

```
class Counter {
    int val;
    
    Counter(int initialVal) {
        this.val = initialVal;
    }
    
    int get() {
        int ans = this.val;
        this.val = this.val + 1;
        return ans;
    }
}
```

And also a couple of examples and tests...

```
package step1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CounterTest {
    Counter c1 = new Counter();
    Counter c2 = new Counter(2);

	@Test
	public void testOne() {
	    assertEquals(_, c1.get());
	    assertEquals(_, c1.get());
	    assertEquals(_, c1.get());
	    assertEquals(_, c1.get());
	}
	
}
```

6. Fill in the expected results above. Is `c1.get()` deterministic?

7. How about these?

```
    @Test
    void testTwo() {
        // What should these tests be?
        assertEquals(_, c1.get());                      // Test 1
        assertEquals(_, c2.get());                      // Test 2
        assertEquals(_, c1.get() == c1.get());          // Test 3
        assertEquals(_, c2.get() == c1.get());          // Test 4
        assertEquals(_, c2.get() == c1.get());          // Test 5
        assertEquals(_, c1.get() == c1.get());          // Test 6
        assertEquals(_, c2.get() == c1.get());          // Test 7
    }
```

---

## Keeping mutation contained

8. It's kind of messy to have to provide a `null` argument to the `Author` constructor. Modify the constructor so it does not take a `Book` parameter. It should set the `book` field to `null`.

9. Define an `updateBook(Book bk)` method in `Author` that assigns the author's book to the given one.

    What does/should the method return?

### `void`

> All we want it to do is to have the side effect of modifying the `Author` — we don’t really want a return value at all! To accommodate this situation, Java defines a new keyword, `void`, which can be used to indicate that a method does not return any value. This type tells the reader of the code that the method’s purpose must be solely to have side effects — after all, if a method had no side effects and returned no value, of what use would it be?

10. When we design methods with side effects, we need to change how we phrase our purpose statements. Instead of saying what the method computes as a *result*, we should specify what the method’s side effects are.

11. Now, modify the `Book` constructor so that it uses `updateBook` to update the author of the book, *when the book itself is being initialized*.

12. Rewrite our examples -- this should all look a lot cleaner.

    ```
        Author knuth = new Author("Donald Knuth", 1938);
        Book taocp1 = new Book("The Art of Computer Programming (volume 1)", 100, 2, knuth);
        
        Author tardos = new Author("Eva Tardos", 1957);
        Book ad = new Book("Algorithm Design", 150, 3, this.tardos);

        @Test
        public void testConstructors() {
            assertEquals( this.taocp1,  this.taocp1.author.book );
            assertEquals( this.knuth,   this.knuth.book.author );
            
            assertEquals( this.ad,  this.ad.author.book );
            assertEquals( this.tardos,   this.wings.book.tardos );
        }
    }   
    ```

--- 
## Mutation with lists

Add the following files to your project:

- [ILoX.java](../code/ILoX.java)
- [BooksTest2.java](../code/BooksTest2.java)

Then:

13. Modify authors to have an `ILoX<Book>` of books. 

14. Modify the `addBook` method so that it passes the tests in `BooksTest2.java`. If the author of the book being added doesn't match `this` author, it should throw an exception. If the book is already in `this` author's list, it should not be added. 


