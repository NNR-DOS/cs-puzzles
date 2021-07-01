package problems;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    //increment counter by 1 to indicate an island has been found
                    counter++;
                    //now find the perimeter of the island
                    depthFirstSearch(grid, i, j);
                }
            }
        }
        return counter;
    }

    public static void depthFirstSearch(char[][] grid, int x, int y) {
        int[][] movements = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] movement : movements) {
            int nextXPosition = x + movement[0];
            int nextYPosition = y + movement[1];
            if (isValid(grid, nextXPosition, nextYPosition)) {
                //we've determined next movement is ok, so we flip it to zero to prevent
                //our function from going backward
                grid[nextXPosition][nextYPosition] = 0;
                //continue to define perimeter of island
                depthFirstSearch(grid, nextXPosition, nextYPosition);
            }
        }
    }

    public static boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1';
    }

    public static void main(String[] args) {

        /*
        Example 1:

        Input:
        11110
        11010
        11000
        00000

        Output: 1
        Example 2:

        Input:
        11000
        11000
        00100
        00011

        Output: 3
         */

        //char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }
}
