package test;

import entity.Lawn;
import entity.Mower;
import org.junit.Test;
import static org.junit.Assert.*;

public class MowerTest {

    @Test
    public void testExecuteInstructions() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'N');
        mower.executeInstructions("GAGAGAGAA", lawn);
        assertEquals("1 3 N", mower.getPosition());
    }

    @Test
    public void testRotateLeft() {
        Mower mower = new Mower(1, 2, 'N');
        mower.rotateLeft();
        assertEquals('W', mower.getOrientation());
    }

    @Test
    public void testRotateRight() {
        Mower mower = new Mower(1, 2, 'N');
        mower.rotateRight();
        assertEquals('E', mower.getOrientation());
    }

    @Test
    public void testMoveForwardNorth() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'N');
        mower.moveForward(lawn);
        assertEquals("1 3 N", mower.getPosition());
    }

    @Test
    public void testMoveForwardEast() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'E');
        mower.moveForward(lawn);
        assertEquals("2 2 E", mower.getPosition());
    }

    @Test
    public void testMoveForwardSouth() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'S');
        mower.moveForward(lawn);
        assertEquals("1 1 S", mower.getPosition());
    }

    @Test
    public void testMoveForwardWest() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'W');
        mower.moveForward(lawn);
        assertEquals("0 2 W", mower.getPosition());
    }

    @Test
    public void testGetPosition() {
        Mower mower = new Mower(3, 4, 'S');
        assertEquals("3 4 S", mower.getPosition());
    }
}
