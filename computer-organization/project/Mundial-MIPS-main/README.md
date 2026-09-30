# Simulador Fase de Grupos - Mundial FIFA 2026

Proyecto del Primer Parcial — Organización de Computadores (CCPG1049) — ESPOL

## Requisitos

- Navegador web moderno (Chrome, Firefox, Edge)
- Acceso a [Mipsy Web](https://cgi.cse.unsw.edu.au/~cs1521/mipsy/)

No se necesita instalar nada.

## Cómo ejecutar

### 1. Abrir Mipsy Web

Ingresa a **https://cgi.cse.unsw.edu.au/~cs1521/mipsy/** en tu navegador.

### 2. Cargar el archivo

- Haz clic en **"Load"** (ícono de carpeta, esquina superior izquierda).
- Selecciona el archivo `mundial2026.s`.
- El código aparecerá en el editor.


### 3. Compilar

- Una vez que el código esté en el editor, haga clic en el botón **Save**
- En Mipsy Web, esta acción guarda el progreso y realiza el ensamblado automático del código a lenguaje máquina en tiempo real.
- Si existen errores sintácticos, el entorno mostrará las alertas en la sección inferior. Si no se muestran errores, el programa queda listo para correr.

### 4. Ejecutar

Tienes dos opciones:

| Modo | Botón | Descripción |
|------|-------|-------------|
| Paso a paso | **Step** | Ejecuta una instrucción a la vez (útil para depurar) |
| Ejecución completa | **Run** | Ejecuta el programa hasta el final |

Se recomienda usar **Run** para ver el flujo completo.

### 5. Usar el programa

El programa guía al usuario con mensajes en pantalla:

```
============================================
    SIMULADOR MUNDIAL FIFA 2026
============================================

--- PAISES PARTICIPANTES EN EL MUNDIAL 2026 ---
1. USA
2. Canada
3. Mexico
...
48. Turquia

--- FASE 0: SELECCION DEL GRUPO ---
Ingrese el nombre del pais 1: Argentina
Ingrese el nombre del pais 2: Francia
Ingrese el nombre del pais 3: Portugal
Ingrese el nombre del pais 4: Mexico
```

**Validaciones activas:**
- El nombre debe coincidir exactamente con el de la lista (mayúsculas incluidas, sin tildes).
- Si el nombre no se encuentra, se pedirá de nuevo.
- Si ingresas un país ya seleccionado, se pedirá de nuevo.

Luego el programa simula los 6 partidos automáticamente, muestra la tabla sin ordenar, la tabla ordenada y los clasificados.

## Estructura del programa

```
Fase 0  →  Muestra lista de 48 países y el usuario elige 4
Fase 1  →  Simula 6 partidos (todos vs todos), goles aleatorios 0-5
           Llena arreglos: GF, GC, PTS
           Muestra tabla sin ordenar
Fase 2  →  Ordena la tabla con Bubble Sort
           Criterio: Puntos (desc), desempate por Diferencia de Goles (desc)
           Muestra tabla ordenada
Fase 3  →  Muestra los 2 equipos clasificados
```

## Ejemplo de salida

```
--- FASE 1: PARTIDOS ---

Partido 1: Argentina vs Francia
  Resultado: 3 - 1

Partido 2: Argentina vs Portugal
  Resultado: 0 - 2
...

--- TABLA DE POSICIONES (SIN ORDENAR) ---
Pos  Pais              PJ  GF  GC  DG  PTS
-------------------------------------------
1    Argentina         3   5   4   1   3
2    Francia           3   6   3   3   6
...

--- TABLA DE POSICIONES (ORDENADA) ---
...

--- FASE 3: CLASIFICADOS ---
Los equipos clasificados a la siguiente etapa son:
  1ro: Francia
  2do: Portugal
```

## Archivos

```
Proyecto1Parcial/
├── mundial2026.s     # Código fuente en MIPS Assembly
└── README.md         # Este archivo
```
