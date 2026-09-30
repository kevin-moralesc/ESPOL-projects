import math

# Funciones auxiliares (sin cambios)
def binario_entero(entero):
    """Convierte la parte entera (positiva) a binario."""
    if entero == 0:
        return "0"
    binario = ""
    entero_temp = int(entero)
    while entero_temp > 0:
        bit = entero_temp % 2
        binario = str(bit) + binario 
        entero_temp = entero_temp // 2 
    return binario

def binario_fraccionario(fraccion, max_bits):
    """Convierte la parte fraccionaria a binario con un límite de bits."""
    binario = ""
    fraccion_temp = fraccion
    for i in range(max_bits):
        fraccion_temp *= 2
        bit = int(fraccion_temp) 
        binario += str(bit) 
        fraccion_temp -= bit
    return binario

def decimal_a_ieee754_pasos(numero_decimal):
    """
    Convierte un decimal a IEEE 754 (32 bits) mostrando los pasos.
    """
    # Constantes IEEE 754
    PRECISION_MANTISA = 23
    BIAS = 127
    
    print("\n--- PASO 1: DETERMINAR SIGNO ---")
    signo_bit = '0' if numero_decimal >= 0 else '1'
    valor_absoluto = abs(numero_decimal)
    print(f"Número a convertir: {numero_decimal}")

    # CORRECCIÓN AQUÍ: Mensaje dinámico basado en el signo.
    estado_signo = "positivo (S = 0)" if signo_bit == '0' else "negativo (S = 1)"
    print(f"El número es **{estado_signo}**, por lo tanto, el bit de Signo (S) es: {signo_bit}")

    if valor_absoluto == 0:
        return "0 00000000 00000000000000000000000"

    # --- 2. Separar y Convertir Partes ---
    print("\n--- PASO 2: CONVERSIÓN BINARIA PURA ---")
    parte_entera = int(valor_absoluto)
    parte_fraccionaria = valor_absoluto - parte_entera
    
    binario_ent = binario_entero(parte_entera)
    # 30 bits es suficiente para la normalización
    binario_frac = binario_fraccionario(parte_fraccionaria, 30) 
    binario_completo = binario_ent + "." + binario_frac
    
    print(f"Parte entera ({parte_entera}) en binario: {binario_ent}")
    print(f"Parte fraccionaria ({round(parte_fraccionaria, 5)}) en binario (aprox.): 0.{binario_frac[:25]}...")
    print(f"Número binario completo: {binario_completo}")

    # --- 3. Normalización (Encontrar Exponente) ---
    print("\n--- PASO 3: NORMALIZACIÓN y EXPONENTE REAL ---")
    if parte_entera > 0:
        # Lógica para números grandes (ej: 237.377)
        exponente_real = len(binario_ent) - 1
        mantisa_completa = binario_ent[1:] + binario_frac
        
        print(f"La coma decimal se mueve {exponente_real} posiciones a la izquierda.")
        print(f"Formato normalizado: 1.{mantisa_completa[:23]}... x 2^{exponente_real}")
        
    else: 
        # Lógica para números muy pequeños (ej: 0.00377)
        primer_uno = binario_frac.find('1')
        
        # Manejo de error si la precisión (30 bits) no encuentra un '1'
        if primer_uno == -1:
             print("⚠️ ERROR DE PRECISIÓN: El primer '1' no se encontró en los primeros 30 bits. Aumente la precisión.")
             return "Error: Aumentar la precisión."
             
        exponente_real = -(primer_uno + 1)
        mantisa_completa = binario_frac[primer_uno + 1:]
        
        print(f"La coma decimal se mueve {abs(exponente_real)} posiciones a la derecha.")
        print(f"Formato normalizado: 1.{mantisa_completa[:23]}... x 2^{exponente_real}")

    # --- 4. Exponente Sesgado (Bias) ---
    print("\n--- PASO 4: CÁLCULO DEL EXPONENTE SESGADO (8 bits) ---")
    exponente_sesgado = exponente_real + BIAS
    exponente_binario = binario_entero(exponente_sesgado).zfill(8)

    print(f"Exponente real: {exponente_real}")
    print(f"Sesgo (Bias): {BIAS}")
    print(f"Exponente Sesgado: {exponente_sesgado} (decimal)")
    print(f"Exponente Binario (E): {exponente_binario}")

    # --- 5. Mantisa Final (23 bits) ---
    print("\n--- PASO 5: OBTENER MANTISA (23 bits) ---")
    mantisa_final = mantisa_completa[:PRECISION_MANTISA].ljust(PRECISION_MANTISA, '0')
    
    print(f"La mantisa es el valor después del '1.' (implícito).")
    print(f"Truncada a 23 bits, la Mantisa (M) es: {mantisa_final}")

    # --- 6. Ensamblar Resultado ---
    print("\n--- PASO 6: ENSAMBLAR EL RESULTADO FINAL (32 bits) ---")
    print("📢 **ACCIÓN REQUERIDA:**")
    print("Debemos unir los tres componentes que hemos calculado en el orden estricto de 32 bits:")
    print("1. Bit de Signo (S): 1 bit")
    print("2. Exponente Sesgado (E): 8 bits")
    print("3. Mantisa (M): 23 bits")
    print("¡El resultado debe ser una única cadena de 32 dígitos binarios!")

    resultado_final = f"{signo_bit} {exponente_binario} {mantisa_final}"
    
    print("\n--- RESUMEN DE COMPONENTES ---")
    print(f"Bit de Signo (S): {signo_bit}")
    print(f"Exponente (E): {exponente_binario}")
    print(f"Mantisa (M): {mantisa_final}")
    
    print("\n--- RESULTADO FINAL ---")
    print(f"Resultado IEEE 754 (32 bits): {resultado_final.replace(' ', '')}") 
    print("-" * 40)
    
    return resultado_final


numero_prueba =232.499
decimal_a_ieee754_pasos(numero_prueba)