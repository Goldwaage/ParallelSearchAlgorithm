package Mergesort;


import Mergesort.byUniversityWashington.MergesortUniversityWashington;
import Mergesort.byUniversityWashington.JavaThreads.MergesortUniversityWashingtonThreaded;
import Mergesort.byVogella.MergesortVogella;
import Mergesort.byVogella.JavaThreads.MergesortVogellaThreaded;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This class evaluate the different versions of mergesort implementations. We are interest for the runningtime
 * of the algorithms in sequential and each parallel implementation.
 *
 * @author Marc Kasper
 */
public class EvaluateMergesort {


    /* Constants */

    /** The number of elements in the array of investigation. */
    private final static int ARRAY_SIZE = 10000;

    /* --- Classvariables --- */

    /** The logger of these instance for debugging outputs */
    private static Logger LOGGER = Logger.getLogger(EvaluateMergesort.class.getName());

    /** Instance of sequential mergesort algorithm by Vogella. */
    private static MergesortVogella msVogella = new MergesortVogella();

    /** Instance of parallel mergesort algorithm based on the Version by Vogella implemented with java threads. */
    private static MergesortVogellaThreaded msVogellaJThreads = new MergesortVogellaThreaded();

    /** Instance of parallel mergesort algorithm based on the Version by Vogella implemented with openMP. */
    // @ToDo declare the classvariable:
    // private static MergesortVogellaOMP msVogellaOMP
    // = new MergesortVogellaOMP();

//    /** Instance of sequential mergesort algorithm by the University of Washington. */
//    private static MergesortUniversityWashington msUniversitiyWashington= new MergesortUniversityWashington();
//
//    /** Instance of parallel mergesort algorithm based on the Version of the University of Washington implemented
//     * with java threads. */
//    private static MergesortUniversityWashingtonThreaded msUniversityWashingtonJThreads =
//            new MergesortUniversityWashingtonThreaded();
//
//    /** Instance of parallel mergesort algorithm based on the Version of the University of Washington implemented
//     * with openMP. */
//    // @ToDo declare the classvariable:
//    // private static MergesortUniversityWashingtonOMP msUniversityWashingtonOMP
//    // = new MergesortUniversityWashingtonOMP();

    /** The unsorted array which will be sort by each mergesort implementation. */
    private static int[] numbers = new int[ARRAY_SIZE];


    /* --- Implementation --- */

    /**
     * The main method.
     */
    public static void main(String[] args) {

        System.out.println("In this testrun the squenz has " + ARRAY_SIZE + " Elements.\n");
        // evaluate Mergesort Vogella
        evaluateMergesortVogella();

        // evaluate Mergesort Vogella with Java Threads
        evaluateMergesortVogellaThreaded();

        // evaluate Mergesort Vogella with openMP
//        evaluateMergesortVogellaOpenMP();

        // evaluate Mergesort University Washington
        evaluateMergesortUniversityWashington();

        // evaluate Mergesort University Washington with Java Threads
        evaluateMergesortUniversityWashingtonThreaded();

        // evaluate Mergesort University Washington with openMP
//        evaluateMergesortUniversityWashingtonOpenMP();
    }


    /**
     * This method evaluate the time which the sequential Mergesort by Vogella needs to sort a sequence.
     *
     */
    private static void evaluateMergesortVogella() {

        // LOGGER.info("evaluating sequential Mergesort by Vogella");

        // The time before start to sort.
        long startTime;

        // The time after sort.
        long endTime;

        // generate sorted array
        numbers = generateSortedArray(ARRAY_SIZE);
        //System.out.println("Array (unsortiert): " + arrayToString(numbers));

        // get array to evaluate
        generateWorstUnsortArray(numbers);
        //System.out.println("Array (unsortiert): " + arrayToString(numbers));

        // get systemtime before sorting
        startTime = System.currentTimeMillis();

        // sort
        msVogella.sort(numbers);

        // get systemtime after sorting
        endTime = System.currentTimeMillis();

        // show the result of the sorting process
        System.out.println("\n- Sortierergebnis: Sequential (Vogella) -");
        System.out.println("Die sortierte Folge lautet: " + arrayToString(numbers));
        System.out.printf("Für die Sortierung wurden %d ms benötigt", endTime - startTime);
        System.out.println("\n------------------------------------------------\n");
    }

