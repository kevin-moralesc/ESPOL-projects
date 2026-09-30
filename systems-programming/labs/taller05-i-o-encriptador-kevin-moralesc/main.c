#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdbool.h>
#include <string.h>
#include <getopt.h>

#include "blowfish.h"

bool dflag = false; //Decrypt/Encrypt flag

void print_help(char *command)
{
	printf("secret encripta o desincripta un archivo usando el algoritmo Blowfish.\n");
	printf("uso:\n %s [-d] -k <key> <nombre_archivo>\n", command);
	printf(" %s -h\n", command);
	printf("Opciones:\n");
	printf(" -h\t\t\tAyuda, muestra este mensaje\n");
	printf(" -d\t\t\tDesincripta el archivo en lugar de encriptarlo.\n");
	printf(" -k <key>\t\tEspecífica la clave (key) de encriptación, 8 bytes en hex.\n");
}

int main(int argc, char **argv)
{
	struct stat mi_stat;
	char *input_file = NULL;
	char *key_arg_str = NULL;

	int opt, index;
	
	while ((opt = getopt (argc, argv, "dhk:")) != -1){
		switch(opt)
		{
			case 'd':
				dflag = true;
				break;
			case 'h':
				print_help(argv[0]);
				return 0;
			case 'k':
				key_arg_str = optarg;
        		break;
			case '?':
			default:
				fprintf(stderr, "uso: %s [-d] -k <key> <nombre_archivo>\n", argv[0]);
				fprintf(stderr, "     %s -h\n", argv[0]);
				return 1;
		}
	}

	/* Aquí recoge argumentos que no son opción, por ejemplo el nombre del input file */
	for (index = optind; index < argc; index++)
		input_file = argv[index];

	if(!input_file){
		fprintf(stderr, "Especifique el nombre del archivo.\n");
		fprintf(stderr, "uso: %s [-d] -k <key> <nombre_archivo>\n", argv[0]);
		fprintf(stderr, "     %s -h\n", argv[0]);
		return 1;
	}else{
		/* Ejemplo como verificar existencia y tamaño de un archivo */
		if(stat(input_file, &mi_stat) < 0){
			fprintf(stderr, "Archivo %s no existe!\n", input_file);
			return 1;
		}else
			printf("Leyendo el archivo %s (%ld bytes)...\n", input_file, mi_stat.st_size);
	}

	/* Valida la clave de encriptación */
	if(key_arg_str){
		if(strlen(key_arg_str) != 16){
			fprintf(stderr, "Error en tamaño de la clave de encriptación.\n");
			return 1;
		}
	}else{
		fprintf(stderr, "Error al especificar la clave de encriptación.\n");
		fprintf(stderr, "uso: %s [-d] -k <key> <nombre_archivo>\n", argv[0]);
		fprintf(stderr, "     %s -h\n", argv[0]);
		return 1;
	}
	
	
	
	/*TO-DO: Encriptar o desencriptar archivo input_file usando Blowfish */
	/*TIP: Revisar https://github.com/B-Con/crypto-algorithms/blob/master/blowfish_test.c */
	
	/* RETO1 - Extraer valor númerico de la clave en ASCII hex. (ver readme) */
	
	BYTE key[8];
	for (int i = 0; i < 8; i++) {
		unsigned int temp_byte;
		sscanf(&key_arg_str[i * 2], "%2x", &temp_byte);
		key[i] = (BYTE)temp_byte;
	}	
	/* RETO2 - generar nombre nuevo de archivo con .enc o .dec. (validar con variable dflag. Usar calloc, strcpy, strcat) */
	
	// Asignamos memoria dinámicamente con calloc para el nombre del archivo de salida
	// Sumamos +5 al tamaño de input_file para darle espacio a las extensiones (.enc o .dec) más el carácter nulo '\0'
	char *output_file = (char *)calloc(strlen(input_file) + 5, sizeof(char));
	if (!output_file) {
		fprintf(stderr, "Error al asignar memoria para el archivo de salida.\n");
		return 1;
	}

	// Copiamos el nombre original del archivo de entrada
	strcpy(output_file, input_file);

	// Dependiendo de dflag, agregamos la extensión correspondiente al final
	if (dflag) {
		strcat(output_file, ".dec");
	} else {
		strcat(output_file, ".enc");
	}
	
	
	
	
	
	
	///* RETO3 - encriptar o desencriptar (ver blowfish_test.c) *///
	
	/* Crear el archivo de salida usando llamadas de sistema POSIX open() */
	int fd_output = open(output_file, O_CREAT | O_TRUNC | O_WRONLY, S_IRUSR | S_IWUSR);
	if (fd_output < 0) {
		fprintf(stderr, "Error al crear el archivo de salida %s\n", output_file);
		free(output_file);
		return 1;
	}

	/* Configuración de las variables y buffers del algoritmo Blowfish */
	BYTE input_buf[BLOWFISH_BLOCK_SIZE] = {0};   // Buffer para leer bloques de 8 bytes
	BYTE output_buf[BLOWFISH_BLOCK_SIZE] = {0};  // Buffer para escribir bloques de 8 bytes
	BLOWFISH_KEY keystruct;                      // Estructura interna de la clave Blowfish

	// Inicializamos las subclaves internas usando la clave numérica de 8 bytes que creamos en el Reto 1
	blowfish_key_setup(key, &keystruct, 8);

	

	/* Abrimos el archivo de entrada en modo solo lectura */
	int fd_input = open(input_file, O_RDONLY);
	if (fd_input < 0) {
		fprintf(stderr, "Error al abrir el archivo de entrada %s\n", input_file);
		close(fd_output);
		free(output_file);
		return 1;
	}

	ssize_t bytes_read;

	/* Ciclo principal: leemos bloques de exactamente 8 bytes (BLOWFISH_BLOCK_SIZE) */
	while ((bytes_read = read(fd_input, input_buf, BLOWFISH_BLOCK_SIZE)) > 0) {
		
		// Dependiendo de si la bandera dflag está activa o no, desencriptamos o encriptamos
		if (dflag) {
			blowfish_decrypt(input_buf, output_buf, &keystruct);
		} else {
			blowfish_encrypt(input_buf, output_buf, &keystruct);
		}

		// Al desencriptar el último bloque, solo escribimos los bytes que originalmente se leyeron
		// para evitar que queden ceros extras invisibles al final del archivo.
		ssize_t bytes_to_write = dflag ? bytes_read : BLOWFISH_BLOCK_SIZE;

		if (write(fd_output, output_buf, bytes_to_write) != bytes_to_write) {
			fprintf(stderr, "Error al escribir en el archivo de salida.\n");
			break;
		}

		// Limpiamos el buffer de entrada llenándolo de ceros antes de la siguiente lectura
		memset(input_buf, 0, sizeof(input_buf));
	}

	/* Mostrar mensaje */
	if (dflag) {
		printf("Archivo desencriptado con éxito. Guardado en: %s\n", output_file);
	} else {
		printf("Archivo encriptado con éxito. Guardado en: %s\n", output_file);
	}

	/* Cerrar descriptores de archivo y liberar memoria asignada dinámicamente */
	close(fd_input);
	close(fd_output);
	free(output_file);

	return 0;

}
