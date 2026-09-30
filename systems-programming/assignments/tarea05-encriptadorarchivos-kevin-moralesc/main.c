#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdbool.h>
#include <string.h>
#include <getopt.h>
#include <dirent.h>
#include <openssl/sha.h>

#include "blowfish.h"

bool dflag = false; //Decrypt/Encrypt flag
bool fflag = false; //Folder flag

void print_help(char *command)
{
    printf("secret encripta o desincripta un archivo usando el algoritmo Blowfish.\n");
    printf("uso:\n %s [-d] [-f] -k <key> <nombre_archivo|carpeta>\n", command);
    printf(" %s -h\n", command);
    printf("Opciones:\n");
    printf(" -h\t\t\tAyuda, muestra este mensaje\n");
    printf(" -d\t\t\tDesincripta el archivo en lugar de encriptarlo.\n");
    printf(" -f\t\t\tEncripta/Desencripta una carpeta en vez de un archivo.\n");
    printf(" -k <key>\t\tEspecífica la clave (key) de encriptación.\n");
}

int process_file(const char *input_file, const char *output_file, BYTE *key)
{
    int fd_output = open(output_file, O_CREAT | O_TRUNC | O_WRONLY, S_IRUSR | S_IWUSR);
    if (fd_output < 0) {
        fprintf(stderr, "Error al crear el archivo de salida %s\n", output_file);
        return 1;
    }

    BYTE input_buf[BLOWFISH_BLOCK_SIZE] = {0};
    BYTE output_buf[BLOWFISH_BLOCK_SIZE] = {0};
    BLOWFISH_KEY keystruct;

    blowfish_key_setup(key, &keystruct, 8);

    int fd_input = open(input_file, O_RDONLY);
    if (fd_input < 0) {
        fprintf(stderr, "Error al abrir el archivo de entrada %s\n", input_file);
        close(fd_output);
        return 1;
    }

    ssize_t bytes_read;

    while ((bytes_read = read(fd_input, input_buf, BLOWFISH_BLOCK_SIZE)) > 0) {
        if (dflag) {
            blowfish_decrypt(input_buf, output_buf, &keystruct);
        } else {
            blowfish_encrypt(input_buf, output_buf, &keystruct);
        }

        ssize_t bytes_to_write = dflag ? bytes_read : BLOWFISH_BLOCK_SIZE;

        if (write(fd_output, output_buf, bytes_to_write) != bytes_to_write) {
            fprintf(stderr, "Error al escribir en el archivo de salida.\n");
            break;
        }

        memset(input_buf, 0, sizeof(input_buf));
    }

    close(fd_input);
    close(fd_output);
    return 0;
}

const char *get_filename(const char *path)
{
    const char *filename = strrchr(path, '/');
    if (filename)
        return filename + 1;
    return path;
}

int main(int argc, char **argv)
{
    char *target_path = NULL;
    char *key_arg_str = NULL;
    int opt, index;
    
    while ((opt = getopt(argc, argv, "dfhk:")) != -1){
        switch(opt)
        {
            case 'd':
                dflag = true;
                break;
            case 'f':
                fflag = true;
                break;
            case 'h':
                print_help(argv[0]);
                return 0;
            case 'k':
                key_arg_str = optarg;
                break;
            case '?':
            default:
                fprintf(stderr, "uso: %s [-d] [-f] -k <key> <nombre_archivo>\n", argv[0]);
                return 1;
        }
    }

    for (index = optind; index < argc; index++)
        target_path = argv[index];

    if(!target_path || !key_arg_str){
        fprintf(stderr, "Especifique el nombre del archivo/carpeta y la clave.\n");
        return 1;
    }

//  Convertir de clave a SHA1 ---
    BYTE key[8] = {0};
    unsigned char sha1_digest[SHA_DIGEST_LENGTH];
    
    // 1. Aplicamos SHA1 a la palabra clave que ingresó el usuario
    SHA1((const unsigned char *)key_arg_str, strlen(key_arg_str), sha1_digest);

    // 2. Convertimos el hash SHA1 a una cadena de texto hexadecimal
    char sha1_hex_str[41]; // 40 caracteres + el null terminator
    for (int i = 0; i < SHA_DIGEST_LENGTH; i++) {
        sprintf(&sha1_hex_str[i * 2], "%02x", sha1_digest[i]);
    }

    // 3. Tomamos los primeros 16 caracteres de esa cadena y los guardamos como los 8 bytes de la llave
    for (int i = 0; i < 8; i++) {
        unsigned int temp_byte;
        sscanf(&sha1_hex_str[i * 2], "%2x", &temp_byte);
        key[i] = (BYTE)temp_byte;
    }

    // Creamos las carpetas
    const char *output_dir = dflag ? "archivos_desencriptados" : "archivos_encriptados";
    mkdir(output_dir, 0755);

    if (fflag) {
        DIR *dir = opendir(target_path);
        if (!dir) {
            fprintf(stderr, "Error al abrir la carpeta %s\n", target_path);
            return 1;
        }

        struct dirent *entry;
        while ((entry = readdir(dir)) != NULL) {
            if (strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0)
                continue;

            char in_path[1024];
            char out_path[1024];

            snprintf(in_path, sizeof(in_path), "%s/%s", target_path, entry->d_name);
            snprintf(out_path, sizeof(out_path), "%s/%s", output_dir, entry->d_name);

            struct stat st;
            if (stat(in_path, &st) == 0 && S_ISREG(st.st_mode)) {
                printf("Procesando archivo: %s\n", entry->d_name);
                process_file(in_path, out_path, key);
            }
        }
        closedir(dir);
        printf("Carpeta procesada con éxito. Resultados en: %s/\n", output_dir);

    } else {
        const char *filename = get_filename(target_path);
        char out_path[1024];
        snprintf(out_path, sizeof(out_path), "%s/%s", output_dir, filename);

        printf("Procesando archivo: %s\n", filename);
        process_file(target_path, out_path, key);
        printf("Archivo procesado con éxito. Guardado en: %s\n", out_path);
    }

    return 0;
}
