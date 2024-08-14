import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {
	
/*
;; Examples of books
(define oms (make-book "Old Man and the Sea" "EH" 10 'F))
(define eos (make-book "Elements of Style" "EBW" 20 'N))
(define htdp (make-book "HtDP" "MF" 60 'T))
 */
	
	Book oms = new Book("Old Man and Sea", "EH", 10, 'F');
	Book eos = new Book("Elements of Style", "EBW", 20, 'N');
	Book htdp = new Book("HtDP", "MF", 60, 'T');

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
