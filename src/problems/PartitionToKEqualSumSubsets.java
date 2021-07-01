package problems;

import java.util.*;

public class PartitionToKEqualSumSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sumNeededInEachBucket = Arrays.stream(nums).sum() / k;
        boolean[] visited = new boolean[nums.length];
        int[] buckets = new int[k];
        if (Arrays.stream(nums).sum() % k != 0) {
            return false;
        }
        return backtrack(nums, buckets, visited, sumNeededInEachBucket, 0, nums.length - 1);
    }

    public static boolean backtrack(int[] nums, int[] buckets, boolean[] visited, int sumNeededInEachBucket, int currentBucket, int workingIndex) {
        if (buckets[currentBucket] == sumNeededInEachBucket) {
            if (currentBucket == buckets.length - 1) {
                return true;
            }
            return backtrack(nums, buckets, visited, sumNeededInEachBucket, currentBucket + 1, nums.length - 1);
        }

        for (int j = workingIndex; j >= 0; j--) {
            if (buckets[currentBucket] < sumNeededInEachBucket) {
                if (visited[j]) {
                    continue;
                }
                if (buckets[currentBucket] + nums[j] <= sumNeededInEachBucket) {
                    buckets[currentBucket] += nums[j];
                    visited[j] = true;
                    boolean routeIsPossible = backtrack(nums, buckets, visited, sumNeededInEachBucket, currentBucket, workingIndex - 1);
                    buckets[currentBucket] -= nums[j];
                    visited[j] = false;
                    if (routeIsPossible) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        /*
        [2,2,2,2,3,4,5]
4

        [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
1

        [4,16,5,3,10,4,4,4,10]
3

        [4,3,2,3,5,2,1]
4
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

        int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
        int k = 3;

        [10,10,10,7,7,7,7,7,7,6,6,6] 3

         */

        int[] nums = {2, 2, 2, 2, 3, 4, 5};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }
}
