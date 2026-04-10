package exercises.join;

public class Exe_3 {
    public static void main(String[] args) throws InterruptedException {
        //create task
        Runnable working = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            System.out.println("This print after 1s");
        };

        //initiate thread
        Thread t1 = new Thread(working);

        //thread start
        t1.start();

        //force to main thread to wait 2s t1 done
        t1.join(2000);

        //main thread works after 2s
        System.out.println("Main thread shows after 2s");
    }
}