package problems;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        HashMap<Character, Character> hashMap = new HashMap<>();

        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char chars : charArray) {
            if (!stack.isEmpty()) {
                if (hashMap.get(chars) == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(chars);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}{{{{{"));
    }
}
