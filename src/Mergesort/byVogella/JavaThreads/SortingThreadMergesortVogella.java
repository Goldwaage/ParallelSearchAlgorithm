package Mergesort.byVogella.JavaThreads;

import java.util.logging.Logger;

/**
 * This class ist the threads implementation for the Mergesort algorithm by Vogella.
 *
 * @author Marc Kasper
 */
public class SortingThreadMergesortVogella extends Thread {

    /** The Logger Constante  for this instance. */
    private static final Logger LOGGER = Logger.getLogger(SortingThreadMergesortVogella.class.getName());

    /** The left part of the sorting set. */
    public int left;

    /** The right part of the sorting set. */
    public int right;

    /** The sorter. */
    public MergesortVogellaThreaded sorter;

    /** The constructer creates a thread for the mergesort algorithm.
     *
     * @param sorter the sorter
     * @param left the left part of set
     * @param right the right part of set
     */
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
