import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BookTest {
	  Book oms = new Book("Old Man and the Sea", "EH", 10, 'F');
	  Book eos = new Book("Elements of Style", "EBW", 20, 'N');
	  Book htdp = new Book("HtDP", "MF", 60, 'T');
	  Book ll = new Book("LL", "MF", 20, 'N');
	  
	  @Test
	  void testWrittenBy() {
	    assertEquals(true, this.oms.writtenBy("EH"));
	    assertEquals(false, this.oms.writtenBy("MF"));
	    assertEquals(false, this.htdp.writtenBy("SK"));
	  }
	  
	  @Test
	  void testSalePrice() {
	    assertEquals(7, this.oms.salePrice());
	    assertEquals(16, this.eos.salePrice());
	    assertEquals(60, this.htdp.salePrice());
	  }
	  
	  @Test
	  void testSameAuthor() {
	    assertEquals(false, this.oms.sameAuthor(this.eos));
	    assertEquals(false, this.eos.sameAuthor(this.ll));
	    assertEquals(true, this.htdp.sameAuthor(this.ll));
	  }
}
