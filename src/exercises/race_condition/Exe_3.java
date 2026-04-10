package exercises.race_condition;

import java.util.ArrayList;
import java.util.List;

public class Exe_3 {

    public static void main(String[] args) {
        var list = new ArrayList<Integer>();

        Runnable addValuesToList = () -> {
            for (int i = 1; i <= 1000; i++) {
                list.add(i);
            }
        };

        Thread t1 = new Thread(addValuesToList);
        Thread t2 = new Thread(addValuesToList);

        t1.start();
        t2.start();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){}

        System.out.println("Main thread worked");
        System.out.println(list.toArray().length);
    }
}