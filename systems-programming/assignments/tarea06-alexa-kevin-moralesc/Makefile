CC = gcc
CFLAGS = -Wall

all: alexa

alexa: main.o
	$(CC) $(CFLAGS) main.o -o alexa

main.o: main.c
	$(CC) $(CFLAGS) -c main.c

clean:
	rm -f alexa *.o
