package exercises.runnable;

public class Exe_1 {

    public static void main(String[] args) {

    //create task
    Runnable numbersPrint = () -> {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            }catch (InterruptedException ignored){}

        }
        System.out.println("Process end..!!");
    };

    //create thread/worker
    Thread t1 = new Thread(numbersPrint);

    //start thread
    t1.start();

        System.out.println("Main thread process..!!");
    }
}