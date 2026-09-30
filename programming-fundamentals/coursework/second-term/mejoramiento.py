# Tarea: Calcular el descuento de un estudiante
#
# ---
#
# ### Descripción del problema
#
# Se necesita desarrollar un programa que calcule el descuento en las pensiones de los estudiantes universitarios. El descuento depende de dos criterios: el número de años que el estudiante lleva en la universidad y su orden de inscripción en la carrera.
#
# **1. Formato del código de estudiante (matrícula):**
# El código consta de 10 dígitos que se desglosan de la siguiente manera:
# * Primeros 4 dígitos: Año de ingreso.
# * Siguientes 3 dígitos: Código de la carrera.
# * Últimos 3 dígitos: Orden de inscripción en la carrera.
#
# *Ejemplo:* 2017030089
# * Año de ingreso: 2017
# * Código de carrera: 030
# * Orden de inscripción: 089
#
# **2. Criterios de descuento:**
#
# **Descuento por años de permanencia:**
# * Si el estudiante lleva 2 años en la universidad: 5% de descuento.
# * Si el estudiante lleva 3 años en la universidad: 15% de descuento.
# * Si el estudiante lleva 4 o más años en la universidad: 25% de descuento.
#
# **Descuento por orden de inscripción:**
# * Si el estudiante se inscribió entre los 10 primeros de su promoción (orden de 1 a 10): 50% de descuento.
# * Si se inscribió entre los lugares 11 y 20: 30% de descuento.
# * Si se inscribió entre los lugares 21 y 30: 10% de descuento.
#
# **Importante:** Un estudiante solo puede obtener uno de los descuentos ofrecidos, el más alto que le corresponda de todos los criterios.
#
# ### Tareas a realizar
#
# 1.  **Solicitar al usuario:**
#     * El año en curso.
#     * El número de matrícula del estudiante.
#
# 2.  **Procesar la información:**
#     * Extraer el año de ingreso y el orden de inscripción de la matrícula.
#     * Calcular los años de permanencia del estudiante en la universidad.
#     * Determinar los descuentos posibles según ambos criterios.
#
# 3.  **Calcular el descuento final:**
#     * Seleccionar el descuento más alto de todos los que aplican.
#     * Si no aplica ningún descuento, se considera que el descuento es del 0%.
#
# 4.  **Mostrar el resultado:**
#     * Imprimir el descuento final obtenido por el estudiante.
#     * Si no tiene descuento, imprimir 'NO TIENE DESCUENTO'.
#     * Al final, imprimir el mensaje 'Fin del programa'.
#
# ### Ejemplos
#
# * **Ejemplo 1:**
#     * `Año en curso:` 2020
#     * `Matrícula:` 2017030029
#     * `Salida:` Obtiene un descuento del 15%
#
# * **Ejemplo 2:**
#     * `Año en curso:` 2020
#     * `Matrícula:` 2018010009
#     * `Salida:` Obtiene un descuento del 50%
#
# * **Ejemplo 3:**
#     * `Año en curso:` 2020
#     * `Matrícula:` 2020010050
#     * `Salida:` NO TIENE DESCUENTO

# amoactual = int(input("ingrese su numero de año en curso:"))
# matricula = input("ingrese numero de matricula:")

# amo_ingreso = int(matricula[:4])
# codcarrera = int(matricula[4:7])
# orden_ingreso = int(matricula[7:])
# lista_descuento = []

# if (int(amoactual) - int(amo_ingreso)) == 2:
#     lista_descuento.append(5)
# elif (int(amoactual) - int(amo_ingreso)) == 3:
#     lista_descuento.append(15)
# elif (int(amoactual) - int(amo_ingreso)) >= 4:
#     lista_descuento.append(25)
# else:
#     lista_descuento.append(0)

# if orden_ingreso <= 10:
#     lista_descuento.append(50)
# elif 11 < orden_ingreso < 20:
#     lista_descuento.append(30)
# elif 21 < orden_ingreso < 30:
#     lista_descuento.append(10)

# if 0 in lista_descuento:
#     print("NO TIENE DESCUENTO")

# else:
#     descuento = max(lista_descuento)
#     print("Obtiene un descuento del", descuento, "%")
# print("Fin del programa")


################################################################################################################


# Vamos a desarrollar una versión simple de un juego para adivinar una palabra.
# Para esto cuenta con una lista de palabras que contienen las palabras que el usuario debe adivinar.
# Debe escoger de manera aleatoria una de las palabras de la lista, luego el usuario deberá seleccionar
# cuál de las siguientes preguntas desea que el programa le responda:

# * ¿Cuántas letras tiene?
# * ¿Cuántas vocales tiene?
# * ¿Cuántas consonantes tiene?

# El programa deberá mostrar la respuesta de la pregunta seleccionada, luego se le pedirá al usuario que adivine la palabra.

# * Si el usuario adivina le mostrará "¡Tiene grandes poderes de deducción!".
# * Si el usuario no adivina, el programa le dirá si la palabra termina en vocal o en consonante y le pedirá que adivine nuevamente.
#     * Si adivina le mostrará "Muy bien, sigue mejorando".
#     * Si no adivina le mostrará "Parece que no tiene poderes de deducción".

# import random as rd

# lista_palabra = ["kevin", "fiec", "computacion", "uwu"]

# randomword = rd.choice(lista_palabra)

# listta_preguntas = [
#     "1.-¿Cuántas letras tiene?",
#     "2.-¿Cuántas vocales tiene?",
#     "3.-¿Cuántas consonantes tiene?",
# ]
# print("seleccione cualquier pregunta:")
# for p in listta_preguntas:
#     print(p)

# pregunta_escogida = input("la pregunta:")


# if int(pregunta_escogida) == int(listta_preguntas[0][0]):
#     print(listta_preguntas[0])


# elif int(pregunta_escogida) == int(listta_preguntas[1][0]):
#     print(listta_preguntas[1])


