import org.junit.Before;
import org.junit.Test;
import src.Square;
import src.SquareType;

import static org.junit.Assert.*;

/**
 * This class tests the functionalities of the class Square.
 */
public class testSquare {
    private Square square;

    /**
     * Initialize the Square class which is used for the remaining tests, with the name of the square as test with squareType chance
     */
    @Before
    public void initialize(){
        square = new Square(SquareType.CHANCE, "test");
    }

    /**
     * Check if the function getSquareName() can return the correct squareName using assertEquals, which is a string "name" for the square instance.
     */
    @Test
    public void testGetSquareName() {
        assertEquals("test", square.getSquareName());
    }

    /**
     * Check if the setSquareName() function can set the square name properly, the test will check the current square name is test, then it will
     * call the setSquareName() function with the new square name "name", and then call the getSquareName() method with assertEquals to see if
     * it has changed to "name" or not
     */
    @Test
    public void testSetSquareName() {
        assertEquals("test", square.getSquareName());
        square.setSquareName("name");
        assertEquals("name", square.getSquareName());
    }

    /**
     * Check if the function getSquareType() can return the correct squareType using assertEquals, which is a enum SquareType.CHANCE for the square instance.
     */
    @Test
    public void testGetSquareType() {
        assertEquals(SquareType.CHANCE, square.getSquareType());
    }

    /**
     * Check if the SetSquareType() function can set the square type properly, the test will check the current square type is SquareType.CHANCE, then it will
     * call the setSquareType() function with the new square type SquareType.GO, and then call the getSquareType() method with assertEquals to see if
     * it has changed to type SquareType.GO or not.
     */
    @Test
    public void testSetSquareType() {
        assertEquals(SquareType.CHANCE, square.getSquareType());
        square.setSquareType(SquareType.GO);
        assertEquals(SquareType.GO, square.getSquareType());
    }
}
