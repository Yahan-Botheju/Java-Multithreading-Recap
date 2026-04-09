package Thread_Race_Condition;

class TicketCounter{

    //create one variable
     int ticketsSold = 0;

     //create method that increment variable
     public void increment(){
         ticketsSold++;
     }
}

public class RaceCondition {
    public static void main(String[] args) {
        //create counter class object
    TicketCounter classCounter = new TicketCounter();

    //create task
    Runnable ticketCounter = () -> {

        for (int i = 1; i <= 10000; i++) {
            //call increment method for increment variable
            classCounter.increment();
        }
    };

    //create two workers, threads and assign same task for both
    Thread t1 = new Thread(ticketCounter);
    Thread t2 = new Thread(ticketCounter);

    //start the thread
    t1.start();
    t2.start();

    //set wait time
    try{
        Thread.sleep(1000);
    }catch (InterruptedException e){}

    //print sold tickets by two workers
    System.out.println(classCounter.ticketsSold);
   }
}