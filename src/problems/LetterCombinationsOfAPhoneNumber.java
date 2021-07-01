package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> returnList = new ArrayList<>();

        HashMap<String, String> phone = new HashMap<>();

        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        /*
        If there are no more digits in the string, return output

        else get digit

        get digits letters

        for as many letters in the digit's letters
        add letter to a string

        increment the substring

        backTrack with both
         */

        if (digits.length() != 0) {
            backtrack(returnList, phone, "", digits);
        }
        return returnList;
    }

    public static void backtrack(List<String> returnList, HashMap<String, String> phone, String combination, String digits) {

        if (digits.length() == 0) {
            returnList.add(combination);
        } else {

            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                backtrack(returnList, phone, combination + letter, digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        String digits = "222";
        System.out.println(letterCombinations(digits));
    }
}

