package problems;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] uniquePaths = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if ((i == 0 || j == 0) && obstacleGrid[i][j] == 0) {
                    uniquePaths[i][j] = 1;
                    continue;
                }
                if ((i == 0 && j > 0 && j + 1 < obstacleGrid[0].length) && obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j + 1] = 1;
                    uniquePaths[i][j] = 0;
                    continue;
                }
                if ((j == 0 && (i > 0 && i + 1 < obstacleGrid.length)) && obstacleGrid[i][j] == 1) {
                    obstacleGrid[i + 1][j] = 1;
                    uniquePaths[i][j] = 0;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    uniquePaths[i][j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && i - 1 >= 0) {
                    uniquePaths[i][j] = uniquePaths[i][j - 1] + uniquePaths[i - 1][j];
                }
            }
        }
        return uniquePaths[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid =
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}


                        /*
                        {1, 1},
                        {0, 0},
                        {1, 0}
                         */
                };

        UniquePathsII uniquePaths = new UniquePathsII();
        System.out.print(uniquePaths.uniquePathsWithObstacles(obstacleGrid));
    }
}
