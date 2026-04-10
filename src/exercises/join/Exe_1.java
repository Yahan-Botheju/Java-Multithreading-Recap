package exercises.join;

public class Exe_1 {
    public static void main(String[] args) throws InterruptedException {

        //create task
         Runnable sumNumbers = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                 sum += i;
            }
             System.out.println("Total: " + sum);
        };

         //define worker
         Thread t1 = new Thread(sumNumbers);

         //start to work
         t1.start();

         //force main thread to wait until worker complete work
         t1.join();

         //when worker completed work, main thread works
        System.out.println("Main thread working..");

    }
}