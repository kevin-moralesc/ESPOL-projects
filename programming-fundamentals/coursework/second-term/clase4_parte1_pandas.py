import pandas as pd

#Series ( muy parecido a un vector, o a una lista)    (columna)
# se crea a partir de cualquier estructura unidimensional listas,vectores
m=[34,78,45,32,77]
lindices=["frank", "kevin", "javier", "cindi", "loki"]
s= pd.Series(m)# podem
s[2]+=10  #elementos de la serie por su indice
# s["javier"]+=10

print(s)
#Dataframes (muy parecidos a una hoja en excel)
#se crea a partir de diccionarios
# y leyendo archivos CSV Y XLS, XLSX


# dtalleres={
#     "frank":[45,67,21,77],
#     "kevin":[44,55,0,47],
#     "loki": [90,87,45,88],
#     "Maria": [66,45,11,69]

# }  

# dfx=pd.DataFrame(dtalleres, index=["cal1","cal2","cal3","cal4"],dtype=float)

#fila horizintal es etiquetas labels
#columnas vertical es indices

# df= pd.read_csv("fortunaxd.csv")
# print(df)
# seleccionar columnas

#print(df.head()) # imprimir los primeros datos head()

#dfprofit=df["Profit (in millions)"]

#print(dfprofit) # columna de un data frame no es mas q una serie
#print(df)



#seleccionar 2 o ma scolumnas

#dfaño= df[["Year", "Profit (in millions)"]]




#crear columnas
#df["impuesto"]=df["Profit (in millions)"] *0.1

#print(df)


# ver la informacion del dataframe
#print(df.info()) #  info() ver la informacion del dataframe


# df["años transcurridos"]=2025-df["Year"]
#print(df)


# para conocer todas las colmnas

#print(df.columns)



