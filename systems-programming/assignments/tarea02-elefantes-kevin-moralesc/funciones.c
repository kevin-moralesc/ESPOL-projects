/*
	Descripcion: functions file that contains the functions for average weights
	Last Modify: 2026-06-09
	Modify by: Kevin Morales
*/

#include "funciones.h"

void calcular_promedio(FILE *file) {
    
    double peso;
    double sumaPesos = 0.0;
    int count = 0;

   //fscanf lee numero por numero del archivo de forma continua.
   //El especificador "%lf" es para double, y retorna 1 siempre que logre leer un numero valido.
     
    while (fscanf(file, "%lf", &peso) == 1) {
        sumaPesos += peso;
        count++;
    }

   // verifica y muestra el promedio 
    if (count > 0) {
        // Calcular matematicamente el promedio simple de los pesos
        double promedio = sumaPesos / count;
        printf("Peso promedio: %.2f\n", promedio);
    } else {
         fprintf(stderr, "No se encontraron datos en el archivo.\n");
    }
}
