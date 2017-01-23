package Mergesort;

// @TODO import Logger and implemented the logger in the Mergesort class

import java.util.*;

/**
 * This class is an implementation of the mergesort algortihm from Lars Vogel by vogella.com
 * (http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html#mergesort_implementation).
 *
 *
 * @author Lars Vogel
 */
public class Mergesort {

    private static final Random RAND = new Random(42);   // random number generator

    // @TODO algo ueberarbeiten, dokumentieren, verstehen
    private int[] numbers;
    private int[] helper;

    private int number;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        MergesortThreaded2 ms = MergesortThreaded2.class.newInstance();

        String sortedSet = "";

        int LENGTH = 1000;   // initial length of array to sort
        int RUNS   =  10;   // how many times to grow by 2?

        for (int i = 1; i <= RUNS; i++) {
            int[] a = createRandomArray(LENGTH);

            // run the algorithm and time how long it takes
            long startTime1 = System.currentTimeMillis();
            ms.sort(a);
            long endTime1 = System.currentTimeMillis();

            if (!isSorted(a)) {
                throw new RuntimeException("not sorted afterward: " + Arrays.toString(a));
            }

            System.out.printf("%10d elements  =>  %6d ms \n", LENGTH, endTime1 - startTime1);
            LENGTH *= 2;   // double size of array for next time
        }
//        int[] mixed = { 3, 6, 4, 34, 23, 78, 42, 5, 7, 1,
//                11, 354, 245, 67, 68, 65, 99, 22, 700, 55,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                3, 6, 4, 34, 23, 78, 42, 5, 7, 1,
//                11, 354, 245, 67, 68, 65, 99, 22, 700, 55,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                3, 6, 4, 34, 23, 78, 42, 5, 7, 1,
//                11, 354, 245, 67, 68, 65, 99, 22, 700, 55,      // 10
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                3, 6, 4, 34, 23, 78, 42, 5, 7, 1,
//                11, 354, 245, 67, 68, 65, 99, 22, 700, 55,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                3, 6, 4, 34, 23, 78, 42, 5, 7, 1,
//                11, 354, 245, 67, 68, 65, 99, 22, 700, 55,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,   //20
//                3, 6, 4, 34, 23, 78, 42, 5, 7, 1,
//                11, 354, 245, 67, 68, 65, 99, 22, 700, 55,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123,
//                56, 88, 87, 900, 500, 111, 26, 444, 777, 123};

//        for (int counter = 0; counter < mixed.length; counter++) {
//
//            sortedSet +=  mixed[counter] + ", ";
//        }
//
//        System.out.println("Array: " + sortedSet.substring(0, sortedSet.length()-1));
//
//        sortedSet = "";
//
//        long startTime = System.currentTimeMillis();
//        ms.sort(mixed);
//        long endTime = System.currentTimeMillis();
//
//        for (int counter = 0; counter < mixed.length; counter++) {
//
//            sortedSet += mixed[counter] + ", ";
//        }
//
//        System.out.println("Array (sorted): " + sortedSet.substring(0, sortedSet.length()-1));
//        System.out.println("Laufzeit: " + (endTime - startTime));
    }

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    /**
     * Diese Methode wendet den Mergesort Algorithmus rekursiv auf das übergebene Intervall der zu
     * sortierenden Menge an.
     *
     * @param low der untere / linke Teil der zu sortierenden Ausgangsmenge
     * @param high der obere / rechte Teil der zu sortierenden Ausgangsmenge
     */
    private void mergesort(int low, int high) {

        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }

    // Returns true if the given array is in sorted ascending order.
    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Creates an array of the given length, fills it with random
    // non-negative integers, and returns it.
    public static int[] createRandomArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RAND.nextInt(1000000);
            // a[i] = RAND.nextInt(40);
        }
        return a;
    }
}