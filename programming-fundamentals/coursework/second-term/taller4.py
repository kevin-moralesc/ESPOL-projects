# Asuma que tiene los siguientes diccionarios donde las claves son nombres de artículos de una tienda y
# los valores corresponden a sus categorías, precios y características:


d_categorias = {
    "Ping pong": "Juego salon",
    "Scooter electrico": "Vehiculos",
    "Futbolin": "Juego salon",
    "Barbie Cantante": "Muñecas",
    "Barbie oficinista": "Muñecas"
}

d_precios = {
    "Ping pong": 230,
    "Scooter electrico": 300,
    "Futbolin": 70,
    "Barbie Cantante": 29,
    "Barbie oficinista": 30}


# Implemente las siguientes funciones:
# 1.) menos_caro(d_categorias, d_precios, categoria) que recibe los diccionarios de categorías y
# precios, y un string con el nombre de una categoría válida. La función retorna dos valores: el nombre
# del artículo más barato en esa categoría y su precio.

# 1

# def menos_caro(d_precios, d_categorias, categoria):
#     nombre=""
#     l=[]
#     for articulo, category in d_categorias.items():
#         if category == categoria:
#             l.append(d_precios[articulo])
#     masbarato = min(l)
#     for articulo, precio in d_precios.items():
#         if precio == masbarato:
#             nombre+=articulo
#     return nombre, masbarato

# print(menos_caro(d_precios, d_categorias, "Muñecas"))

# 2) total_por_categoria(d_categorias, d_precios, ListaCompras) que recibe los diccionarios
# de categorías y precios, y una lista de strings con nombres de artículos comprados por el usuario. La
# función retorna un diccionario que indica cuánto ha gastado el usuario en cada categoría de los
# artículos en la lista. Por ejemplo:

# total_por_categoria(d_categorias, d_precios,["Barbie oficinista","Ping pong","Futbolin", "Barbie cantante"])
# devuelve
# {"Juego salon":300, "Muñecas":59}


# 2
def total_por_categoria(d_categorias, d_precios, listasCompras):
    d={}
    for producto in listasCompras:
        categoria= d_categorias[producto]
        if categoria not in d:
            d[categoria]=0

        d[categoria]+=d_precios[producto]
    return d

print(total_por_categoria(d_categorias, d_precios,["Barbie oficinista","Ping pong","Futbolin", "Barbie Cantante"]))
# Luego, en su programa principal use las funciones previamente implementadas donde aplique para
# desarrollar lo siguiente:

# 3) Pida al usuario que ingrese varias productos a comprar. El usuario podrá ingresar cuántas productos
# desee, pero una a la vez (debe validar que el producto exista en el diccionario); para terminar de
# ingresar los productos debe escribir la palabra "end". El programa debe presentar loa valores del
# total por cada categoria que el usuario acaba de comprar separado por coma y en la primera linea la
# palabra total a pagar : valor. Ejemplo

# total a pagar : 359
# Juego salon,300
# Muñecas,59


# 3

# productos = input("Ingrese el producto que desee (o 'end' para terminar): ")
# l = []

# while productos != "end":
#     if productos not in d_categorias:
#         print("El producto no existe, ingrese nuevamente.")
#     else:
#         l.append(productos)
#     productos = input("Ingrese el producto que desee (o 'end' para terminar): ")

# d = total_por_caregoria(d_categorias, d_precios, l)
# total = sum(d.values())
# print("Total:", total)
# for categoria, valores in d.items():
#     print(categoria, ":", valores)
