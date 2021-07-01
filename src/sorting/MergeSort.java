package sorting;

public class MergeSort {

    // this function can be used for "mergeSort call" where you only pass array
    // it generates "from" and "to" parameters
    public static void mergeSort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
    }

    public static void mergeSort(int[] numbers, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(numbers, start, middle);
            mergeSort(numbers, middle + 1, end);
            mergeSort(numbers, start, middle, end);
        }
    }

    public static void mergeSort(int[] numbers, int start, int middle, int end) {
        int lengthLeft = middle - start + 1;
        int lengthRight = end - middle;
        int[] leftPartition = new int[lengthLeft + 1];
        int[] rightPartition = new int[lengthRight + 1];

        for (int i = 0; i < lengthLeft; i++) {
            leftPartition[i] = numbers[start + i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightPartition[i] = numbers[middle + i + 1];
        }
        leftPartition[lengthLeft] = Integer.MAX_VALUE;
        rightPartition[lengthRight] = Integer.MAX_VALUE;

        int leftPointer = 0;
        int rightPointer = 0;
        for (int i = start; i <= end; i++) {
            if (leftPartition[leftPointer] > rightPartition[rightPointer]) {
                numbers[i] = rightPartition[rightPointer];
                rightPointer++;
            } else {
                numbers[i] = leftPartition[leftPointer];
                leftPointer++;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {10, 8, 1, 88, 64, 21, 19, 4, 3, 2};
        mergeSort(input);
        printArray(input);
    }
}


