package problems;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }

    public static int expandFromCenter(String s, int left, int right) {
        int count = 0;
        if (s.length() == 0 || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    //  a a b b b b a a
    //  0 1 2 3 4 5 6 7


    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
}

