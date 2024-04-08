package com.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private PriorityQueue<E> queue;

    public JavaPriorityQueue() {
        // Usamos un Comparator personalizado para invertir el orden de comparación
        Comparator<E> maxHeapComparator = Comparator.reverseOrder();
        queue = new PriorityQueue<>(maxHeapComparator);
    }

    @Override
    public E getFirst() {
        return queue.peek();
    }

    @Override
    public E remove() {
        return queue.poll();
    }

    @Override
    public void add(E value) {
        queue.add(value);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
