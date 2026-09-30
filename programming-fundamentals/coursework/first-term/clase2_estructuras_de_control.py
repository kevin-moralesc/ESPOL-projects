
#nombre = 'Frank'
#apellido = "Malo"
#parrafo = """esto es una clase de fundamenteos de programación"""


# operadores   +   *
# str + str # unir los dos string (concatenar)
# nombre = "Frank"
# apellido = "malo"
# nombre_completo = nombre + " " + apellido
# print(nombre_completo)

# str * 10 # repite 10 veces el string
# secuencia = "10\n" * 5
# print(secuencia)


# partir un string
# contar un string
# verificar si tien un prefijo o un sufijo
# formatear un string
# contar un string dentro de otro string

# frase = input("Ingrese una palabra: ")
# frase =  frase.upper()
# print(frase)


#frase = "la clase dé python del lunes es en el aula de  FIEC vieja"
#cantidad = frase.count("de") + frase.count("dé")
#print("canti",cantidad)



# nombre = "Frank"
# pos=nombre.find('a')
# print(pos)


#universidad = "escuela superior politécnica del litoral"
#indice = input("ingrese el indice: ")
#indice = int(indice)
#letra = universidad[indice]
#print(letra)


# universidad = "escuela superior politécnica del litoral"
# palabra1 =  universidad[: universidad.find(" ")]

#nombre = "Frank"
#slice = nombre[2: ]
#print(slice)


# direccion = "www.yahoo.pe"
# pais = direccion[ -2 :  ]
# es_ecuador = pais == 'ec'
# print(es_ecuador)

# palabra = "fundamentos"
# sub = palabra[-5:-2]
# sub = palabra[3:-2]
# print(sub)

# palabra = "fundamentos"
# sub = palabra[-2 : 3]
# \print(sub)



# s = str[a:b] b es exvluido
# s = str[: b] la posicion inicial es 0 b es excluido
# s = str[a : ] la posicion final es final del str
# s = str[-a : -b ]
# s = str[ : -b ]
# s = str[ a : -b ]


# s = str[ a : b : s] # s (step), cantidad de saltos,
                      # y el sentido de la lectura

# palabra = "fundamentos"
# inv = palabra[ : : -1]
# print(inv)
# sub = palabra[9 : 1 : -2]
# print(sub)

# 'Spotify-55MB', 'Spotify-112MB', 'Whatsapp-12MB',
# detalle = "instagram-1162MB"
# pos = detalle.find("-")
# app = detalle[ : pos]
# consumo= int(detalle[pos + 1 : -2 ])
# print(app)
# print(consumo)


#palindromo
# palabra = 'Se van sus naves'
# inv = palabra[ : :-1].lower().replace(" ", "")
# palabra = palabra.lower().replace(" ", "")
# es_palindromo = palabra ==inv
# print(es_palindromo)

# y = palabra[ : :-1].count("x").lower() # error


# palabra = input("Ingrese una palabra: ")
# mitad1 = palabra[ : len(palabra) // 2]
# mitad2 = palabra[ len(palabra) // 2 : ]
# print(mitad1)
# print(mitad2)

# Implemente un programa en Python que muestre todas las secuencias .
# 1. Forme la cadena inversa ( INV ) de la secuencia S .
# 2. Si la cadena R aparece exactamente dos veces en la segunda mitad de INV
# y al menos 3 veces en total de INV, la
# secuencia S pertenece a la especie buscada.

# S = 'ATTTGCTTGCTATTTAAACCGGTTATGCATAGCGC' # muestra de algun animal
# R = 'CG'
# INV = S[ : :-1]
# segunda_mitad = INV [ len(INV) // 2 :  ]
# pertenece = segunda_mitad.count(R) ==  2 and INV.count(R) >= 3
# print(pertenece)



#palabra = input("Ingrese una palabra: ")
#mitad1 = palabra[ : len(palabra) // 2 ][::-1]
#mitad2 = palabra[ len(palabra) // 2 : ][::-1]
#mitad1 = mitad1.replace('a', '@').replace('e', '3').replace('i', '!').replace('o', '0').replace('u', '^').lower()
#mitad2 = mitad2.replace('a', '@').replace('e', '3').replace('i', '!').replace('o', '0').replace('u', '^').upper()
#encriptada = "##" + mitad1 + mitad2 + "!!"
#print(encriptada)
