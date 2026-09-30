EXEC = secret
DEPS = blowfish.h

# Target para compilar el ejecutable final (se agrega -lcrypto aquí)
$(EXEC): main.o blowfish.o $(DEPS)
	gcc -o $@ main.o blowfish.o $(DFLAGS) -lcrypto

%.o: %.c $(DEPS)
	gcc -c $< $(DFLAGS)

.PHONY: sanitize debug clean
# Compila usando la opción -g para facilitar la depuración con gdb.
debug: DFLAGS = -g
debug: clean $(EXEC)

# Compila habilitando la herramienta AddressSanitizer para
# facilitar la depuración en tiempo de ejecución.
sanitize: DFLAGS = -fsanitize=address,undefined
sanitize: clean $(EXEC)

clean:
	rm -rf $(EXEC) *.o *.enc *.dec archivos_encriptados archivos_desencriptados
