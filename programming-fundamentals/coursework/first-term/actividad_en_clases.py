# detalle= 'spotify-55MB'
# pos= detalle.index('-')
# app= detalle[:pos]
# consumo= int(detalle[pos+1:-2])
# print(app)
# print(consumo)
print(10+57)
#
#
# tweet= "En el DIA 2021-05-17 dentro  de la CIUDAD en Guayaquil"
# ltweet=tweet.split(" ")
# pos= ltweet.index("en")
# ciudad= ltweet[pos+1]
# print(ciudad)
#
# print(ltweet)
#
# fecha= ltweet[3]
# lfecha= fecha.split("-")
# ano=lfecha[0]
# mes= lfecha[1]
# dia= lfecha[2]
#
# print(ano, mes, dia)
#
#
#
# palabra= input("ingrese texto")
# pos= len(palabra)//2
# mitad1= palabra[:pos]
# mitad2= palabra[pos:]
# inv1= mitad1[::-1].replace( "a","@").replace( "e","3").replace( "i","!").replace( "o","0").replace("u","^")
# inv2= mitad2[::-1].replace( "a","@").replace( "e","3").replace( "i","!").replace( "o","0").replace("u","^")
# minu=inv1.lower()
# mayu=inv2.upper()
# final= "##"+minu+mayu+"!!"
# print(final)
#
#
#
#
#


#Escriba un progama que pida una cadena de caracteres. El programa deberá mostrar por pantalla lo siguiente:
 #El número total de caracteres
 #La cadena repetida 5 veces separada por un enter
 #Los tres primeros caracteres de la cadena
 #Los tres últimos caracteres de la cadena
#l a cadena escrito al reves (Hola  aloH)
 #La cadena en mayúsculas
# La cadena con cada letra “a” remplazada por una “e”
#cadena= input("escriba algo")
#longitud= len(cadena)
#repeticion= cadena*5
#trespalabras= cadena[ :4]
#tresultimas= cadena[-4: ]
#reversaa= cadena[::-1]
#mayuscula= cadena.upper()
#remplazar= cadena.replace("a", "e")
#print(longitud, repeticion, trespalabras, tresultimas, reversaa, mayuscula, remplazar)



#Escriba un progama que pida una cadena de caracteres de 6 letras,
#luego muestre cada letra de la cadena escrita doble y separada por un tab. Por ejemplo: s=Hola
#	HH	OO	LL	AA

#
# palabra= input("Escribe una palabra: ")
# for letra in palabra:
#     if len(palabra)<=6:
#         word= letra*2
#         word= word.upper()
#         print(word, end= "\t ")

# Escriba un programa que pida por teclado la hora en formato hh:mm:ss y convierta todo a segundos.


#tiempo= input("ingresar hora hh:mm:ss")

#formato=tiempo.split(":")
#horas= formato[0]
#horas= int(horas)
#minutos=formato[1]
#minutos=int(minutos)
#segundos=formato[2]
#segundos=int(segundos)

##transformat todo a segundos

#thoras=horas*3600
#tminutos= minutos*60
#resultado= segundos+thoras+tminutos
#print(resultado)



# Escriba un programa que pida por teclado los segundos (mas de 3600) y muestre por pantalla la hora en
# formato hh:mm:ss


#segundos= input("escriba los segundos")
#segundos = int(segundos)

#horas=segundos//3600
#residuo1= segundos%3600
#minutos= residuo1//60
#segundos= residuo1%60
#print("su formato de hora es :", horas,":", minutos,":", segundos)


#Escriba un programa en el que genere un número aleatorio entre 1 y 50 y
# otro número aletorio entre 2 y 5. Muestre ambos números y la multiplicación de ellos


#import random as rd

#numero1= rd.randint(1,51)
#numero2= rd.randint(2,6)

#print(numero1,numero2)

#multiplicacion= numero1*numero2
#print(multiplicacion)





#import random as rd
##Escriba un programa que genere un número decimal entre 1 y 25  y muestre por pantalla dicho número con 2 decimales.

#numero= rd.randint(1,26)
#decimal= numero/100
#print (decimal)









#En cálculo la derivada de x^4 es 4x^3, la derivada de x^5 es 5x^4.
# Escriba un programa que permita el ingreso de una ecuación y muestre por pantalla la derivada de la misma.

#ecuacion= input("ingrese ecuacion para derivarla: ")
#condi=ecuacion.split("^")
#exp= condi[1]
#deri= str(int(condi[1])-1)
#incog= condi[0]
#derivada= exp+incog+"^"+deri
#print("su derivada es: \n", derivada)





#Escriba un programa que, dada dos listas de 4 elementos, devuelva una lista con
# las suma de cada uno de los elementos (suma de vectores).

#l1= [3, 3, 5, 7]
#l2= [2, 10, 6, 8]
#pos= l1[0]+l2[0]
#pos1= l1[1]+l2[1]
#pos2 = l1[2]+l2[2]
#pos3= l1[3]+l2[3]

#sumadevectores=[pos,pos1,pos2,pos3]
#print(sumadevectores)









#Escriba un programa que, dada dos listas de 4 elementos,
#devuelva el producto punto entre ambas listas, es decir
# la suma de los productos de elemento por elemento

#p=[4,1,2,4]
#q=[2,3,5,1]

#pos= p[0]*q[0]
#pos1= p[1]*q[1]
#pos2= p[2]*q[2]
#pos3= p[3]*q[3]
#print(pos,'\n',pos1,'\n',pos2,'\n',pos3)

#pyq=pos+pos1+pos2+pos3

#print(pyq)




#dadas 2 listas terorne una lista nueva con los elementos q se repiten en cada lista
#a= [1,2,3,4,5,6,7,8]
#b= [8,4,10,3,11,20,2,9,16,30]
#iguales=[ ]
#for i in range(len(a)):
#    for j in range(len(b)):
#        if a[i]==b[j]:
#            iguales.append(a[i])
#print(iguales)
# Pirámide de * en forma de triángulo




#usted elaborará un programa que permita el ingreso de 15 números (positivos y negativos).
# Al finalizar deberá mostrar por pantalla tres listas:
#Lista de números ingresados por el usuario.
#Lista de números positivos, y,
#Lista de números negativos.

#numero= input("Introduce 15 numero separado por espacios: ")
#lnumero= numero.split(" ")
#npositivos= []
#nnegativos= []

#for n in lnumero:
#    if int(n)>0:
#        npositivos.append(n)
#    if int(n)<0:
#        nnegativos.append(n)
#print("numeros positivos:",npositivos, "\n", "numeros negativos: ",nnegativos,"\n","lista total", lnumero)



#numero= int(input("ingrese un numero "))

#if numero%2==0:
#    print("es par")
#else:
#    print("es impar")

