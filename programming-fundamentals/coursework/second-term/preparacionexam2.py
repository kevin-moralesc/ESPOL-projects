import pandas as pd


# # Crea un programa que pida al usuario una contraseña hasta que esta cumpla 
# # todos estos requisitos:
# # • Al menos 8 caracteres
# # • Al menos una letra mayúscula
# # • Al menos un número



# contraseña = input("Ingrese una contraseña: ")
# condicion1= len(contraseña)<8
# condicion2=""
# condicion3=""

# for n in contraseña:
#     if n.isupper()==True:
#         condicion2=True
#     condicion2=False
        
#     if n.isdigit()==True:
#         condicion3=True
#     condicion3=False




# while condicion1 or condicion2 or  condicion3: 
#     print(" Contraseña inválida, intente de nuevo")
#     contraseña = input("Ingrese una contraseña: ")

# print(" Contraseña válida")    









# Simula un cajero automático:
# El usuario inicia con un saldo de $500.
# • Puede elegir Depositar, Retirar, o Salir.
# • Cada acción se realiza dentro de un bucle while.
# • No puede retirar más de su saldo

# print("bienvenido al banco kevin uwu")
# saldo=500
# cajero=""
# while saldo>0 and cajero.lower()!="salir":
#     if cajero.lower()=="depositar":
#         cajero= input("Cuanto desea depositar?:")
#         saldo+=int(cajero)
#     if cajero.lower()=="retirar":
#         cajero=input("cuanto desea retirar?:")
#         saldo-=int(cajero)
#     if saldo>0:     
#         print("saldo Actualmente:", saldo)
#         cajero= input("desea depositar,retirar, o salir?:")
#     else: cajero="salir"    


# if saldo<=0:
#     print("su saldo es 0")

# print("vuelva pronto")




# import matplotlib as plt

# l_vehiculos = [
# 'GKL-4522|Camioneta|Azul|123487 KM',
# 'GKX-4522|Bus|Blanco|183513 KM']
# ingrese= input("placa:")
# for info in l_vehiculos:
#     placa,tipovehiculo,color,kilometraje= info.split("|")
#     i=0
#     while ingrese!=placa and i==0:
#         if ingrese==placa:
#             i+=1
#         ingrese= input(" ingrese placa:")

    
#     print(tipovehiculo,",",color, ",", kilometraje) 








# Crear un DataFrame de números del 1 al 10
df = pd.DataFrame({'numeros': list(range(1, 11))})
# Crear un DataFrame con varias columnas: alumnos, calificaciones, talleres y lecciones
df = pd.DataFrame({
    'alumnos': ['Ana', 'Luis', 'Pedro', 'Sofía', 'Juan', 'María', 'Carlos', 'Lucía', 'Miguel', 'Elena'],
    'Examen': [85, 90, 78, 92, 88, 95, 80, 87, 91, 89],
    'talleres': [3, 4, 2, 5, 3, 4, 2, 3, 5, 4],
    'lecciones': [10, 3, 8, 10, 9, 10, 8, 9, 10, 9],
    'apoyo_social_economico': ['padres', 'beca', 'propio', 'padres', 'beca', 'propio', 'padres', 'beca', 'propio', 'padres']
})
filtro= df["lecciones"]<=5
df=df[filtro]
df=df.loc[filtro,"alumnos"]
print(df)


# df=df.groupby("apoyo_social_economico").agg(taller=("talleres","sum"),leccion=("lecciones","mean"))


