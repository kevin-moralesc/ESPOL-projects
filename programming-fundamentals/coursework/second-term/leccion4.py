import pandas as pd
df=pd.read_csv("pizza.csv")

df=df[["name","type","price"]]

dftotal=df.groupby(["name", "type"]).sum()

dfcantidad= df.groupby(["name", "type"]).count()

print(dftotal)
print("##########################")
print(dfcantidad)












