package exercises.race_condition;

public class Exe_2 {
    public static void main(String[] args) {
        //initiate builder object
        StringBuilder builder = new StringBuilder();

        //create task
        Runnable insertLetters = () -> {
            for (int i = 1; i <= 500 ; i++) {
                builder.append("A");
            }
        };

        //set up threads
        Thread t1 = new Thread(insertLetters);
        Thread t2 = new Thread(insertLetters);

        //start threads
        t1.start();
        t2.start();

        //set to rest main thread
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){}

        //print values
        System.out.println("Main Thread Woke");
        System.out.println(builder.length());
    }
}