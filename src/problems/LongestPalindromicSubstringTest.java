package problems;

public class LongestPalindromicSubstringTest {

    public static String getLongestPalindromicSubstring(String s) {

        if (s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int lengthOdd = expandFromCenter(s, i, i);
            int lengthEven = expandFromCenter(s, i, i + 1);
            int maxLength = Math.max(lengthOdd, lengthEven);
            if (maxLength > end - start) {
                start = i - (maxLength / 2) + 1;
                end = i + (maxLength / 2);
            }
        }

        return s.substring(start, end + 1);

    }

    public static int expandFromCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }


    public static void main(String[] args) {
        System.out.println(getLongestPalindromicSubstring("abbbbbba"));
    }
}
