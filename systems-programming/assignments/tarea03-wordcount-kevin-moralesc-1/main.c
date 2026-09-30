#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <getopt.h>
#include <string.h>

//TODO: declarar flags
bool count_flag = false;
bool file_flag = false;

#define MAXWORD 20
// Función que abre el archivo, lee palabra por palabra y cuenta cuántas cumplen con el tamaño mínimo
int count_words(char *filename, int size){
    // Intenta abrir el archivo pasado por parámetro en modo lectura ("r")
    FILE *file = fopen(filename, "r");
    // Si el archivo no existe fopen devuelve NULL
    if (file == NULL) {
        fprintf(stderr, "No se pudo abrir el archivo '%s'\n", filename);
        exit(EXIT_FAILURE);
    }

    int count = 0;
    char palabra[MAXWORD];
    // fscanf() devuelve el número de elementos leídos, en este caso 1 si se leyó una palabra correctamente
    while (fscanf(file, "%s", palabra) == 1) { 
        // funcion strlen()  -->  obtiene largo de palabra directo tal como viene en el texto
        int longitud = strlen(palabra);

        if (longitud >= size) {  
            count++; 
        }
    }
    
    fclose(file);
    return count;
}

// Imprimir las instrucciones de uso en la pantalla si se solicita o se equivoca
void print_help(char *command){
	printf("Programa en C ejemplo, imprime argumentos ingresados en consola.\n");
	printf("Uso:\n");
    printf("  %s -c N -f filename\n", command); // Muestra un ejemplo de cómo usar -c y -f
    printf("  %s -h\n", command); 	// Muestra la opción de ayuda
}

int main(int argc, char **argv)
{
	int opt;
	int size_limit = 0;
    char *filename = NULL;

	//helper: https://www.gnu.org/software/libc/manual/html_node/Example-of-Getopt.html#Example-of-Getopt
	/* Este lazo recorre los argumentos buscando las opciones -c, -f */
	while ((opt = getopt (argc, argv, "hc:f:")) != -1){
		switch(opt){
			// atoi( texto ) --> convierte a entero
			case 'c':
				count_flag = true;	// Cambia el flag a true 
				size_limit = atoi(optarg); // optarg contiene el texto (ej. "8"). atoi lo convierte a un número
				break;
			case 'f':
				file_flag = true;
				filename = optarg;	// Guarda el texto directo que acompaña a -f (el nombre del archivo)
				break;
			
			case 'h':
				print_help(argv[0]);
				return 0;
			case '?':
			default:
				fprintf(stderr, "uso: %s [-c N] [-f filename] [arg 1] [arg 2] ... [arg n]\n", argv[0]);
				fprintf(stderr, "     %s -h\n", argv[0]);
				return -1;
		}
	}
	//Si el programa se ejecutó solo (ej: ./programa), argc vale 1 
	if (argc == 1){
		print_help(argv[0]);
		return 0;
	}
	// si alguno de los dos flags obligatorios se quedó en 'false'
	if (!count_flag || !file_flag) {
        fprintf(stderr, "Faltan parametros obligatorios (-c o -f).\n");
        return -1;
    }

	//Llama a la función count_words 
    int count = count_words(filename, size_limit);

	// Imprime resultado 
    printf("The number of words with length>=%d in '%s' file is %d.\n", size_limit, filename, count);
	return 0;
}
