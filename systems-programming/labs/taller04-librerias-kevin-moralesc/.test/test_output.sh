#!/bin/bash


source $(dirname "$0")/globals


if [ $1 == hash ]; then
	rm -f $EJECUTABLE
	rm -f $EJECUTABLE_DYN

	make hash &>/dev/null
	if [ -f "hash" ] ; then
	  echo -e "$PASS Compilación static exitosa"
	else
	  echo -e "$FAIL Error de compilación static"
	  exit 1
	fi
	
	make hash_dyn &>/dev/null
	if [ -f "hash_dyn" ] ; then
	  echo -e "$PASS Compilación dynamic exitosa"
	else
	  echo -e "$FAIL Error de compilación dynamic"
	  exit 1
	fi

	echo
	echo "Probando output del hash..."
	
	ARGUMENTO1="progsist"
	expected_output="2d468839833bb300fb68359efd747f97330106eb"
		
	output1=$(./$EJECUTABLE $ARGUMENTO1)

	if [[ "$output1" =~ .*"$expected_output".* ]] ; then
	  echo -e "$PASS Salida correcta con static"
	else
	  echo -e "$FAIL Programa con salida inesperada con static..."
	  exit 1
	fi

	ARGUMENTO2="progsist"
	output2=$(./$EJECUTABLE_DYN $ARGUMENTO2)

	if [[ "$output2" =~ .*"$expected_output".* ]] ; then
	  echo -e "$PASS Salida correcta con dynamic"
	else
	  echo -e "$FAIL Programa con salida inesperada con dynamic..."
	  exit 1
	fi

	
elif [ $1 == makefile ]; then
	echo "Probando Makefile..."
	mfile=$(cat Makefile)
	  
	if [[ (("$mfile" =~ .*"libsha1.a".* || "$mfile" =~ .*"-lsha1".*) && "$mfile" =~ .*"-static".*) && ("$mfile" =~ .*"libsha1.so".* || "$mfile" =~ .*"-lsha1".*)]] ; then
		echo -e "$PASS Salida makefile correcta"
		exit 0
	else
		echo -e "$FAIL Su archivo Makefile no esta completo..."
		exit 1
	fi
else
	echo -e "$FAIL Test invalido"
exit 1

fi


echo


