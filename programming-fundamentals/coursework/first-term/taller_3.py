# listaP=["cereales","pescados", "carne"]
# listaC=[47.08, 37.95, 12.07]
# listaE=[-0.42,0.34, -4.25]

#1

# def buscarMayor(listaP,listaC,ref):
#     l=[]
#     for pos, costo in enumerate(listaC):
#         if costo > float(ref):
#             l.append(listaP[pos])
#     return l

#2
#
# def encarecimiento(listaE,tipo):
#     l=[]
#     for e in listaE:
#         if tipo=="positivo" and e>0:
#             l.append(e)
#         elif tipo=="negativo" and e<0:
#             l.append(e)
#     promedio= sum(l)/len(l)
#     return len(l), promedio


#3
# encarecimiento_negativo= "negativo"
# resultado= encarecimiento(listaE, encarecimiento_negativo)
# print(resultado)
#
# import random as rd
# valornumerico= float(input("ingrese valor numerico:"))
# respuesta= buscarMayor(listaP,listaC,valornumerico)
# print(respuesta)
# print("Productos:")
# for pos, p in enumerate(respuesta):
#     print(pos+1,p)
#
# escoger_uno=rd.choice(respuesta)
# pos=listaP.index(escoger_uno)
# costo_deeso= listaC[pos]
# encarecimiento_deeso= listaE[pos]
#
# print("Producto:",escoger_uno,"Costo:",costo_deeso, "Encarecimiento:",encarecimiento_deeso)
#
#
#
#
#










