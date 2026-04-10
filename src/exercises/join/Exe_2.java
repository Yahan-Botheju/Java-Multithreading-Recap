package exercises.join;

public class Exe_2 {

    static synchronized void makeCount(){
        for (int i = 1; i <= 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Runnable count = Exe_2::makeCount;

        Thread t1 = new Thread(count);
        Thread t2 = new Thread(count);
        Thread t3 = new Thread(count);

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();



    }
}