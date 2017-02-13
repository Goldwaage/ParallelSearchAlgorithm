package ThreadExperimental;


/**
 2  * eine einfache Unterklasse
 3  * von Thread
 4  */
//--------------------

public
class SimpleThread extends Thread {

 //--------------------

public SimpleThread(String name) {

    super(name);

}
 //--------------------
 public void run() {

     for (int i = 1;i <= 10; ++i ) {

         System.out.println(getName() + " the " + i + ". time");

         doSomething();

     }
         System.out.println(getName() + " finished");
}
//--------------------
public void doSomething() {

    try {

        // really doing something ???
        // simulate some complex computations
        sleep( (int)(Math.random() * 500) );
    } catch ( InterruptedException e ) {
        e.getStackTrace();
    }
}
}