# elif int(pregunta_escogida) == int(listta_preguntas[2][0]):
#     print(listta_preguntas[2])


# adivinar = input("adivine la palabra")
# intento = 0
# while adivinar != randomword:
#     intento += 1
#     if randomword[-1] in "aeiouAEIOU":
#         print("la palabra termina en vocal ")
#     else:
#         print("la palabra termina en consonante")
#     print("parece q no tienes poderes de deduccion")

#     adivinar = input("adivine la palabra")

#     print("")
# if intento > 1:
#     print("muy bien, sigue mejorando")

# else:
#     print("tienes grandes  poderes de deduccion")


#######################################################################################


# Crear la función calcular(a, b, c) que recibe los valores numéricos a, b y c.
# Esta función deberá aplicar la fórmula que se muestra a continuación para poder calcular y retornar el valor d.

# d = a^b * (c - sqrt(a + b))

# El valor de b debe tener un valor por defecto de 2 y c un valor de 4.


# def calcular(a, b=2, c=4):
#     d = (a**b) * (c - (a + b) ** 1 / 2)

#     return d


# a = 1

# print(calcular(a))
######################################################

# Crea una función obtenerApellido(personas) que reciba una lista con nombres de personas.
# La función debe escoger aleatoriamente una de las personas y retornar su apellido.

# Ejemplo:
# personas = ["Juan Perez", "Carlos Leon", "Francisco Maldonado", ...]
# apellido = obtenerApellido(personas)
# print(apellido) -> Maldonado
# import random as rd

# personas = ["Juan Perez", "Carlos Leon", "Francisco Maldonado"]


# def obtenerApellido(personas):
#     ramdperson = rd.choice(personas)
#     nombre, apellido = ramdperson.split(" ")
#     return apellido


# print(obtenerApellido(personas))
##############################################


# Crear la función calcular(info) que recibe la cadena info que contiene información de una transacción en el formato:
# unidades|valorUnitario$. La función debe retornar el total a pagar de la transacción.

# En el programa principal cuenta con la lista transacciones que contiene cadenas de caracteres con la información
# de cada transacción siguiendo el formato descrito anteriormente.
# Muestre por pantalla el total a pagar por todas las transacciones de la lista.

# Ejemplo:
# Total a pagar: $560.25


# def calcular(info):

#     unidad, valorunitario = info.split("|")

#     return valorunitario
# transacciones=[]
# total_a_pagar=0
# for info in transacciones:
#     total_a_pagar+=calcular(info)
# print("total a pagar:", total_a_pagar)


##########################################
# En la lista de inventario se guarda el registro de los productos que se venden en un market.
# La lista tiene el formato producto,precio,descuento. El último campo indica:
# * 'Si': Se aplica un descuento por ventas al por mayor: un porcentaje aleatorio de descuento entre 10% a 20% si se compran al menos 6 productos.
# * 'No': No se aplica ningún descuento.

# inventario = ['atun,0.90,No', 'leche,1.10,Si', 'arroz,0.56,No', 'cafe,3.4,Si', ...]

# Escriba un programa que dada una lista de compras, calcule el precio total de compra,
# aplicando los descuentos correspondientes. Cada elemento de la lista de compras tiene el formato producto,cantidad.

# compras = ['atun,20', 'cafe,5', 'arroz,10', ...]

# Nota: Puede asumir que todos los productos de la lista de compras también existen dentro de la lista de inventario.
# import random as rd

# inventario = ["atun,0.90,No", "leche,1.10,Si", "arroz,0.56,No", "cafe,3.4,Si"]
# l = [0.10, 0.20]
# prod = []
# precio = []
# desc = []
# for m in inventario:
#     p, preci, d = m.split(",")
#     prod.append(p)
#     precio.append(preci)
#     desc.append(d)


# compras = ["atun,20", "cafe,5", "arroz,10"]

# total = 0
# for info in compras:
#     producto, canti = info.split(",")

#     if producto in prod:
#         pos = prod.index(producto)
#         pago = int(canti) * float(precio[pos])
#         if desc[pos] == "Si" and int(canti) >= 6:
#             pago = pago * (rd.choice(l))

#         total += pago

# print("total", total)


########################################
# Escriba la función ordenaPalabras(cadena) que recibe una cadena que contiene palabras separadas por '-'.
# La función retorna una nueva cadena con las palabras ordenadas alfabéticamente y separadas por 'espacio'.

# Ejemplo:
# texto = "rojo-blanco-azul-celeste-verde-rosa"
# nuevo = ordenarPalabras(texto)
# print(nuevo)
# Salida: azul blanco celeste rojo rosa verde


# cadena = "rojo-blanco-azul-celeste-verde-rosa"


# def ordenaPalabras(cadena):
#     l = cadena.split("-")
#     l.sort()
#     resultado = ""
#     for p in l:
#         nuevo = p + " "
#         resultado += nuevo
#     return resultado


# print(ordenaPalabras(cadena))


#####################################
# [25 puntos] Implemente un programa que simule una carrera de 10 turnos entre dos animales: Liebre y Tortuga.
# Cada animal tiene una velocidad máxima guardada en vel_l y vel_t respectivamente, que indica cuánto puede avanzar por turno, usando un número aleatorio entre 1 y la velocidad máxima, ambos incluidos.
# Además, hay una lista llamada l_trampas que indica las casillas donde hay trampas para la liebre.
# Si cae en una, regresa a la posición anterior (donde estaba antes del último turno).
# El avance de cada animal se acumula turno a turno, sumando las casillas recorridas en cada movimiento para determinar su posición final en la pista de la carrera.
# Además, debe mostrar con guiones el avance alcanzado como se muestra en el ejemplo de salida esperada.
# Al final de los 10 turnos, gana el animal que haya avanzado más casillas en total. En caso de empate, se declara empate.

