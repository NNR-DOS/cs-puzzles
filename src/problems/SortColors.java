package problems;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int red = 0;
        int white = 0;
        int blue = 0;

        for (int color : nums) {
            if (color == 0) {
                red++;
            }
            if (color == 1) {
                white++;
            }
            if (color == 2) {
                blue++;
            }
        }

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int i = red; i < white + red; i++) {
            nums[i] = 1;
        }

        for (int i = white + red; i < red + white + blue; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
