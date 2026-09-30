#!/bin/bash

source $(dirname "$0")/globals

EJECUTABLE="secret"

clean(){
	make clean &>/dev/null
	rm -f $EJECUTABLE
	rm -f *.enc
	rm -f *.dec
	rm -f p2 c2
}

clean_fail(){
	clean
	echo -e "$FAIL " $1
	exit 1
}

clean
make &>/dev/null

if [ $? -eq 0 ] ; then
	echo -e "$PASS Compilación exitosa"
else
	clean_fail "Error de compilación"
fi

key="ffffffffffffffff"
echo ffffffffffffffffffffffffffffffff | xxd -r -p > p2
echo 51866fd5b85ecb8a51866fd5b85ecb8a | xxd -r -p > c2

if [ $1 == encrypt ]; then
	echo "Probando encriptación..."
	output=$(./$EJECUTABLE -k $key p2)
	if [ -f "p2.enc" ]; then
		cmp -s c2 p2.enc
		if [ $? -eq 0 ] ; then
			echo -e "$PASS Encriptación exitosa"
		else
			clean_fail "Error de encriptación"
		fi
	else
		clean_fail "Archivo de salida no encontrado o nombre erróneo..."
	fi
fi

if [ $1 == decrypt ]; then
	echo "Probando desencriptación..."
	output=$(./$EJECUTABLE -d -k $key c2)
	if [ -f "c2.dec" ]; then
		cmp -s p2 c2.dec
		if [ $? -eq 0 ] ; then
			echo -e "$PASS Desencriptación exitosa"
		else
			clean_fail "Error de desencriptación"
		fi
	else
		clean_fail "Archivo de salida no encontrado o nombre erróneo..."
	fi
fi

clean
echo
