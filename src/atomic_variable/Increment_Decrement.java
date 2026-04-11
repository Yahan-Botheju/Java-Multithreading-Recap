package atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class Increment_Decrement {
    //initiate atomic variable
    static AtomicInteger inventoryCount = new AtomicInteger(1000);

    static void sales(){
        //use atomic decrement
        inventoryCount.decrementAndGet();
    }

    static void restock(){
        //use atomic increment
        inventoryCount.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException{

        //create task 1
        Runnable selling = () -> {
            for (int i = 500; i >= 1; i--) {
                sales();
            }
        };

        //create task 2
        Runnable buying = () -> {
            for (int i = 1; i <= 200 ; i++) {
                restock();
            }
        };

        //initiate workers
        Thread t1 = new Thread(selling);
        Thread t2 = new Thread(buying);

        //let workers work
        t1.start();
        t2.start();

        //force main thread to stop
        t1.join();
        t2.join();

        //get final value of atomic variable
        System.out.println("Available Stock: " + inventoryCount.get());

    }
}