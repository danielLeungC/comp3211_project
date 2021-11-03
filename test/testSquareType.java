import org.junit.Before;
import org.junit.Test;
import src.Property;
import src.Square;
import src.SquareType;

import static org.junit.Assert.*;

/**
 * This class tests the functionalities of the class SquareType.
 */
public class testSquareType {

    /**
     * This test checks if the SquareType class contains all of the appropriate types for the tiles, which are property, chance, go, tax, parking, tojail, jail,
     * it checks if the each enum value are correct by checking each enum value against the value in the typeList string array using assertEqualss one by one.
     */
    @Test
    public void testSquareType() {
        String[] typeList = {"PROPERTY", "CHANCE", "GO", "TAX", "PARKING", "TOJAIL", "JAIL"};
        SquareType[] squareTypeList = SquareType.values();
        for(int i=0; i<typeList.length; i++) {
            assertEquals(typeList[i], squareTypeList[i].toString());
        }
    }
}
