package problems;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnValue = new ArrayList<>();
        List<char[]> sorted = new ArrayList<>();
        List<String> sortedString = new ArrayList<>();
        HashSet<String> uniqueSortedString = new HashSet<>();

        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            sorted.add(charArray);
        }

        for (char[] chars : sorted) {
            StringBuilder string = new StringBuilder();
            for (Character character : chars) {
                string.append(character);
            }
            sortedString.add(string.toString());
            uniqueSortedString.add(string.toString());
        }


        for (String uniqueString : uniqueSortedString) {
            List<String> set = new ArrayList<>();
            for (int i = 0; i < sortedString.size(); i++) {
                if (sortedString.get(i).equals(uniqueString)) {
                    set.add(strs[i]);
                }
            }
            returnValue.add(set);
        }

        return returnValue;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
