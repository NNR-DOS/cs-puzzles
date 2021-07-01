package problems;

public class DeleteOperationForTwoStrings {

    public static int minDistance(String text1, String text2) {
        int firstStringPosition = text1.length();
        int secondStringPosition = text2.length();
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = 0;
            }
        }
        int longestSubsequence = memo(text1, text2, firstStringPosition, secondStringPosition, memo);
        return (firstStringPosition - longestSubsequence) + (secondStringPosition - longestSubsequence);
    }

    public static int memo(String text1, String text2, int firstStringPosition, int secondStringPosition, int[][] memo) {
        if (firstStringPosition == 0 || secondStringPosition == 0) {
            return 0;
        } else if (memo[firstStringPosition - 1][secondStringPosition - 1] != 0) {
            return memo[firstStringPosition - 1][secondStringPosition - 1];
        } else if (text1.charAt(firstStringPosition - 1) == text2.charAt(secondStringPosition - 1)) {
            memo[firstStringPosition - 1][secondStringPosition - 1] = 1 + memo(text1, text2, firstStringPosition - 1, secondStringPosition - 1, memo);
            return memo[firstStringPosition - 1][secondStringPosition - 1];
        } else {
            memo[firstStringPosition - 1][secondStringPosition - 1] = Math.max(memo(text1, text2, firstStringPosition - 1, secondStringPosition, memo), memo(text1, text2, firstStringPosition, secondStringPosition - 1, memo));
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

    public static void main(String[] args) {
        //pea
        //heap 3

        //sea
        //eat 2

        //heet
        //feet 2

        //daaaart
        //flaaart 3

        //geeksforgeeks 8
        //geeks

        String word1 = "geeksforgeeks";
        String word2 = "geeks";

        System.out.println(minDistance(word1, word2));
    }
}
