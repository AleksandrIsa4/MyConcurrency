package org.example.cyclic;

public class ComplexTask implements Runnable {

    String nameThreat;

    public ComplexTask(String nameThreat) {
        this.nameThreat = nameThreat;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Паром переправил автомобили!  " +nameThreat);
        } catch (InterruptedException e) {
        }
    }
}