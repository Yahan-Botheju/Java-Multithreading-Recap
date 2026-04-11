package exercises.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex_2 {

    //initiate atomic integer
    static AtomicInteger score = new AtomicInteger(0);


    public static void main(String[] args)throws InterruptedException {

        //task 1 create, use directly set value
        Runnable addScore_1 = () -> {
            score.addAndGet(50);
        };

        //task 1 create, use compare and set values
        Runnable addScore_2 = () -> {
            score.compareAndSet(50, 100);
        };

        //create workers
        Thread t1 = new Thread(addScore_1);
        Thread t2 = new Thread(addScore_2);

        //let worker work
        t1.start();
        t2.start();

        //force to stop MAIN thread, until workers work complete
        t1.join();
        t2.join();

        //get atomic integer final value
        System.out.println("Final Score: " + score.get());
    }
}