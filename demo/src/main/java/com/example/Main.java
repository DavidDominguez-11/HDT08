package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase principal que ejecuta un programa de simulación de atención de emergencias utilizando colas de prioridad.
 * Permite al usuario seleccionar entre dos tipos de colas de prioridad: VectorHeap personalizado o PriorityQueue del Java Collection Framework.
 * Lee datos de pacientes desde un archivo, los inserta en la cola de prioridad seleccionada y los procesa en orden de prioridad.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2024-04-08
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * Permite al usuario seleccionar el tipo de cola de prioridad y procesa los pacientes en orden de prioridad.
     * Lee los datos de pacientes desde un archivo y los inserta en la cola de prioridad.
     *
     * @param args argumentos de línea de comandos (no utilizados en este programa)
     */
    public static void main(String[] args) {
        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Mostrar el menú de selección de tipo de cola de prioridad
        System.out.println("Seleccione el tipo de cola de prioridad:");
        System.out.println("1. (VectorHeap)");
        System.out.println("2. (PriorityQueue del Java Collection Framework)");

        try {
            // Leer la elección del usuario
            String choice = reader.readLine().trim();

            IPriorityQueue<Paciente> emergencyQueue;

            // Crear la cola de prioridad según la elección del usuario
            if (choice.equals("1")) {
                System.out.println("Utilizando VectorHeap original");
                emergencyQueue = PriorityQueueFactory.createPriorityQueue("custom");
            } else if (choice.equals("2")) {
                System.out.println("Utilizando PriorityQueue del Java Collection Framework");
                emergencyQueue = PriorityQueueFactory.createPriorityQueue("java");
            } else {
                System.out.println("Opción inválida. Seleccionando Java por defecto.");
                emergencyQueue = PriorityQueueFactory.createPriorityQueue("java");
            }

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

        } catch (IOException e) {
            System.err.println("Error al leer la entrada del usuario: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el lector de entrada: " + e.getMessage());
            }
        }
    }
}
