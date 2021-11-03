import org.junit.Before;
import org.junit.Test;
import src.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class testController {
    Controller controller;
    Player[] players;
    Square[] squares;
    final String[] squareNameList = {"Go", "Central", "Wan Chai", "Income Tax", "Stanley", "Just Visiting/In Jail", "Shek O", "Mong Kok", "Chance", "Tsing Yi", "Free Parking", "Shatin", "Chance", "Tuen Mun", "Tai Po", "Go to Jail", "Sai Kung", "Yuen Long", "Chance", "Tai O"};
    final int[] squarePrice = {800,700,600,400,500,400,700,400,500,400,400,600};
    final int[] squareRent = {90,65,60,10,40,15,75,20,25,10,25,25};
    final int[] propertyIDMapping = {-1,0,1,-1,2,-1,3,4,-1,5,-1,6,-1,7,8,-1,9,10,-1,11};
    final String[] otherSquareType = {"GO","","","TAX","","JAIL","","","CHANCE","","PARKING","","CHANCE","","","TOJAIL","","","CHANCE",""};

    @Before
    public void initialize() {
        players = new Player[]{new Player("test"), new Player("name")};
        squares = new Square[20];
        squares[0] = new Property(SquareType.PROPERTY, "test", 500, 50);
        Property property = (Property) squares[0];
        for(int i=0; i<squareNameList.length; i++) {
            if(propertyIDMapping[i] != -1){
                squares[i] = new Property(SquareType.PROPERTY,squareNameList[i], squarePrice[propertyIDMapping[i]],squareRent[propertyIDMapping[i]]);
            }else{
                squares[i] = new OtherSquare(SquareType.valueOf(otherSquareType[i]),squareNameList[i]);
            }
        }
        controller = new Controller(new Display(), squares, players);
    }

    @Test
    public void temp(){

    }
}
