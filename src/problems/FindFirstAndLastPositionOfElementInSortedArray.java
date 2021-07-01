package problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {

        int counter = 0;
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] == target) {
                counter++;
            }
            i += 1;
        }

        if (counter == 0) {
            return new int[]{-1, -1};
        }

        i = 0;
        int copy = 0;

        if (counter == 1) {
            int[] returnIntArray = new int[2];
            while (i < nums.length) {
                if (nums[i] == target) {
                    returnIntArray[j] = i;
                    returnIntArray[j + 1] = i;
                    j += 1;
                }
                i += 1;
            }
            return returnIntArray;

        } else {
            int[] returnIntArray = new int[2];
            while (i < nums.length) {
                if (nums[i] == target && copy == 0 || copy + 1 == counter) {
                    returnIntArray[j] = i;
                    j += 1;
                }
                if (nums[i] == target) {
                    copy++;
                }
                i += 1;
            }
            return returnIntArray;
        }
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[i] == target) {
//                returnIntArray[i] = i;
//                while (true) {
//                    if (nums[i++] == target) {
//                        returnIntArray[i++] = i++;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3};
        System.out.print(Arrays.toString(searchRange(nums, 3)));
    }
}
