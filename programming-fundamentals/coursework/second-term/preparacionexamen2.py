# Ayudantía 1


# teoria

import numpy as np
import pandas as pd

# #Series

# con diccionario
# las claves seran los indices y los vavlores los datos
# d= {'a':1, 'b':2, 'c':3}
# serie= pd.Series(d)
# print(serie)


# #con vectores
# vector=np.array([1,3,4,3,4,5])
# serie= pd.Series(vector)
# print(serie)


# #con lista
# lista=[1,2,3,4,5]
# serie1=pd.Series(lista, index=['a','b','c','d','e'], name='Serie 1', dtype=float)
# serie1["z"]= serie1.sum()
# print(serie1) #agrega un nuevo elemento a la serie


# DataFrame

# diccionario de 'listas'
# claves seran los numbres de las columnas
# valores seran los datos de las columnas
# d={'col1':[1,2,3], 'col2':[4,5,6]}
# df=pd.DataFrame(d, index=['a','b','c'], columns=['col1','col2'], dtype=float)
# print(df)

# dff=pd.read_csv("pizza.csv", index_col=0)
# # Select only float columns from dff
# float_columns = dff.select_dtypes(include=float, exclude=object).columns
# dff_floats = dff[float_columns]

# dff= dff[dff["id"].isnull()] #elimina filas con id nulo
# print(dff)


# is null  devuelve un dataframe booleano con True en las posiciones donde hay NaN
# y False en las posiciones donde no hay NaN

# canti=dff.isnull().values.sum() #cuantos nulos hay en todo el dataframe
# print(canti)
# #cuabtos nulos hay en cada  columna y fila
# print(dff.isnull().sum(axis=0)) #columnas
# print(dff.isnull().sum(axis=1)) #filas
# #elimina filas o columnas con nulos
# dff2=dff.dropna(axis=0) #elimina filas con nulos
# dff3=dff.dropna(axis=1) #elimina columnas con nulos


# not null  devuelve un dataframe booleano con True en las posiciones donde no hay NaN
# df=dff.notnull()
# print(df)


# excel ]
# sheert_name
# io


# sort_values
# ordena de menor a mayor si pongo ascending=true
# ordena de mayor a menor si pongo ascending=false


# Ejercicio 1
# Implemente la función consolidar_calificaciones(dict_parcial, dict_final) que recibe dos diccionarios con las calificaciones de un curso.
# El primer diccionario (dict_parcial) contiene las notas del examen parcial y el segundo (dict_final) las del examen final.
# La función debe retornar un nuevo diccionario llamado consolidado donde las claves son los nombres de los estudiantes
# y los valores son una lista con la siguiente estructura: [nota_parcial, nota_final, promedio].

# Reglas:
# 1. Si un estudiante aparece en ambos diccionarios, su lista debe contener ambas notas y su promedio.
# 2. Si un estudiante solo aparece en dict_parcial, su nota final debe ser registrada como 0.
# 3. Si un estudiante solo aparece en dict_final, su nota parcial debe ser registrada como 0.
# 4. El promedio debe ser calculado como (nota_parcial + nota_final) / 2.

# Ejemplo:
# parcial = {"Ana": 85, "Luis": 91, "Marta": 76}
# final = {"Ana": 95, "Luis": 88, "Pedro": 92}

# consolidado = consolidar_calificaciones(parcial, final)
# print(consolidado)

# Salida Esperada:
# {'Ana': [85, 95, 90.0], 'Luis': [91, 88, 89.5], 'Marta': [76, 0, 38.0], 'Pedro': [0, 92, 46.0]}
