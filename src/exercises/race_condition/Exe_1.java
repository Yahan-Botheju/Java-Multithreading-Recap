package exercises.race_condition;

public class Exe_1 {

    static int count = 0;

    static  void increase(){
        count++;
    }

    public static void main(String[] args) {

        //create task
        Runnable increment = () -> {
            for (int i = 1; i <= 1000 ; i++) {
                 increase();
            }
        };

        //assign task for both workers
        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);

        //start
        t1.start();
        t2.start();

        //main thread to sleep
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){}

        //print count
        System.out.println("Main thread woke up");
        System.out.println(count);

    }
}