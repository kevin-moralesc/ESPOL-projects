#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>      // Para fork() y execvp()
#include <sys/wait.h>    // Para wait()

#define MAX_LINE 1024
#define MAX_ARGS 100 // Número máximo de argumentos
int main(int argc, char *argv[]) {
    // Manejo mensaje de ayuda (-h)
    if (argc == 2 && strcmp(argv[1], "-h") == 0) {
        printf("Uso: ./alexa\n");
        printf("Shell basico. Solo soporta el built-in: QUIT\n");
        return 0;
    }

    char input[MAX_LINE];
    char *args[MAX_ARGS]; // Arreglo para guardar los comandos y argumentos separados

    // Bucle principal del shell
    while (1) {
        printf(">> ");
        fflush(stdout); // Fuerza a que el prompt salga en pantalla de inmediato

        // Leer lo que escribe el usuario
        if (fgets(input, MAX_LINE, stdin) == NULL) {
            break; // Si hay error o se presiona Ctrl+D, salimos
        }

        // Limpiar el salto de linea (\n) que deja la tecla Enter al final del texto
        input[strcspn(input, "\n")] = 0;

        // Si el usuario no escribio nada y solo dio Enter, volvemos a preguntar
        if (strlen(input) == 0) {
            continue;
        }

        // Al escribir QUIT para terminar el shell
        if (strcmp(input, "QUIT") == 0) {
            printf("BYE!\n");
            break;
        }

	// Separar el comando en "tokens" (palabras)
        int i = 0;
        // Obtenemos la primera palabra, separando por el espacio " "
        char *token = strtok(input, " ");

        while (token != NULL) {
            args[i] = token; // Guardamos la palabra en nuestro arreglo
            i++;
            // Obtenemos la siguiente palabra
            token = strtok(NULL, " "); 
        }

        // El arreglo siempre debe terminar en NULL
        args[i] = NULL;

        pid_t pid = fork(); // Creamos el proceso hijo

        if (pid < 0) {
            // Si pid es menor a 0, hubo un error al clonar
            perror("Error en fork");
        } 
        else if (pid == 0) {
            // PROCESO HIJO
            // execvp busca el programa (args[0]) y le pasa los argumentos (args)
            if (execvp(args[0], args) == -1) {
                // Si execvp falla, imprimimos error
                perror("Error");
            }
            // El hijo DEBE morir si execvp falla, para no tener dos shells corriendo
            exit(EXIT_FAILURE); 
        } 
        else {
            // PROCESO PADRE (shell original)
            // Esperamos pacientemente a que el hijo termine su trabajo
            wait(NULL);
        }
    }

    return 0;
}
