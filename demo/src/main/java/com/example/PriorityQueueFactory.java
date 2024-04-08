package com.example;

public class PriorityQueueFactory {

    public static <E extends Comparable<E>> IPriorityQueue<E> createPriorityQueue(String type) {
        if ("custom".equalsIgnoreCase(type)) {
            return new VectorHeap<>();
        } else if ("java".equalsIgnoreCase(type)) {
            return new JavaPriorityQueue<>();
        } else {
            throw new IllegalArgumentException("Invalid priority queue type: " + type);
        }
    }
}
