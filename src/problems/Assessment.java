package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Assessment {

    public static int minimumTime(int numOfParts, List<Integer> parts) {

        int minimumTime = 0;

        for (int i = 0; i < numOfParts-1; i++) {
            Collections.sort(parts);
            int integer = parts.get(0) + parts.get(1);
            minimumTime += integer;
            parts.remove(0);
            parts.remove(0);
            parts.add(integer);
        }
        return minimumTime;
    }


    public static void main(String[] args) {

        List<Integer> parts = new ArrayList<>();

        parts.add(8);
        parts.add(4);
        parts.add(6);
        parts.add(12);
        parts.add(3);
        parts.add(7);

        /*
        7
        13
        15
        25
        40
         */

        /*
        15, 25

         */

        System.out.println(minimumTime(6, parts));
    }
}
