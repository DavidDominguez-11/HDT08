package com.example;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    // Getters y setters

    @Override
    public int compareTo(Paciente otro) {
        // Ordenar de manera inversa: A (más alta prioridad) a E (menor prioridad)
        return otro.codigoEmergencia - this.codigoEmergencia;
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
