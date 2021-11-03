import org.junit.Before;
import org.junit.Test;
import src.OtherSquare;
import src.Square;
import src.SquareType;

import static org.junit.Assert.*;

/**
 * This class tests the functionalities of the class OtherSquare.
 */
public class testOtherSquare {
    OtherSquare otherSquare;

    /**
     * Initialize the OtherSquare class which is used for the remaining tests, with the name of the otherSquare as test with squareType chance
     */
    @Before
    public void initialize(){
        otherSquare = new OtherSquare(SquareType.CHANCE, "test");
    }

    /**
     * Check if the function getSquareName() can return the correct squareName using assertEquals, which is a string "test" for the otherSquare instance.
     */
    @Test
    public void testGetSquareName() {
        assertEquals("test", otherSquare.getSquareName());
    }

    /**
     * Check if the setSquareName() function can set the square name properly, the test will check the current square name is test, then it will
     * call the setSquareName() function with the new square name "name", and then call the getSquareName() method with assertEquals to see if
     * it has changed to "name" or not
     */
    @Test
    public void testSetSquareName() {
        assertEquals("test", otherSquare.getSquareName());
        otherSquare.setSquareName("name");
        assertEquals("name", otherSquare.getSquareName());
    }

    /**
     * Check if the function getSquareType() can return the correct squareType using assertEquals, which is a enum SquareType.CHANCE for the square instance.
     */
    @Test
    public void testGetSquareType() {
        assertEquals(SquareType.CHANCE, otherSquare.getSquareType());
    }

    /**
     * Check if the SetSquareType() function can set the square type properly, the test will check the current square type is SquareType.CHANCE, then it will
     * call the setSquareType() function with the new square type SquareType.GO, and then call the getSquareType() method with assertEquals to see if
     * it has changed to type SquareType.GO or not.
     */
    @Test
    public void testSetSquareType() {
        assertEquals(SquareType.CHANCE, otherSquare.getSquareType());
        otherSquare.setSquareType(SquareType.GO);
        assertEquals(SquareType.GO, otherSquare.getSquareType());
    }

    /**
     * Check if the Property are properly polymorphic, whether it can change into super class Square, and change back into Property class, the test will
     * first cast the property instance of class Property into class Square, then check if the casted instance is still of class Property, then the test
     * will case the instance back to class Property, and check if the casted instance is still of class Property.
     */
    @Test
    public void testPolymorphism() {
        Square square = (Square) otherSquare;
        assertEquals(square.getSquareName(),"test");
        otherSquare = (OtherSquare) square;
        assertEquals(otherSquare.getSquareName(),"test");
    }
}
