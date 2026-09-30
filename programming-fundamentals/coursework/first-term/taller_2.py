#La función recibirá una palabra y retornará el puntaje de dicha palabra.
# Todas las letras ingresadas deben ser mayúsculas. Si se ingresa un letra minúscula,
# esta es ignorada (puntuación de 0 para dicha letra).
#Una corrida ejemplo del programa sería:
#ReY el resultado seria 5

#
# def puntajepalabra (palabra):
#     alfabeto = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
#                 'V', 'W', 'X', 'Y', 'Z']
#     puntos = [1, 3, 3, 2, 1, 4, 2, 4, 1, 9, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 9, 4, 10]
#     puntajefinal=0
#     for letra in palabra:
#         if letra in alfabeto:
#             pos= alfabeto.index(letra)
#             puntaje=puntos[pos]
#             puntajefinal= puntajefinal + puntaje
#     return puntajefinal
