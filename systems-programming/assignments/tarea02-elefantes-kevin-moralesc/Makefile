 #variable
GCC=gcc

promedio: main.o funciones.o
	$(GCC) -o promedio main.o funciones.o

main.o: main.c funciones.h
	$(GCC) -c main.c

funciones.o: funciones.c funciones.h
	$(GCC) -c funciones.c

.PHONY: clean
clean:
	rm -f *.o promedio
