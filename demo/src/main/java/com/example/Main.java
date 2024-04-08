package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        VectorHeap<Paciente> emergencyQueue = new VectorHeap<>();

        // Leer pacientes desde el archivo pacientes.txt
        String filename = "demo\\src\\main\\java\\com\\example\\pacientes.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String nombre = parts[0];
                    String sintoma = parts[1];
                    char codigoEmergencia = parts[2].charAt(0);

                    // Crear un nuevo paciente y agregarlo a la cola de prioridad
                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    emergencyQueue.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Procesar la atención de los pacientes en orden de prioridad
        System.out.println("Procesando atención de pacientes:");
        while (!emergencyQueue.isEmpty()) {
            Paciente nextPatient = emergencyQueue.remove();
            System.out.println("Atender a: " + nextPatient.toString());
        }
    }
}