    /**
     * This method evaluate the time which the parallel Mergesort implementation with Java Threads based on
     * the Vogella-Version needs to sort a sequence.
     *
     */
    private static void evaluateMergesortVogellaThreaded() {

        // LOGGER.info("evaluating parallel mergesort with Java Threads based on the Vogella version");

        // The time before start to sort.
        long startTime;

        // The time after sort.
        long endTime;

        // generate sorted array
        numbers = generateSortedArray(ARRAY_SIZE);

        // get array to evaluate
        generateWorstUnsortArray(numbers);

        // get systemtime before sorting
        startTime = System.currentTimeMillis();

        // sort
        msVogellaJThreads.sort(numbers);

        // get systemtime after sorting
        endTime = System.currentTimeMillis();

        // show the result of the sorting process
        System.out.println("\n- Sortierergebnis: Java Threads (Vogella) -");
        System.out.println("Die sortierte Folge lautet: " + arrayToString(numbers));
        System.out.printf("Für die Sortierung wurden %d ms benötigt", endTime - startTime);
        System.out.println("\n------------------------------------------------\n");
    }

    /**
     * This method evaluate the time which the parallel mergesort implementation with OpenMP based on
     * the Vogella-Version needs to sort a sequence.
     *
     */
    private static void evaluateMergesortVogellaOpenMP() {

        // LOGGER.info("evaluating parallel mergesort with OpenMP based on the Vogella version");

        // The time before start to sort.
        long startTime;

        // The time after sort.
        long endTime;

        // generate sorted array
        numbers = generateSortedArray(ARRAY_SIZE);

        // get array to evaluate
        generateWorstUnsortArray(numbers);

        // get systemtime before sorting
        startTime = System.currentTimeMillis();

        // sort @TODO
        //msVogellaOMP.sort(numbers);

        // get systemtime after sorting
        endTime = System.currentTimeMillis();

        // show the result of the sorting process
        System.out.println("\n- Sortierergebnis: OpenMP (Vogella) -");
        System.out.println("Die sortierte Folge lautet: " + arrayToString(numbers));
        System.out.printf("Für die Sortierung wurden %d ms benötigt", endTime - startTime);
        System.out.println("\n------------------------------------------------\n");
    }

    /**
     * This method evaluate the time which the sequential mergesort by the University of Washington needs.
     *
     */
    private static void evaluateMergesortUniversityWashington() {

        // LOGGER.info("evaluating sequential mergesort by the University of Washington");

        // The time before start to sort.
        long startTime;

        // The time after sort.
        long endTime;

        // generate sorted array
        numbers = generateSortedArray(ARRAY_SIZE);

        // get array to evaluate
        generateWorstUnsortArray(numbers);

        // get systemtime before sorting
        startTime = System.currentTimeMillis();

        // sort
        MergesortUniversityWashington.parallelMergeSort(numbers);

        // get systemtime after sorting
        endTime = System.currentTimeMillis();

        // show the result of the sorting process
        System.out.println("\n- Sortierergebnis: Sequential (University Washington) -");
        System.out.println("Die sortierte Folge lautet: " + arrayToString(numbers));
        System.out.printf("Für die Sortierung wurden %d ms benötigt", endTime - startTime);
        System.out.println("\n------------------------------------------------\n");
    }

    // evaluate Mergesort University Washington with Java Threads
    /**
     * This method evaluate the time which the parallel mergesort implementation with Java Threads based on
     * the Version by the Univeraity of Washington needs to sort a sequence.
     *
     */
    private static void evaluateMergesortUniversityWashingtonThreaded() {

        // LOGGER.info("evaluating parallel mergesort with Java Threads based on the version of the University
        //              of Washington");

        // The time before start to sort.
        long startTime;

        // The time after sort.
        long endTime;

        // generate sorted array
        numbers = generateSortedArray(ARRAY_SIZE);

        // get array to evaluate
        generateWorstUnsortArray(numbers);

        // get systemtime before sorting
        startTime = System.currentTimeMillis();

        // sort
        MergesortUniversityWashingtonThreaded.parallelMergeSort(numbers);

        // get systemtime after sorting
        endTime = System.currentTimeMillis();

        // show the result of the sorting process
        System.out.println("\n- Sortierergebnis: Java Threads (University Washington) -");
        System.out.println("Die sortierte Folge lautet: " + arrayToString(numbers));
        System.out.printf("Für die Sortierung wurden %d ms benötigt", endTime - startTime);
        System.out.println("\n------------------------------------------------\n");
    }


