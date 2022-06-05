import java.util.Scanner;

public class BattleShipApp {

    public static void main(String[] args)
    {
        BattleShip.placeShips();

        while (!BattleShip.gameOver())
        {
            BattleShip.print();
            Scanner scan = new Scanner(System.in);
            System.out.println("\nWhat row and column do you want to fire on?");
            System.out.print("row (0-9)  : ");
            int row = scan.nextInt();
            System.out.print("col (0-9)  : ");
            int col = scan.nextInt();
            if(row < 0 || row > 9 || col < 0 || col > 9)
            {
                System.out.println("\nSelect a value between 0-9 for row and col\n");
                continue;
            }
            //If we can fire at the selected index, then fire
            if(BattleShip.canFire(row, col))
            {
                BattleShip.processFire(row, col);
            }
            else
            {
                System.out.println("You cannot fire at the specific area as you have already fired here...\n");
            }

            //if the game is over, print Game Over, and ask the player if they want to restart the game
            if(BattleShip.gameOver())
            {
                System.out.println("|++++++++++++++++++++++++++++++++++++++++++++++++|");
                System.out.println("|                                                |");
                System.out.println("|                                                |");
                System.out.println("|                   GAME OVER                    |");
                System.out.println("|                   WELL DONE                    |");
                System.out.println("|                                                |");
                System.out.println("|++++++++++++++++++++++++++++++++++++++++++++++++|");
                System.out.println("\n\n\nDo you want to restart the game? (y/n) : ");
                if(scan.next().equalsIgnoreCase("y"))
                {
                    BattleShip.placeShips();
                }
                else
                {
                    System.out.println("\nGoodbye.. Thank you for playing");
                }
            }
        }
    }
}
