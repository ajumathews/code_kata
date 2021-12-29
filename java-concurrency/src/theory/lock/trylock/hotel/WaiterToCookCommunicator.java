package theory.lock.trylock.hotel;

import java.util.concurrent.locks.Lock;

public class WaiterToCookCommunicator implements Runnable{

    private Cook cook;
    private Waiter waiter;
    private Lock mic;

    public WaiterToCookCommunicator(Cook cook, Waiter waiter,Lock mic) {
        this.cook = cook;
        this.waiter = waiter;
        this.mic = mic;
    }


    @Override
    public void run() {
        int count=0;
        while(cook.getItemSize()<20){

            if(waiter.getOrderSize()>0 && mic.tryLock()){
                cook.addNewItems(waiter.getOrders());
                waiter.emptyOrders();
                System.out.println(cook.getName() +" Receiving Items from " +waiter.getName());
                try{
                   Thread.sleep(3000);
                }catch (InterruptedException ex){}
                finally {
                    mic.unlock();
                }
            }else{
                System.out.println(waiter.getName()+" Fetching new orders from Customers");
                waiter.addItem("item :"+count);
                count++;
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ex){}

            }
        }
    }
}
