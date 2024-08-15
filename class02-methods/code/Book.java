// Simple methods for Book


/*
 +---------------------------+
 | Book                      |
 +---------------------------+
 | String title              |
 | String author             |
 | int price                 |
 | char kind                 |
 +---------------------------+
 | boolean writtenBy(String) |
 | int salePrice()           |
 | boolean sameAuthor(Book)  |
 +---------------------------+  
 */

/** Represents a book in a bookstore */
class Book {
	String title;
	String author;
	int price;
	char kind;

	Book(String title, String author, int price, char kind){
		this.title = title;
		this.author = author;
		this.price = price;
		this.kind = kind;    
	}

	/* TEMPLATE:
  ??? bookMethod(...) {
    ... this.title ...            -- String
    ... this.author ...           -- String
    ... this.price ...            -- int
    ... this.kind ...             -- char

    ... this.writtenBy(String)    -- boolean
    ... this.salePrice() ...      -- int
    ... this.sameAuthor(Book) ... -- boolean  
  }
	 */

	/** was this book written by the given author? */
	boolean writtenBy(String author) {
		return this.author.equals(author);
	}

	/** compute the discounted sale price for this book. 
   the sale price of the book depends on the daily discounts
   these may differ depending on the kind of book
   suppose today we have the following discounts:
   there is 30% discount on fiction books
   there is 20% discount on nonfiction books
   textbooks sell at full price
	 */
	int salePrice(){    
		if (this.kind == 'F') {
			return this.price - 3 * (this.price / 10);
		} else  if (this.kind == 'N') {
			return this.price - 2 * (this.price / 10);
		} else {
			return this.price;
		}
	}

	/** was this book written by the same author as the given book? */
	boolean sameAuthor(Book that){
		return this.author.equals(that.author);
	}

}
