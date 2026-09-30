#Implemente un programa que determine el porcentaje de efectividad de la función
#random.shuffle . Para esto:
#1. Genere una lista de 57 números aleatorios únicos (sin repetidos) entre <<12 y 1632>>.

#2. Repita los siguientes pasos 100 veces:
#2.1 Desordene la lista original usando random.shuffle
#2.2 Contar cuántos elementos han cambiado de posición entre la lista original y la lista
#resultante (después de mezclarla). Llamemos a este valor X .
#2.3 Calcular el porcentaje de efectividad de la iteración actual. % efectividad iteracion
#= X * 100 / len(lista)


#3. Calcule y muestre por pantalla el porcentaje de efectividad final. El porcentaje de
#efectividad final es el promedio de los porcentajes de efectividad de las 100 repeticiones,
#en otras palabras debe dividir la suma de todos los porcentajes de efectividad de las
#repeticiones para 100.

#
#
# import random as rd
#
# #1
#
# lista_57_alt= rd.sample(range(12,1633), 57)
#
# #2
# porcentaje= []
# for _ in range (100):
#     lcopia= lista_57_alt.copy()
#     rd.shuffle(lcopia)
#     x=0
#
#     for pos,n in enumerate(lcopia):
#         if lista_57_alt[pos]!=lcopia[pos]:
#             x+=1
#     porcentaje_efectividad=x*100/len(lista_57_alt)
#     porcentaje.append(porcentaje_efectividad)
# #3
# porcentajeEfitividadFinal= sum(porcentaje) /100
# print(porcentajeEfitividadFinal)
