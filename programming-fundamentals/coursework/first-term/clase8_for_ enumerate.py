# nombre = "frank"
# for l in nombre:
#     print("hola")

# lnombres = ["Juan", "Pedro", "Maria", "Angelica"]
# for n in lnombres:
#     print("hola", n)
#import funciones as fn
# l = fn.mitadLista(["Juan", "Pedro", "Maria", "Angelica"])
# print(l)


# l = ["Juan", "Pedro", "Ana" ,"Maria", "Angelica"]
# n = fn.obtener_menor(l)
# print(n)

# nombre = "frank"
# for letra in nombre:
#     print(letra)

# for con listas y for con str



# l = [3, 5, 5, 8, 2, 7, 10]
# # crear una lista con las posiciones
# # de los numeros impares
# lpos = [ pos for pos, n in enumerate(l) if n % 2 == 1  ]
# # lpos = []
# # for pos, n in enumerate(l):
# #     if n % 2 == 1:
# #         lpos.append(pos)
# print(lpos)

# texto = "escuela superior politecnica del litoral"
# # crear una lista de posiciones de las vocales
# l = []
# for pos, letra in enumerate(texto):
#     if letra.lower() in ['a', 'e', 'i', 'o', 'u']:
#         l.append(pos)
# print(l)


# texto = "la espol es una universidad que es tecnica"
# silaba = "es" # variable un, esp
# # cuantas veces tengo que buscar (ejecutar index ?)
# veces = texto.count(silaba)
# inicio = 0
# # generar las n iteraciones corresponden a veces
# for _ in range(veces):
#     # mandar a buscar pero con un inicio
#     pos = texto.index(silaba, inicio)
#     print(pos)
#     # incremento ese inicio para que la siguiente busqueda,
#     # inicie desde la siguiente posicion
#     inicio = pos + 1




# Implemente un programa en Python que muestre todas las secuencias .
# 1. Forme la cadena inversa ( INV ) de la secuencia S .
# 2. Si la cadena R aparece exactamente dos veces en la segunda mitad de INV
# y al menos 3 veces en total de INV, la
# secuencia S pertenece a la especie buscada.

# S = 'ATTTGCTTGCTATTTAAACCGGTTATGCATAGCGC' # muestra de algun animal
# R = 'CG'
# INV = S[ : :-1]
# segunda_mitad = INV [ len(INV) // 2 :  ]
# pertenece = segunda_mitad.count(R) ==  2 and INV.count(R) >= 3


# lnombres = ["Frank", "Juan", "Pedro", "Maria"]
# for nombre in lnombres: # recorre la lista nombre
#     lpos = []
#     for pos,letra in enumerate(nombre): # recorre letra por letra del nombre
#         if letra in ["a", "e", "i", "o", "u"]:
#             lpos.append(str(pos))
#     print(nombre, ",".join(lpos))


# Frank 2
# Juan 1,2
# Pedro 1,4
# Maria 1,3,4

#
# def buscar_par_descendente(l_numeros):
#     for pos, n in enumerate(l_numeros[ : -1]):
#         valor_actual = n
#         valor_siguiente = l_numeros[pos+1]
#         if valor_actual > valor_siguiente:
#             return pos
#
#
#

