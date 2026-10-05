import matplotlib.pyplot as plt
import numpy as np

# Rangos con paso de 0.2
n_10 = np.arange(0, 10.2, 0.2)
n_20 = np.arange(0, 20.2, 0.2)

# Funciones 
# f(n) = 100*n^2 
# g(n) = 2^n
f_10, g_10 = 100 * (n_10**2), 2**n_10
f_20, g_20 = 100 * (n_20**2), 2**n_20

plt.figure(figsize=(12, 5))

# Gráfico 1: Rango de 0 a 10
plt.subplot(1, 2, 1)
plt.plot(n_10, f_10, label=r"$100n^2$", color="blue", linewidth=2)
plt.plot(n_10, g_10, label=r"$2^n$", color="red", linewidth=2)
plt.title("Rango 0 a 10 (Salto 0.2)")
plt.xlabel("n")
plt.ylabel("Pasos / Tiempo")
plt.legend()
plt.grid(True)

# Gráfico 2: Rango de 0 a 20
plt.subplot(1, 2, 2)
plt.plot(n_20, f_20, label=r"$100n^2$", color="blue", linewidth=2)
plt.plot(n_20, g_20, label=r"$2^n$", color="red", linewidth=2)
plt.axvline(x=14.32, color="gray", linestyle="--", label="Punto de cruce (~14.3)")
plt.title("Rango 0 a 20 (Salto 0.2)")
plt.xlabel("n")
plt.ylabel("Pasos / Tiempo")
plt.legend()
plt.grid(True)

plt.tight_layout()
plt.show()