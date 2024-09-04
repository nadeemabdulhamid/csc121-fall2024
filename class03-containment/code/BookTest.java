import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BookTest {
    Author eh = new Author("Hemingway", 1900);
    Author ebw = new Author("White", 1920);
    Author mf = new Author("MF", 1970);

    Book oms = new Book("Old Man and the Sea", eh, 10, 'F');
    Book eos = new Book("Elements of Style", ebw, 20, 'N');
    Book htdp = new Book("HtDP", mf, 60, 'T');

    // test the method writtenBy in the class Book
    @Test
    public void testWrittenBy() {
        assertEquals(true, oms.writtenBy("Hemingway"));
        assertEquals(false, eos.writtenBy("Hemingway"));
        assertEquals(false, htdp.writtenBy("White"));
    }

    // test the method sameName in the class Author
    @Test
    public void testSameName() {
        assertEquals(true, eh.sameName("Hemingway"));
        assertEquals(false, ebw.sameName("Hemingway")); 
        assertEquals(true, mf.sameName("MF"));
    }

    // test the method olderAuthor in the class Book
    @Test
    public void testOlderAuthor() {
        assertEquals(true, oms.olderAuthor(this.htdp));
        assertEquals(false, htdp.olderAuthor(this.oms));
        assertEquals(false, eos.olderAuthor(this.oms));
    }

    // test the method bornBefore in the class Author
    @Test
    public void testBornBefore() {
        assertEquals(true, eh.bornBefore(this.mf));
        assertEquals(false, ebw.bornBefore(this.eh));
        assertEquals(false, mf.bornBefore(this.eh));  
    }
}
