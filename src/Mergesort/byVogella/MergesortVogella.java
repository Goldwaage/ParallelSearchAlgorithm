package Mergesort.byVogella;

import java.util.*;
import java.util.logging.Logger;

/**
 * This class is an implementation of the mergesort algortihm from Lars Vogel by vogella.com
 * (http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html#mergesort_implementation).
 *
 *
 * @author Lars Vogel
 * @author Marc Kasper (german comments)
 */
public class MergesortVogella {

    private static Logger LOGGER = Logger.getLogger(MergesortVogella.class.getName());

    private int[] numbers;
    private int[] helper;

    private int number;


    public void sort(int[] values) {

        //LOGGER.info("Sorting sequential by Vogella");

        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    /**
     * Diese Methode wendet den MergesortVogella Algorithmus rekursiv auf das übergebene Intervall der zu
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
}