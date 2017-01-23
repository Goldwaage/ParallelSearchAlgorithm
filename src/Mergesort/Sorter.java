package Mergesort;

import java.util.logging.Logger;

/**
 * Created by marc on 23.01.17.
 */
public class Sorter extends Thread {

    //private static final Logger LOGGER = Logger.getLogger(Sorter.class.getName());

    public int cores;

    public int[] array;

    public Sorter(int[] array, int cores) {

       // LOGGER.info("Creates SortingThread");

        this.array = array;
        this.cores = cores;
    }

    @Override
    public void run() {

        MergesortThreaded.parallelMergeSort(this.array, cores);
    }
}
