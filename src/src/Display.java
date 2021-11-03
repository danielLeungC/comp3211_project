package src;

import src.Player;
import src.Square;

public class Display {

    public void displayBoard(Square[] squares, Player player) {
        int position = player.getPlayerPosition();
        System.out.println("          11             12            13            14            15 ");
        System.out.println("    -------------------------------------------------------------------------------------");
        System.out.println("    |             |             |             |             |             |             |");
        System.out.println("    |    Free     |    Shatin   |      ?      |   Tuen Mun  |    Tai Po   |      Go     |");
        System.out.println("    |             |             |             |             |             |             | 16");
        System.out.println("    |   Parking   |   HKD 700   |    CHANCE   |   HKD 400   |   HKD 500   |   TO JAIL   |");
        System.out.println("    |             |             |             |             |             |             |");
        System.out.println("    |-----------------------------------------------------------------------------------|");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |   Tsing Yi  |                                                       |   Sai Kung  |");
        System.out.println(" 10 |             |                                                       |             | 17");
        System.out.println("    |   HKD  400  |                                                       |   HKD 400   |");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |-------------|                                                       |-------------|");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |      ?      |                                                       |  Yuen Long  |");
        System.out.println(" 9  |             |                                                       |             | 18");
        System.out.println("    |    CHANCE   |                                                       |   HKD 400   |");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |-------------|                                                       |-------------|");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |   Mong Kok  |                                                       |      ?      |");
        System.out.println(" 8  |             |                                                       |             | 19");
        System.out.println("    |   HKD 500   |                                                       |    CHANCE   |");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |-------------|                                                       |-------------|");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |   Shek  O   |                                                       |    Tai O    |");
        System.out.println(" 7  |             |                                                       |             | 20");
        System.out.println("    |   HKD 400   |                                                       |   HKD 600   |");
        System.out.println("    |             |                                                       |             |");
        System.out.println("    |-----------------------------------------------------------------------------------|");
        System.out.println("    |      |  IN  |             |             |             |             |             |");
        System.out.println("    | JUST | JAIL |   Stanley   |  INCOME TAX |   Wan Chai  |   Central   |             |");
        System.out.println(" 6  |      -------|             |             |             |             |     G O     |");
        System.out.println("    |   VISITING  |   HKD 600   |   PAY 10%   |   HKD 700   |   HKD 800   |             |");
        System.out.println("    |             |             |             |             |             |             |");
        System.out.println("    -------------------------------------------------------------------------------------");
        System.out.println("                         5             4             3             2             1");
    }

    public void printPlayerInfo(Player player) {
        System.out.println(player.getPlayerName() + ":");
        System.out.println("Current position: " + player.getPlayerPosition());
        System.out.println("Current balance: " + player.getBalance());
    }

    public void displayWinMsg(String winMsg) {}

    public String acceptInput(String inputMsg) { return "";}

    public void printMsg(String string) {}
}
