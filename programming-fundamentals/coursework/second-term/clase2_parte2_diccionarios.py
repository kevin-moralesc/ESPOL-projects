# panimales = """especie,Honduras,Australia,Ecuador
# Elefante,0,500,0
# Koala,0,10325,0
# Galapagos,0,1000,5000"""
#
# def crear_diccionario(texto, n):
#     d = {}
#     llineas = texto.split("\n") # revisar caracteres especiales
#     lpaises = llineas[0].split(",")[1:]
#     for linea in llineas[1:]:
#         ldatos = linea.split(",")
#         animal = ldatos[0]
#         lpoblacion = ldatos[1:]
#         for pos,pais in enumerate(lpaises):
#             poblacion = int(lpoblacion[pos])
#             if poblacion > n:
#                 lpais_animal = d.get(animal, [])
#                 lpais_animal.append(pais)
#                 lpais_animal.append(poblacion)
#                 d[animal] = lpais_animal
#     return d
#
# r = crear_diccionario(panimales, 100)
# print(r)

# La función mas_popular(dicEspecie, especie) que recibe el diccionario de especies del numeral anterior (1.)
# y el nombre de una especie. La función retorna el nombre del país que tiene el mayor número de
# ejemplares de esa especie.
#
# def mas_popular(dicEspecie, especie):
#     lpaispoblacion = dicEspecie.get(especie)
#     lpoblacion = lpaispoblacion[1: :2]
#     maximo = max(lpoblacion)
#     pos = lpaispoblacion.index(maximo)
#     pais = lpaispoblacion[pos -1]
#     return pais
#
# pais  = mas_popular(r, "Galapagos")
# print(pais)

# La función pais_especie(dicEspecie) que recibe el diccionario de especies. La función retorna un nuevo
# diccionario de especies por país, donde la clave es el país y el valor es una lista con los nombres de las
# especies que existen en ese país.

# {'Australia': ['Koala', 'Galapagos']}
# def pais_especie(dicEspecie):
#     d = {}
#     for animal, lpais_pob in dicEspecie.items():
#         lpaises = lpais_pob[ : : 2 ]
#         for pais in lpaises:
#             lanimales = d.get(pais, [])
#             lanimales.append(animal)
#             d[pais] = lanimales
#     return d
#
# x = pais_especie(r)
# print(x)


#
# def glosario(lpaginas):
#     dglosario= {}
#     for pos,pagina in enumerate(lpaginas):
#         numero_pagina = pos + 1
#         lpalabras = pagina.split(" ")
#         for palabra in lpalabras:
#             lindices = dglosario.get(palabra, [])
#             if str(numero_pagina) not in lindices:
#                 lindices.append(str(numero_pagina))
#                 dglosario[palabra] = lindices
#     return dglosario
#
# l = [
#     "hola mundo hola",
#     "chao hola"
# ]
#
# d = glosario(l)
# lpalabras = list(d.keys())
# lpalabras.sort()
# for palabra in lpalabras:
#     print(palabra, " ... ".join(d[palabra]) )




