package com.example;

import java.util.PriorityQueue;

public class JavaPriorityQueue<E extends Comparable<E>>{

    private PriorityQueue<E> priorityQueue;

    public JavaPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return priorityQueue.peek();
    }

    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return priorityQueue.poll();
    }

    public void add(E value) {
        priorityQueue.add(value);
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public int size() {
        return priorityQueue.size();
    }

    public void clear() {
        priorityQueue.clear();
    }
}


