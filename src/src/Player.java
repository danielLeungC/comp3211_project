package src;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private int balance;
    private String status;
    private ArrayList<Property> propertiesList;
    private int playerPosition;

    /*
     * player status: normal, retired, jail
     * */

    public Player(String playerName) {
        this.playerName = playerName;
        balance = 1500;
        status = "normal";
        setPlayerPosition(0);
        propertiesList = new ArrayList<Property>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Property> getProperties() {
        return propertiesList;
    }

    public void addProperties(Property property) {
        propertiesList.add(property);
    }

    public void setPlayerPosition(int nextPosition) {
        if(nextPosition<0) {
            throw new IllegalArgumentException("Invalid position, the position must be positive!");
        }
        playerPosition = Math.floorMod(nextPosition, 20);
    }

    public int getPlayerPosition() {
        return playerPosition;
    }
}