# Datos iniciales:
# vel_l = 5 # liebre
# vel_t = 3 # tortuga
# l_trampas = [4, 7, 9, 13]

# Salida esperada:
# Turno 1:
# Liebre: --- (posición 3)
# Tortuga: -- (posición 2)
# Turno 2:
# Liebre cayó en trampa en casilla 4, regresa a su posición anterior
# Liebre: --- (posición 3)
# Tortuga: ----- (posición 5)
# ... otros turnos ...
# Turno 10:
# Liebre: --------- (posición 9)
# Tortuga: -------------- (posición 14)
# Ganador: Tortuga

# import random as rd

# turnos = 0
# vel_l = 5
# vel_t = 3
# liebre = rd.randint(1, vel_l)
# tortuga = rd.randint(1, vel_t)
# l_trampas = [4, 7, 9, 13]

# total_l = 0
# total_t = 0

# while turnos != 10:
#     turnos += 1
#     print("turno:", turnos)
#     total_l += liebre
#     if total_l in l_trampas:
#         print("liebre cayó en trampa en la casilla", total_l, "regrese a su posicion")
#     else:
#         print("Liebre:", "-" * total_l, "(posición", total_l, ")")
#     total_t += tortuga

#     print("Tortuga:", "-" * total_t, "(posicion", total_t, ")")

# if total_t > total_l:
#     print("Ganador: Tortuga")
# else:
#     print("Ganador: Liebre")


##########################################

# Crear la función generar_clave(longitud, especiales) que recibe la longitud de la clave a generar
# y una cadena con caracteres especiales que se desean usar en la clave.
# La función debe retornar una clave generada en forma de cadena de caracteres considerando lo siguiente:

# * Incluya entre 2 a 7 letras mayúsculas de manera aleatoria y sin repetir.
# * Incluya de 2 a 4 caracteres especiales de manera aleatoria, estos se pueden repetir.
# * Escoja un número múltiplo de 5 entre 5 y 26.
# * Desordene los caracteres de la cadena generada.
# * Rebana la cadena generada para que cumpla con la longitud.


# import random as rd


# def generar_clave(longitud, especiales):
#     clave = ""
#     l_palabras = list("abcdefghijklmnñopkrstwxyz".upper())
#     listaf = []
#     for k in range(2, 8):
#         palabra = rd.choice(l_palabras)
#         listaf.append(palabra)
#         if listaf.count(palabra) > 1:
#             listaf.remove(palabra)
#     clave += "".join(listaf)

#     for c in range(2, 5):
#         clave += rd.choice(list(especiales))

#     l = []
#     for m in range(5, 27):
#         if m % 5 == 0:
#             l.append(m)
#     numero = str(rd.choice(l))
#     clave += numero

#     lclave = list(clave)
#     rd.shuffle(lclave)
#     clave = "".join(lclave)
#     clave = clave[:longitud]

#     return clave


# longitud = 10
# especiales = "#@$^&"

# print(generar_clave(longitud, especiales))

###############################################


# equipos = ["Ecu", "Qat", "Arg"]
# puntajes = [5, 2, 4]


# def agregar_puntaje(equipos, puntajes, equipo, puntos):

#     if equipo in equipos:
#         for pos, equipo in enumerate(equipos):
#             puntajes[pos] += puntos
#     else:
#         equipos.append(equipo)
#         puntajes.append(puntos)
#     return equipos, puntajes


# print(agregar_puntaje(equipos, puntajes, "Pe", 10))


################################################


# import random as rd


# def desordenarNombre(cadena):
#     l = list(cadena)
#     rd.shuffle(l)
#     return "".join(l)


# cadena = input("ingrese su nombre:")

# print(desordenarNombre(cadena))


mayu = "abcdefghijklmnñopqrstwxyz".upper()

general = "abcdefghijklmnñopqrstwxyz" + mayu

##########################################


# def devolver_numero(dato):
#     pt = 0
#     l = []
#     for r in dato:
#         if r in general:
#             return 0.0
#         if r == ".":
#             pt += 1
#         else:
#             l.append(r)
#     if pt > 1:
#         return 0.0
#     if len(l) > 0:
#         return 0.0
#     else:
#         return float(dato)


# print(devolver_numero("44.%"))


###########################################################

# [30 puntos] Implementa la función monto_categoria(lista_proyectos, categoria) para calcular el monto total de los proyectos asociados a una categoría específica.
# Cada elemento de l_proyectos tiene el siguiente formato: Categoria;proyecto1:valor;proyecto2:valor;...

# Ejemplo de la lista de proyectos por categoría:
# l_proyectos = [
# "Ciencias Naturales;Monitoreo cardiaco:230;Primeros auxilios:210",
# "Tecnología;Clasificador de imágenes:250;Chatbot para Call Center:220;...",
# "Arte y Creatividad;App para matemáticas:180;Juego de lógica para niños:160;..."
# ]

# La función debe:
# * Buscar la categoría especificada (sin distinguir mayúsculas/minúsculas).
# * Sumar los montos de todos los proyectos de esa categoría.
# * Retornar el total.

# Ejemplo:
# Para la lista de proyectos del ejemplo y la categoría buscada
# cat = "Ciencias naturales"
# # Salida esperada:
# 440.00


# def monto_categoria(lista_proyecyos, categoria):
#     total = 0

#     for info in lista_proyecyos:
#         l = info.split(";")
#         category = l[0]

#         if category.lower() == categoria.lower():
#             l = l[1:]
#             for n in l:
#                 proyecto, valor = n.split(":")
#                 total += float(valor)
#     return total


# l_proyectos = [
#     "Ciencias Naturales;Monitoreo cardiaco:230;Primeros auxilios:210",
#     "Tecnología;Clasificador de imágenes:250;Chatbot para Call Center:220",
#     "Arte y Creatividad;App para matemáticas:180;Juego de lógica para niños:160",
# ]
# cat = "Arte Y CreAtIvidad"


