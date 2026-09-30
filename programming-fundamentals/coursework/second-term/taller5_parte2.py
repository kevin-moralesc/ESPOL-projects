#Usando el dataset de importaciones_exportaciones.csv
# Presentar por cada año que producto se exportó menos.
# usandp el campo (CE_EXP_VALOR), no tomar encuenta los 
# valores con 0 de exportación

import pandas as pd

# df = pd.read_csv("importaciones_exportaciones.csv", sep=";")
# print(df.head())

# # Nos aseguramos de que los nombres de las columnas estén en mayúsculas y sin espacios
# df = df[["CE_ANIO", "CE_PRODUCTO", "CE_EXP_VALOR"]]

# # Convertimos a numérico el campo de valor de exportación
# df["CE_EXP_VALOR"] = pd.to_numeric(df["CE_EXP_VALOR"], errors='coerce')

# # Filtramos para no considerar valores de exportación 0 o nulos
# df = df[df["CE_EXP_VALOR"] > 0]

# # Agrupamos por año y producto, sumando los valores de exportación
# df_grouped = df.groupby(["CE_ANIO", "CE_PRODUCTO"], as_index=False)["CE_EXP_VALOR"].sum()

# # Por cada año, obtenemos el producto con menor valor de exportación
# result = df_grouped.loc[df_grouped.groupby("CE_ANIO")["CE_EXP_VALOR"].idxmin()]

# print(result)




import pandas as pd
import numpy as np

# 1. Cargar el archivo y seleccionar columnas
df = pd.read_csv("importaciones_exportaciones.csv", sep=";")
df = df[["CE_ANIO", "CE_PRODUCTO", "CE_EXP_VALOR"]]

# 2. Limpiar y convertir la columna de valor
# Reemplazamos la coma por un punto.
df["CE_EXP_VALOR"] = df["CE_EXP_VALOR"].str.replace(",", ".")
# Reemplazamos los espacios en blanco
df["CE_EXP_VALOR"] = df["CE_EXP_VALOR"].str.strip()
# Ahora, intentamos convertir a numérico.
# Si la conversión falla, la fila se vuelve NaN.
# df["CE_EXP_VALOR"] = pd.to_numeric(df["CE_EXP_VALOR"], errors='coerce')

# # 3. Eliminar filas con valores NaN (Not a Number) y valores 0
# df = df[df["CE_EXP_VALOR"] > 0]

# # 4. Agrupar y sumar los valores
# df_grouped = df.groupby(["CE_ANIO", "CE_PRODUCTO"])["CE_EXP_VALOR"].sum().reset_index()

# # 5. Encontrar el producto con menor valor de exportación en cada año
# result = df_grouped.loc[df_grouped.groupby("CE_ANIO")["CE_EXP_VALOR"].idxmin()]

# print(result)

print(df)