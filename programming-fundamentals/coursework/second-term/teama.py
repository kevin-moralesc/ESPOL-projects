import pandas as pd
import matplotlib.pyplot as plt
df = pd.DataFrame({"Nombre":["Ana","Luis","Carla"],"Edad":[1000,25,23]})
df["Edad"].plot(kind="bar", color="skyblue", title="Edades"); plt.show()

print(df)