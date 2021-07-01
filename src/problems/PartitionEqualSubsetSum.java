//package com.company;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class PartitionEqualSubsetSum {
//
//    public static boolean canPartition(int[] nums) {
//
//        if (sum(nums) % 2 != 0) {
//            return false;
//        }
//
//        List<List<Integer>> visited = new ArrayList<>();
//        for (int k = 0; k < nums.length; k++) {
//            for (int h = 0; h < nums.length; h++) {
//                int[] copy;
//                copy = swap(nums, k, h);
//                List<Integer> integerList = new ArrayList<>();
//                for (int ints : copy) {
//                    integerList.add(ints);
//                }
//                if (!visited.contains(integerList)) {
//                    visited.add(integerList);
//                    for (int i = 0; i < copy.length; i++) {
//                        int firstSetFinalIndex = i + 1;
//                        int secondSetFinalIndex = copy.length;
//                        if (subsetSum(nums, 0, firstSetFinalIndex) == subsetSum(nums, firstSetFinalIndex, secondSetFinalIndex)) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public static int sum(int[] arr) {
//        int total = 0;
//        for (int integer : arr) {
//            total += integer;
//        }
//        return total;
//    }
//
//    public static int subsetSum(int[] arr, int start, int end) {
//        int total = 0;
//        for (int i = start; i < end; i++) {
//            total += arr[i];
//        }
//        return total;
//    }
//
//    public static int[] swap(int[] copy, int thisOne, int thatOne) {
//        List<Integer> integerList = new ArrayList<>();
//        for (int ints : copy) {
//            integerList.add(ints);
//        }
//        Collections.swap(integerList, thisOne, thatOne);
//        for (int i = 0; i < integerList.size(); i++) {
//            copy[i] = integerList.get(i);
//        }
//        return copy;
//    }
//
//    public static void main(String[] args) {
//        //int[] nums = {5, 62, 97, 69, 93, 69, 85, 68, 75, 83, 5, 10, 56, 24, 35, 76, 53, 80, 2, 20, 3, 2, 22, 81, 100, 41, 17, 29, 36, 40, 93, 45, 51, 88, 4, 77, 81, 64, 39, 69, 38, 4, 66, 64, 13, 31, 26, 64, 95, 63, 15, 35, 68, 91, 54, 19, 1, 62, 37, 19, 49, 87, 67, 53, 1, 45, 32, 62, 82, 4, 20, 15, 54, 29, 4, 65, 53, 52, 61, 56, 71, 53, 93, 29, 91, 79, 3, 75, 79, 38, 79, 100, 52, 88, 99, 82, 67, 86, 12, 54};
//        int[] nums = {1, 2, 3, 5};
//
//
//        // [2,2,2,2,4,4] [1]
//
//        System.out.println(canPartition(nums));
//    }
//}
