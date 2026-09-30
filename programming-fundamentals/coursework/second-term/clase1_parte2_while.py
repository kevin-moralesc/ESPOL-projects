#El programa genera
#import random as rd

#adivinar = rd.randint(1, 100)
#numero = int(input("Adivina el numero (entre 1 a 100):"))
#intento = 7

#while intento > 0 and adivinar != numero:
#    intento-=1
#    if numero>adivinar:
#        print("mul alto, tienes",intento,"intentos")
#    else:
#        print("muy bajo, tienes", intento, "intentos")
#    numero = int(input("Adivina el numero (entre 1 a 100):"))
#
#if numero==adivinar:
#   print("ese es el numero correcto")
#else:
#    print("el numero corecto es", adivinar)



#crea un script que emule  una alcancia virtual, inicialmente , se solicita al usuario ingresar la cantidad deseada para ahorrar.
#Luego,de manera iterativ, el programa  pedira que ingreses  las cantidades a ahorrar hasta  alcanzaar o superar la meta establecida



#ahorrar= int(input("cuanto desea ahorrar?:"))
#alcancia=0
#while alcancia<ahorrar:
#    dinero= int(input("ingrese dinero a la alcancia"))
#    alcancia+=dinero
#    
#if alcancia >= ahorrar:
#    print("ha ahorrado:", alcancia)





#l=["rueda"]*4+ ["x"]*11 
#rd.shuffle(l)
#validad= int(input("ingrese nuemro"))
#ruedasEncontradas=0
#intentos=7
#premio=0

#while ruedasEncontradas<4 and intentos>0:
#    intentos-=1
#    
#    if l[validad]=="rueda":
#        ruedasEncontradas+=          c
#    else:
#        validad= int(input("ingrese nuemro nuevamente"))
#if ruedasEncontradas>=4:
#    premio+=1000
#
#print("Premio:", premio)




#ingrese un programa  que permita al usuario el ingreso de n numeros.
# PRIMERO debe preguntar al usuario cuantos numeros desea ingresar
#Al FINAL del programa presente la sumatoria de dichos numeros.


#cuanto= int(input("ingrese cantidad de numeros a sumar"))
#sumatoria=0
#ciclo=0
#while ciclo!=cuanto:
#    ciclo+=1
#    num= int(input("ingrese un numero"))
#    sumatoria+=num
#print(sumatoria)
#print("programa terminado")





#opcion=0
#while opcion!=3: 
#    print("Bienvenido a tu calculadora\n 1.-Suma\n 2.- Resta\n 3.- Salir")
#    suma=1
#    resta=2
#    salir=3
#    opcion= int(input("ingrese la opcion que desee"))
#
#    if opcion==suma:
#        sumarr=0
#        cantidad=0

#        while cantidad!=2:
#            cantidad+=1
#            numero=int(input("ingrese numero"))
#            sumarr+=numero
#        print("la suma de los numeros son:", sumarr)
#
#    elif opcion==resta:
#        n=""
#        cantidadnum=0
#        while cantidadnum!=2:
#            cantidadnum+=1
#            numero=input("ingrese numero")
#            n+=numero
#        resta= int(n[0])-int(n[1])
#        print("la resta de esos numero son:", resta)




 


# “Cho Han”

# El juego tradicional japonés "Cho Han" consiste en el lanzamiento de dos dados 
# en un vaso para luego colocarlo sobre el suelo con la abertura hacia abajo, 
# ocultando los dados. Los jugadores deben de adivinar si la suma de los dos dados 
# da Cho (par) o Han (impar).

# Simule el juego "Cho Han" en python donde un jugador ingresará cuánto dinero desea 
# apostar en cada turno (asuma que el jugador comienza con $10 en su billetera).

# - Si adivina: gana el doble de lo que apostó. Por ejemplo: 
#   si en la billetera tiene $10 y apuesta $2, entonces tendrá $12.

# - Si no adivina: pierde lo que apostó. Por ejemplo: 
#   si en la billetera tiene $10 y apuesta $2, entonces tendrá $8.

# El juego termina cuando el usuario se queda sin dinero 
# o ingresa que "no" desea continuar.

# Se deberá mostrar el resultado de cada ronda, el dinero que tiene en la billetera 
# y al finalizar todas las rondas se deberá mostrar la cantidad de partidas que ganó el jugador.


#print("bienvenido a CHO HAN")

#victoria=0
#continuar="si"
#billetera=10


