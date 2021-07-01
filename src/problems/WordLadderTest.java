package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderTest {

    public static int minimumNumberOfTransformations(String beginWord, String endWord, List<String> wordList) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabetChars = alphabet.toCharArray();
        Queue<String> stringQueue = new LinkedList<>();
        HashSet<String> strings = new HashSet<>();
        strings.addAll(wordList);
        stringQueue.offer(beginWord);
        int level = 1;

        while (!stringQueue.isEmpty()) {
            int size = stringQueue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = stringQueue.poll();
                char[] currentWordChars = currentWord.toCharArray();
                for (int j = 0; j < currentWordChars.length; j++) {
                    char originalCharacter = currentWordChars[j];
                    for (int k = 0; k < alphabetChars.length; k++) {
                        currentWordChars[j] = alphabetChars[k];
                        String testWord = String.valueOf(currentWordChars);
                        if (testWord.equals(currentWord)) {
                            continue;
                        }
                        if (testWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (strings.contains(testWord)) {
                            stringQueue.offer(testWord);
                            strings.remove(testWord);
                        }
                    }
                    currentWordChars[j] = originalCharacter;
                }
            }
            level++;
        }
        return 0;
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(minimumNumberOfTransformations("hit", "cog", wordList));

    }
}
