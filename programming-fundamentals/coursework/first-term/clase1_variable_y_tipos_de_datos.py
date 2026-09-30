# estatura = 1.75 # flotante (float)
# cant_estudiantes = 35 # enteros (int)
# nombre = "Carlos" # cadena de caracteres - string (str)
# es_mayor_edad = True # valor de verdad (bool) booleano
#
# nombreCompleto = "Frank Malo"
#
# estudiante1 = "frank"
# estudiante2 = "juan"
# estudiante3 = "maría"

# nombres lógicos
# no iniciar con numeros
# no caractreres especiales solo _

# definimos las variales
# variable = valor | resultado funcion | operacion

# 67 = calificacion #incorrecto

# otras formas
# año_actual = 2025
# nombre, edad, estatura = "frank", año_actual - 1986, 1.75

#cal_fp, cal_bd = 80, 78
#cal_fp, cal_bd = cal_bd , cal_fp

# cal_fp2 = cal_bd
# cal_bd2 = cal_fp
# cal_fp, cal_bd = cal_fp2, cal_bd2

# año_actual = 2025
# año_nacimiento = "1986"


#r = 17 // 3 # r tendria el valor de 5
#r = 17 % 3 # r tendria el valor de 2

# segundos_totales = 3665
# horas = segundos_totales // 3600
# minutos = (segundos_totales % 3600) // 60
# segundos = segundos_totales % 60
# print(horas, minutos, segundos)


# x = (34 + 15) / 5
# print(x)

# linea = 80 # almacenado en nuestro cerebro
# bus = 70 # dato que tomo con los ojos
# es_bus = bus == linea
#
# # script de si tengo suficiente dinero para el pasaje
# costo_pasaje = 0.30
# dinero = 0.75
# tengo_dinero = dinero >= costo_pasaje
#
# puedo_viajar = es_bus and tengo_dinero

# si tu compra tiene más de 3 unidades o supera 50 dolares tienes 5% de descuento
# unidades_compradas = 8
# precio_unitario = 8.9
# venta = precio_unitario * unidades_compradas
# tiene_descuento = unidades_compradas > 3 or venta > 50



# linea = 80 # almacenado en nuestro cerebro
# bus = 70 # dato que tomo con los ojos
# costo_pasaje = 0.30
# dinero = 0.75
# conductor_familia = True
#
# puedo_viajar = (linea == bus and dinero >= costo_pasaje) or conductor_familia


# zoo, niños (desde los 5 años hacia abajo) no pagan,
# adultos mayores pagan 50%, los demas pagan completo
# edad = 18
# costo = 5
# es_niño = edad <= 5
# es_adulto_mayor = edad >= 65
# # paga_completo = edad > 5 and edad < 65
# paga_completo = 5 < edad < 65

# print(paga_completo)

# input # funcion que devuelve a una variable
# lo que el usuario escribe por teclado
# nombre = input("Ingrese su nombre por favor: ")
# print("Hola, ", nombre)





# linea = 80 # almacenado en nuestro cerebro
# bus = input("Ingrese el nuemero del vehículo: ") # SIEMPRE DEVUELVE STR
# bus = int(bus)
# es_bus = bus == linea
# print(es_bus)

# para convertir a entero int(dato)
# para convertir a float float(dato)
# para convertir a string/ texto str(dato)

# # ingrese dos calificaciones y genere su promedio, sumas y division
# cal_1 = input("Ingrese cal 1: ")
# cal_2 = input("Ingrese cal 2: ")
# promedio = (float(cal_1) + float(cal_2)) / 2
# aprobo = promedio >= 60
# print(promedio, aprobo)


# investigar funcion format y formateo de strings, caracteres de escape


print(2*2)