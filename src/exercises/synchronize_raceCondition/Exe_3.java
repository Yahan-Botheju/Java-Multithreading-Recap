package exercises.synchronize_raceCondition;

public class Exe_3 {
    static int availableTickets = 10;

    public synchronized  void bookTicket(){
        availableTickets--;
    }

    public static void main(String[] args) {
        Exe_3 classExe3 = new Exe_3();

        Runnable buyTicket = () -> {
          classExe3.bookTicket();
        };

        Thread t1 = new Thread(buyTicket);
        Thread t2 = new Thread(buyTicket);
        Thread t3 = new Thread(buyTicket);

        t1.start();
        t2.start();
        t3.start();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){}

        System.out.println("Main thread woked");
        System.out.println("Available Ticket" + availableTickets);
    }
}