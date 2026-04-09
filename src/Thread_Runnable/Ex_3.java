package Thread_Runnable;

import java.lang.Runnable;

public class Ex_3 {
    public static void main(String[] args) {
        /* define tasks */
        //task 1
        Runnable logTasks = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(i + " " + "Logging data...");

                //set time for resting thread
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        };

        //task 2
        Runnable dbTask = () -> {
            System.out.println("Data fetching from db...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            System.out.println("Data loaded complete!!");
        };


        /* define workers assign work*/
        //worker 1
        Thread t1 = new Thread(logTasks);

        //worker 2
        Thread t2 = new Thread(dbTask);

        //let them work
        t1.start();
        t2.start();

        //main thread working
        System.out.println("Main Thread Working...");
    }
}