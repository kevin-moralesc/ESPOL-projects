#datos = "Ana:25:Python;Luis:30:JavaScript;María:28:Java;Carlos:35:Python;Lucía:29:C++"
#seperad1= datos.split(";")
#lelemntos=[]
#for n in seperad1:
#    lelemntos= lelemntos+(n.split(":"))

#nombre= lelemntos [::3]
#edad= lelemntos [1::3]
#lenguaje= lelemntos [2::3]


#element=[]
#for hola in lenguaje:
#    x = hola.replace('Java','Kotlin').replace('KotlinScript','JavaScript')
#    element.append(x)


#cadena_nombre= ','.join(nombre)

#favpy= lenguaje.count("Python")


##################################

#posnom3= lelemntos.index("María")
#nombre3= lelemntos[posnom3:posnom3+1]
#edad3= lelemntos[posnom3+1:posnom3+2]
#lenguaje3= lelemntos[posnom3+3:posnom3+4]
#print(edad3,lenguaje3)



#COREGIDO
#
# datos = "Ana:25:Python;Luis:30:JavaScript;María:28:Java;Carlos:35:Python;Lucía:29:C++"
# elementos=datos.split(";")
# lelementos=[]
#
# for letra in elementos:
#     lelementos= lelementos+ letra.split(":")

#obtener sublistas por slicing


#
# lnombres= lelementos[ : : 3]
# ledades=lelementos[1: :3]
# llenguajes= lelementos[2::3]

#Reemplazar un lenguaje en la lista original
#
# copialengua= llenguajes.copy()
# lelementos_modificados= []
# for letra in copialengua:
#     y=letra.replace("Java","Kotlin").replace("KotlinScript","JavaScript")
#     lelementos_modificados.append(y)

#Unir los nombres en un solo string separado por comas
# stringnombres= ",".join(lnombres)
#
# #Contar cuántos usan "Python" como lenguaje favorito
#
# python_lenguaje= llenguajes.count("Python")
#

#Obtener los datos del tercer desarrollador
#Usando indexamiento y slicing sobre elementos, guarda en variables:

# print(lelementos)
# pos= lelementos.index("María")
#
# nombre3=lelementos[pos]
# edad3= lelementos[pos+1]
# lenguaje3= lelementos[pos+2]
# print(nombre3)
# print(edad3)
# print(lenguaje3)
#
#
#
#









