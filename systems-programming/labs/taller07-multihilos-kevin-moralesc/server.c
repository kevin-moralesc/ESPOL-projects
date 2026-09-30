#include <getopt.h>
#include <limits.h>
#include <sys/wait.h>


#include <pthread.h>
#include <syslog.h>
#include <fcntl.h>

#include "common.h"

void atender_cliente(int connfd);

void print_help(char *command)
{
	printf("Servidor simple de ejecución remota de comandos.\n");
	printf("uso:\n %s <puerto>\n", command);
	printf(" %s -h\n", command);
	printf("Opciones:\n");
	printf(" -h\t\t\tAyuda, muestra este mensaje\n");
	//-d option for deamonize
	printf(" -d\t\t\tFunciona en modo daemon\n");
}

/**
 * Función que crea argv separando una cadena de caracteres en
 * "tokens" delimitados por la cadena de caracteres delim.
 *
 * @param linea Cadena de caracteres a separar en tokens.
 * @param delim Cadena de caracteres a usar como delimitador.
 *
 * @return Puntero a argv en el heap, es necesario liberar esto después de uso.
 *	Retorna NULL si linea está vacía.
 */
char **parse_comando(char *linea, char *delim)
{
	char *token;
	char *linea_copy;
	int i, num_tokens = 0;
	char **argv = NULL;

	linea_copy = (char *) malloc(strlen(linea) + 1);
	strcpy(linea_copy, linea);

	/* Obtiene un conteo del número de argumentos */
	token = strtok(linea_copy, delim);
	/* recorre todos los tokens */
	while( token != NULL ) {
		token = strtok(NULL, delim);
		num_tokens++;
	}
	free(linea_copy);

	/* Crea argv en el heap, extrae y copia los argumentos */
	if(num_tokens > 0){

		/* Crea el arreglo argv */
		argv = (char **) malloc((num_tokens + 1) * sizeof(char **));

		/* obtiene el primer token */
		token = strtok(linea, delim);
		/* recorre todos los tokens */
		for(i = 0; i < num_tokens; i++){
			argv[i] = (char *) malloc(strlen(token)+1);
			strcpy(argv[i], token);
			token = strtok(NULL, delim);
		}
		argv[i] = NULL;
	}

	return argv;
}

/**
 * Recoge hijos zombies... (puede ser eliminado)
 */
void recoger_hijos(int signal){
	while(waitpid(-1, 0, WNOHANG) >0)
		;

	return;
}

/**
 * Recibe SIGINT, termina ejecución. NO comentar ni eliminar esta función!!!
 */
void salir(int signal){
	printf("BYE\n");
	exit(0);
}

void *thread(void *vargp); 
int dflag = 0;

// define and implement daemonize() function (funcion en ppt)
void daemonize(char *nombre_programa) {
	pid_t pid;

	// Primer fork para separar el proceso
	pid = fork();
	if (pid < 0) exit(1); // Error
	if (pid > 0) exit(0); // El proceso padre original termina aquí

	// Crear una nueva sesión independiente de la terminal
	if (setsid() < 0) exit(1);

	// Segundo fork (buena práctica para que no vuelva a pedir una terminal)
	pid = fork();
	if (pid < 0) exit(1);
	if (pid > 0) exit(0);

	// Dar permisos completos a los archivos que cree el demonio y moverse a la raíz
	umask(0);
	chdir("/");

	// Apagar las salidas a la pantalla (porque en segundo plano nadie las lee)
	int fd = open("/dev/null", O_RDWR);
	if (fd != -1) {
		dup2(fd, 0); // Apaga entrada estándar
		dup2(fd, 1); // Apaga salida estándar (printf)
		dup2(fd, 2); // Apaga errores estándar
		close(fd);
	}
}



