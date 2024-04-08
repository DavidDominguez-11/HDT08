package com.example;

import java.util.ArrayList;

/**
 * Implementación de una cola de prioridad utilizando un VectorHeap.
 * Esta implementación utiliza un ArrayList para almacenar los elementos y mantener la estructura de heap.
 *
 * @author David Dominguez
 * @version 1.0
 * @since 2024-04-08
 * 
 * @param <E> el tipo de elementos que se almacenarán en la cola de prioridad
 */
public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> heap;

    /**
     * Constructor para crear una nueva instancia de VectorHeap.
     * Inicializa la estructura de datos subyacente (ArrayList) para almacenar los elementos.
     */
    public VectorHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     *
     * @return true si la cola de prioridad está vacía; false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Retorna el número de elementos en la cola de prioridad.
     *
     * @return el número de elementos en la cola de prioridad
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     * El nuevo elemento se agrega al final del ArrayList y se ajusta la estructura de heap.
     *
     * @param element el elemento que se va a agregar a la cola de prioridad
     */
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

    /**
     * Retorna y elimina el elemento máximo (raíz) de la cola de prioridad.
     * Se reemplaza la raíz con el último elemento del ArrayList y se ajusta la estructura de heap.
     *
     * @return el elemento máximo (raíz) de la cola de prioridad
     * @throws IllegalStateException si la cola de prioridad está vacía
     */
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

    /**
     * Método auxiliar para realizar el proceso de "heapify down" a partir de un índice dado.
     * Se compara el elemento en el índice con sus hijos y se intercambia si es necesario para mantener la propiedad de heap.
     *
     * @param index el índice a partir del cual realizar el "heapify down"
     */
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

    /**
     * Método para obtener el índice del padre de un nodo dado.
     *
     * @param i el índice del nodo para el cual se quiere obtener el índice del padre
     * @return el índice del padre del nodo en la posición i
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Método para obtener el índice del hijo izquierdo de un nodo dado.
     *
     * @param i el índice del nodo para el cual se quiere obtener el índice del hijo izquierdo
     * @return el índice del hijo izquierdo del nodo en la posición i
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Método para obtener el índice del hijo derecho de un nodo dado.
     *
     * @param i el índice del nodo para el cual se quiere obtener el índice del hijo derecho
     * @return el índice del hijo derecho del nodo en la posición i
     */
    protected static int right(int i) {
        return (2 * i + 1) + 1;
    }

    /**
     * Método auxiliar para intercambiar dos elementos en el ArrayList.
     *
     * @param i el índice del primer elemento
     * @param j el índice del segundo elemento
     */
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Retorna el primer elemento (máximo) de la cola de prioridad sin eliminarlo.
     *
     * @return el primer elemento (máximo) de la cola de prioridad
     * @throws IllegalStateException si la cola de prioridad está vacía
     */
    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    /**
     * Elimina y retorna el primer elemento (máximo) de la cola de prioridad.
     * Se reemplaza la raíz con el último elemento del ArrayList y se ajusta la estructura de heap.
     *
     * @return el primer elemento (máximo) de la cola de prioridad
     * @throws IllegalStateException si la cola de prioridad está vacía
     */
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

    /**
     * Elimina todos los elementos de la cola de prioridad.
     */
    @Override
    public void clear() {
        heap.clear();
    }
}
