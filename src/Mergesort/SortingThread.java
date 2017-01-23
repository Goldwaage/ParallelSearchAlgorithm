package Mergesort;

import java.util.logging.Logger;

/**
 * Created by marc on 23.01.17.
 */
public class SortingThread extends Thread {

    private static final Logger LOGGER = Logger.getLogger(SortingThread.class.getName());

    public int left;

    public int right;

    public MergesortThreaded2 sorter;

    public SortingThread(MergesortThreaded2 sorter, int left, int right) {

       // LOGGER.info("Creates SortingThread");

        this.sorter = sorter;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {

        this.sorter.mergesort(this.left, this.right);
    }
}
