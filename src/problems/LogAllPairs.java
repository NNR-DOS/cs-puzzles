package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogAllPairs {


    public static List< List<Integer>> logPairs(int[] array) {
        List< List<Integer>> integerList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                List<Integer> newPair = new ArrayList<>();
                newPair.add(i);
                newPair.add(j);
                integerList.add(newPair);
            }
        }
        return integerList;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(logPairs(array));
    }
}
