


# def EscogerVocal(palabra):
#     vocales = "aeiou"
#     letra = '*'
#     while letra not in vocales:
#         letra = rd.choice(palabra)
#     pos = palabra.index(letra) # falla si la vocal se repite en la palabra
#     return letra, pos


# def EscogerVocal(palabra):
#     vocales = "aeiou"
#     letra = '*'
#     while letra not in vocales:
#         pos = rd.randint(0, len(palabra) - 1)
#         letra = palabra[pos]
#
#     return letra, pos
#
# print(EscogerVocal("insoportable"))

#
# def calcularPersistenciaAditiva(numero):
#     cont = 0
#     while int(numero) >= 10:
#         total = 0
#         cont += 1
#         for digito in str(numero):
#             total += int(digito)
#         numero = total
#         # print(numero)
#     return cont

# def calcularPersistenciaAditiva(numero):
#     cont = 0
#     continuar = True # PROHIBIDO EL USO DE VARIABLES BANDERA (FLAGS)
#     while continuar:
#         total = 0
#         cont += 1
#         for digito in str(numero):
#             total += int(digito)
#         numero = total
#
#         if int(numero) >= 10:
#             continuar = False
#         # print(numero)
#     return cont



# print(calcularPersistenciaAditiva("5978"))


# dado una lista de numeros generen una nueva lista de numeros
# con k elementos sin repetir (SIN USAR SAMPLE)
#
# import random as rd
# l = [3,7,9, 2, 9, 4, 7, 0]
# k = 4
# l2 = [7, 2, 9, 0] # ejemplo
# # l2 = [7, 2, 9, 9] # error
#
#
# lresultado = []
# while len(lresultado) < k :
#     elemento = rd.choice(l)
#     if elemento not in lresultado:
#         lresultado.append(elemento)
#
# print(lresultado)
#
#
#


