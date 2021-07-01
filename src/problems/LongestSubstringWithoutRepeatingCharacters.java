package problems;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int maxLen = 1;
        int cursor = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= cursor) {
                cursor = map.get(c) + 1;
            } else {
                maxLen = (int)Math.max(maxLen, i - cursor + 1);
            }
            map.put(c, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("addasu"));
    }
}
