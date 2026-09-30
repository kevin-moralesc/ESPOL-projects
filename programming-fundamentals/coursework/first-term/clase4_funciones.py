# def PromedioLista(lnumeros):
#     promedio = sum(lnumeros) / len(lnumeros)
#     return promedio

# una funcion que dado un total neto,
# calcule el valor a pagar considerando el iva
# def TotalPagar(neto, iva):
#     resultado = neto + (neto * iva)
#     # print(resultado)
#     return resultado

# funcion llamada SumarPares
# la funcion recibe una lista de numeros
# y solo suma los valores que se encuentran en
# posiciones pares
# def SumarPares(lnumeros):
#     return sum(lnumeros[ : : 2])

# funcion llamada TerminaEnVocal que recibe
# una palabra y retorna True o False si
# la palabra termina en vocal

# def TerminaEnVocal(palabra):
#     # es_vocal = palabra[-1] == 'a' or palabra[-1] == 'e' or palabra[-1] == 'i' or palabra[-1] == 'o' or palabra[-1] == 'u'
#     es_vocal = palabra[-1].lower() in ['a', 'e', 'i', 'o', 'u']
#     return es_vocal


# una funcion que dado un total neto,
# calcule el valor a pagar considerando el iva
# def TotalPagarVP(neto, iva = 0.15):
#     resultado = neto + (neto * iva)
#     # print(resultado)
#     return resultado


# una funcion reciba una lista de numeros y sume los n primeros
# numeros. donde n tiene un valor por defecto de 1
# def SumaNPrimeros(lnumeros, n = 1):
#     return sum(lnumeros[:n])


# retornar suma, resta, mult, div entra a y b
# def Calculadora(a, b):
    # s = a + b
    # r = a - b
    # m = a * b
    # d = a / b
    # return s, r, m, d
    # return s # siempre el retorno es el fin de la funcion
    # return r
    # return m
    # return d


#
# import math as mt
#
# def CalcularRaices(a , b, c):
#     x1 = (-b + mt.sqrt(b**2 - (4*a*c))) / (2 * a)
#     x2 = (-b - mt.sqrt(b**2 - (4*a*c))) / (2 * a)
#     return x1, x2


# funcion mitadLista recibe una lista de palabras
# devuelve una lista con la primera mitad de cada palabra
# ejemplo: ["Juan", "Pedro", "Maria", "Angelica"]
# [ "Ju", "Pe", "Ma", "Ange" ]
# def mitadLista(lpalabras):
#     lfinal = []
#     for n in lpalabras: # para cada nombre en la lista de palabras
#         lfinal.append(n[: len(n) // 2])
#     return lfinal

# funcion obtenerMenor recibe una lista de palabras
# devuelve el nombre con menor cantidad de letras
# ejemplo: ["Juan", "Pedro", "Ana" ,"Maria", "Angelica"]
# "Ana"
# def obtener_menor(lnombres):
#     l = []
#     for nombre in lnombres:
#         l.append(len(nombre))
#     return lnombres[l.index(min(l))]
#


# funcion que sume cuantas nombres coinciden en la misma posicion
# luego de barajar la lista que recibe como parametro.
# retorna el total de nombres que coinciden. CuentaNoBarajados
#import random as rd

#def CuentaNoBarajados(l):
#    lcopy = l.copy()
#    rd.shuffle(lcopy)
#    total = 0
#    for pos in range(len(l)): #---> 0, 1, 2,...., len(l) - 1
#        comp = l[pos] == lcopy[pos] # booleano T => 1, F => 0
#        total = total + comp
#return total


#def siglas(frase,palabras_comunes):
#    lpalabras= frase.split(" ")
#   siglainicial=lpalabras[0][0]
#    siglafinal=lpalabras[-1][0]
#    lsiglas=[]
#    for palabra in lpalabras[1:-1]:
#        if palabra not in palabras_comunes:
#            sigla= palabra[0]
#            lsiglas.append(sigla)
#    return (siglainicial+"".join(lsiglas)+siglafinal).upper()





