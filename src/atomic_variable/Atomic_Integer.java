package atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_Integer {

    //create ATOMIC VARIABLE OBJECT
    static AtomicInteger count = new AtomicInteger(0);

    static void increment(){
        //set variable as atomic variable
        count.incrementAndGet();
    }


    public static void main(String[] args) throws InterruptedException{

        //create task
        Runnable task = () -> {
            for (int i = 1; i <= 5000 ; i++) {
                increment();
            }
        };

        //create workers
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        //let worker work
        t1.start();
        t2.start();

        //force MAIN thread to wait
        t1.join();
        t2.join();

        //get atomic variable value by get()
        System.out.println("Count :" + count.get());
    }
}