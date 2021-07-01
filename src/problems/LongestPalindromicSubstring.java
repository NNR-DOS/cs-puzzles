package problems;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        String longestString = "";

        for (int i = 0; i < s.length(); i++) {
            String test = "";
            for (int j = i; j < s.length() + 1; j++) {
                test = s.substring(i, j);
                if (expandFromCenter(test, 0, test.length() - 1)) {
                    longestString = longestString.length() > test.length() ? longestString : test;
                }
            }
        }
        return longestString;
    }

    public static boolean expandFromCenter(String s, int left, int right) {

        if (s.length() <= 1) {
            return true;
        }

        while (right > left && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left - right == 1 || left - right == 0;

    }


    //  a a b b b b a a
    //  0 1 2 3 4 5 6 7

    /*
    how would we define the length of the palindrome in relation to i (our middle index)?
     */

    public static void main(String[] args) {
        System.out.println(longestPalindrome("gkgkjh"));
    }

}
