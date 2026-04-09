package Thread_Race_Condition;

class TicketCounterTwo{

    //create one variable
    int ticketsSold = 0;

    //create method that increment variable with SYNCHRONIZED
    public synchronized void increment(){
        ticketsSold++;
    }
}

public class RaceCondition_synchronized {
    public static void main(String[] args) {
        //create counter class object
        TicketCounterTwo classTicketCounterTwo =  new TicketCounterTwo();

        //create task
        Runnable ticketCounter = () -> {

            for (int i = 1; i <= 10000; i++) {
                //call increment method for increment variable
                classTicketCounterTwo.increment();
            }
        };

        //create two workers, threads and assign same task for both
        Thread t1 = new Thread(ticketCounter);
        Thread t2 = new Thread(ticketCounter);

        //start the thread
        t1.start();
        t2.start();

        //set wait time for sleep MAIN thread
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        //print sold tickets by two workers
        System.out.println(classTicketCounterTwo.ticketsSold);
    }
}