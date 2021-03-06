package sorting;

import java.util.Scanner;

public class QuickSort {

    public static int[] quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    public static void quickSort(int[] numbers, int wall, int pivot) {

        int wallPrevious = wall;

        if (pivot - wall == 0 || pivot < 0 || wall > pivot) {
            return;
        }

        for (int i = wall; i < pivot; i++) {
            if (numbers[i] < numbers[pivot]) {
                swap(numbers, wall, i);
                wall++;
            }
        }

        swap(numbers, wall, pivot);
        print(numbers);
        quickSort(numbers, wallPrevious, wall - 1);
        quickSort(numbers, wall + 1, pivot);
    }

    public static void swap(int[] numbers, int wall, int i) {
        int numberAtWall = numbers[wall];
        int numberAtI = numbers[i];
        numbers[wall] = numberAtI;
        numbers[i] = numberAtWall;
    }

    public static void print(int[] numbers) {
        for (int integer : numbers) {
            System.out.print(integer + "" + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfNums = sc.nextInt();
        int[] nums = new int[numberOfNums];
        for (int i = 0; i < numberOfNums; i++) {
            nums[i] = sc.nextInt();

        }
        quickSort(nums);
    }

}

/*
    // is used in "medianOfThree" function
    public static void selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            // i points at first number behind "wall"
            int indexOfSmallest = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            // swap
            int temp = input[i];
            input[i] = input[indexOfSmallest];
            input[indexOfSmallest] = temp;
        }
    }

    // this function can be used for "quickSort call" where you only pass array
    // it generates "from" and "to" parameters
    public static void quickSortExecutor(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int from, int to) {
        if (from < to) {
            int indexOfPivot = partition(input, from, to);
            quickSort(input, from, indexOfPivot - 1);
            quickSort(input, indexOfPivot + 1, to);
        }
    }

    public static int partition(int[] input, int from, int to) {
        int pivot = input[to];
        int wall = from;
        for (int i = from; i < to; i++) {
            if (input[i] <= pivot) {
                int temp = input[wall];
                input[wall] = input[i];
                input[i] = temp;
                wall++;
            }
        }
        input[to] = input[wall];
        input[wall] = pivot;

        return wall;
    }

    // this function can be used for "quickSortAverage call" where you only pass array
    // it generates "from" and "to" parameters
    public static void quickSortMedianExecutor(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSortMedian(int[] input, int from, int to) {
        if (from < to) {
            int indexOfPivot = partitionMedian(input, from, to);
            quickSort(input, from, indexOfPivot - 1);
            quickSort(input, indexOfPivot + 1, to);
        }
    }

    public static int medianOfThree(int[] input, int first, int middle, int last) {
        int[] array = {input[first], input[middle], input[last]};
        selectionSort(array);
        if (array[1] == input[first]) {
            return first;
        } else if (array[1] == input[middle]) {
            return middle;
        } else {
            return last;
        }
    }

    public static int partitionMedian(int[] input, int from, int to) {
        int indexOfPivot = medianOfThree(input, from, (from + to) / 2, to);
        int pivot = input[indexOfPivot];
        if (indexOfPivot != to) {
            input[indexOfPivot] = input[to];
            //input[to] = pivot;
        }
        int wall = from;
        for (int i = from; i < to; i++) {
            if (input[i] <= pivot) {
                int temp = input[wall];
                input[wall] = input[i];
                input[i] = temp;
                wall++;
            }
        }
        input[to] = input[wall];
        input[wall] = pivot;

        return wall;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //initialize
        int[] input = {10, 8, 1, 88, 64, 21, 19, 4, 3, 2};
        int[] inputMedian = input;

        // sort
        quickSortExecutor(input);
        quickSortMedianExecutor(inputMedian);

        // print
        printArray(input);
        printArray(inputMedian);
    }
 */
