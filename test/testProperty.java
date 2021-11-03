import org.junit.Before;
import org.junit.Test;
import src.Property;
import src.Square;
import src.SquareType;

import static org.junit.Assert.*;

/**
 * This class tests the functionalities of the class Property.
 */
public class testProperty {
    Property property;

    /**
     * Initialize the Property class which is used for the remaining tests, with the name of the property as "test", with type SquareType.PROPERTY,
     * property price of 500 and rent of 50
     */
    @Before
    public void initialize(){
        property = new Property(SquareType.PROPERTY, "test", 500, 50);
    }

    /**
     * Check if the function getPrice() can return the correct property price using assertEquals, which is an integer of 500 for the property instance.
     */
    @Test
    public void testGetPrice() {
        assertEquals(500, property.getPrice());
    }

    /**
     * Check if the setPrice() function can set the property price properly, the test will check the current property price is 500, then it will
     * call the setPrice() function with the new property price 1000, and then call the getPrice() method with assertEquals to see if
     * it has changed to 1000 or not
     */
    @Test
    public void testSetPrice() {
        assertEquals(500, property.getPrice());
        property.setPrice(1000);
        assertEquals(1000, property.getPrice());
    }

    /**
     * Check if the function getRent() can return the correct property rent using assertEquals, which is an integer of 50 for the property instance.
     */
    @Test
    public void testGetRent() {
        assertEquals(50, property.getRent());
    }

    /**
     * Check if the setRent() function can set the property rent properly, the test will check the current property rent is 50, then it will
     * call the setRent() function with the new property price 100, and then call the getRent() method with assertEquals to see if
     * it has changed to 100 or not
     */
    @Test
    public void testSetRent() {
        System.out.println(property.getPrice());
        assertEquals(50, property.getRent());
        property.setRent(100);
        assertEquals(100, property.getRent());
    }

    /**
     * Check if the function getSquareName() can return the correct squareName using assertEquals, which is a string "test" for the property instance.
     */
    @Test
    public void testGetSquareName() {
        assertEquals("test", property.getSquareName());
    }

    /**
     * Check if the setSquareName() function can set the square name properly, the test will check the current square name is "test", then it will
     * call the setSquareName() function with the new square name "name", and then call the getSquareName() method with assertEquals to see if
     * it has changed to "name" or not
     */
    @Test
    public void testSetSquareName() {
        assertEquals("test", property.getSquareName());
        property.setSquareName("name");
        assertEquals("name", property.getSquareName());
    }

    /**
     * Check if the function getSquareType() can return the correct squareType using assertEquals, which is a enum SquareType.PROPERTY for the property instance.
     */
    @Test
    public void testGetSquareType() {
        assertEquals(SquareType.PROPERTY, property.getSquareType());
    }

    /**
     * Check if the SetSquareType() function can set the square type properly, the test will check the current square type is SquareType.PROPERTY, then it will
     * call the setSquareType() function with the new square type SquareType.GO, and then call the getSquareType() method with assertEquals to see if
     * it has changed to type SquareType.GO or not.
     */
    @Test
    public void testSetSquareType() {
        assertEquals(SquareType.PROPERTY, property.getSquareType());
        property.setSquareType(SquareType.GO);
        assertEquals(SquareType.GO, property.getSquareType());
    }

    /**
     * Check if the function isOwned() can return whether the property is owned or not using assertFalse, which is an the default of false for the property instance.
     */
    @Test
    public void testIsOwned() {
        assertFalse(property.isOwned());
    }

    /**
     * Check if the setOwned() function can set the property owned status properly, the test will check the current property is not owned with assertFalse, then it will
     * call the setOwned() function with property owned true, and then call the getRent() method with asserTrue to see if
     * it has changed to true or not
     */
    @Test
    public void testSetOwned() {
        assertFalse(property.isOwned());
        property.setOwned(true);
        assertTrue(property.isOwned());
    }

    /**
     * Check if the function getOwner() can return the owner of the property, which is null by default for the property instance.
     */
    @Test
    public void testGetOwner() {
        assertEquals(null, property.getOwner());
    }

    /**
     * Check if the setOwner() function can set the owner of the property properly, the test will check the current property owner is null, then it will
     * call the setOwned() function with property owner "testUser", and then call the getOwner() method with asserEquals to see if it has changed to "testUser" or not,
     * the process will be repeated once more, with null instead, to check if the owner can be set to null.
     */
    @Test
    public void testSetOwner() {
        assertEquals(null, property.getOwner());
        property.setOwner("testUser");
        assertEquals("testUser", property.getOwner());
        property.setOwner(null);
        assertEquals(null, property.getOwner());
    }

    /**
     * Check if the Property are properly polymorphic, whether it can change into super class Square, and change back into Property class, the test will
     * first cast the property instance of class Property into class Square, then check if the casted instance is still of class Property, then the test
     * will case the instance back to class Property, and check if the casted instance is still of class Property.
     */
    @Test
    public void testPolymorphism() {
        Square square = property;
        assertEquals(Property.class.getName(), square.getClass().getName());
        property = (Property) square;
        assertEquals(Property.class.getName(), property.getClass().getName());
    }
}
