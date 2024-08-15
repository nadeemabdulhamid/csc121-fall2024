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
  }
	 */

	/*
  // was this book written by the given author?
  boolean writtenBy(String author) {
    ... this.title ...            -- String
    ... this.author ...           -- String
    ... this.price ...            -- int
    ... this.kind ...             -- char
  }
	 */

	/*  
   the sale price of the book depends on the daily discounts
   these may differ depending on the kind of book
   suppose today we have the following discounts:
   there is 30% discount on fiction books
   there is 20% discount on nonfiction books
   textbooks sell at full price
	 */

	/*
  // compute the discounted sale price for this book
  int salePrice(){    
    ... this.title ...            -- String
    ... this.author ...           -- String
    ... this.price ...            -- int
    ... this.kind ...             -- char

    ... this.writtenBy(String)    -- boolean
  }
	 */

	/*
  // was this book written by the same author as the given book?
  boolean sameAuthor(Book that){
    ... this.title ...            -- String
    ... this.author ...           -- String
    ... this.price ...            -- int
    ... this.kind ...             -- char

    ... this.writtenBy(String)    -- boolean
    ... this.salePrice() ...      -- int
  }
	 */

}
