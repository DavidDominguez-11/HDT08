package com.example;

import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> heap;

    public VectorHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;
        int parentIndex = (currentIndex - 1) / 2;

        while (currentIndex > 0 && heap.get(currentIndex).compareTo(heap.get(parentIndex)) > 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    public E getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        E maxElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);

        return maxElement;
    }

    protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}

	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}

	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}

    private void heapifyDown(int index) {
        int leftChildIndex = left(index);
        int rightChildIndex = right(index);
        int maxIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        E root = heap.get(0);
        if (heap.size() > 1) {
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapifyDown(0);
        } else {
            heap.remove(0);
        }
        return root;
    }
    
    @Override
    public void clear() {
        heap.clear();
    }
}