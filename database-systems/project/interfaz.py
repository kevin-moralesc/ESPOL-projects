import tkinter as tk
from tkinter import ttk, messagebox
from PIL import Image, ImageTk
from crud_cliente import crear_cliente, obtener_clientes, actualizar_cliente, eliminar_cliente
# VENTANA PRINCIPAL
ventana = tk.Tk()
ventana.title("TimeSkill - Gestión de Clientes")
#version python
# ventana.state("zoomed")

#forma de linux
#try:
#    ventana.attributes('-zoomed', True)
#except:
#    ventana.state("zoomed")


#forma practica
if ventana.tk.call('tk', 'windowingsystem') == 'x11':
    ventana.attributes('-zoomed', True)  # Para Ubuntu/SLinux
else:
    ventana.state('zoomed')               # Para Windows


color_fondo = "#a7cff4"
ventana.configure(bg=color_fondo)

# VARIABLES
vars_cliente = {
    "id": tk.StringVar(),
    "nombre": tk.StringVar(),
    "apellido": tk.StringVar(),
    "correo": tk.StringVar(),
    "ciudad": tk.StringVar()
}

# FUNCIONES
def limpiar_campos():
    for var in vars_cliente.values():
        var.set("")
    tabla.selection_remove(tabla.selection())

def cargar_tabla():
    tabla.delete(*tabla.get_children())
    for cliente in obtener_clientes():
        tabla.insert("", tk.END, values=cliente)
    limpiar_campos()

def seleccionar_fila(event):
    item = tabla.focus()
    if not item:
        return

    datos = tabla.item(item, "values")
    vars_cliente["id"].set(datos[0])
    vars_cliente["nombre"].set(datos[1])
    vars_cliente["apellido"].set(datos[2])
    vars_cliente["correo"].set(datos[3])
    vars_cliente["ciudad"].set(datos[7])

def accion(tipo):
    if tipo == "crear":
        if any(vars_cliente[k].get() == "" for k in ["nombre","apellido","correo","ciudad"]):
            messagebox.showwarning("Error", "Complete todos los campos")
            return

        if not crear_cliente(
            vars_cliente["nombre"].get(),
            vars_cliente["apellido"].get(),
            vars_cliente["correo"].get(),
            vars_cliente["ciudad"].get()
        ):
            messagebox.showerror("Error", "El correo ya está registrado")
            return

    elif tipo == "actualizar":
        if vars_cliente["id"].get() == "":
            messagebox.showwarning("Error", "Seleccione un cliente")
            return

        actualizar_cliente(
            vars_cliente["id"].get(),
            vars_cliente["nombre"].get(),
            vars_cliente["apellido"].get(),
            vars_cliente["correo"].get(),
            vars_cliente["ciudad"].get()
        )

    elif tipo == "eliminar":
        if vars_cliente["id"].get() == "":
            messagebox.showwarning("Error", "Seleccione un cliente")
            return

        if not messagebox.askyesno("Confirmar", "¿Eliminar cliente?"):
            return

        if not eliminar_cliente(vars_cliente["id"].get()):
            messagebox.showerror(
                "No se puede eliminar",
                "Este cliente no puede eliminarse porque ya tiene tutorías registradas."
            )
            return

    cargar_tabla()

# CONTENEDORES
main_frame = tk.Frame(ventana, bg=color_fondo)
main_frame.pack(fill="both", expand=True, padx=20, pady=10)

panel_izq = tk.Frame(main_frame, bg=color_fondo)
panel_izq.pack(side="left", fill="y", padx=10)

panel_der = tk.Frame(main_frame, bg=color_fondo)
panel_der.pack(side="right", fill="both", expand=True, padx=10)

# FORMULARIO
form = tk.LabelFrame(panel_izq, text="Datos del Cliente",
                     bg=color_fondo, font=("Arial",12,"bold"))
form.pack(padx=20, pady=20)

campos = [
    ("Nombre","nombre"),
    ("Apellido","apellido"),
    ("Correo","correo"),
    ("Ciudad","ciudad")
]

for i,(txt,key) in enumerate(campos):
    tk.Label(form, text=txt, bg=color_fondo).grid(row=i, column=0, pady=5, sticky="w")
    tk.Entry(form, textvariable=vars_cliente[key], width=35).grid(row=i, column=1, pady=5)

for txt,acc in [("Crear","crear"),("Actualizar","actualizar"),("Eliminar","eliminar")]:
    tk.Button(panel_izq, text=txt, width=15, bg="#99ccff",
              font=("Arial",11,"bold"),
              command=lambda a=acc: accion(a)).pack(pady=5)

tk.Button(panel_izq, text="Limpiar", width=15, bg="#99ccff",
          font=("Arial",11,"bold"),
          command=limpiar_campos).pack(pady=5)

# IMAGEN
try:
    img = Image.open("espol.jpg").resize((200,200))
    img_tk = ImageTk.PhotoImage(img)
    lbl_img = tk.Label(panel_der, image=img_tk, bg=color_fondo)
    lbl_img.image = img_tk
    lbl_img.pack(pady=10)
except:
    print("No se encontró la imagen")

# TABLA
columnas = ("ID","Nombre","Apellido","Correo","Créditos","Fecha","Reputación","Ciudad")
tabla = ttk.Treeview(panel_der, columns=columnas, show="headings")

for c in columnas:
    tabla.heading(c, text=c)
    tabla.column(c, anchor="center", width=120)

tabla.pack(fill="both", expand=True)
tabla.bind("<<TreeviewSelect>>", seleccionar_fila)

# INICIO
cargar_tabla()
ventana.mainloop()
