# Variables
CC=gcc
CFLAGS=-c -I.


prog: main.o distanceFunc.o
	$(CC) main.o distanceFunc.o -o prog


main.o: main.c distance.h
	$(CC) $(CFLAGS) main.c

distanceFunc.o: distanceFunc.c distance.h
	$(CC) $(CFLAGS) distanceFunc.c

.PHONY: clean
clean:
	rm -f *.o prog
