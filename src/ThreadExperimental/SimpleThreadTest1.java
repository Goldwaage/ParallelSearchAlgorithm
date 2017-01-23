package ThreadExperimental;

/**
 * Copyright (c): Uwe Schmidt, FH Wedel
 *
 * You may study, modify and distribute this source code
 * FOR NON-COMMERCIAL PURPOSES ONLY.
 * This copyright message has to remain unchanged.
 *
 * Note that this document is provided 'as is',
 * WITHOUT WARRANTY of any kind either expressed or implied.
 */

/**
 * ein Test fuer SimpleThread
 */

//--------------------

public
class SimpleThreadTest1 {

    public static
    void main(String[] argv) {

        Thread [] threads =
                new Thread[argv.length];

        for (int i = 0;
             i < threads.length;
             ++i) {

            threads[i] =
                    new SimpleThread(argv[i]);

            threads[i].start();
        }
    }
}

//--------------------