# print(monto_categoria(l_proyectos, cat))


########################################################################


# TEMA 2
# [25 pts] Escriba la función limpiar_comentarios(
# l_comentarios, l_palabras) que recibe una lista de
# cadenas con comentarios recibidos de una página web
# y otra lista de palabras negativas.
# La función debe devolver una lista con los comentarios
# sin palabras negativas ni signos de puntuación (.,).
# Las palabras negativas deberán ser reemplazadas por
# una cadena de asteriscos (***).
# Nota 1: Asegúrese de quitar los signos de puntuación
# antes de procesar cada comentario.
# Nota 2: Asuma que las listas solo tienen palabras en
# minúsculas.

# l_comentarios = [
#     "me encanta este producto, es increíble, exprímalo al máximo.",
#     "este producto es una basura, no lo compren.",
#     "no me gusta, el servicio es muy malo.",
#     "el diseño es horrible, no lo compraría nunca.",
#     "excelente calidad, lo recomiendo",
#     "muy malo, malo, de lo peor"
# ]
# l_palabras = [
#     'basura',
#     'malo',
#     'horrible',
#     'peor'
# ]

# Ejemplo de lista luego de limpiar:
# [
#     "me encanta este producto es increíble exprímalo al máximo",
#     "este producto es una *** no lo compren",
#     "no me gusta el servicio es muy ***",
#     "el diseño es *** no lo compraría nunca",
#     "excelente calidad lo recomiendo",
#     "muy *** *** de lo ***"
# ]


# def limpiar_comentarios(lista_comentarios, lista_palabras):
#     comentarios_limpios = []
#     for comentario in lista_comentarios:
#         comentario = comentario.replace(",", "").replace(".", "")
#         lword = comentario.split(" ")
#         palabras_limpias = []
#         for palabra in lword:
#             if palabra in lista_palabras:
#                 palabras_limpias.append("***")
#             else:
#                 palabras_limpias.append(palabra)
#         comentarios_limpios.append(" ".join(palabras_limpias))
#     return comentarios_limpios


# l_comentarios = [
#     "me encanta este producto, es increíble, exprímalo al máximo.",
#     "este producto es una basura, no lo compren.",
#     "no me gusta, el servicio es muy malo.",
#     "el diseño es horrible, no lo compraría nunca.",
#     "excelente calidad, lo recomiendo",
#     "muy malo, malo, de lo peor",
# ]
# l_palabras = ["basura", "malo", "horrible", "peor"]

# print(limpiar_comentarios(l_comentarios, l_palabras))


#######################################################3


# TEMA 3
# Considere las siguientes variables:
# abecedario = "abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWXYZ"
# simbolos = "!@#$%^&*-=_:;,.<>?/~"

# [25 pts] Cree una función llamada generar_contraseña(longitud, abecedario, simbolos) que reciba un número entero, representando la longitud deseada de la contraseña; una cadena que contiene las letras en minúsculas y mayúsculas (separada por guión); y una cadena que contiene los símbolos permitidos.
# Si la función recibe una longitud menor a 6 debe retornar una cadena vacía, caso contrario, debe retornar una contraseña utilizando los parámetros recibidos.
# La contraseña debe cumplir con lo siguiente:
# * Contener exactamente 2 letras aleatorias distintas en mayúsculas.
# * Incluir 2 símbolos aleatorios.
# * El resto de la contraseña debe estar compuesta por letras aleatorias en minúscula hasta alcanzar la longitud indicada.
# * Además, las letras y los símbolos deben distribuirse aleatoriamente en la cadena retornada.

# import random as rd


# def generar_contraseña(longitud, abecedario, simbolos):
#     contraseña = ""
#     pos = abecedario.index("-")
#     labc_may = list(abecedario[: pos + 1])
#     labc_min = list(abecedario[pos:])
#     lsimbolos = list(simbolos)
#     if longitud < 6:
#         return ""
#     else:
#         l = rd.sample(labc_may, 2)
#         contraseña += "".join(l)
#         s = rd.choices(lsimbolos, k=2)
#         contraseña += "".join(s)
#         rd.shuffle(labc_min)
#         contraseña += "".join(labc_min)
#     lcontraseña = list(contraseña[:longitud])
#     rd.shuffle(lcontraseña)

#     return "".join(lcontraseña)


# longitud = 10
# abecedario = "abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWXYZ"
# simbolos = "!@#$%^&*-=_:;,.<>?/~"

# print(generar_contraseña(longitud, abecedario, simbolos))


###########################################################################


# info = input("Ingrese la informacion del producto:")
# total = 0
# unidadesCompradas, valorunitario, descuento = info.split("|")
# total += (float(unidadesCompradas)) * float(valorunitario.replace("$", ""))
# total -= (
#     (float(unidadesCompradas))
#     * float(valorunitario.replace("$", ""))
#     * (float(descuento.replace("%", "")) / 100)
# )

# print(total)


###############
# Ejercicio 2

# Pida al usuario que ingrese una cadena de caracteres, luego seleccione 2 caracteres aleatorios y verifique si estos son alfanuméricos.

# Ejemplo de Salida
# Ingrese una cadena: abc_$$123
# Caracter 1: c
# Caracter 2: 3
# Los caracteres son alfanumericos?: True

# import random as rd

# cadena = input("ingrese una cadena:")
# lcadena = list(cadena)
# l = rd.sample(lcadena, 2)
# respuesta = 0
# for pos, n in enumerate(l):
#     print("caracter", pos + 1, ":", n)
#     if n.isalnum():
#         respuesta += 1

# if respuesta == 2:
#     print("los caranteres son alfanumericos?: True")
# else:
#     print("los caranteres son alfanumericos?: False")

##############################333# Ejercicio 0

# Usted cuenta con la variable 'mensaje' la cual contiene una cadena de caracteres con un mensaje cifrado.
# mensaje = ';3;ajduat|q17!9k.crEcn te-u?Q1'

