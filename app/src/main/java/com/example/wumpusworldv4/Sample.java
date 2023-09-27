package com.example.wumpusworldv4;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
class Sample {
    static int n=4;
    static Block[][] maze;

    static int []path=new int[100];
    static List<Integer> cheatpath;
    static List<int[]> pitLocations;
    static int[] goldLocation= new int[2];
    static int[] wumpusLocation=new int[2];;
    static Random random;
    //static List<Integer> pathbfs;
    public static void main(String[] args) {


        //System.out.print("Enter the order of the maze: ");
        //n = 4;
        //initialize();
        fp(4);
        printMaze(0,0);
        /*
        for (int k:a)
	   	{
			if (k==-1)
			{
				break;
			}
			System.out.println(k);
	   	}*/


    }
    static boolean isLocationInList(int[] location, List<int[]> locationList) {
        for (int[] loc : locationList) {
            if (isEqualLocation(location, loc)) {
                return true;
            }
        }
        return false;
    }

    static boolean isEqualLocation(int[] loc1, int[] loc2) {
        return loc1[0] == loc2[0] && loc1[1] == loc2[1];
    }
    static void initialize()
    {



        //GridParhFinder.startRow=3;
        //GridParhFinder.startCol=0;
        //GridParhFinder.endRow=goldLocation[0];
        //GridParhFinder.endCol=goldLocation[1];

    }
    public static int[] fp(int n) {
        maze=new Block[n][n];
        for(int i=0; i<n; i++) {
            maze[i] = new Block[n];
            for(int j=0; j<n; j++)
                maze[i][j] = new Block();
        }

        //GridParhFinder.GRID[wumpusLocation[0]][wumpusLocation[1]]=0;
        initialize();
        int gridSize = n;

        random = new Random();

        // Randomly assign the locations of the pit, gold, and Wumpus
        //int gridSize = 4;
        //int numPits = 3;
        int numPits = n-1;

        // Create a Random object
        //Random random = new Random();

        // Randomly assign the locations of the pits, gold, and Wumpus
        pitLocations = new ArrayList<>();
        int[] spawn= {n-1,0};
        wumpusLocation[0] = random.nextInt(gridSize);
        wumpusLocation[1] = random.nextInt(gridSize);
        while (isEqualLocation(wumpusLocation,spawn)) {
            wumpusLocation[0] = random.nextInt(gridSize);
            wumpusLocation[1] = random.nextInt(gridSize);
        }
        goldLocation[0] = random.nextInt(gridSize);
        goldLocation[1] = random.nextInt(gridSize);
        while (isEqualLocation(goldLocation,wumpusLocation )) {
            goldLocation[0] = random.nextInt(gridSize);
            goldLocation[1] = random.nextInt(gridSize);
        }
        for (int i = 0; i < numPits; i++) {
            int[] pitLocation = {random.nextInt(gridSize), random.nextInt(gridSize)};
            while (isLocationInList(pitLocation, pitLocations) || isEqualLocation(pitLocation,spawn ) || isEqualLocation(wumpusLocation,pitLocation) || isEqualLocation(goldLocation,pitLocation) ) {
                pitLocation[0] = random.nextInt(gridSize);
                pitLocation[1] = random.nextInt(gridSize);
            }
            //GridParhFinder.GRID[pitLocation[0]][pitLocation[1]]=0;
            pitLocations.add(pitLocation);
        }
        // Print the assigned locations
        //System.out.println("Pit locations:");

        for (int[] pitLocation : pitLocations) {
            //System.out.println("(" + pitLocation[0] + ", " + pitLocation[1] + ")");
            addPit(pitLocation[0], pitLocation[1]);
        }

        //System.out.println("Gold location: (" + goldLocation[0] + ", " + goldLocation[1] + ")");
        addGold(goldLocation[0], goldLocation[1]);
        //System.out.println("Wumpus location: (" + wumpusLocation[0] + ", " + wumpusLocation[1] + ")");
        addWumpus(wumpusLocation[0], wumpusLocation[1]);
        /*
        addPit(3, 2);
        addPit(1, 2);
        addPit(0, 3);
        */
        //System.out.print("\nEnter the location of wumpus: ");
        //addWumpus(1, 0);

        //System.out.print("\nEnter the location of gold: ");
        //addGold(1, 1);
        //pathroot=new TreeNode(goldLocation[0]*10+goldLocation[1]);

        //addnode(goldLocation[0],goldLocation[1],treeptr);

        //System.out.print("\nEnter the number of pits: ");
        //int pits = 3;


        //addPit(1, 2);
        //addPit(0, 3);

        //System.out.print("\nEnter the location of wumpus: ");
        //addWumpus(1, 0);

        //System.out.print("\nEnter the location of gold: ");
        //addGold(1, 1);


        //System.out.print("\nEnter the starting location: ");
        int[] tarr=new int[2*numPits+4];
        int k=0;
        for (int a[]:pitLocations)
        {
            tarr[k]=a[0];
            tarr[k+1]=a[1];
            k+=2;
        }
        tarr[6]=wumpusLocation[0];
        tarr[7]=wumpusLocation[1];
        tarr[8]=goldLocation[0];
        tarr[9]=goldLocation[1];
        return tarr;
        //return path;
        //if(moves <= n*n)
        //System.out.println("\nFound gold in " + moves + " moves.");

    }

    static void addPit(int r, int c) {
        maze[r][c].hasPit = true;

        if(r >= 1)
            maze[r-1][c].hasBreeze = true;
        if(r <= (n-2))
            maze[r+1][c].hasBreeze = true;
        if(c >= 1)
            maze[r][c-1].hasBreeze = true;
        if(c <= (n-2))
            maze[r][c+1].hasBreeze = true;
    }

    static void addWumpus(int r, int c) {
        maze[r][c].hasWumpus = true;

        if(r >= 1)
            maze[r-1][c].hasStench = true;
        if(r <= (n-2))
            maze[r+1][c].hasStench = true;
        if(c >= 1)
            maze[r][c-1].hasStench = true;
        if(c <= (n-2))
            maze[r][c+1].hasStench = true;
    }

    static void addGold(int r, int c) {
        maze[r][c].hasGold = true;
    }


    static void printMaze(int r, int c) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char charToPrint = '-';
                if(r == i && c == j)
                    charToPrint = '*';
                else if(maze[i][j].hasPit)
                    charToPrint = 'O';
                else if(maze[i][j].hasWumpus)
                    charToPrint = 'X';
                else if(maze[i][j].hasGold)
                    charToPrint = '$';

                System.out.print(charToPrint + "\t");
            }
            System.out.println();
        }
    }
}
