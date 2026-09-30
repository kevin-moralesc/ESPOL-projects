#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "libsha1.h"

//Imprime cadena de bytes en formato hexadecimal
static void print_hex(const char* data, size_t size){
	int i;
	for(i = 0; i < size; ++i)
		printf("%02x",(unsigned char) data[i]);
}

int main(int argc, char *argv[]){
	char *texto = NULL; //Importante inicializar en NULL	
	size_t n = 0;
	ssize_t l = 0;
	int i;
	
	if (argc>1 && strlen(argv[1])>0){ // Si ingresa texto por consola
		texto = argv[1];
		l = strlen(texto)+1;
		printf("El texto tiene %lu caracteres.\n",l-1);
	}else{
		printf("Ingrese texto: ");
		l = getline(&texto, &n, stdin); //getline llama a malloc internamente
		printf("El texto tiene %lu caracteres (incluido salto de línea).\n",l);

		texto[l-1] = '\0'; //OPCIONAL: Sobreescribe el salto de linea
	}

        // Calcular hash SHA-1
	sha1_ctx ctx; //Contexto para hash sha1
	char dgst[SHA1_DIGEST_SIZE]; //resultado final hash sha1

	// Añadimos las funciones de la librería externa:
	sha1_begin(&ctx);
	sha1_hash((const unsigned char *)texto, (unsigned long)strlen(texto), &ctx);
	sha1_end((unsigned char *)dgst, &ctx);
	printf("El texto \'%s\' en SHA1 es: \n",texto);
	print_hex(dgst, SHA1_DIGEST_SIZE);
	printf("\n");

	if (argc==1)
		free(texto); //liberar espacio reservado para texto (si uso getline)
}
