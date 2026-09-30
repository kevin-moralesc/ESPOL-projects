#
# mensaje="comer relleno me deja muy lleno y cuando estoy lleno no me siento bien"
# palabras= ["lleno/repleto", "comer/cenar","bien/alegre"]
#
# def reemplazar_palabras(mensaje,palabras):
#     lmensaje= mensaje.split(" ")
#     for palabra in palabras:
#         vieja,nueva= palabra.split("/")
#         for pos in range(0,len(lmensaje)):
#            if lmensaje[pos]==vieja:
#                 lmensaje[pos] = nueva
#     nuevomensaje= " ".join(lmensaje)
#     return nuevomensaje
#
#
#
#
#
#
#
#
#
# cedula= "1713175031"
#
#
# def verificar_cedula (cedula):
#     indices_pares= cedula[::2]
#     indices_impares= cedula[1:-1:2]
#     lista_par=[]
#     lmulti2=[]
#     lresta9=[]
#     lista_impar=[]
#     for n in indices_pares:
#         entero= int(n)
#         lista_par.append(entero)
#         multi= entero*2
#         lmulti2.append(multi)
#     for n in lmulti2:
#         if n<9:
#             lresta9.append(n)
#         if n>9:
#             resta=n-9
#             lresta9.append(resta)
#     for m in indices_impares:
#         entero= int(m)
#         lista_impar.append(entero)
#
#     suma= sum(lresta9)+sum(lista_impar)
#
#     digito_suma= str(suma)[-1]
#     verificaror=0
#     if digito_suma>"0":
#         verificaror=0
#
#     if  digito_suma>"0":
#         veri= 10-int(digito_suma)
#         verificaror+=veri
#     if verificaror==int(cedula[-1]):
#         verificaror=True
#     else:
#         verificaror=False
#     return lista_par,lmulti2,lresta9,lista_impar, suma, digito_suma, verificaror
#
#
#
#
#
#
#
#
#
#
# def buscardivisibles(numeros,divisor):
#     l=[]
#     if divisor>0 and divisor<len(numeros):
#         for n in numeros:
#             if n%divisor==0:
#                 l.append(n)
#     return l
#
#
# import random as rd
# numeros= rd.sample(range(5,453),52)
# divisor=rd.randint(6,19)
#
# y=buscardivisibles(numeros,divisor)
#
#
#
#
# ################################3
# def buscar_clave(datos, clave):
#     ldatos= datos.split(" ")
#     valor =0
#     for str in ldatos:
#         if str==clave:
#             pos=ldatos.index(clave)
#             n= ldatos[pos+1]
#             valor+=int(n)
#     return valor
#
#
#
# f=buscar_clave("ALT 60 DIST 110 PRESION 2 TEMP 33 PAS 4", "TEMP")
#
#
#
#
#
#
# def validad(cadena):
#     x=0
#     if len(cadena)>=8:
#         x+=1
#     for str in cadena:
#         if str.isupper():
#             x+=1
#         if str.isdigit():
#             x+=1
#         if str in "#$%":
#             x+=1
#     if x>3:
#         x=True
#     else:
#         x=False
#     return x
#
# lcadena= ["H1l#", "k3v$","keva3#jI"]
# l=[]
# for palabra in lcadena:
#     y=validad(palabra)
#     l.append(y)
#
#
#
#
# def buscar_palabras(texto, lpalabras):
#     suma=0
#     ltexto= texto.split(" ")
#     for letra in ltexto:
#         if letra in lpalabras:
#             suma+=1
#
#     return suma
#
# texto="como tenemos como tenemos como y que tenia que tenia que tenia que tenia que"
# lpalabras=["como", "que"]
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#










