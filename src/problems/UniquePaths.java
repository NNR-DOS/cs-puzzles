package problems;

public class UniquePaths {

//    int counter = 0;
//
//    public int uniquePaths(int m, int n) {
//        backtrack(m - 1, n - 1);
//        return counter;
//    }
//
//    public void backtrack(int m, int n) {
//        if (m == 0 && n == 0) {
//            counter++;
//        } else {
//            if ((m - 1) >= 0) {
//                backtrack(m - 1, n);
//            }
//            if ((n - 1) >= 0) {
//                backtrack(m, n - 1);
//            }
//        }
//    }


    public int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    uniquePaths[i][j] = 1;
                    continue;
                }
                uniquePaths[i][j] = uniquePaths[i][j - 1] + uniquePaths[i - 1][j];

            }
        }
        return uniquePaths[m - 1][n - 1];
    }


    public static void main(String[] args) {

        int[][] board =
                {
                        {1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 3, 4, 5, 6, 7},
                        {1, 3, 1, 4, 5, 6, 7}
                };

        UniquePaths uniquePaths = new UniquePaths();
        System.out.print(uniquePaths.uniquePaths(1, 1));
    }
}
