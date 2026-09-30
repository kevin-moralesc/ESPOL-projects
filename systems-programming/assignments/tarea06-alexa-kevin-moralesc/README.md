[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DS5i-ta0)


# Tarea 06 - Alexa MiniShell Kevin Morales
## Descripción

Este proyecto consiste en la implementación de un intérprete de comandos (shell) básico. 

El programa simula el comportamiento de una terminal real mediante el uso de las llamadas al sistema `fork()` y `execvp()`. El flujo principal consiste en:
1. Leer la entrada del usuario mediante un prompt personalizado (`>> `).
2. Procesar (parsear) la cadena de texto separando los argumentos utilizando `strtok()`.
3. Generar un proceso hijo (`fork`) que ejecuta el comando solicitado (`execvp`).
4. El proceso padre espera (`wait`) a que el hijo termine su ejecución antes de volver a solicitar un nuevo comando.

### Restricciones y Limitaciones
* **NO** soporta comandos *built-ins* nativos del sistema (ej. `cd`, `dir`).
* **NO** implementa el uso de redirecciones o tuberías (`|`, `>`, `<`).

## Comandos Soportados
El shell permite ejecutar cualquier binario o programa disponible en el `$PATH` del sistema (ej. `ls -lh /usr`, `pwd`, `echo`, etc.). 

Adicionalmente, implementa los siguientes comandos internos:
* `QUIT`: Finaliza la ejecución del shell de manera segura y muestra el mensaje "BYE!".
* `-h`: Muestra el menú de ayuda (se debe ejecutar al iniciar el programa: `./alexa -h`).

## Cómo compilar
Para compilar el proyecto, utilice la herramienta `make`. En la terminal, ejecute:

`make`

Para eliminar los archivos binarios y temporales, ejecute:

`make clean`

## Cómo ejecutar
Una vez compilado, inicie el shell con:

`./alexa`

Para ver el menú de ayuda, ejecute:

`./alexa -h`
