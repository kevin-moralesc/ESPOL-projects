#Caso 1
A= [9,1,6]
#Caso 2
B= [1,9,6]
#Caso 3
C= [6,1,9]
#Caso 4
D= [6,9,1]
#Caso 5
E= [1,6,9]
#Caso 6
F= [9,6,1]

n = len(A)

def insertion_sort(l):
    A = l.copy()
    n = len(A)

    swaps = 0
    inserts = 0

    for i in range(1,n):
        key = A[i]
        j = i - 1
        while j >= 0 and A[j] > key:
            A[j + 1] = A[j] #swap/move
            swaps += 1
            j -= 1
        A[j + 1] = key  #insert
        inserts += 1
    total = swaps + inserts
    return A, swaps, inserts, total

casos = [("Caso 1 [9,1,6]", A), 
         ("Caso 2 [1,9,6]", B), 
         ("Caso 3 [6,1,9]", C), 
         ("Caso 4 [6,9,1]", D), 
         ("Caso 5 [1,6,9]", E), 
         ("Caso 6 [9,6,1]", F)]

totales = []

for nombre, lista in casos:
    ordenado, s, i, t = insertion_sort(lista)
    totales.append(t)
    print(f"{nombre} -> Ordenado: {ordenado} | Swaps: {s} | Inserts: {i} | Total T(n): {t}")

print("-" * 60)
print(f"Mejor Caso: {min(totales)} operaciones")
print(f"Peor Caso: {max(totales)} operaciones")
print(f"Caso Promedio: {sum(totales) / len(totales):.2f} operaciones")