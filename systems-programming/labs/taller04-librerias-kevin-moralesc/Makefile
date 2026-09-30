hash: main.c
	gcc -static -o hash main.c libsha1.a

hash_dyn: main.c
	gcc -o hash_dyn main.c -Wl,-rpath,. -L. -lsha1

.PHONY: clean
clean:
	rm -rf hash hash_dyn
