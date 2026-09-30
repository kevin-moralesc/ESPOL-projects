#nombre= input("Ingresa tu nombre: ")
#Edad= input("Ingresa tu edad: ")
#Edad= int(Edad)
#nombre= str(nombre)
#estatura_en_metros= input("ingrese su estatura:")
#estatura_en_metros=float(estatura_en_metros)
#peso= input("ingrese su peso:")
#peso= float(peso)
#pregunta1= input("¿realiza actividad fisica al menos 3 veces por semana?(si/no): ")
#pregunta1= pregunta1=="si"
#pregunta2=input("duerme al menos  7 horas por dia (si/no):")
#pregunta2=pregunta2=='si'
#pregunta3=input("fuma regularmente? (si/no):")
#pregunta3=pregunta3=='si'
#pregunta4=input("consume frutas y verduras a diario? (si/no):")
#pregunta4=pregunta4=='si'
#IMC=(peso)/(estatura_en_metros**2)

#requisito1=Edad>=18
#requisito2=100-Edad
#requisito3= 1.50<estatura_en_metros<2.00
#flaco= IMC<18.5
#gordo= IMC>25
#normal= 18.5< IMC < 24.9
#condicion1 = requisito1 and requisito2 and requisito3 and (flaco or normal or gordo)
#condi= pregunta1+pregunta2+pregunta3+pregunta4+requisito3+normal
#perfil= (condi==5 and 'optimo y saludable') or (condi==4 and 'saludable') or (condi==3 and 'en riesgo') or (condi==2 and 'riesgo')or (condi==1 and 'critico')
#print(perfil)






#CORREGIDO

#
#
# nombre= input("Introduce el nombre: ")
# edad= int(input("Introduce el edad: "))
# estaturaEnMetros= float(input("Introduce el estatura en metros: "))
# pesoEnKilo= float(input("Introduce el peso en kilo: "))
#
# pregunta1=input("¿Realiza actividad física al menos 3 veces por semana? (sí/no):")
# cond1= pregunta1 == "sí"
# pregunta2=input("¿Duerme al menos 7 horas por día? (sí/no):")
# cond2= pregunta2 == "sí"
# pregunta3=input("¿Fuma regularmente? (sí/no):")
# cond3= pregunta3 == "no"
# pregunta4=input("¿Consume frutas y verduras a diario? (sí/no):")
# cond4= pregunta4 == "sí"
#
# imc= pesoEnKilo/(estaturaEnMetros**2)
# imc= float(imc)
# mayoredad= edad>18
# anosrestantes= 100-edad
# condiestatura= 1.50 <estaturaEnMetros <2.00
# bajopeso= imc<18.5
# sobrepeso= imc>25
# condimc= imc >= 18.5 and imc <= 24.9
# print(imc)
#
# sumarequisito= cond1+cond2+cond3+cond4+mayoredad+condiestatura+bajopeso+sobrepeso+condimc
# print(sumarequisito)
# if sumarequisito == 5:
#     print("Su perfil es optimo y saludable")
# if sumarequisito == 4:
#     print("Su perfil es saludable")
# if sumarequisito == 2 or sumarequisito== 3:
#     print("Su perfil esta en riesgo")
# if sumarequisito == 1:
#     print("Su perfil es critico")
#
#
# print("anosrestantes", anosrestantes)