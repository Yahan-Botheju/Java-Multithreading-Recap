package exercises.runnable;

public class Exe_2 {

    //task
    Runnable printName = () -> {
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Name: Bob Foe");

            try {
                Thread.sleep(2000);
            }catch (InterruptedException ignore){}
        }
        System.out.println("Name print completed..!!");
    };

    public static void main(String[] args) {
        //create object
        Exe_2 classExe = new Exe_2();

        //create thread object
        Thread t1 = new Thread(classExe.printName);

        //start thread
        t1.start();

        //main thread representation
        System.out.println("Main thread..");
    }
}