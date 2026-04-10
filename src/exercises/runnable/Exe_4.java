package exercises.runnable;

public class Exe_4 {

    public static void main(String[] args) {

        //create task
        Runnable getThreadName = () -> {
            for (int i = 1; i <= 5 ; i++) {
              System.out.println(Thread.currentThread().getName());

              //set sleep time
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){}
            }

        };
        //worker define
        Thread t1 = new Thread(getThreadName);

        //let worker work
        t1.start();

    }
}