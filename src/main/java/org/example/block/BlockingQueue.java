package org.example.block;

import java.util.ArrayDeque;
import java.util.Deque;

public class BlockingQueue {

    private final  Deque<Runnable> deque = new ArrayDeque<>();

    public synchronized void enqueue(Runnable runnable) {
        System.out.println("BlockingQueue enqueue  "+Thread.currentThread().getName());
        deque.add(runnable);
        notify();
    }

    public synchronized Runnable dequeue() {
        System.out.println("BlockingQueue dequeue  "+Thread.currentThread().getName());
        while(deque.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Runnable runnable = deque.poll();
        return runnable;
    }

    public int size() {
        return deque.size();
    }
}