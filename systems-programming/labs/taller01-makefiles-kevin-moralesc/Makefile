#variable
GCC=gcc

programa: main.o functions.o
	$(GCC) -o programa main.o functions.o

main.o: main.c functions.h
	$(GCC) -c main.c

functions.o: functions.c functions.h
	$(GCC) -c functions.c


.PHONY: clean
clean:
	rm -f *.o programa