# Para poder revelar su contenido deberá seguir los siguientes pasos:
# * Cree una nueva cadena quedándose únicamente con los últimos 17 caracteres.
# * En la nueva cadena inserte la palabra 'zaz' en el índice 5.
# * Usando la cadena del paso anterior, obtenga los caracteres en índice par.
# * Finalmente, invierta la cadena obtenida y muestre por pantalla el mensaje.

# mensaje = ";3;ajduat|q17!9k.crEcn te-u?Q1"
# nuevo = mensaje[-17:]
# lnuevo = list(nuevo)
# lnuevo.insert(5, "zaz")
# nuevo = "".join(lnuevo)
# nuevo = nuevo[2::2]
# nuevo = nuevo[::-1]
# print(nuevo)

#############################################

# Ejercicio 1


# Cree un programa que reciba una contraseña e indique si tiene un buen nivel de seguridad, para esto la contraseña debe cumplir con lo siguiente:
# * Debe tener al menos 8 caracteres
# * Debe poseer al menos un '_' o un '$'
# * Debe terminar en un dígito

# Ejemplo de Salida
# Ingrese su password: xav_pauta99
# Nivel de seguridad alto: True


# password = input("ingrese su contraseña:")
# x = 0
# lpcontra = list(password)
# if len(password) >= 8:
#     x += 1
# if "_" in lpcontra or "$" in lpcontra:
#     x += 1
# if password[-1] in "0123456789":
#     x += 1


# if x == 3:
#     print("Nivel de seguridad Alto: True")
# else:
#     print("Nivel de seguridad Alto: False")


###########################


# Ejercicio 6
# Editado por: Xavier - 0980782990

# Un obrero necesita calcular su salario semanal, el cual se obtiene de la siguiente manera:
# * Si trabaja 40 horas o menos se le paga $10 por hora.
# * Si trabaja más de 40 horas se le paga $10 por cada una de las primeras 40 horas y $20 por cada hora extra.

# Ejemplo
# Ingrese la cantidad de horas: 30
# => Total: $300

# Ejemplo
# Ingrese la cantidad de horas: 45
# => Total: $400 + $100 = $500


# hora = input("ingrese la cantidad de horas:")
# total = 0
# if int(hora) <= 40:
#     total += int(hora) * 10
#     print("total:", "$", total)
# if int(hora) > 40:
#     condi1 = 40 * 10
#     cond2 = (int(hora) - 40) * 20
#     total += condi1 + cond2
#     print("total:", "$", condi1, "+", cond2, "=", total)

##########################################
# Ejercicio 3
# Editado por: Xavier - 0980782990

# Escriba un programa que solicite el usuario su nombre, apellido y el nombre de la empresa. Luego con estos datos genere lo siguiente:
# 1. Correo electrónico conformado por:
# * Las 3 primeras letras del nombre en minúsculas.
# * Las 2 últimas letras del apellido en mayúsculas.
# * 2 dígitos aleatorios.
# * Finalmente @empresa.com.

# 2. Contraseña conformada por 8 caracteres que contiene:
# * 3 letras diferentes del nombre escogidas de forma aleatoria.
# * La cantidad de letras que contiene su nombre.
# * Las 2 últimas letras del apellido, al revés, serán agregadas al inicio y al final de la contraseña.

# Ejemplo de Salida
# Ingrese su nombre: Xavier
# Ingrese su Apellido: Pauta
# Ingrese el nombre de la empresa: ESPOL
# Resultados:
# Correo -> xavTA85@espol.com
# Contraseña -> atxvr6at


# import random as rd

# correo = ""

# nombre = input("ingrese su nombre:")
# apellido = input("ingrese su apellido:")
# empresa = input("ingrese el nombre de la empresa:")
# nombre = nombre.lower()
# apellido = apellido.lower()

# correo += nombre[:3].lower()
# correo += apellido[-2:].upper()
# correo += "".join(rd.sample(list("0123456789"), 2))
# x = "@" + empresa.lower() + ".com"
# correo += x


# contraseña = ""
# letras = ""
# for n in nombre:
#     if n not in "aeiouAEIOU":
#         letras += n
# contraseña += apellido[-2:][::-1]
# contraseña += "".join(rd.sample(list(letras), 3))
# contraseña += str(len(nombre))


# contraseña += apellido[-2:][::-1]


# print("resultados:")
# print("\tcorreo->", correo)
# print("\tcontraseña->", contraseña)
############################
# Ejercicio 7

# Escribe un programa que determine si un estudiante aprobó o reprobó un examen, considerando que la nota mínima de aprobación es 60, pero si obtiene menos de 40, se considera que tiene una calificación muy baja.

# Ejemplo 1
# Ingrese su calificacion: 70
# => Aprobado

# Ejemplo 2
# Ingrese su calificacion: 50
# => Reprobado

# Ejemplo 3
# Ingrese su calificacion: 30
# => Reprobado
# => Su calificacion es muy baja

# calificacion = input("ingrese su calificacion:")

# if int(calificacion) >= 60:
#     print("aprobado")
# elif int(calificacion) < 40:
#     print("reprobado")
#     print("su calificacion es muy baja")

# else:
#     print("reprobado")


#################################


# Ejercicio 5
# Creado por: Xavier - 0980782990

# Usted cuenta con una lista que contiene la información del salario de una persona que ha recibido por cada año trabajado, esta contiene el año y a continuación el salario de ese año, como se ve a continuación:
# datos = ['2001', 2400, '2002', 2520, '2003', 2554 ...]

# Con esta información muestre por pantalla lo siguiente:
# 1. Salario Promedio
# 2. El mayor y menor salario que ha recibido
# 3. El Salario Promedio de los últimos 5 años

# Ejemplo de Salida
# - Salario promedio: $ 2540.56
# - Mayor salario: $ 3100 - Menor Salario: $ 1500
# - Salario Promedio de los últimos 5 años: $ 1045


