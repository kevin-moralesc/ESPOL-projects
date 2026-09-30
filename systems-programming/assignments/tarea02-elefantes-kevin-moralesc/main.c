/*
    Description:  main.c file of program that calculates
                  the average weight of elephants.
    Last modify:  2026-06-09
    Modify by:    Kevin Morales
*/

#include "funciones.h"

int main() {
    // Declara el puntero de tipo FILE para manejar el archivo de datos
    FILE *fileptr;

    // Abre el archivo elephants.txt en modo lectura
    fileptr = fopen("elephants.txt", "r");

    // Si el archivo no existe, muestra el error exacto en ingles
    if (fileptr == NULL) {
        fprintf(stderr, "Error  el archivo no existe\n");
        return 1;
    }

    // Llama a la funcion para calcular el promedio
    calcular_promedio(fileptr);

    // Cierra el archivo
    fclose(fileptr);

    return 0;
}
