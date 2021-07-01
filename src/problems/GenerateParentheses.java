package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static List<String> res;

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0 , n);
        return res;
    }

    public static void backtrack(List<String> res, String s, int open, int close, int max) {

        if (s.length() == max * 2) {
            res.add(s);
            return;
        }

        if (open < max) {
            backtrack(res, s + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(res, s + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}


/*
1. OUR CHOICE?
DO I OPEN A PARENTHESES OR DO I CLOSE A PARENTHESES?

2. OUR CONSTRAINTS?
OPEN BRACKET MUST BE CLOSED BY THE SAME TYPE OF BRACKET
I CANNOT CLOSE A PARENTHESES WITHOUT HAVING AN OPEN PARENTHESES

3. OUR GOAL?
FINAL LENGTH OF OUR STRINGS ARE N*2
AT THIS LENGTH WE ADD TO ARRAY AND THEN RECURSE


/*
        if (open == 0 && close == 0) res.add(s);
        if (open > 0) backtracking(s + "(", open - 1, close);
        if (open < close) backtracking(s + ")", open, close - 1);
 */

/*
        res = new ArrayList<>();
        backtracking("", n, n);
        return res;
 */
