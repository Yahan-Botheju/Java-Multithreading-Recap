package exercises.synchronize_raceCondition;

public class Exe_2 {
    static int count = 0;

     public void increase(){
        synchronized (this){
            count++;
        }
    }

    public static void main(String[] args) {

         Exe_2 classEx2 = new Exe_2();

        //create task
        Runnable increment = () -> {
            for (int i = 1; i <= 1000 ; i++) {
                classEx2.increase();
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