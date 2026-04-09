package Thread_Runnable;

import java.lang.Runnable;

public class Ex_1 {

    public static void main(String[] args) {
        //create thread
        Runnable searchFile = () -> {
            System.out.println("Start searching file");

            //define time to work
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            //create a message work is done
            System.out.println("File search completed!!");
        };

        //initiate a thread
        Thread t1 = new Thread(searchFile);

        t1.start();

        //other work in main thread
        System.out.println("Main thread continue...");
    }
}