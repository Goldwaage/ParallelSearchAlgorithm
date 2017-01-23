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
class SimpleThreadTest0 {

    public static
    void main(String[] argv) {
        Thread t1 =
                new SimpleThread("foo");

        Thread t2 =
                new SimpleThread("bar");

        t1.start();
        t2.start();
    }
}

//--------------------

