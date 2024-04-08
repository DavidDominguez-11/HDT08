package com.example;

/**
 * Clase que representa un paciente con nombre, síntoma y código de emergencia.
 * Implementa la interfaz Comparable para permitir la comparación y ordenación de pacientes según su código de emergencia.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2024-04-08
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Constructor para crear un nuevo paciente con nombre, síntoma y código de emergencia.
     *
     * @param nombre           el nombre del paciente
     * @param sintoma          el síntoma o condición del paciente
     * @param codigoEmergencia el código de emergencia del paciente (de 'A' a 'E', donde 'A' es la mayor prioridad)
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Método para comparar este paciente con otro paciente basado en su código de emergencia.
     * Define un orden de prioridad inverso: 'A' (más alta prioridad) a 'E' (menor prioridad).
     *
     * @param otro el otro paciente con el que comparar
     * @return un valor negativo si este paciente tiene mayor prioridad que el otro,
     *         un valor positivo si este paciente tiene menor prioridad que el otro,
     *         o cero si ambos pacientes tienen la misma prioridad
     */
    @Override
    public int compareTo(Paciente otro) {
        // Ordenar de manera inversa: 'A' (más alta prioridad) a 'E' (menor prioridad)
        return otro.codigoEmergencia - this.codigoEmergencia;
    }

    /**
     * Devuelve una representación en forma de cadena de este paciente.
     *
     * @return una cadena que representa este paciente en el formato "nombre, sintoma, codigoEmergencia"
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}