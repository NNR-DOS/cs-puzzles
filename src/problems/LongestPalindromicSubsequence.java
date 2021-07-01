package problems;

/*
 "b b b a b"
  0 1 2 3 4


// a g b d b a
// 0 1 2 3 4 5

      0 1 2 3 4 5
    0 1 1 1 1 3 5
    1   1 1 1 3 3
    2     1 1 3 3
    3       1 1 1
    4         1 1
    5           1
 */

public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        int[][] dynamicProgramming = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j + i <= s.length() - 1) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        dynamicProgramming[j][j + i] = i >= 1 ? 2 + dynamicProgramming[j + 1][j + i - 1] : 1;
                    } else {
                        dynamicProgramming[j][j + i] = Math.max(dynamicProgramming[j + 1][j + i], dynamicProgramming[j][j + i - 1]);
                    }
                }
            }
        }
        return dynamicProgramming[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"
        ));
    }

    //"abcabcabcabc"
    // acbabca


    /*
    "b b b a b"
     0 1 2 3 4

     j, j+i

     j = 0    bbb
     i = 2

     j = 1    bba
     i = 2

     j = 2    bab
     i = 2

     j = 0    bbbab
     j = 4

      0 1 2 3 4
    0 1 2 3 3 4
    1   1 2 2 3
    2     1 1 3
    3       1 1
    4         1


// a g b d b a
// 0 1 2 3 4 5

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - 1; j++) {
                if (j + i <= s.length() - 1) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        dynamicProgramming[j][j + i] = i >= 1 ? 2 + dynamicProgramming[i + 1][j + i - 1] : 1;
                    } else {
                        dynamicProgramming[j][j + i] = Math.max(dynamicProgramming[j][j], dynamicProgramming[j + 1][j]);
                    }
                }
            }
        }

      0 1 2 3 4 5
    0 1 1 1 1 3 5
    1   1 1 1 3 3
    2     1 1 3 3
    3       1 1 1
    4         1 1
    5           1

    dp[0][4] = 2 + dp[1][3];



    longest palindromic sequence at a given length if first and last index of string of that length are not the same
    is the max value of string length current string length - 1

    if value at index is equal to value at last index in string you are looking at


    2 + whatever's in between which is 1





     */
}
