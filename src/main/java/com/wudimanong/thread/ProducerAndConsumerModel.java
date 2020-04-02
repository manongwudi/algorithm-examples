package com.wudimanong.thread;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiangqiao
 * @生产者，消费者模式
 */
public class ProducerAndConsumerModel {

    public static void main(String[] args) {
        final Queue<Integer> sharedQueue = new LinkedList<>();
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}

/**
 * 生产者
 */
class Producer extends Thread {

    private static final int MAX_QUEUE_SIZE = 5;

    private final Queue sharedQueue;

    public Producer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() >= MAX_QUEUE_SIZE) {
                    System.out.println("队列满了，等待消费");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            sharedQueue.add(i);
            System.out.println("进行生产：" + i);
        }
    }
}

/**
 * 消费者线程
 */
class Consumer extends Thread {

    private final Queue sharedQueue;

    public Consumer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    System.out.println("队列空了，等待消费");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = (int) sharedQueue.poll();
                System.out.println("进行消费：" + number);
                sharedQueue.notify();
            }
        }
    }
}