    // evaluate Mergesort University Washington with openMP
    /**
     * This method evaluate the time which the parallel mergesort implementation with openMP based on
     * the Version by the University of Washington needs to sort a sequence.
     *
     */
    private static void evaluateMergesortUniversityWashingtonOpenMP() {

        // LOGGER.info("evaluating parallel mergesort with OpenMP based on the version of the University of
        //              Washington");

        // The time before start to sort.
        long startTime;

        // The time after sort.
        long endTime;

        // generate sorted array
        numbers = generateSortedArray(ARRAY_SIZE);

        // get array to evaluate
        generateWorstUnsortArray(numbers);

        // get systemtime before sorting
        startTime = System.currentTimeMillis();

        // sort @TODO
        // MergesortUniversityWashingtonOpenMP.parallelMerge(numbers);

        // get systemtime after sorting
        endTime = System.currentTimeMillis();

        // show the result of the sorting process
        System.out.println("\n- Sortierergebnis: OpenMP (University Washington) -");
        System.out.println("Die sortierte Folge lautet: " + arrayToString(numbers));
        System.out.printf("Für die Sortierung wurden %d ms benötigt", endTime - startTime);
        System.out.println("\n------------------------------------------------\n");
    }

    /**
     * This method generate a sorted array from 1 to the given size.
     *
     * @param size the size of the sorted array
     */
    private static int[] generateSortedArray(int size) {

        int[] sortedArray = new int[size];

        // fill the array with the numbers beginning by 1
        for (int i = 0; i < size; i++) {

            sortedArray[i] = i + 1;
        }

        return sortedArray;
    }

    /**
     * This method generate an worst case unsorted array of an sorted integer sequence.
     *
     * @param array the sorted array which will be mixed
     */
    private static void generateWorstUnsortArray(int[] array) {

         if (array.length == 2) {

            int swap = array[0];
            array[0] = array[1];
            array[1] = swap;
        } else if (array.length > 2) {

            int i, j;
            int m = (array.length + 1) / 2;
            int left[] = new int[m];
            int right[] = new int[array.length - m];

            for (i = 0, j = 0; i < array.length; i = i + 2, j++) {

                left[j] = array[i];
            }

            for (i = 1, j = 0; i < array.length; i= i + 2, j++) {

                right[j] = array[i];
            }

            generateWorstUnsortArray(left);
            generateWorstUnsortArray(right);
            merge(array, left, right);
        }
    }


    /**
     * A helper method for generating the worst case of an unsorted array.
     *
     * @param array
     * @param left
     * @param right
     */
    private static void merge(int[] array, int[] left, int[] right) {

        int i;

        for(i = 0; i < left.length; i++) {

            array[i] = left[i];
        }

        for (int j = 0; j < right.length; j++, i++) {

            array[i] = right[j];
        }
    }


    /** This method puts an array of integer in a "," seperated string.
     *
     * @prarm the array
     * @return the seperated array as string
     */
    private static String arrayToString(int[] array) {

        String arrayOutput = "";

        // seperate the elements of the array and add each to the outputstring
        for (int position = 0; position < array.length; position++) {

            arrayOutput +=  array[position] + ", ";
        }

        // trim the outputstring of the last seperation char
        arrayOutput = arrayOutput.substring(0, (arrayOutput.length() - 1));

        // output the string of the integer array
        return arrayOutput;
    }



//    private int[] numbers;
//    private final static int SIZE = 7;
//    private final static int MAX = 20;
//
//    @Before
//    public void setUp() throws Exception {
//        numbers = new int[SIZE];
//        Random generator = new Random();
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = generator.nextInt(MAX);
//        }
//    }
//
//    @Test
//    public void testMergeSort() {
//        long startTime = System.currentTimeMillis();
//
//        MergesortVogella sorter = new MergesortVogella();
//        //MergesortVogellaThreaded sorter = new MergesortVogellaThreaded();
//        sorter.sort(numbers);
//
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println("Mergesort " + elapsedTime);
//
//        for (int i = 0; i < numbers.length - 1; i++) {
//            if (numbers[i] > numbers[i + 1]) {
//                fail("Should not happen");
//            }
//        }
//        assertTrue(true);
//
//    }
//
//    @Test
//    public void itWorksRepeatably() {
//        for (int i = 0; i < 200; i++) {
//            numbers = new int[SIZE];
//            Random generator = new Random();
//            for (int a = 0; a < numbers.length; a++) {
//                numbers[a] = generator.nextInt(MAX);
//            }
//            MergesortVogella sorter = new MergesortVogella();
////            MergesortVogellaThreaded sorter = new MergesortVogellaThreaded();
//            sorter.sort(numbers);
//            for (int j = 0; j < numbers.length - 1; j++) {
//                if (numbers[j] > numbers[j + 1]) {
//                    fail("Should not happen");
//                }
//            }
//            assertTrue(true);
//        }
//    }
//
//    @Test
//    public void testStandardSort() {
//        long startTime = System.currentTimeMillis();
//        Arrays.sort(numbers);
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println("Standard Java sort " + elapsedTime);
//
//        for (int i = 0; i < numbers.length - 1; i++) {
//            if (numbers[i] > numbers[i + 1]) {
//                fail("Should not happen");
//            }
//        }
//        assertTrue(true);
//    }
}