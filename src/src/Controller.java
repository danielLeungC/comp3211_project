package src;

import src.Display;
import src.Player;
import src.Property;
import src.Square;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private Display display;
    private Square[] squaresList;
    private ArrayList<Player> playersList;
    private ArrayList<Player> retireList;
    private Player currentPlayer;
    private boolean status;
    private int turns;
    private String userInput;

    public Controller(Display display, Square[] squares, Player[] players) {
        this.display = display;
        this.squaresList = squares;
        playersList = new ArrayList<Player>();
        for (Player player : players) {
            playersList.add(player);
        }
        turns = 0;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Square[] getSquaresList() {
        return squaresList;
    }

    public void setSquaresList(Square[] squaresList) {
        this.squaresList = squaresList;
    }

    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public ArrayList<Player> getRetireList() {
        return retireList;
    }

    public void setRetireList(ArrayList<Player> retireList) {
        this.retireList = retireList;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void play() {
        /*
         * Flow:
         * check the game status:                                           @
         *   if turn=100 -> end game || only 1 player in the player list,
         *   turn!=100 || >1 player in the player list -> continue
         * set the current player according to the player list              @
         * rollDice and move the current player                             @
         * check which type of square the player landed and handle it
         * add player to the retire list if he bankrupted                   @
         * pass to next player                                              @
         * if all player have played, then turn number ++                   @
         * */
        int playerIndex = 0;
        while (!isEndGame()) {
            currentPlayer = playersList.get(playerIndex);
            movePlayer(currentPlayer);
            squareTypeHandler();
            if (playerIndex < 5) {
                playerIndex += 1;
            } else {
                playerIndex = 0;
                turns += 1;
            }
        }
        if (isEndGame()) {
            //TODO win sequence
            winSequence();
        }
    }

    // To handle different square type action
    public void squareTypeHandler() {
        Square landedSquare = squaresList[currentPlayer.getPlayerPosition()];
        int squareType = checkSquareType(landedSquare);
        switch (squareType) {
            case 0:
                Property property = (Property) landedSquare;
                checkProperty(currentPlayer, property, playersList);
                break;
            case 1:
                chance(currentPlayer);
                break;
            case 2:
                go(currentPlayer);
                break;
            case 3:
                incomeTax(currentPlayer);
                break;
            case 4:
                break;
            case 5:
                jail(currentPlayer);
                break;
            case 6:
                leaveJail(currentPlayer);
                break;
        }
    }

    // roll a dice and return the num
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    // player = current position + sum of two rolled dices
    public void movePlayer(Player player) {
        int squaresToMove = player.getPlayerPosition() + rollDice() + rollDice();
        player.setPlayerPosition(squaresToMove);
    }

    // player = current position + num
    public void movePlayer(Player player, int num) {
        int squaresToMove = player.getPlayerPosition() + num;
        player.setPlayerPosition(squaresToMove);
    }

    // check who owns the property and do the follow up
    public void checkProperty(Player player, Property property, ArrayList<Player> playersList) {
        Boolean propertyOwned = property.isOwned();
        // pay rent to landlord
        if (propertyOwned) {
            display.printMsg(property.getSquareName() + " is owned by " + property.getOwner());
            Player landlord = findPropertyOwner(playersList, property);

            int rentValue = property.getRent();
            if (isEnoughMoney(property.getRent(), player.getBalance())) {
                deductCurrentPlayerMoney(rentValue);
                landlord.setBalance(landlord.getBalance() + rentValue);
            } else {
                bankruptRetire();
            }

        } else {
            userInput = display.acceptInput("Do you want to buy " + property.getSquareName() + " with $" + property.getPrice() + "?");
            if (confirmPurchase(userInput)) {
                purchaseProperty(player, property);
            }
        }
    }

    public Player findPropertyOwner(ArrayList<Player> playersList, Property property) {
        Player owner = null;
        for (Player player : playersList) {
            if (property.getOwner().equals(player.getPlayerName())) {
                owner = player;
            }
        }
        return owner;
    }

    public boolean confirmPurchase(String answer) {
        if (answer.equals("Yes")) {
            return true;
        }
        if (answer.equals("No")) {
            return false;
        } else {
            // TODO do the exception handling
            return true;
        }
    }

    public void purchaseProperty(Player buyer, Property property) {
        if (isEnoughMoney(property.getPrice(), buyer.getBalance())) {
            deductCurrentPlayerMoney(property.getPrice());
            buyer.addProperties(property);
            property.setOwner(buyer.getPlayerName());
            property.setOwned(true);
        } else {
            display.printMsg("You do not have enough money.");
        }
    }

    public int[] retirement() {

        return null;
    }

    public boolean isEnoughMoney(int deductAmount, int playerBalance) {
        if (playerBalance >= deductAmount) {
            return true;
        } else {
            return false;
        }
    }

    public void updateTurnNumber(int turns) {

    }

    public void chance(Player player) {
        Random random = new Random();
        // gain money
        if (random.nextBoolean()) {
            int amount = (random.nextInt(20) + 1) * 10;
            player.setBalance(player.getBalance() + amount);
        }
        // lose money
        else {
            int amount = (random.nextInt(30) + 1) * 10;
            if (isEnoughMoney(amount, player.getBalance())) {
                deductCurrentPlayerMoney(amount);
            } else {
                bankruptRetire();
            }
        }
    }

    public void go(Player player) {
        player.setBalance(player.getBalance() + 1500);
    }

    public void incomeTax(Player player) {
        int taxAmount = (int) Math.floor(player.getBalance() * 0.1);

        if (isEnoughMoney(taxAmount, player.getBalance())) {
            deductCurrentPlayerMoney(taxAmount);
        }
    }

    // Move player to jail
    public void jail(Player player) {
        player.setPlayerPosition(5);
        player.setStatus("jail");
    }

    public void leaveJail(Player player) {
        // {{playerName, turnInJail}, ..., {}}
        ArrayList<String[]> jailList = null;
        String[] newPlayer;

        for (int i = 0; i < jailList.size(); i++) {
            if (player.getPlayerName() != jailList.get(i)[0]) {
                newPlayer = new String[]{player.getPlayerName(), "0"};
                jailList.add(newPlayer);
            } else {
                int turnInJail = Integer.parseInt(jailList.get(i)[1] + 1);
                int firstDice = rollDice();
                int secondDice = rollDice();
                int sum = firstDice + secondDice;
                // 1 < turnInJail <=3
                switch (turnInJail) {
                    case 1:
                        if (sameDice(firstDice, secondDice)) {
                            movePlayer(player, sum);
                        } else {
                            // update turns in jail
                            jailList.get(i)[1] = String.valueOf(turnInJail);
                        }
                        break;
                    case 2:
                        userInput = display.acceptInput("Input A to Pay $150 to get out of jail.\nInput B to roll dices.");
                        if (userInput == "A") {
                            if (isEnoughMoney(150, player.getBalance())) {
                                deductCurrentPlayerMoney(150);
                                movePlayer(player);
                                jailList.remove(i);
                            } else {
                                display.printMsg("You do not have enough money to pay $150.\nDices will be rolled.");
                                if (sameDice(firstDice, secondDice)) {
                                    movePlayer(player, sum);
                                    jailList.remove(i);
                                } else {
                                    // update turns in jail
                                    jailList.get(i)[1] = String.valueOf(turnInJail);
                                }
                            }
                        }
                        if (userInput == "B") {
                            if (sameDice(firstDice, secondDice)) {
                                movePlayer(player, sum);
                                jailList.remove(i);
                            } else {
                                // update turns in jail
                                jailList.get(i)[1] = String.valueOf(turnInJail);
                            }
                        }
                        break;
                    case 3:
                        if (sameDice(firstDice, secondDice)) {
                            movePlayer(player, sum);
                            jailList.remove(i);
                        } else {
                            display.printMsg("You failed to throw doubles in the last three turns.");
                            display.printMsg("You must pay $150 to get out of jail.");
                            if (isEnoughMoney(150, currentPlayer.getBalance())) {
                                deductCurrentPlayerMoney(150);
                                jailList.remove(i);
                            } else {
                                bankruptRetire();
                            }
                        }
                        break;
                }
            }
        }
    }

    public void deductCurrentPlayerMoney(int deductAmount) {
        currentPlayer.setBalance(currentPlayer.getBalance() - deductAmount);
    }

    public Boolean sameDice(int firstDice, int secondDice) {
        if (firstDice == secondDice) {
            display.printMsg("Congratulation! You rolled doubles!");
            return true;
        } else {
            display.printMsg("Sorry! You rolled " + firstDice + " and " + secondDice + ".");
            return false;
        }
    }


    /*
     * handle player bankrupt
     * Release all owned properties
     * Remove the player from the playerList and add he to retireList
     * */
    public void bankruptRetire() {
        for (int i = 0; i < squaresList.length; i++) {
            if (squaresList[i] instanceof Property) {
                if (((Property) squaresList[i]).getOwner().equals(currentPlayer.getPlayerName())) {
                    ((Property) squaresList[i]).setOwner("");
                    ((Property) squaresList[i]).setOwned(false);
                }
            }
        }

        playersList.remove(playersList.indexOf(currentPlayer));
        retireList.add(currentPlayer);
    }

    //TODO check if end game
    public Boolean isEndGame() {
        if (turns == 100) {
            return true;
        }
        if (playersList.size() == 1) {
            return true;
        }
        return false;
    }

    /*PROPERTY(0),
    CHANCE(1),
    GO(2),
    TAX(3),
    PARKING(4),
    TOJAIL(5),
    JAIL(6);*/
    // return the square type
    public int checkSquareType(Square square) {
        return square.getSquareType().ordinal();
    }

    /*
     * Determine how many winners
     *
     * */
    public void winSequence() {
        String winMessage = "Winner: \n";
        for (int i = 0; i < playersList.size(); i++) {
            winMessage = winMessage + playersList.get(i).getPlayerName() + "\n";
        }
        display.displayWinMsg(winMessage);
    }

    public ArrayList<Player> getPlayersList(){
        return playersList;
    }
}
