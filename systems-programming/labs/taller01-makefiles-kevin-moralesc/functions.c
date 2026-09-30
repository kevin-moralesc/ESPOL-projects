/*
	Descripcion: functions file that contains the functions for counting words
	Last Modify: 2026-06-01
	Modify by: Kevin Morales
*/

#include "functions.h"

int count_words(FILE *file){
	int count = 0;
	char word[MAXWORD];

	// Retorna EOF cuando llega al final del archivo.
	while (fscanf(file, "%s", word) != EOF) {
		count++;
	}

	return count;
}
