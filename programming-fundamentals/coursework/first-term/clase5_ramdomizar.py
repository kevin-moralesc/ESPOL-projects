# import random as rd
# lestudiantes=["kevin ", "uwuw", "xdd", "aas"]
# #rd.shuffle(lestudiantes)
# xd=rd.sample(lestudiantes,2)
#
# print(xd)
#
#
# for n in range(3):
#     numero= rd.randrange(2,11,2)
#
#
#
#
#
# x= rd.randint(1,20)
# print(x)
#
#
#
#
















#Escriba un programa que simule el juego de piedra, papel o tijera.
#Generar dos números aleatorios, esto servirá para guardar las opciones de los dos jugadores.
#Si el número generado es igual a 1, es piedra.
#Si el número generado es igual a 2, es papel.
#Si el número generado es igual a 3, es tijera

#Mostrar el ganador:
#Piedra le gana a tijera
#Tijera le gana a papel
#Papel le gana a piedra


import random as rd

jugador1=rd.randint(1,3)
jugador2= rd.randint(1,3)


if jugador1 == 1 :
    print("Jugador 1 elige: Piedra")
if jugador1 == 2:
    print("Jugador 1 elige: Papel")
if jugador1 == 3:
    print("Jugador 1 elige: Tijera")

if jugador2 == 1:
    print("Jugador 2 elige: Piedra")
if jugador2 == 2:
    print("Jugador 2 elige: Papel")
if jugador2 == 3:
    print("Jugador 2 elige: Tijera")

# Determinar el resultado
if jugador1 == jugador2:
    print("Empate")

if (jugador1 == 1 and jugador2== 3)or (jugador1 == 2 and jugador2 == 1) or (jugador1 == 3 and jugador2 == 2) :
    print("¡Gana el Jugador 1!")

if (jugador1 == 3 and jugador2 == 1) or (jugador1 == 1 and jugador2 == 2) or (jugador1 == 2 and jugador2 == 3):
    print("¡Gana el Jugador 2!")


