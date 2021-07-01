package problems;

import java.util.*;
import java.util.LinkedList;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        char[] alphabetChars = alphabet.toCharArray();

        Queue<String> strings = new LinkedList<>();

        HashSet<String> set = new HashSet<>(wordList);

        int level = 1;

        strings.offer(beginWord);


        while (!strings.isEmpty()) {
            int size = strings.size();
            for (int i = 0; i < size; i++) {
                String current = strings.poll();
                char[] currentChars = current.toCharArray();
                for (int j = 0; j < currentChars.length; j++) {
                    char orginalCharacter = currentChars[j];
                    for (int k = 0; k < alphabetChars.length; k++) {
                        currentChars[j] = alphabetChars[k];
                        String test = String.valueOf(currentChars);
                        if (test.equals(current)) {
                            continue;
                        }
                        if (test.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(test)) {
                            strings.offer(test);
                            set.remove(test);
                        }
                    }
                    currentChars[j] = orginalCharacter;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {

        /*
        Example 1:

        Input:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        Output: 5

        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        return its length 5.
        Example 2:

        Input:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        Output: 0

        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
         */

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
