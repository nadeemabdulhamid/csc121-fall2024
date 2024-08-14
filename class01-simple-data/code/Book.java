
/** Represents a book in a bookstore */
class Book {
	String title;
	String author;
	int price;      // in whole dollars
	char kind;		// 'F'iction, 'N'onfiction, or 'T'extbook

	Book(String title, String author, int price, char kind) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.kind = kind;
	}
}


/*

;; A Book is (make-book String String Num Symbol)		<----- types comment
;; Represents a book for sale in our bookstore			<----- interpretation
;; There are three kinds of books: fiction, nonfiction, or
;;                                 textbook, represented by symbols 'F 'N 'T
(define-struct book (title author price kind))			<----- structure defn

;; Examples of books
(define oms (make-book "Old Man and the Sea" "EH" 10 'F)) <---- examples ("instances")
(define eos (make-book "Elements of Style" "EBW" 20 'N))
(define htdp (make-book "HtDP" "MF" 60 'T))

 */