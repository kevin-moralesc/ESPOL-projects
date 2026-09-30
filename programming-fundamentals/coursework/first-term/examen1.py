#
#
# def devolver_numero(dato):
#     for n in dato:
#         if n not in '0987654321.':
#             return 0.0
#     if dato.count(".") > 1:
#         return 0.0
#
#     return float(dato)

    # if not dato.isdigit():
    #     return 0.0
    # elif dato.count(".") > 1:
    #     return 0.0
    # else:
    #     return float(dato)

# print(devolver_numero("5.1"))
#
# def monto_categoria (lista_proyectos, categoria):
#     total = 0
#     for dato_proyecto in lista_proyectos:
#         datos = dato_proyecto.split(";")
#         # cat = datos[0]
#         cat = datos.pop(0)
#         if cat.lower() == categoria.lower():
#             # for dato in datos[1:]:
#             for dato in datos:
#                 _, valor = dato.split(":")
#                 total += float(valor)
#     return total


# cat = "CIencias naturalEs"
# l_proyectos = [ "Ciencias Naturales;Monitor cardíaco:230;Primeros auxilios:210",
# "Tecnología;Clasificador de imágenes:250;Chatbot para Call Center:220",
# "Arte y Creatividad;App para matemáticas:180;Juego de lógica para niños:160" ]
#
# print(monto_categoria(l_proyectos, cat))
import random as rd
#
# vel_l = 5 # liebre
# vel_t = 3 # tortuga
# l_trampas= [4, 7, 9, 13]
#
# total_l = 0
# total_t = 0

# for i in range(10):
#     print("turno {}".format(i + 1))
#     avance_l = rd.randint(1, vel_l)
#     total_l += avance_l
#     if total_l in l_trampas:
#         print("Liebre cayó en trampa en casilla {}, regresa a su posición anterior".format(total_l))
#         total_l -= avance_l

    # if total_l + avance_l not in l_trampas:
    #     total_l += avance_l
#
#     avance_t = rd.randint(1, vel_t)
#     total_t += avance_t
#
#     print("Liebre : {} (posicion {})".format('-' * total_l, total_l ))
#     print("Tortuga : {} (posicion {})".format('-' * total_t, total_t))
#
# if total_l > total_t:
#     print("Ganó la liebre")
# elif total_t > total_l:
#     print("Ganó la tortuga")
# else:
#     print("Empataron")