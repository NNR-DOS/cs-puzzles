package problems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        boolean goingDown = false;
        int currentRow = 0;

        StringBuilder letters = new StringBuilder();

        letters.append(s.toCharArray());

        for (int i = 0; i < letters.length(); i++) {
            list.get(currentRow).append(letters.charAt(i));

            if (currentRow == 0 || currentRow == list.size() - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder returnString = new StringBuilder();

        for (StringBuilder row : list) {
            returnString.append(row);
        }

        return returnString.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AA", 1));
    }
}

