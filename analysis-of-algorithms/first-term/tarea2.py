import time
import matplotlib.pyplot as plt


# Fibonacci iterativo

def fibonacci_iterativo(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b


# Fibonacci recursivo

def fibonacci_recursivo(n):
    if n <= 0:  #caso base
        return 0
    elif n == 1:
        return 1
    else:
        #caso recursivo
        return fibonacci_recursivo(n - 1) + fibonacci_recursivo(n - 2)


valores_n = [1, 2, 5, 8, 10, 12, 15, 20, 25, 50, 100]

tiempos_iterativos = []
tiempos_recursivos = []

# Medición Iterativa
for n in valores_n:
    inicio = time.perf_counter()

    fibonacci_iterativo(n)

    fin = time.perf_counter()

    tiempos_iterativos.append(fin - inicio)


# Medición Recursiva 
# Se limita a n <= 25 porque la recursión directa
# repite muchos cálculos y su tiempo de ejecución
# crece exponencialmente. Para n = 50 y n = 100
# se omite la medición para evitar tiempos de
# espera excesivos.
for n in valores_n:
    if n <= 25: 
        inicio = time.perf_counter()

        fibonacci_recursivo(n)

        fin = time.perf_counter()

        tiempos_recursivos.append(fin - inicio)
    else:
        tiempos_recursivos.append(None)


# Resultados
print("Resultados de Fibonacci")
print("-" * 80)
print("n\tFibonacci\t\tTiempo iterativo (s)\tTiempo recursivo (s)")
print("-" * 80)

for i, n in enumerate(valores_n):
    resultado = fibonacci_iterativo(n)
    tiempo_i = format(tiempos_iterativos[i], ".8f")
    tiempo_r = tiempos_recursivos[i]

    if tiempo_r is not None:
        print(str(n) + "\t" + str(resultado).ljust(25) + "\t" + tiempo_i + "\t" + format(tiempo_r, ".8f"))
    else:
        print(str(n) + "\t" + str(resultado).ljust(25) + "\t" + tiempo_i + "\t" + "Muy lento")

# Gráfica de tiempos de ejecución
plt.figure(figsize=(10, 6))


# Trazado iterativo
plt.plot(
    valores_n,
    tiempos_iterativos,
    marker="o",
    label="Iterativo",
    color="green"
)

# Trazado recursivo
n_rec = [
    n for n, t in zip(valores_n, tiempos_recursivos)
    if t is not None
]

t_rec = [
    t for t in tiempos_recursivos
    if t is not None
]

plt.plot(
    n_rec,
    t_rec,
    marker="o",
    label="Recursivo",
    color="red"
)
plt.title("Tiempo de ejecución: Fibonacci iterativo vs. recursivo") 
plt.xlabel("Valor de n")
plt.ylabel("Tiempo de ejecución (segundos)")
plt.yscale("log")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.savefig('grafica_fibonacci Kevin Morales.png', dpi=300)
plt.show()


