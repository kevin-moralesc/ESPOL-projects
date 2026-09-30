# Dos jugadores compiten en un juego de recolección. El objetivo es ser el primero en recolectar
# los 3 tipos diferentes de objetos disponibles: "piedra", "madera" y "hierba".
# En cada turno, un jugador encuentra un objeto aleatorio y lo agrega a su inventario.
#
# Crea un programa que:
#
# 1. Tenga un diccionario llamado jugadores, donde la clave sea el nombre del jugador y
#    el valor una lista con los objetos recolectados (ej. {"Ana": [], "Luis": []}).
# 2. En cada iteración del while, el turno cambia entre los dos jugadores,
#    comenzando por el primero "Ana".
# 3. En cada turno, se genera un objeto aleatorio de la lista
#    ["piedra", "madera", "hierba", "nada"] y se agrega a la lista del jugador correspondiente.
# 4. "nada" (significa que no encontró nada y no debe agregarse al inventario)
# 5. El juego continúa hasta que uno de los jugadores haya recolectado los 3 tipos de objetos distintos.
# 6. Cuando alguien gana, el programa debe mostrar quién fue el ganador, cuántos turnos se jugaron en total
#    y el estado final de ambos inventarios.
#
# jugadores = {
#     "Ana": [],
#     "Luis": []
# }
# jugadores ={"Ana":[], "Luis":[]}

# objetos = ["piedra", "madera", "hierba", "nada"]

# import random as rd
# turno = 0
# jugadoractual =""

# while len(list(jugadores.values())[0])<3 and len(list(jugadores.values())[1])<3:
#     if turno%2==0:
#         jugadoractual="Ana"
#     else:
#         jugadoractual="Luis"

#     objetoencontrado=rd.choice(objetos)
#     if objetoencontrado !="nada":
#         jugadores[jugadoractual].append(objetoencontrado)

#     turno+=1


# for player,inventario in jugadores.items():
#     if len(inventario)==3:
#         print("El ganador es:", player)
#         print("Inventario:", inventario )

#     if len(inventario)<3:
#         print("El perdedor es:", player)
#         print("Inventario:", inventario )

import pandas as pd

d1 = {
    "Examen": [86, 100],
    "Control de lectura 1": [100, 100],
    "Control de lectura 2": [25, 100],
    "Lección 1": [73, 50],
    "Lección 2": [59, 100],
}


df = pd.DataFrame(d1, index=["Primer parcial", "Segundo Parcial"])

df["cl 15%"] = ((df["Control de lectura 1"] + df["Control de lectura 2"]) / 2) * 0.15
df["leccimon 35%"] = ((df["Lección 1"] + df["Lección 2"]) / 2) * 0.35
df["Exam 50%"] = df["Examen"] * 0.5

df["nota parcial"] = df["cl 15%"] + df["leccimon 35%"] + df["Exam 50%"]
print(df)

d2 = {
    "Taller 2": [60],
    "Taller 3": [95],
    "Taller 4": [90],
    "Taller 5": [51],
    "Actuación 1": [90],
    "Actuación número feliz": [95],
}

dfp = pd.DataFrame(d2)

dfp["taller 80%"] = (
    (dfp["Taller 2"] + dfp["Taller 3"] + dfp["Taller 4"] + dfp["Taller 5"]) / 4
) * 0.8
dfp["act 20%"] = ((dfp["Actuación 1"] + dfp["Actuación número feliz"]) / 2) * 0.2
dfp[" nota practico"] = dfp["taller 80%"] + dfp["act 20%"]
print(dfp)


# Calcular el promedio de los dos parciales y aplicar el 70%
teorico = ((85 + df.loc["Segundo Parcial", "nota parcial"]) / 2) * 0.7
print("Teórico (70%):", teorico)

# Calcular el promedio del práctico y aplicar el 30%
practico = dfp[" nota practico"].mean() * 0.3
print("Práctico (30%):", practico)

# Sumar ambos para obtener el total
total = (teorico + practico) / 10
print("Total:", total)
