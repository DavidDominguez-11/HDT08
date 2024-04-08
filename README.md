# HDT08 ALGORITMOS Y ESTRUCTURAS DE DATOS
# David Dominguez 23712
Hoja de trabajo sobre Colas con Prioridad y su implementación con HEAPS, Un sistema de colas con prioridad para atender pacientes en la emergencia de un hospital.

Este programa implementa una cola de prioridad en Java utilizando dos enfoques diferentes:

JavaPriorityQueue: Implementación de una cola de prioridad utilizando la clase PriorityQueue del Java Collections Framework.
VectorHeap: Implementación de una cola de prioridad utilizando un vector (ArrayList) y aplicando las operaciones de un (heap) máximo.
La cola de prioridad se utiliza para gestionar una lista de pacientes según su código de emergencia, donde un código más alto indica una mayor prioridad.

## Contenido del Repositorio
El repositorio contiene los siguientes componentes:

src: Directorio que contiene el código fuente del proyecto.
com.example: Paquete principal del proyecto.
IPriorityQueue.java: Interfaz que define los métodos comunes para una cola de prioridad.
JavaPriorityQueue.java: Implementación de IPriorityQueue utilizando PriorityQueue.
Main.java: Clase principal que muestra la funcionalidad de la cola de prioridad.
Paciente.java: Clase que representa un paciente con un código de emergencia.
PriorityQueueFactory.java: Fábrica para crear instancias de IPriorityQueue según el tipo especificado.
VectorHeap.java: Implementación de IPriorityQueue utilizando un vector (ArrayList) y aplicando un montículo (heap) máximo.
demo: Directorio que contiene archivos de demostración para el programa.
pacientes.txt: Archivo de texto con información de pacientes utilizado en la demo.

## Pruebas Unitarias
El proyecto incluye pruebas unitarias para la implementación de VectorHeap ubicadas en el directorio src/test/java/com/example. Estas pruebas están diseñadas para verificar el correcto funcionamiento de los métodos implementados en VectorHeap.

## Diagrama de Clases UML  
![UML HDT08](https://github.com/DavidDominguez-11/HDT08/assets/84152698/5448ff21-05f7-4399-8f6c-b04cfaad07b9)
  
## Ejecución del Programa
Para ejecutar el programa:

Ejecuta la clase Main.java.
Sigue las instrucciones en consola para seleccionar el tipo de cola de prioridad y procesar la atención de los pacientes.

## Descripción de Clases
IPriorityQueue
La interfaz IPriorityQueue define los métodos comunes para una cola de prioridad genérica en Java. Estos métodos incluyen:

getFirst(): Devuelve el elemento con la máxima prioridad (mínimo valor) sin eliminarlo de la cola.
remove(): Elimina y devuelve el elemento con la máxima prioridad (mínimo valor) de la cola.
add(value): Agrega un elemento a la cola de prioridad.
isEmpty(): Verifica si la cola de prioridad está vacía.
size(): Devuelve el número de elementos en la cola de prioridad.
clear(): Elimina todos los elementos de la cola de prioridad.
JavaPriorityQueue
La clase JavaPriorityQueue implementa la interfaz IPriorityQueue utilizando la clase PriorityQueue del Java Collections Framework. Proporciona las siguientes funcionalidades:

getFirst(): Devuelve el elemento con la máxima prioridad (mínimo valor) sin eliminarlo de la cola.
remove(): Elimina y devuelve el elemento con la máxima prioridad (mínimo valor) de la cola.
add(value): Agrega un elemento a la cola de prioridad.
isEmpty(): Verifica si la cola de prioridad está vacía.
size(): Devuelve el número de elementos en la cola de prioridad.
clear(): Elimina todos los elementos de la cola de prioridad.
VectorHeap
La clase VectorHeap implementa la interfaz IPriorityQueue utilizando un vector (ArrayList) y aplicando las operaciones de un montículo (heap) máximo. Sus funcionalidades incluyen:

isEmpty(): Verifica si el montículo está vacío.
size(): Devuelve el número de elementos en el montículo.
add(element): Agrega un elemento al montículo manteniendo la propiedad de heap máximo.
getMax(): Devuelve y elimina el elemento con la máxima prioridad (raíz del montículo).
getFirst(): Devuelve el elemento con la máxima prioridad (raíz del montículo) sin eliminarlo.
remove(): Elimina y devuelve el elemento con la máxima prioridad (raíz del montículo).
clear(): Elimina todos los elementos del montículo.
Main
La clase Main contiene el método main que demuestra el uso de la cola de prioridad en el contexto de un sistema de atención de emergencias médicas. Esta clase interactúa con IPriorityQueue, Paciente y PriorityQueueFactory para seleccionar el tipo de cola de prioridad (ya sea JavaPriorityQueue o VectorHeap) y procesar la atención de los pacientes.

Paciente
La clase Paciente representa a un paciente con información básica como nombre, síntoma y código de emergencia. Implementa la interfaz Comparable para que los pacientes puedan ser comparados y ordenados según su código de emergencia.

PriorityQueueFactory
La clase PriorityQueueFactory es una fábrica que crea instancias de IPriorityQueue según el tipo especificado (ya sea "java" para JavaPriorityQueue o "custom" para VectorHeap).
