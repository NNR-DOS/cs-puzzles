package problems;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int max = 0;
        int count = 0;
        char[] chars = s.toCharArray();

        Set<Character> hashSet = new HashSet<>();
        hashSet.add(chars[0]);

        for (char character : chars) {
            hashSet.add(character);
        }
        List<Integer> integerList = new ArrayList<>();
        for (char character : hashSet) {
            integerList.add(count(chars, character, max, count, 0, 0, k, k));
        }

        Collections.sort(integerList);
        Collections.reverse(integerList);

        return integerList.get(0);
    }

    public static int count(char[] array, char letter, int max, int count, int lastWorkingIndex, int startingPosition, int numberIndexesYouCanFlip, int currentNumberIndexesYouCanFlip) {
        if (startingPosition == array.length - 1) {
            return max;
        }

        for (int i = startingPosition; i < array.length; i++) {
            if (array[i] == letter) {
                count++;
                max = Math.max(count, max);
                continue;
            }
            if (array[i] != letter && numberIndexesYouCanFlip != 0) {
                count++;
                max = Math.max(count, max);
                numberIndexesYouCanFlip--;
                continue;
            }
            if (numberIndexesYouCanFlip == 0) {
                numberIndexesYouCanFlip = currentNumberIndexesYouCanFlip;
                return count(array, letter, max, 0, lastWorkingIndex + 1, lastWorkingIndex + 1, numberIndexesYouCanFlip, currentNumberIndexesYouCanFlip);
            }
        }
        return max;
    }


    public static void main(String[] args) {

        /*
        Example 1:

        Input:
        s = "ABAB", k = 2

        Output:
        4

        Explanation:
        Replace the two 'A's with two 'B's or vice versa.


        Example 2:

        Input:
        s = "AABABBA", k = 1

        Output:
        4

        Explanation:
        Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        The substring "BBBB" has the longest repeating letters, which is 4.
         */

        String s = "ADFAAFA";
        int k = 0;

        System.out.println(characterReplacement(s, k));
    }
}
