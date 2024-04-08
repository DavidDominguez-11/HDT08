package com.example;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implementación de una cola de prioridad basada en Java utilizando la clase PriorityQueue.
 * Esta clase implementa la interfaz IPriorityQueue<E> y utiliza un Comparator para invertir el orden de comparación
 * y así simular una cola de prioridad que devuelve el elemento mínimo en lugar del máximo.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2024-04-08
 *
 * @param <E> el tipo de elementos que se almacenan en la cola de prioridad
 */
public class JavaPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private PriorityQueue<E> queue;

    /**
     * Constructor que inicializa una nueva instancia de JavaPriorityQueue.
     * Utiliza un Comparator personalizado para invertir el orden de comparación,
     * permitiendo que la cola de prioridad funcione como un min-heap.
     */
    public JavaPriorityQueue() {
        Comparator<E> maxHeapComparator = Comparator.reverseOrder();
        queue = new PriorityQueue<>(maxHeapComparator);
    }

    /**
     * Obtiene el mínimo valor en la cola de prioridad (sin eliminarlo).
     *
     * @return el mínimo valor en la cola de prioridad, o null si la cola está vacía
     */
    @Override
    public E getFirst() {
        return queue.peek();
    }

    /**
     * Elimina y devuelve el mínimo valor de la cola de prioridad.
     *
     * @return el mínimo valor que fue eliminado de la cola de prioridad
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    @Override
    public E remove() {
        return queue.poll();
    }

    /**
     * Agrega un valor a la cola de prioridad.
     *
     * @param value el valor que se va a agregar a la cola de prioridad
     * @throws NullPointerException si el valor especificado es nulo
     */
    @Override
    public void add(E value) {
        queue.add(value);
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     *
     * @return true si la cola de prioridad está vacía; false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Retorna el número de elementos en la cola de prioridad.
     *
     * @return el número de elementos en la cola de prioridad
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Elimina todos los elementos de la cola de prioridad.
     * La cola estará vacía después de llamar a este método.
     */
    @Override
    public void clear() {
        queue.clear();
    }
}
