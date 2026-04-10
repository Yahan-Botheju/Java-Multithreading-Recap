package exercises.race_condition;

public class Exe_4 {
    //create common variable
    static int commonVariable = 0;

    //create increment, common variable
    static void increment(){ commonVariable++; }
    //create decrement, common variable
    static void decrement(){
        commonVariable--;
    }

    public static void main(String[] args){

        //create task increase
        Runnable sizeUp = () -> {
            for (int i = 1; i <= 10000 ; i++) {
                increment();
            }
        };

        //create task decrease
        Runnable sizeDown = () -> {
            for (int i = 1; i <= 10000 ; i++) {
                decrement();
            }
        };

        //create workers
        Thread t1 = new Thread(sizeUp);
        Thread t2 = new Thread(sizeDown);

        //start to work
        t1.start();
        t2.start();

        System.out.println("Main Thread working...");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        //print final result of task that done by workers

        System.out.println(commonVariable);
    }
}