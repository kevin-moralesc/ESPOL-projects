# Taller uso de librerías
Taller sobre uso de librerías de terceros en C.

## Instrucciones
En esta práctica se debe implementar un programa que calcule el hash [SHA-1](https://en.wikipedia.org/wiki/SHA-1) de un texto ingresado por el usuario. SHA-1 produce un hash de 20 bytes a partir de un texto de cualquier longitud.

Primero instale los siguientes programas (para evitar errores): 

```
sudo apt install autoconf autogen libtool shtool
```

Luego, para implementar el algoritmo SHA-1 es necesario usar una librería de terceros (el algoritmo es relativamente complejo). La librería a utilizar es *libsha1*, el repositorio del código fuente está en:

* https://github.com/dottedmag/libsha1


Para usar libsha1 es necesario clonar el repositorio y compilar la librería (clonar fuera del repositorio del taller):
```
$ git clone https://github.com/dottedmag/libsha1.git
$ cd libsha1
$ ./autogen.sh
$ make
```
Al hacer el paso final (make), puede que le de warnings (ignorarlos)

Una vez realizado el paso anterior, dentro de la carpetas aparecerán las librerías compiladas, estáticas y dinámicas (.a y .so) que se encuentran dentro de la carpeta oculta _.libs_; estas librerías deberán ser copiadas en el directorio principal del proyecto. También, se deberá copiar la cabecera de la librería (.h). NO COPIAR LOS ARCHIVOS SOFTLINK (accesos directos)
Revisar el archivo llamado _test.c_, donde muestra un ejemplo de cómo usar esta librería.

Nota: Al archivo copiado dentro de su proyecto llamado _libsha1.so.0.0.0_ debe ser renombrado por _libsha1.so_ ( y para evitar posible errores con el autocalificador, crear una copia de este archivo y ponerle el nombre de _libsha1.so.0_)


## TO-DO
Modificar los archivos: _main.c_ y _Makefile_ (guiarse por los TO-DO y del archivo _test.c_)

La práctica debe ser compilada de manera estática por defecto usando *make* y de manera dinámica usando *make hash_dyn*, el primero generará un ejecutable llamado ***_hash_*** y el otro ***_hash_dyn_***. Compilar y EJECUTAR su programa (pruebe que funcione tanto estatico como dinamico), luego los testfile.


## Salida
Una vez clonada y compilada la librería, y que haya completado el _main.c_ el funcionamiento esperado del programa sería:

```
$./hash
Ingrese texto: hola
El texto ingresado tiene 5 caracteres (incluido el salto de línea).
El texto 'hola' en SHA1 es: 
9980b85d3383e3a2fb45eb7d066a4879a9dad0
```
Para comprobar el funcionamiento correcto de la salida del programa usar: http://www.sha1-online.com/


## Validacion
```
make -f Testfile makefile
make -f Testfile hash
```

## Entregable
Completar este taller agregando el código necesario, las librerías y modificando el Makefile. Al menos realizar dos commits.



### Tip makefile

static: gcc -static -o hash file.c libsha1.a

dynamic: gcc -o hash_dyn file.c libsha1.so