#while continuar!="no" and billetera>0:
#    apuesta=int(input("ingrese apuesta"))
#    while apuesta>billetera:   
#        print("la apuesta es mayor a lo  que tiene  en su billetera")
#        cambio=int(input("ingrese apuesta:"))
#        apuesta=cambio
#    dado1=rd.randint(1,6)
#    dado2=rd.randint(1,6)
#    suma= dado1+dado2
#    
#    adivinar= input("par o impar")
#    if adivinar=="par"and suma % 2 ==0:
#        print("gano!!!!!!!")
#        print("salio",dado1,"+", dado2, "=", suma)
#        victoria+=1
#        billetera+=(apuesta)
#        print("billetera:", billetera)
#    else:
#        print("perdio =(")
#        billetera-=apuesta
#        print("salio",dado1,"+", dado2, "=", suma)
#        print("billetera:", billetera)
#    deseo= input("desea seguir jugando? (si/no)")
#    continuar=deseo
#    print("-------------------")

#print("usted gano",victoria,"victorias")
#print("gracias por jugar")







# Un número feliz es un número definido por el siguiente proceso:
# 1. Comienza con cualquier número entero positivo.
# 2. Sustituye el número por la suma de los cuadrados de sus dígitos.
# 3. Repite el proceso hasta que:
#    * Llegues a 1 (en cuyo caso el número es feliz), o
#    * Entras en un ciclo que no contiene el 1 (el número no es feliz).

# Por ejemplo:
# 19 → 1² + 9² = 82 → 8² + 2² = 68 → 6² + 8² = 100 → 1² + 0² + 0² = 1 ✅ Feliz
# 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 🔁 Ciclo → No feliz



#def es_feliz(n):
#   estado=""
#    numero=n
#    lnumero=[]
#    while numero!=1 and numero not in lnumero:
#        lnumero.append(numero)
#        numstring= str(numero)
#        suma=0
#        for i in range(len(numstring)):
#            suma+= int(numstring[i])**2
#        numero=suma
#    if numero==1:
#        estado+="Feliz"
#    else:
#        estado+="No feliz"
#    
#    return estado, print(lnumero)
#

#print(es_feliz(20))


############################

# La conjetura de Collatz establece que, dada cualquier
# entero positivo n, se puede llegar a 1 aplicando las
# siguientes reglas:
# * Si n es par, entonces n = n / 2.
# * Si n es impar, entonces n = 3n + 1.
#
# Por ejemplo, para n = 6,
# la secuencia seria: 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1.
# Implementa un algoritmo que encuentre el numero
# inicial entre 1 y 10,000 cuya secuencia de Collatz
# tenga la mayor longitud


#def coollatz(n):
#    longitud=0 
#    
#    while n!=1:
#        if n%2==0:
#            n= n/2
#        else:
#            n= 3*n +1
#        longitud+=1
#    return longitud
#
#
#l=[]
#for i in range (1,10001):
#    y= coollatz(i)
#    l.append(y)
#pos= l.index(max(l))
#
#
#print(max(l),pos)




####################################




# TEMA 1 (20 PUNTOS)
# Escriba un programa en Python que implemente el "Juego de las Ruedas". Para esto genere aleatoriamente una
# lista de 15 elementos donde cuatro elementos deben decir "Rueda" y los otros once, "X".

# Luego el programa deberá pedirle al jugador que ingrese por teclado índices entre 0 y 14 (validar). Asuma que el
# jugador siempre ingresa índices distintos. Si el índice ingresado por el usuario corresponde al de una "Rueda", gana
# $1000. El jugador tiene siete intentos para hallar las cuatro "Ruedas". # en cada intento muestre en pantalla # el
# número total de "Ruedas" encontradas hasta el momento. # si el jugador encuentra las cuatro "Rueda" se gana un
# carro. El juego termina cuando encuentra las cuatro "Ruedas" o ha usado todos los intentos.

# Al final muestre el premio que recibe el jugador (cantidad de dólares o la palabra "carro" si encontró las cuatro
# ruedas).

# Escriba un programa en Python que implemente el “Juego de las Ruedas”. Para esto genere aleatoriamente una
# lista de 12 elementos donde cuatro elementos deben decir “Rueda” y los otros ocho deben decir “X”.

#l = ["rueda"] * 4 + ["x"] * 8
#rd.shuffle(l)
#print(l)
#dinero = 0
#ruedas_encontradas = 0
#turnos = 0
#while turnos < 6 and ruedas_encontradas != 4:
#    turnos += 1
#    indice = input("indice: ")
#    if indice.isnumeric() and  0<= int(indice) <= 11:
#        valor = l[int(indice)]
#        if valor == 'rueda':
#           dinero += 1000
#           ruedas_encontradas += 1
#    print("cantidad de ruedas", ruedas_encontradas)


#if ruedas_encontradas ==4:
#    print("ganó carro")
#else:
#    print("ganó dinero", dinero)













































