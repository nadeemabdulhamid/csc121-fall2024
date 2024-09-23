import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IShapeTest {

    IShape dot = new Dot(new CartPt(4, 3));
    IShape squ = new Square(new CartPt(4, 3), 3);
    IShape cir = new Circle(new CartPt(12, 5), 2);

    @Test
    public void testArea() {
        assertEquals(0.0, this.dot.area(), 0.01);
        assertEquals(9.0, this.squ.area(), 0.01);
        assertEquals(12.56, this.cir.area(), 0.01);
    }

    @Test
    public void testLargerThan() {
        assertEquals(false, this.dot.largerThan(this.squ));
        assertEquals(true, this.squ.largerThan(this.dot));
        assertEquals(false, this.squ.largerThan(this.cir));
        assertEquals(true, this.cir.largerThan(this.squ));
    }

    @Test
    public void testDistTo0() {
        assertEquals(5.0, new CartPt(4, 3).distTo0(), 0.01);
        assertEquals(13.0, new CartPt(12, 5).distTo0(), 0.01);

        assertEquals(5.0, this.dot.distTo0(), 0.01);
        assertEquals(5.0, this.squ.distTo0(), 0.01);
        assertEquals(11.0, this.cir.distTo0(), 0.01);
    }
}
