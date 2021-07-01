package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        return compare(intervals);
    }

    private static int[][] merge(int[][] intervals, int[] first, int[] second) {
        List<int[]> integerList = new ArrayList<>();
        int[] merge = new int[2];
        merge[0] = Math.min(first[0], second[0]);
        merge[1] = Math.max(first[1], second[1]);
        integerList.add(merge);
        for (int[] interval : intervals) {
            if (interval != first && interval != second) {
                integerList.add(interval);
            }
        }
        int[][] newIntervalSetFinal = new int[integerList.size()][];
        for (int i = 0; i < newIntervalSetFinal.length; i++) {
            newIntervalSetFinal[i] = integerList.get(i);
        }
        return newIntervalSetFinal;
    }

    private static int[][] compare(int[][] intervals) {
        for (int[] ints : intervals) {
            for (int[] interval : intervals) {
                if (ints != interval) {
                    if (ints[1] >= interval[0] && ints[0] <= interval[0]) {
                        int[][] newIntervals = merge(intervals, ints, interval);
                        return compare(newIntervals);
                    }
                }
            }
        }
        return intervals;
    }

    public static void main(String[] args) {

        /*
        Example 1:

        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
        Example 2:

        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

        int[][] intervals = {{1,4},{0,2},{3,5}}
         */

        /*
        Input
       int[][] intervals = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        Output
        [[2,4],[5,5],[2,2]]
        Expected
        [[2,4],[5,5]]
         */

        //int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        //int[][] intervals = {{0, 4}, {1, 4}};

        //int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};

        //int[][] intervals = {{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};

        int[][] intervals = {{1, 4}, {2, 3}};

        System.out.println(Arrays.deepToString(merge(intervals)));

    }
}
