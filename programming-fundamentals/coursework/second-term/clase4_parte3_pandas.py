import pandas as pd

df = pd.read_csv("titanic.csv")
print(df)
print(df.columns)

# por sexo contar cuantas personas sobrevivieron

df = df[["Sex", "Survived", "PassengerId"]]
df["Survived"] = df["Survived"].mask(df["Survived"] == 0, "No")
df["Survived"] = df["Survived"].mask(df["Survived"] == 1, "Si")
df = df.groupby(["Sex", "Survived"]).count()

print(df)

#df.to_excel("sobrevivieron.xlsx")

# hace q se haga documento en excel o el q ponga







