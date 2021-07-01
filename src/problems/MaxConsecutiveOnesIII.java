//package com.company;
//
//public class MaxConsecutiveOnesIII {
//
//    public static int longestOnes(int[] A, int K) {
//        int max = 0;
//        int count = 0;
//        max = count(A, max, count, 0, 0, K, K);
//        return max;
//    }
//
//    public static int count(int[] array, int max, int count, int lastWorkingIndex, int startingPosition, int numberIndexesYouCanFlip, int currentNumberIndexesYouCanFlip) {
//        if (startingPosition == array.length - 1) {
//            return max;
//        }
//
//        for (int i = startingPosition; i < array.length; i++) {
//            if (array[i] == 1) {
//                count++;
//                max = Math.max(count, max);
//                continue;
//            }
//            if (array[i] == 0 && numberIndexesYouCanFlip != 0) {
//                count++;
//                max = Math.max(count, max);
//                numberIndexesYouCanFlip--;
//                continue;
//            }
//            if (numberIndexesYouCanFlip == 0) {
//                numberIndexesYouCanFlip = currentNumberIndexesYouCanFlip;
//                return count(array, max, 0, lastWorkingIndex + 1, lastWorkingIndex + 1, numberIndexesYouCanFlip, currentNumberIndexesYouCanFlip);
//            }
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//
//        /*
//        Example 1:
//
//        Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        Output: 6
//        Explanation:
//        [1,1,1,0,0,'1,1,1,1,1,1']
//        Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
//
//        Example 2:
//
//        Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//        Output: 10
//        Explanation:
//        [0,0,'1,1,1,1,1,1,1,1,1,1',0,0,0,1,1,1,1]
//        Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
//         */
//
//        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
//        int K = 2;
//
//        System.out.println(longestOnes(A, K));
//    }
//}
