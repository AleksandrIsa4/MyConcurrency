package org.example.block;

public class Printer extends Thread {

    public void run() {
        int time=(int)(Math.random()*10)*100;
        System.out.println("I’m printer time: "+time+"   "+Thread.currentThread().getName());
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}