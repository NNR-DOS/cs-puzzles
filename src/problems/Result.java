package problems;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

//    /*
//     * Complete the 'addNumbers' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. FLOAT a
//     *  2. FLOAT b
//     */
//
//    public static int addNumbers(float a, float b) {
//        int result = 0;
//        return (int) Math.floor(a + b);
//    }
//
//    public static String winner(String erica, String bob) {
//        char[] ericaCharArray = erica.toCharArray();
//        char[] bobCharArray = bob.toCharArray();
//
//        int ericaScore = 0;
//        int bobScore = 0;
//
//        for (char charE : ericaCharArray) {
//            if (charE == 'E') {
//                ericaScore += 1;
//            }
//            if (charE == 'M') {
//                ericaScore += 3;
//            }
//            if (charE == 'H') {
//                ericaScore += 5;
//            }
//        }
//
//        for (char charB : bobCharArray) {
//            if (charB == 'E') {
//                bobScore += 1;
//            }
//            if (charB == 'M') {
//                bobScore += 3;
//            }
//            if (charB == 'H') {
//                bobScore += 5;
//            }
//        }
//
//        if (ericaScore > bobScore) {
//            return "Erica";
//        }
//        if (bobScore > ericaScore) {
//            return "Bob";
//        }
//
//        return "Tie";
//    }
//
//}
//
//class Comparator {
//    public boolean compare(int a, int b) {
//        return a == b;
//    }
//
//    public boolean compare(String a, String b) {
//        return a.equals(b);
//    }
//
//    public boolean compare(int[] a, int[] b) {
//
//        if (a.length == b.length) {
//            for (int i = 0; i < a.length; i++) {
//                if (a[i] != b[i]) {
//                    return false;
//                }
//            }
//        }
//
//        return a.length == b.length;
//    }
//}

    static class SortByName implements Comparator<List<String>> {
        public int compare(List<String> a, List<String> b) {
            return a.get(0).compareTo(b.get(0));
        }
    }

    static class SortByRelevance implements Comparator<List<String>> {
        public int compare(List<String> a, List<String> b) {
            return a.get(1).compareTo(b.get(1));
        }
    }

    static class SortByPrice implements Comparator<List<String>> {
        public int compare(List<String> a, List<String> b) {
            return a.get(2).compareTo(b.get(2));
        }
    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here

        if (sortOrder == 0) {
            if (sortParameter == 0) {
                items.sort(new SortByName());
            }

            if (sortParameter == 1) {
                items.sort(new SortByRelevance());
            }

            if (sortParameter == 2) {
                items.sort(new SortByPrice());
            }
        }

        if (sortOrder == 1) {
            if (sortParameter == 0) {
                items.sort(new SortByName().reversed());
            }

            if (sortParameter == 1) {
                items.sort(new SortByRelevance().reversed());
            }

            if (sortParameter == 2) {
                items.sort(new SortByPrice().reversed());
            }
        }

        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < items.size(); i++) {
            List<String> pageList = new ArrayList<>();
            for (int j = 0; j < items.size(); j++) {
                pageList.add(items.get(i).get(0));
                items.remove(i);
            }
            map.put(i, pageList);
        }

        return map.get(pageNumber);
    }
}


/*
SELECT SUPERHERO.NAME FROM SUPERHERO WHERE LEN(SUPERHERO.NAME) > 4 ORDER BY SUPERHERO.ID DESC
 */

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> items = new ArrayList<>();

        IntStream.range(0, itemsRows).forEach(i -> {
            try {
                items.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());

        int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());

        int itemsPerPage = Integer.parseInt(bufferedReader.readLine().trim());

        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