# datos = ["2001", 2400, "2002", 2520, "2003", 2554]

# promedio = sum(datos[1::2]) / len(datos[1::2])
# maxsalario = max(datos[1::2])
# minsalario = min(datos[1::2])
# lsalarrios = datos[1::2]
# lsalraio = lsalarrios[-5:]
# promedioultimos = sum(lsalraio) / len(lsalraio)

# print("salario promedio: $", promedio)
# print("mayor salario: $", maxsalario, "- menor salario: $", minsalario)
# print("salario promedio de los ultimos 5 años: $", promedioultimos)


############################################


# La función recibirá una palabra y retornará el puntaje de dicha palabra. Todas las letras ingresadas deben ser mayúsculas. Si se ingresa un letra minúscula, esta es ignorada (puntuación de 0 para dicha letra).
# Una corrida ejemplo del programa sería:

# ReY el resultado seria 5


# Se adjuntan las listas correspondientes:

# alfabeto = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

# puntos = [1, 3, 3 ,2, 1, 4, 2, 4, 1, 9, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 9, 4, 10]

# def puntaje(palabra):
#     puntaje_total = 0
    
#     for n in palabra:
#         if n in alfabeto:
#             pos= alfabeto.index(n)
#             puntaje_total+=puntos[pos]
#         else:
#             puntaje_total+=0
#     return puntaje_total
# print(puntaje("ReY"))
################################3

# Se ha obtenido información de costos mensuales de productos de la canasta básica que se muestra a continuación:
# prodsL = ["CEREALES", "CARNE", "PESCADOS", ...]  # Nombres de productos
# costosL = [47.08, 37.95, 12.07, ...]  # Costo mensual
# el = [-0.42, 0.34, -4.25, ...] # Encarecimiento. Si es positivo, el producto subió de precio


# Escriba lo siguiente:
# 1. La función buscarMayor(listaP, listaC, ref) que recibe listaP con la lista de productos, listaC con la lista de costos y un valor numérico llamado ref. La función retorna otra lista con los nombres de los productos para los cuales el costo mensual es mayor a ref.


# prodsL = [ "CEREALES ", "CARNE", "PESCADOS" ] 
# costosL = [ 47.08, 37.95, 12.07 ] 
# eL = [-0.42, 0.34, -4.25 ] 

# def buscarMayor(listaP, listaC, ref):
#     l=[]
#     for pos, n in enumerate(listaC):
#         if n>ref:
#             l.append(listaP[pos])
        
#     return l

#################################################################################################3

# 2. La función encarecimiento(listaE, tipo) que recibe listaE con la lista de encarecimiento y un string llamado tipo que puede tomar dos valores: "positivo" o "negativo". La función retorna cuántos productos tienen un encarecimiento positivo o negativo (dependiendo del parámetro tipo) y el promedio de encarecimiento para esos productos.

# prodsL = [ "CEREALES ", "CARNE", "PESCADOS" ] 
# costosL = [ 47.08, 37.95, 12.07 ] 
# eL = [-0.42, 0.34, -4.25 ] 


# def encarecimiento(listaE, tipo):
#     l=[]
#     total=0
#     for pos, n in enumerate(listaE):
#         if tipo=="positivo" and n>0:
#             l.append(prodsL[pos])
#             total+=n
#         if tipo=="negativo" and n<0:
#             l.append(prodsL[pos])
#             total+=n
        
#     promedio= total/len(l)
#     return l , promedio
     


# 3. Un programa que, dadas las listas prodsL, costosL y el, muestre el número de productos con encarecimiento "negativo" y el valor promedio del encarecimiento. Luego, pida al usuario un valor numérico y muestre los productos cuyo valor mensual es mayor al valor dado. Finalmente su programa mostrará aleatoriamente uno de estos productos obtenidos con su respectivo costo y encarecimiento. Use las funciones dadas.
# Ejemplo de la salida del programa:
# Cantidad de productos con encarecimiento negativo: 5 - Valor promedio: -3.27
# Ingrese un valor mínimo: 10
# Productos:
# 1. Cereales
# 2. Pescados
# 3. ...
# Ejemplo de producto: Pescados, Costo = 12.07, Encarecimiento = -4.25


# prodsL = [ "CEREALES ", "CARNE", "PESCADOS" ] 
# costosL = [ 47.08, 37.95, 12.07 ] 
# eL = [-0.42, 0.34, -4.25 ] 


# productonega,promedio =encarecimiento(eL,"negativo")

# valor_numerico= int(input("ingrese un valor minimo:"))

# import random as rd


# lprodictos= buscarMayor(prodsL,costosL,int(valor_numerico))

# for pos, m in enumerate(lprodictos):
#     print(pos+1,".",m.lower().capitalize()) 

# pro= rd.choice(lprodictos)
# pos= prodsL.index(pro)
# e= eL[pos]
# c= costosL[pos]

# print("ejemplo de producto:",pro,",","costo=",c,",", "Encareciiento=",e)




#################################################################################################################3





#  Crear una función llamada calculaPromedio que recibe su nota de primer parcial, de segundo parcial, tercera calificación, calificación de práctico y porcentaje de teórico y retorne un valor booleano indicando si aprobó o no la materia. El porcentaje teórico debe tener un valor por defecto de 0.7


# def calculadoraPromedio(cal1,cal2,cal3,calprac, pt=0.7):
#     lnotas=[]
#     lnotas.append(cal1)
#     lnotas.append(cal2)
#     lnotas.append(cal3)
#     lnotas.sort()

#     l= lnotas[1:]
#     promedioteo= sum(l)/len(l)
#     promedioteo= promedioteo*pt
#     promediopract=calprac*(1-pt)
#     promfinal=promedioteo+promediopract
#     promfinal=promfinal/10
#     print(promfinal)
#     return promfinal>=6
# print(calculadoraPromedio(95,92,93,96))