int main(int argc, char **argv)
{
	int opt, index;

	//Sockets
	int listenfd;
	unsigned int clientlen;
	//Direcciones y puertos
	struct sockaddr_in clientaddr;
	char *port;

	while ((opt = getopt (argc, argv, "hd")) != -1){
		switch(opt)
		{
			case 'h':
				print_help(argv[0]);
				return 0;
			//-d (dflag/break)
			case 'd':
				dflag = 1;   //encendemos la bandera si es el caso -d
				break;
			default:
				fprintf(stderr, "uso: %s <puerto>\n", argv[0]);
				fprintf(stderr, "     %s -h\n", argv[0]);
				return -1;
		}
	}

	/* Recorre argumentos que no son opción */
	for (index = optind; index < argc; index++)
		port = argv[index];

	if(argv == NULL){
		fprintf(stderr, "uso: %s <puerto>\n", argv[0]);
		fprintf(stderr, "     %s -h\n", argv[0]);
		return 1;
	}

	//Valida el puerto
	int port_n = atoi(port);
	if(port_n <= 0 || port_n > USHRT_MAX){
		fprintf(stderr, "Puerto: %s invalido. Ingrese un número entre 1 y %d.\n", port, USHRT_MAX);
		return 1;
	}

	//Registra funcion para recoger hijos zombies (innecesario?)
	signal(SIGCHLD, recoger_hijos);

	//Registra funcion para señal SIGINT (Ctrl-C)
	// NO comentar ni eliminar esta linea!!!
	signal(SIGINT, salir);

	//Abre un socket de escucha en port
	listenfd = open_listenfd(port);

	if(listenfd < 0)
		connection_error(listenfd);

	// Si el usuario puso -d, activamos el demonio
	if (dflag) {
		daemonize(argv[0]);
	}
	printf("server escuchando en puerto %s...\n", port);

	// thread vars
	pthread_t tid;
	int *connfdp;

	while (1) {
		clientlen = sizeof(clientaddr);
		// Asignamos memoria dinámica para evitar la condición de carrera
		connfdp = malloc(sizeof(int));

		// Aceptamos la conexión y la guardamos en nuestro puntero
		*connfdp = accept(listenfd, (struct sockaddr *)&clientaddr, &clientlen);

		// Creamos el hilo
		pthread_create(&tid, NULL, thread, connfdp);
		}
		//TO-DO: threadcreate (ver diapositiva)

		//codigo viejo de procesos
		//El proceso hijo atiende al cliente (innecesario?)
		/* if(fork() == 0){
			close(listenfd);
			// Determine the domain name and IP address of the client
			hp = gethostbyaddr((const char *)&clientaddr.sin_addr.s_addr,
						sizeof(clientaddr.sin_addr.s_addr), AF_INET);
			haddrp = inet_ntoa(clientaddr.sin_addr);

			printf("server conectado a %s (%s)\n", hp->h_name, haddrp);
			atender_cliente(connfd);
			printf("server desconectando a %s (%s)\n", hp->h_name, haddrp);
			close(connfd);
			exit(0);

}

		close(connfd);
	}*/
	return 0;
}

// *thread() function

void *thread(void *vargp) 
{
	// Extraemos el descriptor de conexión del puntero
	int connfd = *((int *)vargp);

	// "Desprendemos" el hilo para que el sistema limpie sus recursos automáticamente al terminar
	pthread_detach(pthread_self());

	// Liberamos la memoria que reservamos con malloc en el main (crucial para no saturar la RAM)
	free(vargp);

	// Llamamos a la función atender cliente
	atender_cliente(connfd);

	// Cerramos la conexión de este cliente
	close(connfd);

	return NULL;
}



void atender_cliente(int connfd)
{
	int n, status;
	char buf[MAXLINE] = {0};
	char **argv;
	pid_t pid;

	//Comunicación con cliente es delimitada con '\0'
	while(1){
		n = read(connfd, buf, MAXLINE);
		if(n <= 0)
			return;

		printf("Recibido: %s", buf);

		//Detecta "CHAO" y se desconecta del cliente
		if(strcmp(buf, "CHAO\n") == 0){
			write(connfd, "BYE\n", 5);
			return;
		}

		//Remueve el salto de linea antes de extraer los tokens
		buf[n - 1] = '\0';

		//Crea argv con los argumentos en buf, asume separación por espacio
		argv = parse_comando(buf, " ");

		if(argv){
			if((pid = fork()) == 0){
				dup2(connfd, 1); //Redirecciona STDOUT al socket
				dup2(connfd, 2); //Redirecciona STDERR al socket
				if(execvp(argv[0], argv) < 0){
					fprintf(stderr, "Comando desconocido...\n");
					exit(1);
				}
			}

			//Espera a que el proceso hijo termine su ejecución
			waitpid(pid, &status, 0);

			if(!WIFEXITED(status))
				write(connfd, "ERROR\n",7);
			else
				write(connfd, "\0", 1); //Envia caracter null para notificar fin

			/*Libera argv y su contenido
			para evitar fugas de memoria */
			for(int i = 0; argv[i]; i++)
				free(argv[i]);
			free(argv);

		}else{
			strcpy(buf, "Comando vacío...\n");
			write(connfd, buf, strlen(buf) + 1);
		}

		memset(buf, 0, MAXLINE); //Encera el buffer
	}
}
