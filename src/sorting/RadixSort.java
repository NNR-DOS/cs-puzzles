package sorting;

import java.util.*;

public class RadixSort {

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp, HashMap<Integer, Queue<Integer>> buckets) {
        int[] output = new int[n];
        int counter = 0;

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            Queue<Integer> thisQueue = buckets.get((arr[i] / exp) % 10);
            thisQueue.offer(arr[i]);
        }

        for (int i = 0; i< buckets.size(); i++) {
            Queue<Integer> thisQueue = buckets.get(i);
            for (int integer : thisQueue) {
                output[counter] = integer;
                counter++;
            }
            buckets.get(i).clear();
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int[] arr) {

        HashMap<Integer, Queue<Integer>> buckets = new HashMap<>();

        for (int i =0; i< 10; i++) {
            buckets.put(i, new LinkedList<>());
        }


        // Find the maximum number to know number of digits
        int m = getMax(arr, arr.length);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, arr.length, exp, buckets);
    }


    public static void main(String[] args) {
        int[] input = {181, 51, 11, 33, 11, 39, 60, 2, 27, 24, 12};
        radixSort(input);
        System.out.println(Arrays.toString(input));
    }
}

/*
public class RadixSort {

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int[] arr) {




        // Find the maximum number to know number of digits
        int m = getMax(arr, arr.length);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, arr.length, exp);
    }


    public static void main(String[] args) {
        int[] input = {181, 51, 11, 33, 11, 39, 60, 2, 27, 24, 12};
        radixSort(input);
        System.out.println(Arrays.toString(input));
    }
}
 */
