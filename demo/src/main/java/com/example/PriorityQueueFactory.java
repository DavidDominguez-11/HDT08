package com.example;

/**
 * Clase utilitaria que permite crear instancias de colas de prioridad (`IPriorityQueue`) según el tipo especificado.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2024-04-08
 */
public class PriorityQueueFactory {

    /**
     * Crea y devuelve una instancia de `IPriorityQueue` según el tipo especificado.
     *
     * @param type el tipo de cola de prioridad que se desea crear ("custom" para VectorHeap o "java" para JavaPriorityQueue)
     * @param <E> el tipo de elementos que se almacenarán en la cola de prioridad
     * @return una nueva instancia de `IPriorityQueue` del tipo especificado
     * @throws IllegalArgumentException si se proporciona un tipo no válido
     */
    public static <E extends Comparable<E>> IPriorityQueue<E> createPriorityQueue(String type) {
        if ("custom".equalsIgnoreCase(type)) {
            return new VectorHeap<>();
        } else if ("java".equalsIgnoreCase(type)) {
            return new JavaPriorityQueue<>();
        } else {
            throw new IllegalArgumentException("Tipo de cola de prioridad no válido: " + type);
        }
    }
}
