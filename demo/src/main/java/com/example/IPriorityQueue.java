package com.example;

/**
 * Esta interfaz representa una cola de prioridad que almacena elementos de tipo E, donde E extiende Comparable<E>.
 * Los elementos se almacenan en la cola según su orden natural definido por Comparable.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2024-04-08
 *
 * @param <E> el tipo de elementos almacenados en la cola de prioridad
 */
public interface IPriorityQueue<E extends Comparable<E>> {

    /**
     * Obtiene el valor mínimo en la cola de prioridad.
     *
     * @return el valor mínimo en la cola de prioridad
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    E getFirst();

    /**
     * Elimina y devuelve el valor mínimo de la cola de prioridad.
     *
     * @return el valor mínimo que fue eliminado
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    E remove();

    /**
     * Agrega un valor a la cola de prioridad.
     *
     * @param value el valor que se va a agregar
     * @throws NullPointerException si el valor especificado es nulo
     */
    void add(E value);

    /**
     * Comprueba si la cola de prioridad está vacía.
     *
     * @return true si la cola de prioridad está vacía; false en caso contrario
     */
    boolean isEmpty();

    /**
     * Retorna el número de elementos en la cola de prioridad.
     *
     * @return el número de elementos en la cola de prioridad
     */
    int size();

    /**
     * Elimina todos los elementos de la cola de prioridad.
     * La cola estará vacía después de llamar a este método.
     */
    void clear();
}
