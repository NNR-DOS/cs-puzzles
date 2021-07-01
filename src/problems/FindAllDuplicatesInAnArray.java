package problems;

import java.util.*;

public class FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int integer : nums) {
            if (hashSet.contains(integer)) {
                duplicates.add(integer);
            }
            hashSet.add(integer);
        }
        return duplicates;
    }

    public static void main(String[] args) {
        /*
        Input:
        [4,3,2,7,8,2,3,1]

        Output:
        [2,3]
         */

        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(findDuplicates(nums));
    }
}
