package problems;

public class MinimumPathSum {

    int counter = 0;

    int minPathSum(int[][] board) {
        int currentPositionRowValue = board.length - 1;
        int currentPositionColumnValue = board[0].length - 1;
        backtrack(board, currentPositionRowValue, currentPositionColumnValue);
        return counter;
    }

    public void backtrack(int[][] board, int row, int column) {
        if (row < 0 || column < 0) {
        } else if (row == 0 && column == 0) {
            counter++;
        } else {
            backtrack(board, row - 1, column);
            backtrack(board, row, column - 1);
        }
    }

//    int minPathSum(int[][] board) {
//        int currentPositionRowValue = board.length - 1;
//        int currentPositionColumnValue = board[0].length - 1;
//        return backtrack(board, currentPositionRowValue, currentPositionColumnValue);
//    }

//    public int backtrack(int[][] board, int row, int column) {
//        if (row < 0 || column < 0) {
//            return Integer.MAX_VALUE;
//        } else if (row == 0 && column == 0) {
//            return board[row][column];
//        } else {
//            return board[row][column] + Math.min(backtrack(board, row - 1, column), backtrack(board, row, column - 1));
//        }
//    }

//    int minPathSum(int[][] board) {
//        int R = board.length;
//        int C = board[0].length;
//
//        int[][] totalCost = new int[R][C];
//
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                totalCost[i][j] = board[i][j];
//                if (i == 0 && j > 0) {
//                    totalCost[0][j] += totalCost[0][j - 1];
//                }
//                else if (j == 0 && i > 0) {
//                    totalCost[i][0] += totalCost[i - 1][0];
//                }
//                else {
//                    if (i <= 0) {
//                        continue;
//                    }
//                    totalCost[i][j] += Math.min(totalCost[i][j - 1], totalCost[i - 1][j]);
//                }
//            }
//        }
//        return totalCost[R - 1][C - 1];
//    }

    public static void main(String[] args) {

        int[][] board =
                {
                        {1, 3, 1, 4, 5, 6, 7},
                        {1, 3, 1, 4, 5, 6, 7},
                        {1, 3, 1, 4, 5, 6, 7}
                };

        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.print(minimumPathSum.minPathSum(board));
    }
}
