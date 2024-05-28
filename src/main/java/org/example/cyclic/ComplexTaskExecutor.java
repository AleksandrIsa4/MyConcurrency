package org.example.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {

    public static CyclicBarrier BARRIER;

    int value;

    public ComplexTaskExecutor(int value){
        BARRIER= new CyclicBarrier(value,new ComplexTask(Thread.currentThread().getName()));
    }

    public void executeTasks(int numberOfTasks)  {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);
        try{
            for (int i = 0; i < numberOfTasks; i++) {
                executorService.execute(new Car(i,Thread.currentThread().getName()));
           //     new Thread(new Car(i,Thread.currentThread().getName())).start();
                Thread.sleep(400);
            }
        } catch (InterruptedException e){
        }
        executorService.shutdown();
    }
}
