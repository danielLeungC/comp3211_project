import org.junit.Before;
import org.junit.Test;
import src.Player;
import src.Property;
import src.SquareType;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class tests the functionalities of the class Player.
 */
public class testPlayer {
    Player player;
    Property property1, property2;

    /**
     * Initialize the Properties and Player instance which is used for the remaining tests, 2 properties are used, both property are of type SquareType.PROPERTY,
     * with the first property having name "test", price 100 and rent 10, and the second property having name "name", price 200 and rent 20 respectively,
     * the player class with name "playerTest are also instantiated.
     */
    @Before
    public void initialize() {
        player = new Player("playerTest");
        property1 = new Property(SquareType.PROPERTY, "test", 100, 10);
        property2 = new Property(SquareType.PROPERTY, "name", 200, 20);
    }

    /**
     * Check if the function getPlayerName() can return the correct playerName using assertEquals, which is a string "playerTest" for the Player instance.
     */
    @Test
    public void testGetPlayerName(){
        assertEquals("playerTest", player.getPlayerName());
    }

    /**
     * Check if the function getBalance() can return the correct player balance using assertEquals, which is an integer 1500 as the default value for the Player instance.
     */
    @Test
    public void testGetBalance(){
        assertEquals(1500, player.getBalance());
    }

    /**
     * Check if the setBalance() function can set the player balance properly, the test will check the current player balance is 1500, then it will
     * call the setBalance() function with the new balance 100, and then call the getBalance() method with assertEquals to see if
     * it has changed to 100 or not
     */
    @Test
    public void testSetBalance(){
        assertEquals(1500, player.getBalance());
        player.setBalance(100);
        assertEquals(100, player.getBalance());
    }

    /**
     * Check if the function getStatus() can return the correct player status using assertEquals, which is an "normal" as the default value for the Player instance.
     */
    @Test
    public void testGetStatus(){
        assertEquals("normal", player.getStatus());
    }

    /**
     * Check if the setStatus() function can set the player status properly, the test will check the current player status, then it will
     * call the setStatus() function with the new status "test", and then call the getStatus() method with assertEquals to see if
     * it has changed to "test" or not, this test is repeated with the value to null to see if the value can be set to null.
     */
    @Test
    public void testSetStatus(){
        assertEquals("normal", player.getStatus());
        player.setStatus("test");
        assertEquals("test", player.getStatus());
        player.setStatus(null);
        assertEquals(null, player.getStatus());
    }

    /**
     * Check if the function getProperties() can return the correct properties owned by the player using assertEquals, which is an empty arrayList of type Property for the Player instance.
     */
    @Test
    public void testGetProperties(){
        assertEquals(new ArrayList<Property>(), player.getProperties());
    }

    /**
     * Check if the addProperties() function can add new property to the list of properties owned by the player properly,
     * the test will check the current player owned properties which is null, then it will call the addProperties() function with the property1,
     * and then call the getProperties() method with assertEquals to see if the returned arrayList contains only property1, then the test is repeated
     * with property2, then check if the returned arrayList contains property1 and property2.
     */
    @Test
    public void testAddProperties(){
        ArrayList<Property> propertiesReferenceList = new ArrayList<Property>();
        assertEquals(new ArrayList<Property>(), player.getProperties());
        player.addProperties(property1);
        propertiesReferenceList.add(property1);
        assertEquals(propertiesReferenceList, player.getProperties());
        player.addProperties(property2);
        propertiesReferenceList.add(property2);
        assertEquals(propertiesReferenceList, player.getProperties());
    }

    /**
     * Check if the function getPlayerPosition() can return the correct player position using assertEquals, which is an integer 0 as the default for the Player instance.
     */
    @Test
    public void testGetPlayerPosition(){
        assertEquals(0,player.getPlayerPosition());
    }

    /**
     * Check if the setPlayerPosition() function can set the position of the player properly, the test will check the current player position, then it will
     * call the setPlayerPosition() function with the new position 10, and then call the getPlayerPosition() method with assertEquals to see if
     * it has changed to 10 or not, this test is repeated with the value as 100, to see if the value can be looped back around with modular operation,
     * because the position can be larger than 20 if the player is at position 19 and roll a dice, then the value must be looped back, by using 100, it
     * should loop back to 0, for the last test, a negative number -1 is used in setPlayerPosition(), assertThrows(illegalArgumentException) is used
     * to check if the function will throw an error based on the negative position number, because that is impossible in the game.
     */
    @Test
    public void testSetPlayerPosition(){
        assertEquals(0,player.getPlayerPosition());
        player.setPlayerPosition(10);
        assertEquals(10,player.getPlayerPosition());
        player.setPlayerPosition(100);
        assertEquals(0,player.getPlayerPosition());
        assertThrows(IllegalArgumentException.class, () ->
                player.setPlayerPosition(-10)
        );
    }
}
