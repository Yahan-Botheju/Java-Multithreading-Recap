package exercises.runnable;

public class Exe_3 {

    public static void main(String[] args) {

        //task 1
        Runnable taskHello = () -> {
            System.out.print("Hello ");
        };

        //task 2
        Runnable taskWorld = () -> {
            System.out.println("World");
        };

        //workers create
        Thread t1 = new Thread(taskHello);
        Thread t2 = new Thread(taskWorld);

        //start workers
        t1.start();
        t2.start();

        //main thread to sleep until work done
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        //msg main thread read
        System.out.println("Main Thread Woke Up..!!");
    }
}