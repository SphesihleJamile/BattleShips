public class BattleShip {

    private static char[][] ocean = new char[10][10];

    public static void placeShips()
    {
        /********
         * First, we will assign the space character to all the elements of the 2D array.
         * These empty character signify that there is no ship/boat in that location.
        *********/
        for(int i = 0; i < 10; i ++)
        {
            for(int j = 0; j < 10; j ++)
            {
                ocean[i][j] = ' ';
            }
        }

        /*****
         * Now we will be randomly placing the ships and boats into the 2D array called ocean
         */
        //Aircraft carrier - 5 squares
        addShip(5);
        //battleship - 4 squares
        addShip(4);
        //destroyer - 3 squares
        addShip(3);
        //submarine - 3 squares
        addShip(3);
        //PT boat - 2 squares
        addShip(2);
    }

    public static void addShip(int length)
    {
        int row, col;
        int count = length;
        while (true)
        {
            //we want this method to run until the ship has been randomly placed within the array
            row = (int)(Math.random()*10);
            col = (int)(Math.random()*10);
            while((col+count) > 9)
            {
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*10);
                //This infinite loop will make sure that the col index is less than 9,
                //thus getting a random index that is within the array
            }
            while(count>0)
            {
                //After we have found the random starting index, we must then check if the ships won't overlap each other
                if(ocean[row][col] == 'S')
                    continue;
                count--;
                col++;
            }
            //if the compiler arrives at this point, then we are ready to assign the ship to the ocean
            col-=length;//return the column index to it's original random number
            ////////////////////
            for(int i = 0; i < length; i++)
            {
                ocean[row][col] = 'S';
                col++;
            }
            break;
        }
    }

    public static void print()
    {
        //prints out the current state of the game
        // blank square if there is no hit
        // 'M' if there is a miss
        // 'H' if there is a hit
        for(int i = 0; i < 11; i ++)
        {
            if(i == 0)
            {
                System.out.print("      ");
                for(int k = 0; k < 10; k++)
                {
                    System.out.print(" " + k + " ");
                }
                System.out.println("");
            }
            else
            {
                System.out.print((i-1) + "     ");
                for(int j = 0; j < 10; j ++)
                {
                    if(ocean[i-1][j] == 'M')
                        System.out.print("[" + ocean[i-1][j] + "]");
                    else if(ocean[i-1][j] == 'H')
                        System.out.print("[" + ocean[i-1][j] + "]");
                    else
                        System.out.print("[ ]");
                }
                System.out.println();
            }
        }
    }

    public static boolean canFire(int row, int col)
    {
        return (ocean[row][col] != 'H' && ocean[row][col] != 'M');
    }
    
    public static void  processFire(int row, int col)
    {
        if(ocean[row][col] == ' ')
            ocean[row][col] = 'M';
        else
            ocean[row][col] = 'H';
    }
    
    public static boolean gameOver()
    {
        int count = 0;
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j<10; j++)
            {
                count += (ocean[i][j] == 'S') ? 1 : 0;
            }
        }
        return count==0;
    }
}
