package Thread_Runnable;

import java.lang.Runnable;

public class Ex_2 {

    public static void main(String[] args) {

        //create a task, (task defines in Runnable)
        Runnable printNumbers = () -> {

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);

                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){}
            }

            //message when thread is complete
            System.out.println("Number print completed!!");
        };

        //create a worker, giving the task
        Thread t1 = new Thread(printNumbers);

        //let worker start
        t1.start();

        //program main thread
        System.out.println("Main thread is working...");
    }
}