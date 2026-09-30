import pandas as pd



df=pd.read_csv("pizza.csv")
#mostrar las columnas
# df=df.loc[:6,"id":"time"]  #se
print(df.head(8))
#print(df.loc[:,["date", "time"] ])
#dfcolumnas= df.columns
#print(dfcolumnas)


#mostras las primeros 10 filas
# df=df.iloc[:11,:]
# print(df)

#print(df.head(10))  #es otra opcion


#mostrar los tipos de datos
# print(df.dtypes)
# print(df.info())


#mostrar las 3 pizzas que más venden
# df=df[["name", "id"]]
# df=df.groupby("name").count()
# df=df.sort_values("id")

# df=df.iloc[::-1,:]
# print(df)
# print(df.head(3))



#pizza q mas se vende sin usar sort_values
# df=df[["name", "id"]]
# df=df.groupby("name").count()
# condicion=df["id"]==df["id"].max()
# df=df[condicion]
# print(df)





#pizza q mas dinero ingrese
# df=df[["name", "price"]]
# df=df.groupby("name").sum()
# condicion=df["price"]==df["price"].max()
# df=df[condicion]
# print(df)

#la pizza q mas se vende pero el mes de mayo
condicion= df["date"].str[5:7]=="05"
df=df[condicion]
# print(df.head())
df=df[["name", "id"]]
df=df.groupby("name").count()
df=df.sort_values("id")
df=df.iloc[::-1,:]
print(df.head())

#agregar una columna con el calculo del iva al df
