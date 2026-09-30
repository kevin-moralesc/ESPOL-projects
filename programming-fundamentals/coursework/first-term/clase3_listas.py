# prod1 = "papa"
# prod2 = "queso"
# prod3 = "aceite"

# lproductos = [] # lista vacia
# lproductos = ["papa" , "queso", "aceite"]
# prod = input("Ingrese el producto: ")
# lproductos.append(prod) # in place
# print(lproductos)

#lropa_inv = ['chompa', 'abrigo', 'chompa' ]
#lropa = ['pantalon', "camiseta", 'chompa']
#lropa.extend(lropa_inv)


#lropa.insert(1, "pantaloneta")
#print(lropa)
#elemento = lropa.pop(2)

#lropa.remove("chompa")
#print(lropa)
# pos = lropa.index("abrigo")
# print(elemento)
# print(pos)
# total = lropa.count("chompa")
# tamaño = len(lropa)
# print(tamaño)
# print(total)

# buscar elementos dadas listas paralelas #
# ltemperaturas = [23.5, 23.7, 24.1, 23.9]
# ltiempos = [1500, 1501, 1502, 1503]
# a que hora fue la máxima temperatura
# hora = ltiempos[ ltemperaturas.index(max(ltemperaturas)) ]
# print(hora)
# pos = ltiempos.index(1501)
# temp = ltemperaturas[pos]
# print(temp)


# split e indexamiento de elementos adyacentes
#tweet = 'En el dia 2021-Mayo-17 dentro de la CIUDAD Guayaquil se registró una TEMP_MIN 18.3 y una TEMP_MAX 32.1'
#ltweet = tweet.upper().split(" ")
#pos = ltweet.index("DIA")
#fecha =  ltweet[pos + 1]
#año, mes, dia = fecha.split("-")
#print(año)
#print(mes)
#print(dia)

# lfecha = fecha.split("-")
# año= lfecha[0]
# mes=lfecha[1]
# dia=lfecha[2]


# ciudad = ltweet[ltweet.index("CIUDAD") + 1]
# print(ciudad)

# actualizar valores de las listas

#lcalificaciones = [75, 56, 80, 20]
#lcalificaciones[-1] = 30
#print(lcalificaciones)


# lcalificaciones = [75, 56, 80, 20]
# pos es la 1 : a ese elementos hay que aumentarle 15
# lcalificaciones[1] = lcalificaciones[1] + 15
# print(lcalificaciones)


# lcalificaciones = [75, 56, 80, 20]
# # aumente el 10% de la calificacion
# # al que esta más bajo
# pos = lcalificaciones.index(min(lcalificaciones))
# lcalificaciones[pos] = lcalificaciones[pos] * 1.1
# print(lcalificaciones)




# remplace la menor calificacion
# por el promedio de la lista
# minimo = min(lcalificaciones)
# pos = lcalificaciones.index(minimo)
# promedio = sum(lcalificaciones)/len(lcalificaciones)
# lcalificaciones[pos] = promedio
# print(lcalificaciones)

# quiero hacer mayuscyla la letra en la 7ma posicion
# palabra = "fundamentos"
# # palabra[7] = palabra[7].upper() # asignacion por posicion no se puede hacer en strings, hay que convertirlo a lista
# lletras = list(palabra)
# lletras[7] = lletras[7].upper()
# palabra = "".join(lletras)
# print(palabra)



