#include "common.h"

// Implementación de las funciones del buffer usando semáforos

void sbuf_init(sbuf_t *sp, int n) {
    sp->buf = calloc(n, sizeof(int));
    sp->n = n;
    sp->front = sp->rear = 0;
    sem_init(&sp->mutex, 0, 1);       // Mutex inicializado en 1 (desbloqueado)
    sem_init(&sp->slots, 0, n);       // Slots inicializado en 'n' (todo el espacio disponible)
    sem_init(&sp->items, 0, 0);       // Items inicializado en 0 (buffer vacío)
}

void sbuf_insert(sbuf_t *sp, int item) {
    sem_wait(&sp->slots);             // Espera a que haya un espacio disponible
    sem_wait(&sp->mutex);             // Bloquea el acceso al buffer (sección crítica)

    sp->buf[(++sp->rear) % (sp->n)] = item; // Inserta el socket de forma circular

    sem_post(&sp->mutex);             // Libera el acceso al buffer
    sem_post(&sp->items);             // Anuncia que hay un nuevo item disponible
}

int sbuf_remove(sbuf_t *sp) {
    int item;
    sem_wait(&sp->items);             // Espera a que haya un item (socket) disponible
    sem_wait(&sp->mutex);             // Bloquea el acceso al buffer (sección crítica)
    
    item = sp->buf[(++sp->front) % (sp->n)]; // Saca el socket del buffer
    
    sem_post(&sp->mutex);             // Libera el acceso al buffer
    sem_post(&sp->slots);             // Anuncia que hay un nuevo espacio disponible
    return item;
}





int open_listenfd(char *port) 
{
    struct addrinfo hints, *listp, *p;
    int listenfd, optval=1;

    /* Get a list of potential server addresses */
    memset(&hints, 0, sizeof(struct addrinfo));
    hints.ai_socktype = SOCK_STREAM;  /* Accept TCP connections */
    hints.ai_flags = AI_PASSIVE;      /* ... on any IP address */
    hints.ai_flags |= AI_NUMERICSERV; /* ... using a numeric port arg. */
    hints.ai_flags |= AI_ADDRCONFIG;  /* Recommended for connections */
    getaddrinfo(NULL, port, &hints, &listp);

    /* Walk the list for one that we can bind to */
    for (p = listp; p; p = p->ai_next) {

        /* Create a socket descriptor */
        if ((listenfd = socket(p->ai_family, p->ai_socktype, p->ai_protocol)) < 0) 
            continue;  /* Socket failed, try the next */

        /* Eliminates "Address already in use" error from bind */
        setsockopt(listenfd, SOL_SOCKET, SO_REUSEADDR, 
                   (const void *)&optval , sizeof(int));

        /* Bind the descriptor to the address */
        if (bind(listenfd, p->ai_addr, p->ai_addrlen) == 0)
            break; /* Success */
        close(listenfd); /* Bind failed, try the next */
    }

    /* Clean up */
    freeaddrinfo(listp);
    if (!p) /* No address worked */
        return -1;

    /* Make it a listening socket ready to accept connection requests */
    if (listen(listenfd, 1024) < 0)
		return -1;
    return listenfd;
}


int open_clientfd(char *hostname, char *port) {
    int clientfd;
    struct addrinfo hints, *listp, *p;

    memset(&hints, 0, sizeof(struct addrinfo));
    hints.ai_socktype = SOCK_STREAM;  
    hints.ai_flags = AI_NUMERICSERV; 
    hints.ai_flags |= AI_ADDRCONFIG; 
    getaddrinfo(hostname, port, &hints, &listp);
  
    for (p = listp; p; p = p->ai_next) {

        if ((clientfd = socket(p->ai_family, p->ai_socktype, p->ai_protocol)) < 0) 
            continue; 
        if (connect(clientfd, p->ai_addr, p->ai_addrlen) != -1) 
            break; 
        close(clientfd); 
    } 

    freeaddrinfo(listp);
    if (!p) 
        return -1;
    else   
        return clientfd;
}

void connection_error(int connfd)
{
	fprintf(stderr, "Error de conexión: %s\n", strerror(errno));
	close(connfd);
	exit(-1);
}


