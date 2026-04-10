package exercises.join;

public class Exe_4 {

    static int fact = 1;

    public static void main(String[] args) throws InterruptedException {
        Runnable factorial = () -> {

            for (int i = 1; i <= 5; i++) {
                fact = fact * i;
            }

        };

        Thread t1 = new Thread(factorial);

        t1.start();
        t1.join(2000);


        System.out.println("Show in Main Thread: " + fact);
    }
}