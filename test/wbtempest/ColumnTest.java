package wbtempest;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTest {

    @Test
    public void getFrontPoint1_X() {
        Column col = new Column(1,2,3,4);
        int[] points = col.getFrontPoint1();
        assertEquals(points[0],1);
    }

    @Test
    public void getFrontPoint1_Y() {
        Column col = new Column(1,2,3,4);
        int[] points = col.getFrontPoint1();
        assertEquals(points[1],2);
    }

    @Test
    public void getFrontPoint2_X() {
        Column col = new Column(1,2,3,4);
        int[] points = col.getFrontPoint1();
        assertEquals(points[0],3);
    }

    @Test
    public void getFrontPoint2_Y() {
        Column col = new Column(1,2,3,4);
        int[] points = col.getFrontPoint1();
        assertEquals(points[1],4);
    }
}