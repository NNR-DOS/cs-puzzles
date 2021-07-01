package problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {

    static List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {
        List<String> oldBoxes = new ArrayList<>();
        List<String> newBoxes = new ArrayList<>();
        for (String s : boxList) {
            String[] x = s.split(" ");
            if (Character.isDigit(x[1].toCharArray()[0])) {
                newBoxes.add(s);
            }
            if (!Character.isDigit(x[1].toCharArray()[0])) {
                oldBoxes.add(s);
            }
        }
        Collections.sort(oldBoxes);
        System.out.println(newBoxes);
        return Stream.of(oldBoxes, newBoxes)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> boxList;
        boxList = Arrays.asList(
                "ykc 82 01",                        //"09z cat hamster"
                "eo first qpx",                     //"236 cat dog rabbit snake"
                "09z cat hamster",                  //"eo first qpx"
                "06f 12 25 6",                      //"az0 first qpx"
                "az0 first qpx",                    //"06f 12 25 6"
                "236 cat dog rabbit snake");        //"ykc 82 01"
        System.out.println(orderedJunctionBoxes(6, boxList));

    }
}
