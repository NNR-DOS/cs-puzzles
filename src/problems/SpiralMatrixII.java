package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n*n; i++) {
            numbers.add(i);
        }

        int[][] returnArray = new int[n][n];
        int direction = 0, top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    returnArray[top][i] = numbers.get(0);
                    numbers.remove(0);
                }
                top++;
                direction = 1;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    returnArray[i][right] = numbers.get(0);
                    numbers.remove(0);
                }
                right--;
                direction = 2;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    returnArray[bottom][i] = numbers.get(0);
                    numbers.remove(0);
                }
                bottom--;
                direction = 3;
            } else {
                for (int i = bottom; i >= top; i--) {
                    returnArray[i][left] = numbers.get(0);
                    numbers.remove(0);
                }
                left++;
                direction = 0;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16

        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

//        int[][] matrix =
//                {
//                        {1, 2, 3},
//                        {4, 5, 6},
//                        {7, 8, 9}
//                };

        System.out.print(Arrays.deepToString(generateMatrix(3)));

    }
}
