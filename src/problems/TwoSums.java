package problems;

import java.util.Arrays;

public class TwoSums {

    public static int[] twoSum(int[] nums, int target) {
        int[] returnIndices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (addIndices(nums[i], nums[j]) == target) {
                    returnIndices[0] = i;
                    returnIndices[1] = j;
                    return returnIndices;
                }
            }
        }
        return returnIndices;
    }

    public static int addIndices(int indexOne, int indexTwo) {
        return indexOne + indexTwo;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 26)));
    }
}
