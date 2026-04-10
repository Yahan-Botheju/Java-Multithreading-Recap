package exercises.synchronize_raceCondition;

public class Exe_4 {

    static int currentAmount = 700;
    static int accountBalance;

    static synchronized void account(int withdraw){
        if(currentAmount >= withdraw){
            currentAmount = currentAmount - withdraw;
            accountBalance = currentAmount;
        }else{
            System.out.println("Not enough money");
        }

    }

    public static void main(String[] args) {

        Runnable withdraw = () -> {
            int amount = 500;
            account(amount);
        };

        Thread t1 = new Thread(withdraw);
        Thread t2 = new Thread(withdraw);

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(accountBalance);

    }

}