####################################
#  Crear una función llamada encontrarMayor el cual recibe una lista y retorna el nombre de la persona que más sueldo gana y el valor del sueldo. Un ejemplo de la lista es el siguiente:
# ['Frank', 200, 'Juan', 500, 'María', 300]

# La función encontrar mayor debería retornar dos valores
#  ‘Juan’
#  500
# # 
# def encontrarMayor(lista):
#     lsueldos=lista[1::2]
#     lpersonas=lista[::2]
#     mayorsueldo= max(lsueldos)
#     pos=lsueldos.index(mayorsueldo)
#     persona=lpersonas[pos]

#     return persona, mayorsueldo
# l=['Frank', 200, 'Juan', 500, 'María', 300]
# print(encontrarMayor(l))


###33############################33333
# Crear una función llamada intercambioMayuscula la cual recibe una frase de tipo string, una posicion1 de tipo int y una posicion2 de tipo int. La función debe retornar la frase con las palabras cambiadas y transformadas en mayúsculas. Ejemplo:
# intercambioMayuscula("mi nombre es python y soy un lenguaje de programacion", 0, 5)

# retornaría

# "SOY nombre es python y MI un lenguaje de programacion"

# def intercambioMayuscula(frase,pos1,pos2):
#     lfrase=frase.split(" ")
#     palabra1=lfrase[pos1]
#     palabra2=lfrase[pos2]
#     print(lfrase)
#     lfrase[pos1]=palabra2.upper()
#     lfrase[pos2]=palabra1.upper()

#     return " ".join(lfrase)

# print(intercambioMayuscula("mi nombre es python y soy un lenguaje de programacion", 0, 5))






###########################################################3


# 1.Dividir la palabra en dos mitades:
# 2.Invertir cada mitad por separado.
# 3.Reemplazar vocales por símbolos (en ambas mitades):
# •a → @
# •e → 3
# •i → !
# •o → 0
# •u → ^
# 4.Convertir la primera mitad a minúsculas y la segunda a mayúsculas.
# 5.Unir ambas partes y agregar un prefijo "##" y un sufijo "!!"
# palabra="Kevin"
# mitad1=palabra[ :len(palabra)//2]
# mitad2=palabra[len(palabra)//2: ]
# mitad1=mitad1[::-1]
# mitad2=mitad2[::-1]

# mitad1=mitad1.replace("a","@").replace("e","3").replace("i","!").replace("o","0").replace("u",">")
# mitad2=mitad2.replace("a","@").replace("e","3").replace("i","!").replace("o","0").replace("u",">")

# mitad1=mitad1.lower()
# mitad2=mitad2.upper()
# final="##"+mitad1+mitad2+"!!"


# print(final)


#################################################################
# leccion 1

# Implemente la función buscar_palindromos (mensaje) que recibe un mensaje y retorna una lista con todas las palabras (de 2 o más letras) del mensaje que son palíndromos.

# Recuerde que un palíndromo es una cadena que se lee igual de izquierda a derecha o de derecha a izquierda. Por ejemplo: madam, ana, somos, reconocer, anilina.

# Ejemplo de entrada

# mensaje = "ana y yo. somos amigos y, trabajamos en la torre del radar"

# Ejemplo de salida ['ana', 'somos', 'radar']

# Las palabras pueden estar en mayuscula o minuscula, y tienen signos de puntuacion . o la ,

# def buscarPalindromos(mensaje):
#     mensaje=mensaje.replace(".","").replace(",","")
#     lmensaje=mensaje.split(" ")
#     l=[]
#     for word in lmensaje:
#         if word==word[::-1]and len(word)>1:
#             l.append(word)
#     return l

# mensaje = "ana y yo. somos amigos y, trabajamos en la torre del radar"
# print(buscarPalindromos(mensaje))

######################################################################
#leccion2

# Implemente un programa que determine el porcentaje de efectividad de la función
# random.shuffle . Para esto:
# 1. Genere una lista de 57 números aleatorios únicos (sin repetidos) entre <<12 y 1632>>.


# 2. Repita los siguientes pasos 100 veces:

# 2.1 Desordene la lista original usando random.shuffle
# 2.2 Contar cuántos elementos han cambiado de posición entre la lista original y la lista
# resultante (después de mezclarla). Llamemos a este valor X .
# 2.3 Calcular el porcentaje de efectividad de la iteración actual. % efectividad iteracion
# = X * 100 / len(lista)

# 3. Calcule y muestre por pantalla el porcentaje de efectividad final. El porcentaje de
# efectividad final es el promedio de los porcentajes de efectividad de las 100 repeticiones,
# en otras palabras debe dividir la suma de todos los porcentajes de efectividad de las
# repeticiones para 100.

# import random as rd
# ln=[]
# for n in range(12,1633):
#     ln.append(n)
# l= rd.sample(ln,57)
# lcopy=l.copy()
# lpor=[]
# for _ in range(100):
#     rd.shuffle(l)
#     x=0
#     for pos,n in enumerate(l):
#         if n!=lcopy[pos]:
#             x+=1
#     porefectivi= x*100/len(l)
#     lpor.append(porefectivi)
# porcentajefinal= sum(lpor)/100

# print(porcentajefinal)




#####################################################


# Dos jugadores compiten en un juego de recolección. El objetivo es ser el primero en recolectar los 3 tipos diferentes de objetos disponibles: "piedra", "madera" y "hierba". En cada turno, un jugador encuentra un objeto aleatorio y lo agrega a su inventario.

# Crea un programa que:

