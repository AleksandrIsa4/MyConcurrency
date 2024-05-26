package org.example.block;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        BlockingQueue blockingQueue = new BlockingQueue();

        blockingQueue.enqueue(new Printer());
        blockingQueue.enqueue(new Printer());
        blockingQueue.enqueue(new Printer());

        CompletableFuture.runAsync(() ->
                blockingQueue.dequeue().run());
        CompletableFuture.runAsync(() ->
                blockingQueue.dequeue().run());
        CompletableFuture.runAsync(() ->
                blockingQueue.dequeue().run());
        CompletableFuture.runAsync(() ->
                blockingQueue.dequeue().run());
        Thread.sleep(1000);
        CompletableFuture.runAsync(() ->
                blockingQueue.dequeue().run());
        blockingQueue.enqueue(new Printer());
        CompletableFuture.runAsync(() ->
                blockingQueue.dequeue().run());
        blockingQueue.enqueue(new Printer());
        blockingQueue.enqueue(new Printer());
        blockingQueue.enqueue(new Printer());
    }
}