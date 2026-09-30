# Tarea03 - WordCount

# Nombre:
Kevin Morales

Este programa abre un archivo de texto con la función fopen() usando el nombre que el usuario escribe en la consola. 

Luego, usa un bucle while y la función fscanf() para leer el archivo palabra por palabra de forma secuencial.

Para saber el tamaño de cada palabra, el programa utiliza la función strlen(), la cual obtiene la longitud directa del texto tal y como viene en el archivo (incluyendo los signos que tenga pegados).

Después, revisa con una condición if si esa longitud es mayor o igual al tamaño mínimo que pidió el usuario. Si cumple con la condición, lo cuenta sumando uno al contador de palabras válidas.

En la función main(), el programa usa getopt() dentro de un while para capturar lo que el usuario escribe en la terminal. 

El caso 'c' guarda el tamaño mínimo convirtiendo el texto a un número entero con la función atoi(). 

El caso 'f' guarda el nombre del archivo de texto.

El caso 'h' muestra la ayuda en pantalla con la función print_help().

Al final, el programa tiene un if que revisa si el usuario olvidó poner el parámetro -c o -f. Si se le olvidó alguno, muestra un mensaje de error con fprintf(stderr) y detiene el programa regresando un -1. 

Si todo está correcto, llama a la función para contar las palabras, muestra el resultado final en la pantalla y termina de forma exitosa.

## Instrucciones para compilar y usar el programa:

Para compilar el código y crear el programa ejecutable escriba:
make

Para borrar los archivos temporales .o y limpiar la carpeta escriba:
make clean

Para usar el programa manualmente con el archivo de la tarea:
./programa -c 5 -f c_history.txt




[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/i3KR2ecy)