# Tenga un diccionario llamado jugadores, donde la clave sea el nombre del jugador y el valor una lista con los objetos recolectados (ej. {"Ana": [], "Luis": []}).
# En cada iteración del while, el turno cambia entre los dos jugadores, comenzando por el primero "Ana".
# En cada turno, se genera un objeto aleatorio de la lista ["piedra", "madera", "hierba", "nada"] y se agrega a la lista del jugador correspondiente.
# "nada" (significa que no encontró nada y no debe agregarse al inventario)
# El juego continúa hasta que uno de los jugadores haya recolectado los 3 tipos de objetos distintos.
# Cuando alguien gana, el programa debe mostrar quién fue el ganador, cuántos turnos se jugaron en total y el estado final de ambos inventarios.
# jugadores = {"Ana": [],"Luis": []}
# import random as rd
# jugadores = {"Ana": [],"Luis": []}
# l=["piedra", "madera", "hierba", "nada"]
# i=0
# jugadoractual="Ana"
# turnos=0
# while len(jugadores[jugadoractual])!=3:
#     if i%2==0:
#         jugadoractual="Ana"
#     else:
#         jugadoractual="Luis"
#     objeto=rd.choice(l) 
#     if objeto!="nada":
#         if objeto not in jugadores[jugadoractual]:
#             jugadores[jugadoractual].append(objeto)
#     i+=1
#     turnos+=1
# for jugador, inventario in jugadores.items():
#     if len(inventario)==3:
#         print("Ganador:",jugador,"\n turnos:",turnos)
#         print("estado de ambos inventattios:", inventario)
#     else:
#         print("perdedor:",jugador,"\n turnos:",turnos)
#         print("estado de ambos inventattios:", inventario)

#########################################################################

# d_categorias = {       
#   "Ping pong":"Juego salon",  
#   "Scooter electrico":"Vehiculos",  
#   "Futbolin":"Juego salon",  
#   "Barbie Cantante":"Muñecas",  
#   "Barbie oficinista":"Muñecas" 
# }  
  
# d_precios = {   
#  "Ping pong":230,  
#  "Scooter electrico":300,  
#  "Futbolin":70,  
#  "Barbie Cantante":29,  
#  "Barbie oficinista":30}

# # Implemente las siguientes funciones:  
# # 1. menos_caro(d_categorias, d_precios, categoria) que recibe los diccionarios de categorías y 
# # precios, y un string con el nombre de una categoría válida. La función retorna dos valores: el nombre 
# # del artículo más barato en esa categoría y su precio. 

# def menos_caro(d_categorias,d_precios,categoria):
#     ln=[]
#     lp=[]
#     for articulo,category in d_categorias.items():
#         if  category==categoria:
#             lp.append(d_precios [articulo])
#             ln.append(articulo)
#     precio=min(lp)
#     nombre=ln[lp.index(precio)]
#     return nombre,precio

# print(menos_caro(d_categorias,d_precios ,"Muñecas"))


# 2) total_por_categoria(d_categorias, d_precios, ListaCompras) que recibe los diccionarios 
# de categorías y precios, y una lista de strings con nombres de artículos comprados por el usuario. La 
# función retorna un diccionario que indica cuánto ha gastado el usuario en cada categoría de los 
# artículos en la lista. Por ejemplo:  
  
# total_por_categoria(d_categorias, d_precios,   
#                     ["Barbie oficinista","Ping pong","Futbolin", "Barbie cantante"])  
  
# devuelve  
# {"Juego salon":300, "Muñecas":59} 



# def total_por_categoria(d_categorias,d_precios,listaCompras):
#     d={}
#     for producto in listaCompras:
#         categoria=d_categorias[producto]
#         precio=d_precios[producto]
#         if categoria not in d:
#             d[categoria]=0
        
#         d[categoria]+=precio

#     return d
        

# print(total_por_categoria(d_categorias, d_precios,   
#                     ["Barbie oficinista","Ping pong","Futbolin", "Barbie Cantante"]))



# 3) Pida al usuario que ingrese varias productos a comprar. El usuario podrá ingresar cuántas productos 
# desee, pero una a la vez (debe validar que el producto exista en el diccionario); para terminar de 
# ingresar los productos debe escribir la palabra "end". El programa debe presentar loa valores del 
# total por cada categoria que el usuario acaba de comprar separado por coma y en la primera linea la 
# palabra total a pagar : valor. Ejemplo 
 
# total a pagar : 359 
# Juego salon,300 
# Muñecas,59

# productos= input("ingrese productos:")
# l=[]
# while productos not in d_categorias.keys():
#     print("escriba nuevamente")
#     productos= input("ingrese productos: ")

# while productos!="end":
#     l.append(productos)
#     productos= input("ingrese productos: ")

# d=total_por_categoria(d_categorias,d_precios,l)

# total=0

# for catego, precio in d.items():
#     total+=float(precio)
#     print(catego,";",precio)
# print("total:",total)

########################################################


# Crea un función que pueda determinar si un número entero positivo es feliz o no.
# Un número feliz es un número definido por el siguiente proceso:
#    1. Comienza con cualquier número entero positivo.
#    2. Sustituye el número por la suma de los cuadrados de sus dígitos.
#    3. Repite el proceso hasta que:
#       •  Llegues a 1 (en cuyo caso el número es feliz), o
#       •  Entras en un ciclo que no contiene el 1 (el número no es feliz).
# Por ejemplo:
#    •  19 → 1² + 9² = 82 → 8² + 2² = 68 → 6² + 8² = 100 → 1² + 0² + 0² = 1 → ✅ Feliz.
#    •  4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 → 🔁 Ciclo → No feliz

# def numeroFeliz(numero):
#     l=[]
#     wordnumber=str(numero)
#     estado=""
#     while wordnumber!=1 and wordnumber not in l:
#         if wordnumber not in l:
#             l.append(wordnumber)
#         x=0
        
#         for n in wordnumber:
#             x+=int(n)**2
        
#         wordnumber=str(x)
    
#     if int(wordnumber)==1:
#         estado+="feliz"
#     else:
#         estado+="triste"
#     return estado
    

# print(numeroFeliz(4))

#######################################################
