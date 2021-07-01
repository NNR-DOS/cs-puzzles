package problems;

public class SearchA2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] value : matrix) {
            if (target > value[matrix[0].length - 1]) {
            } else if (target <= value[matrix[0].length - 1]) {
                if (target == value[matrix[0].length - 1]) {
                    return true;
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    if (target == value[j]) {
                        return true;
                    }
                    if (target > value[j]) {
                    } else if (target < value[j]) {
                        for (int[] ints : matrix) {
                            if (j - 1 > 0 && target == ints[j - 1]) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                //{-5}
        };

        int target = 30;

        System.out.println(searchMatrix(matrix, target));
    }
}
