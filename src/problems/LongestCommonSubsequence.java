package problems;

import java.io.IOException;
import java.util.Arrays;

public class LongestCommonSubsequence {

    /*

          "mhunuzqrkzsnidwbun"
          "szulspmhwpazoxijwbq"

             0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9
             s z u l s p m h w p a z o x i j w b q
         0 m             1
         1 h               1
         2 u     1
         3 n
         4 u     1
         5 z   1                   1
         6 q                                     1
         7 r
         8 k
         9 z   1                   1
        10 s 1       1
        11 n
        12 i                             1
        13 d
        14 w                  1              1
        15 b                                    1
        16 u    1
        17 n
                 0  1  2  3  4  5  6  7  8  9 10 11

            0    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            1    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            2    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            3    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            4    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1],
            5    0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1],
            6    0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2],
            7    0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2],
            8    0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2],
            9    0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2],
           10    0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2]]



           aaaaavbbb

           aaavva


     */

    public static int longestCommonSubsequence(String text1, String text2) {
        int firstStringPosition = text1.length();
        int secondStringPosition = text2.length();
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = 0;
            }
        }
        return memoize(text1, text2, firstStringPosition, secondStringPosition, memo);
    }

    public static int memoize(String text1, String text2, int firstStringPosition, int secondStringPosition, int[][] memo) {
        if (firstStringPosition == 0 || secondStringPosition == 0) {
            return 0;
        } else if (memo[firstStringPosition - 1][secondStringPosition - 1] != 0) {
            return memo[firstStringPosition - 1][secondStringPosition - 1];
        } else if (text1.charAt(firstStringPosition - 1) == text2.charAt(secondStringPosition - 1)) {
            memo[firstStringPosition - 1][secondStringPosition - 1] = 1 + memoize(text1, text2, firstStringPosition - 1, secondStringPosition - 1, memo);
            print(memo);
            return memo[firstStringPosition - 1][secondStringPosition - 1];
        } else {
            memo[firstStringPosition - 1][secondStringPosition - 1] = Math.max(memoize(text1, text2, firstStringPosition - 1, secondStringPosition, memo), memoize(text1, text2, firstStringPosition, secondStringPosition - 1, memo));
            print(memo);
            return memo[firstStringPosition - 1][secondStringPosition - 1];
        }
    }

    public static void print(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(" " + anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        String text1 = "mhunuzqrkzsnidwbun";
        String text2 = "szulspmhwpazoxijwbq";

        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
