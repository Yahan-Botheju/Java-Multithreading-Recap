package Join;

class Ticketing{
    int ticketSold = 0;

    public synchronized void increment(){
        ticketSold++;
    }
}

public class Join {
    public static void main(String[] args) throws InterruptedException {

        Ticketing classTicketing = new Ticketing();

        Runnable countSoldTickets = () -> {
            for (int i = 1; i <= 10000; i++) {
               classTicketing.increment();
            }
        };

        Thread worker1 = new Thread(countSoldTickets);
        Thread worker2 = new Thread(countSoldTickets);

        worker1.start();
        worker2.start();

        //remove sleep and use join with synchronized
        worker1.join();
        worker2.join();



        System.out.println("Tickets Sold: " + classTicketing.ticketSold);

    }
}