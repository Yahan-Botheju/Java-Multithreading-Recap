package Thread_Runnable;

public class Runnable {
    public static void main(String[] args) {
        //thread create
        java.lang.Runnable fileSearchTask = () -> {
            System.out.println("File searching...");

            //define time for complete tash
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){}

            //leave a message if work is done
            System.out.println("File search completed!!");
        };

        //define a thread
        Thread t1 = new Thread(fileSearchTask);

        //tell thread to start work
        t1.start();

        //other work of main thread
        System.out.println("Main thread continue..");

    }
}