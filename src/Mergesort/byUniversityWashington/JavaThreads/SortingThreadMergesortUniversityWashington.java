package Mergesort.byUniversityWashington.JavaThreads;

import Mergesort.byUniversityWashington.JavaThreads.MergesortUniversityWashingtonThreaded;

/**
 * This class ist the threads implementation for the Mergesort algorithm by the University of Washington.
 *
 * @author Marc Kasper
 */
public class SortingThreadMergesortUniversityWashington extends Thread {

    //private static final Logger LOGGER = Logger.getLogger(SortingThreadMergesortUniversityWashington.class.getName());

    public int cores;

    public int[] array;

    public SortingThreadMergesortUniversityWashington(int[] array, int cores) {

       // LOGGER.info("Creates SortingThreadMergesortVogella");

        this.array = array;
        this.cores = cores;
    }

    @Override
    public void run() {

        MergesortUniversityWashingtonThreaded.parallelMergeSort(this.array, cores);
    }
}
