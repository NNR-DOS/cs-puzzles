package problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> returnList = new ArrayList<>();

        int direction = 0;

        int top = 0;

        int bottom = matrix.length - 1;

        int left = 0;

        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    returnList.add(matrix[top][i]);
                }
                top++;
                direction = 1;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    returnList.add(matrix[i][right]);
                }
                right--;
                direction = 2;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    returnList.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 3;
            } else {
                for (int i = bottom; i >= top; i--) {
                    returnList.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return returnList;
    }

    public static void main(String[] args) {

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16

        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

        int[][] matrix =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        System.out.print(spiralOrder(matrix));

    }
}
