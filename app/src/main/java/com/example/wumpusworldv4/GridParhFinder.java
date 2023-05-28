package com.example.wumpusworldv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class GridParhFinder {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    static int[][] GRID = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
    };
    static boolean foundPath;
    static List<Integer> cheatPath;
    private static int[][] VISITED = new int[ROWS][COLS];

    private static final int[] ROW_NEIGHBORS = {-1, 0, 1, 0};
    private static final int[] COL_NEIGHBORS = {0, 1, 0, -1};

    private static List<Cell> path;
    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;
    static int gridSize=4;
    public static void main(String[] args) {

        Sample.initialize();
        for(int i=0; i<gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                GRID[i][j]=1;
            }
        }
        for (int a[]:Sample.pitLocations)
        {
            GRID[a[0]][a[1]]=0;
        }
        GRID[Sample.wumpusLocation[0]][Sample.wumpusLocation[1]]=0;
        startRow=3;
        startCol=0;
        endRow=Sample.goldLocation[0];
        endCol=Sample.goldLocation[1];
        //printMaze(3, 0,GRID);
        for(int i=0; i<gridSize; i++) {
            for(int j=0; j<gridSize; j++) {
                System.out.print(GRID[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println(startRow+""+startCol+""+endRow+""+endCol);
        path = new ArrayList<>();
        cheatPath=new ArrayList<>();
        foundPath = findPath(startRow, startCol, endRow, endCol);
        if (foundPath) {
            System.out.println("Path found:");
            for (Cell cell : path) {
                System.out.println("(" + cell.row + ", " + cell.col + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
    public static List<Integer> CheatPath(int[] tarr)
    {
        //Sample.initialize();
        for(int i=0; i<gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                GRID[i][j]=1;
                VISITED[i][j]=0;
            }
        }
        for (int i=0;i<6;i=i+2)
        {
            GRID[tarr[i]][tarr[i+1]]=0;
        }

        //GRID[Sample.wumpusLocation[0]][Sample.wumpusLocation[1]]=2;
        GRID[tarr[6]][tarr[7]]=0;
        startRow=3;
        startCol=0;
        endRow=tarr[8];
        endCol=tarr[9];
        GRID[endRow][endCol]=5;
        //printMaze(3, 0,GRID);
    	/*for(int i=0; i<gridSize; i++) {
            for(int j=0; j<gridSize; j++) {
            	System.out.print(GRID[i][j]+"\t");
            }
            System.out.println();
    	}*/

        //System.out.println(startRow+""+startCol+""+endRow+""+endCol);
        path = new ArrayList<>();
        cheatPath=new ArrayList<>();
        foundPath = findPath(startRow, startCol, endRow, endCol);
        if (foundPath) {
            //System.out.println("Path found:");
            return cheatPath;
        } else {
            return new ArrayList<>();
        }
    }

    static boolean findPath(int row, int col, int endRow, int endCol) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || GRID[row][col] == 0 || VISITED[row][col] == 1 || GRID[row][col] == 2 ) {
            return false;
        }

        // Mark current cell as visited
        VISITED[row][col] = 1;

        // Add current cell to the path
        path.add(new Cell(row, col));
        cheatPath.add(row*10+col);
        if (row == endRow && col == endCol) {
            return true; // Path found
        }

        // Explore neighbors
        for (int i = 0; i < ROW_NEIGHBORS.length; i++) {
            int newRow = row + ROW_NEIGHBORS[i];
            int newCol = col + COL_NEIGHBORS[i];
            if (findPath(newRow, newCol, endRow, endCol)) {
                return true; // Path found
            }
        }

        // If no path found, backtrack
        path.remove(path.size() - 1);
        cheatPath.remove(cheatPath.size() - 1);
        return false;
    }

}