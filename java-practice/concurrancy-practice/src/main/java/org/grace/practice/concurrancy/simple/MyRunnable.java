package org.grace.practice.concurrancy.simple;

public class MyRunnable implements Runnable {

    private  int runUntil;

    public MyRunnable(int runUntil){
        this.runUntil=runUntil;
    }




    @Override
    public void run() {
        int sum=0;

        for(int i=0; i<runUntil ;i++){
            sum= sum+i;
        }

        System.out.println(sum);
    }
}
