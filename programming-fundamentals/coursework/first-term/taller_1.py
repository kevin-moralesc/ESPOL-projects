#Crear una función llamada calculaPromedio que recibe su nota de primer parcial, de segundo parcial,
# tercera calificación, calificación de práctico y porcentaje de teórico y retorne un valor booleano
# indicando si aprobó o no la materia. El porcentaje teórico debe tener un valor por defecto de 0.7.

#
# def calculapromedio (ca1,ca2,ca3,cap,pteo=0.7):
#     ca1 = float(ca1)
#     ca2 = float(ca2)
#     ca3 = float(ca3)
#     lteorico= [ca1,ca2,ca3]
#     lteorico.sort( )
#     lteorico.pop(0)
#     teo= sum(lteorico)/2
#     promedioteo= teo* pteo
#
#     cap= float(cap)
#     calpractico= cap * (1-pteo)
#
#     notafinal= promedioteo + calpractico
#     aprobo= notafinal>=60
#     print("su nota final es", notafinal)
#     print("aprobo?:", aprobo )
#
#     return aprobo


#Crear una función llamada encontrarMayor el cual recibe una lista y retorna el nombre de
# la persona que más sueldo gana y el valor del sueldo. Un ejemplo de la lista es el siguiente:
#['Frank', 200, 'Juan', 500, 'María', 300]
#La función encontrar mayor debería retornar dos valores
#‘Juan’
# 500

#
# def encontrarmayor (lnombres):
#     listanombres= lnombres[::2]
#     listasueldo= lnombres[1::2]
#     sueldomayor=max(listasueldo)
#     possueldomayor=listasueldo.index(sueldomayor)
#     nombremayor= listanombres[possueldomayor]
#
#
#     return nombremayor, sueldomayor
#


# Crear una función llamada intercambioMayuscula la cual recibe una frase de tipo string,
# una posicion1 de tipo int y una posicion2 de tipo int. La función debe retornar la frase con las palabras
# cambiadas y transformadas en mayúsculas. Ejemplo:

#intercambioMayuscula("mi nombre es python y soy un lenguaje de programacion", 0, 5)
#retornaría
#"SOY nombre es python y MI un lenguaje de programacion"

#
# def intercambiomayuscula (frase, pos1, pos2):
#     frase= frase.split (" ")
#     frase[pos1], frase[pos2] = frase[pos2].upper(), frase[pos1].upper()
#     union= " ".join (frase)
#     return union
#
#
#










