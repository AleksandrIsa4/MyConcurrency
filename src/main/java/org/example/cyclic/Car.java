package org.example.cyclic;

import static org.example.cyclic.ComplexTaskExecutor.BARRIER;

public class Car implements Runnable {
    private int carNumber;

    String nameThreat;

    public Car(int carNumber,String nameThreat) {
        this.carNumber = carNumber;
        this.nameThreat = nameThreat;
    }

    @Override
    public void run() {
        try {
            System.out.println("Автомобиль "+carNumber+" подъехал к паромной переправе.   " +nameThreat);
            BARRIER.await();
            System.out.println("Автомобиль "+carNumber+" продолжил движение.   " +nameThreat);
        } catch (Exception e) {
        }
    }
}
