package exercises.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex_3 {

    static AtomicInteger capacity = new AtomicInteger(0);

    static void increase(){
        capacity.incrementAndGet();
    }


    public static void main(String[] args) throws InterruptedException{
        Runnable increase_1 = () -> {
            int currentValue = capacity.get();

            if(currentValue < 10){

                for (int i = 1; i <= 10 ; i++) {

                    capacity.compareAndSet(10 , currentValue + 1);
                    increase();

                }
            }

        };

        Thread t1 = new Thread(increase_1);
        Thread t2 = new Thread(increase_1);
        Thread t3 = new Thread(increase_1);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(capacity.get());
    }
}