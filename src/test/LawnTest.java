package test;

import entity.Lawn;
import org.junit.Test;
import static org.junit.Assert.*;

public class LawnTest {

    @Test
    public void testGetMaxX() {
        Lawn lawn = new Lawn(5, 7);
        assertEquals(5, lawn.getMaxX());
    }

    @Test
    public void testGetMaxY() {
        Lawn lawn = new Lawn(5, 7);
        assertEquals(7, lawn.getMaxY());
    }
}

