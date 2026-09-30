#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <getopt.h>
#include <string.h>

#include "input.h"

bool eflag = false; //Opción -e, switch to english
bool iflag = false; //Opción -i, ingresa una línea de texto
bool aflag = false; //Opción -a, orden ascendente
bool dflag = false; //Opción -d, orden descendente


void sort(char **text, int n, bool ascendente){
    char *temp;
    int i, j;

    for(i=0; i<n; i++){
        for (j=i+1; j<n; j++){
            // Compara dos palabras. Si están en el orden incorrecto, las intercambia.
            if ((ascendente && strcmp(text[i], text[j]) > 0) || 
                (!ascendente && strcmp(text[i], text[j]) < 0)) {
                temp = text[i];
                text[i] = text[j];
                text[j] = temp;
            }
        }
    }
}

void print_help(char *command)
{
	printf("Programa en C ejemplo, imprime argumentos ingresados en consola.\n");
	printf("uso:\n");
	printf(" ./programa [-i] [-e] [-a] [-d] [arg 1] [arg 2] ... [arg n]\n");
	printf(" ./programa -h\n");
	printf("Opciones:\n");
	printf(" -h			Ayuda, muestra este mensaje\n");
	printf(" -e			Switch to english\n");
	printf(" -i			Ingresa una línea de texto\n");
	printf(" -a			Imprime argumentos en orden ascendente\n");
	printf(" -d			Imprime argumentos en orden descendente\n");

}

int main(int argc, char **argv)
{
	int opt, index;

	/* Este lazo recorre los argumentos buscando las
	opciones indicadas... */
	while ((opt = getopt (argc, argv, "iehad")) != -1){
		switch(opt)
		{
			case 'i':
				iflag = true;
				break;
			case 'e':
				eflag = true;
				break;
			//TO-DO: cases for: -a -d (no olvidar el break)
				case 'a':
					aflag = true;
					break;
				case 'd':
					dflag = true;
					break;
			case 'h':
				print_help(argv[0]);
				return 0;
			case '?':
			default: 
				fprintf(stderr, "uso: %s [-i] [-e] [-a] [-d] [arg 1] [arg 2] ... [arg n]\n", argv[0]); //TO-DO: update -a -d
				fprintf(stderr, "     %s -h\n", argv[0]);
				return -1;
		}
	}

	// TO-DO: Sorting -a | -d
	// Calcula cuántas palabras normales ingresó el usuario
	int num_args = argc - optind;

	// Si se activó -a o se activó -d, pero NO ambas al mismo tiempo:
	if ((aflag || dflag) && !(aflag && dflag)) {
		// Llamamos a nuestra función sort pasándole dónde empiezan las palabras
		sort(&argv[optind], num_args, aflag);
	}

	
	/* Aquí imprime argumentos que no son opción */
	// optind: indica el inicio de los argumentos sin opción
	for (index = optind; index < argc; index++) {
		if(eflag)
			printf ("Non-option argument: %s\n", argv[index]);
		else
			printf ("Argumento no-opción: %s\n", argv[index]);
	}

	/* Aquí ingresa una línea de texto desde consola y la reimprime en consola */
	if(iflag) {
		char *texto;
		get_from_console(&texto);
		printf("%s\n", texto);
		free(texto);
	}

	/* El programa se invocó sin usar opciones o argurmentos */
	if(argc == 1)
		print_help(argv[0]);
}
