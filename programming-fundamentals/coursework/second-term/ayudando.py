
# Usted cuenta con la variable 'mensaje' la cual contiene una cadena de caracteres con un mensaje cifrado.
# mensaje = ';3;ajduat|q17!9k.crEcn te-u?Q1'

# Para poder revelar su contenido deberá seguir los siguientes pasos:
# * Cree una nueva cadena quedándose únicamente con los últimos 17 caracteres.
# * En la nueva cadena inserte la palabra 'zaz' en el índice 5.
# * Usando la cadena del paso anterior, obtenga los caracteres en índice par.
# * Finalmente, invierta la cadena obtenida y muestre por pantalla el mensaje.

mensaje = ";3;ajduat|q17!9k.crEcn te-u?Q1"
nuevo = mensaje[-17:]
lnuevo = list(nuevo)
lnuevo.insert(5, "zaz")
nuevo = "".join(lnuevo)
nuevo = nuevo[2::2][::-1]
print(nuevo)