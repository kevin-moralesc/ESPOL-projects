#variable
GCC=gcc

programa: main.o
	$(GCC) -o programa main.o

main.o: main.c
	$(GCC) -c main.c

.PHONY: clean
clean:
	rm -f *.o programa
