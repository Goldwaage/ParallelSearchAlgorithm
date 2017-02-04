package Mergesort.byVogella.JavaThreads;

import java.util.logging.Logger;

/**
 * This class ist the threads implementation for the Mergesort algorithm by Vogella.
 *
 * @author Marc Kasper
 */
public class SortingThreadMergesortVogella extends Thread {

    private static final Logger LOGGER = Logger.getLogger(SortingThreadMergesortVogella.class.getName());

    public int left;

    public int right;

    public MergesortVogellaThreaded sorter;

    public SortingThreadMergesortVogella(MergesortVogellaThreaded sorter, int left, int right) {

       // LOGGER.info("Creates SortingThreadMergesortVogella");

        this.sorter = sorter;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {

        this.sorter.mergesort(this.left, this.right);
    }
}
