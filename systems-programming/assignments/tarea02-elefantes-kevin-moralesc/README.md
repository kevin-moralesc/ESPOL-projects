# Programación de Sistemas - Tarea 02: Average Weights

* **Nombre:** Kevin Javier Morales Castillo

## ¿En qué consiste este repositorio?
Este repositorio contiene un programa que su trabajo  es abrir, leer y procesar un archivo de 
texto llamado `elephants.txt`. El archivo contiene los pesos de  elefantes. 
El programa lee de forma continua estos datos numéricos, realiza la suma acumulada y 
calcula el promedio, imprimiéndolo en pantalla con dos decimales. Si el archivo no existe
 en la carpeta, se muestra en pantalla q hay un error.

El programa se encuentra estructurado de estos archivos:
* **`main.c`**: Es el punto de entrada principal. Se encarga de la lógica 
para abrir el archivo con `fopen`, validar si el puntero es válido (no nulo) 
y cerrar el archivo con `fclose`.
* **`funciones.c`**: Contiene la implementación del método `calcular_promedio`. 
Este método utiliza un ciclo while con la función `fscanf` para leer los números 
flotantes uno por uno, evitando errores por espacios o saltos de línea.
* **`funciones.h`**: Contiene el prototipo de la función y las librerías estándar 
necesarias como `stdio.h` y `stdlib.h`.

Para este programa se implementó un archivo `Makefile` que qyuda a compilar el codigo de forma rapida

