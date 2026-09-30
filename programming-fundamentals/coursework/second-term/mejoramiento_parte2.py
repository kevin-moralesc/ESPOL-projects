import pandas  as pd

df=pd.read_csv("datos_estudiantiles.csv")
print(df.columns)
#muestra las 8 primeras filas
print(df.head(8))


#ccual es la cantidad de observaciones

# print(len(df))

#muestre las estadisticas generales de este conjunto de datos

# print(df.describe())



# promedio general de horas_estudio_semanales de todos los estudiantes

# print(df["horas_estudio_semanales"].mean())

#cual fue el maximo porcentaje de sistencia registrado


# maximo=df["porcentaje_asistencia"].max()
# print(maximo)

#cuantos estudiantes tienen una cantidad de horas_sueno_promedio de al menos 6 horas


# filtro= df["horas_sueno_promedio"]>=6
# canti=filtro.sum()
# print(cantidad)


#####################


#cuantos estudiantes tienen problemas en sus calificaciones promedio_semestre  no mas de 6


# filtro= df["promedio_semestre"]<=6
# cantidad=filtro.sum()
# print(cantidad)




##cual es el promedio de calificaciones de los estuiantes con una cantidad de horas de sueño menor a 6
# df=df[["horas_sueno_promedio","promedio_semestre"]]
# filtro=df["horas_sueno_promedio"]<6
# df=df[filtro]
# df=df["promedio_semestre"].mean()
# print(df)



#cuanatos estudoiantes trabajan mas de 15 horas semanales y tiene un promedio superior a 8

# filtro=(df["horas_trabajo_semanales"]>15) & (df["promedio_semestre"]>8 )
# cantidad=filtro.sum()
# print(cantidad)


#muestra solo el nombre y el promedio_semestre de los estudiantes que tiene indice sociecomonio mayo a 4

df=df[["nivel_socioeconomico","nombre","promedio_semestre"]]
condi=df["nivel_socioeconomico"]>4
df=df[condi]
df=df[["nombre","promedio_semestre"]]
print(df)