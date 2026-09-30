#Usando el dataset de titanic.csv encontrar cual fue la clase donde hubo más sobrevivientes

import pandas as pd


df = pd.read_csv("titanic.csv")

df=df[["Pclass", "Survived", "PassengerId"]]
# df= df.groupby(["Pclass", "Survived"]).count()
# df=df.iloc[1::2,:]
# condicion= df["PassengerId"]==df["PassengerId"].max()
# df=df[condicion]
# print(df)



#corregido


# df=df.groupby("Pclass").sum()["Survived"]
# df=df.sort_values(ascending=False)
# df=df.head(1)

# print(df)
