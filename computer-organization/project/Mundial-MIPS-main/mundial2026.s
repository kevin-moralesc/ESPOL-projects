# ============================================================
#  SIMULADOR FASE DE GRUPOS - MUNDIAL FIFA 2026
#  Materia: Organización de Computadores - CCPG1049
#  Lenguaje: MIPS Assembly (Mipsy Web)
# ============================================================

.data

# ==================== NOMBRES DE LOS 48 PAISES ====================
# --- GRUPO A ---
pais0:  .asciiz "Mexico"
pais1:  .asciiz "Sudafrica"
pais2:  .asciiz "Corea"
pais3:  .asciiz "Republica Checa"
# --- GRUPO B ---
pais4:  .asciiz "Canada"
pais5:  .asciiz "Bosnia"
pais6:  .asciiz "Qatar"
pais7:  .asciiz "Suiza"

# --- GRUPO C ---
pais8:  .asciiz "Brasil"
pais9:  .asciiz "Marruecos"
pais10: .asciiz "Haiti"
pais11: .asciiz "Escocia"

# --- GRUPO D ---
pais12: .asciiz "USA"
pais13: .asciiz "Paraguay"
pais14: .asciiz "Australia"
pais15: .asciiz "Turquia"

# --- GRUPO E ---
pais16: .asciiz "Alemania"
pais17: .asciiz "Curazao"
pais18: .asciiz "Costa de Marfil"
pais19: .asciiz "Ecuador"

# --- GRUPO F ---
pais20: .asciiz "Paises Bajos"
pais21: .asciiz "Japon"
pais22: .asciiz "Suecia"
pais23: .asciiz "Tunez"

# --- GRUPO G ---
pais24: .asciiz "Belgica"
pais25: .asciiz "Egipto"
pais26: .asciiz "Iran"
pais27: .asciiz "Nueva Zelanda"

# --- GRUPO H ---
pais28: .asciiz "Espana"
pais29: .asciiz "Cabo Verde"
pais30: .asciiz "Arabia Saudita"
pais31: .asciiz "Uruguay"

# --- GRUPO I ---
pais32: .asciiz "Francia"
pais33: .asciiz "Senegal"
pais34: .asciiz "Bolivia"
pais35: .asciiz "Noruega"

# --- GRUPO J ---
pais36: .asciiz "Argentina"
pais37: .asciiz "Argelia"
pais38: .asciiz "Austria"
pais39: .asciiz "Jordania"

# --- GRUPO K ---
pais40: .asciiz "Portugal"
pais41: .asciiz "Jamaica"
pais42: .asciiz "Uzbekistan"
pais43: .asciiz "Colombia"

# --- GRUPO L ---
pais44: .asciiz "Inglaterra"
pais45: .asciiz "Croacia"
pais46: .asciiz "Ghana"
pais47: .asciiz "Panama"

# Tabla de punteros a los nombres de paises (48 entradas)
pais_ptrs:
    .word pais0,  pais1,  pais2,  pais3,  pais4,  pais5,  pais6,  pais7
    .word pais8,  pais9,  pais10, pais11, pais12, pais13, pais14, pais15
    .word pais16, pais17, pais18, pais19, pais20, pais21, pais22, pais23
    .word pais24, pais25, pais26, pais27, pais28, pais29, pais30, pais31
    .word pais32, pais33, pais34, pais35, pais36, pais37, pais38, pais39
    .word pais40, pais41, pais42, pais43, pais44, pais45, pais46, pais47

# ==================== ARREGLOS PARALELOS DEL GRUPO ====================
seleccion: .word 0, 0, 0, 0
gf:        .word 0, 0, 0, 0
gc:        .word 0, 0, 0, 0
pts:       .word 0, 0, 0, 0

# ==================== BUFFER DE ENTRADA Y SEMILLA ====================
input_buf: .space 64
seed:      .word 31415

# ==================== MENSAJES ====================
msg_titulo:    .asciiz "\n============================================\n"
msg_mundial:   .asciiz "    SIMULADOR MUNDIAL FIFA 2026\n"
msg_sep:       .asciiz "============================================\n"
msg_lista:     .asciiz "\n--- PAISES PARTICIPANTES EN EL MUNDIAL 2026 ---\n"
msg_punto:     .asciiz ". "
msg_nl:        .asciiz "\n"
msg_tab:       .asciiz "\t"

msg_sel_titulo:.asciiz "\n--- FASE 0: SELECCION DEL GRUPO ---\n"
msg_ingrese:   .asciiz "Ingrese el nombre del pais "
msg_ingrese2:  .asciiz ": "
msg_err_noenc: .asciiz "  Error: pais no encontrado. Verifique el nombre y use mayusculas correctas.\n"
msg_err_dup:   .asciiz "  Error: ese pais ya fue seleccionado. Elija otro.\n"

msg_grupo:     .asciiz "\nGrupo formado:\n"
msg_guion_pos: .asciiz ") "

msg_partidos:  .asciiz "\n--- FASE 1: PARTIDOS ---\n"
msg_partido:   .asciiz "\nPartido "
msg_dos_ptos:  .asciiz ": "
msg_vs:        .asciiz " vs "
msg_resultado: .asciiz "  Resultado: "
msg_guion:     .asciiz " - "

msg_tabla_sin: .asciiz "\n--- TABLA DE POSICIONES (SIN ORDENAR) ---\n"
msg_tabla_ord: .asciiz "\n--- TABLA DE POSICIONES (ORDENADA) ---\n"
msg_encabez:   .asciiz "Pos  Pais              PJ  GF  GC  DG  PTS\n"
msg_sep_tab:   .asciiz "-------------------------------------------\n"
msg_espacio2:  .asciiz "  "
msg_espacio4:  .asciiz "    "

msg_clasif:    .asciiz "\n--- FASE 3: CLASIFICADOS ---\n"
msg_clasif2:   .asciiz "Los equipos clasificados a la siguiente etapa son:\n"
msg_1ro:       .asciiz "  1ro: "
msg_2do:       .asciiz "  2do: "
msg_fin:       .asciiz "\n============================================\n"
msg_fin2:      .asciiz "        FIN DE LA SIMULACION\n"

.text

# ============================================================
#  MAIN
# ============================================================
main:
    li   $v0, 4
    la   $a0, msg_titulo
    syscall
    li   $v0, 4
    la   $a0, msg_mundial
    syscall
    li   $v0, 4
    la   $a0, msg_sep
    syscall

    jal  mostrar_lista_paises
    jal  seleccionar_grupo

    # Mostrar grupo formado
    li   $v0, 4
    la   $a0, msg_grupo
    syscall

    li   $s0, 0
mostrar_grupo_loop:
    beq  $s0, 4, fin_mostrar_grupo
    li   $v0, 1
    addi $a0, $s0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_guion_pos
    syscall
    la   $t0, seleccion
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    jal  imprimir_nombre_pais
    li   $v0, 4
    la   $a0, msg_nl
    syscall
    addi $s0, $s0, 1
    j    mostrar_grupo_loop
fin_mostrar_grupo:

    li   $v0, 4
    la   $a0, msg_partidos
    syscall
    jal  simular_partidos

    li   $v0, 4
    la   $a0, msg_tabla_sin
    syscall
    jal  mostrar_tabla

    jal  bubble_sort

    li   $v0, 4
    la   $a0, msg_tabla_ord
    syscall
    jal  mostrar_tabla

    li   $v0, 4
    la   $a0, msg_clasif
    syscall
    li   $v0, 4
    la   $a0, msg_clasif2
    syscall

    li   $v0, 4
    la   $a0, msg_1ro
    syscall
    la   $t0, seleccion
    lw   $a0, 0($t0)
    jal  imprimir_nombre_pais
    li   $v0, 4
    la   $a0, msg_nl
    syscall

    li   $v0, 4
    la   $a0, msg_2do
    syscall
    la   $t0, seleccion
    lw   $a0, 4($t0)
    jal  imprimir_nombre_pais
    li   $v0, 4
    la   $a0, msg_nl
    syscall

    li   $v0, 4
    la   $a0, msg_fin
    syscall
    li   $v0, 4
    la   $a0, msg_fin2
    syscall
    li   $v0, 4
    la   $a0, msg_fin
    syscall

    li   $v0, 10
    syscall


# ============================================================
#  mostrar_lista_paises: imprime los 48 paises numerados
# ============================================================
mostrar_lista_paises:
    addiu $sp, $sp, -8
    sw    $ra, 0($sp)
    sw    $s0, 4($sp)

    li   $v0, 4
    la   $a0, msg_lista
    syscall

    li   $s0, 0
loop_lista:
    beq  $s0, 48, fin_lista
    li   $v0, 1
    addi $a0, $s0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_punto
    syscall
    move $a0, $s0
    jal  imprimir_nombre_pais
    li   $v0, 4
    la   $a0, msg_nl
    syscall
    addi $s0, $s0, 1
    j    loop_lista
fin_lista:
    lw   $s0, 4($sp)
    lw   $ra, 0($sp)
    addiu $sp, $sp, 8
    jr   $ra


# ============================================================
#  imprimir_nombre_pais: $a0 = indice (0-47), imprime el nombre
#  Funcion hoja
# ============================================================
imprimir_nombre_pais:
    la   $t0, pais_ptrs
    sll  $t1, $a0, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    li   $v0, 4
    syscall
    jr   $ra


# ============================================================
#  seleccionar_grupo: el usuario escribe el nombre de 4 paises
#  Valida que exista en la lista y que no este repetido
# ============================================================
seleccionar_grupo:
    addiu $sp, $sp, -12
    sw    $ra, 0($sp)
    sw    $s0, 4($sp)                  # contador seleccionados
    sw    $s1, 8($sp)                  # indice encontrado

    li   $v0, 4
    la   $a0, msg_sel_titulo
    syscall

    li   $s0, 0
loop_selec:
    beq  $s0, 4, fin_selec

    # Pedir nombre
    li   $v0, 4
    la   $a0, msg_ingrese
    syscall
    li   $v0, 1
    addi $a0, $s0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_ingrese2
    syscall

    # Leer string en input_buf (max 63 chars + null)
    li   $v0, 8
    la   $a0, input_buf
    li   $a1, 64
    syscall

    # Quitar el '\n' que deja syscall 8
    la   $a0, input_buf
    jal  strip_newline

    # Buscar el pais en la lista
    la   $a0, input_buf
    jal  buscar_pais                   # retorna indice en $v0 o -1
    move $s1, $v0

    # -1 significa no encontrado
    li   $t0, -1
    beq  $s1, $t0, err_no_enc

    # Verificar duplicado
    move $a0, $s1
    move $a1, $s0
    jal  ya_seleccionado
    bne  $v0, $zero, err_dup

    # Guardar seleccion
    la   $t0, seleccion
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    sw   $s1, 0($t0)

    addi $s0, $s0, 1
    j    loop_selec

err_no_enc:
    li   $v0, 4
    la   $a0, msg_err_noenc
    syscall
    j    loop_selec

err_dup:
    li   $v0, 4
    la   $a0, msg_err_dup
    syscall
    j    loop_selec

fin_selec:
    lw   $s1, 8($sp)
    lw   $s0, 4($sp)
    lw   $ra, 0($sp)
    addiu $sp, $sp, 12
    jr   $ra


# ============================================================
#  strip_newline: reemplaza el primer '\n' del string con '\0'
#  $a0 = direccion del string
#  Funcion hoja
# ============================================================
strip_newline:
loop_strip:
    lb   $t0, 0($a0)
    beq  $t0, $zero, fin_strip        # fin de string, salir
    li   $t1, 10                       # '\n'
    bne  $t0, $t1, sig_char
    sb   $zero, 0($a0)                 # reemplazar '\n' con '\0'
    jr   $ra
sig_char:
    addi $a0, $a0, 1
    j    loop_strip
fin_strip:
    jr   $ra


# ============================================================
#  buscar_pais: busca el string $a0 en la lista de 48 paises
#  Retorna el indice en $v0, o -1 si no se encontro
# ============================================================
buscar_pais:
    addiu $sp, $sp, -12
    sw    $ra, 0($sp)
    sw    $s0, 4($sp)                  # indice i
    sw    $s1, 8($sp)                  # direccion del input

    move $s1, $a0                      # guardar input
    li   $s0, 0

loop_buscar:
    beq  $s0, 48, pais_no_encontrado

    # Obtener direccion del nombre pais[i]
    la   $t0, pais_ptrs
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $a1, 0($t0)                   # nombre del pais i

    move $a0, $s1                      # input del usuario
    jal  strcmp_func

    beq  $v0, $zero, pais_encontrado

    addi $s0, $s0, 1
    j    loop_buscar

pais_encontrado:
    move $v0, $s0
    lw   $s1, 8($sp)
    lw   $s0, 4($sp)
    lw   $ra, 0($sp)
    addiu $sp, $sp, 12
    jr   $ra

pais_no_encontrado:
    li   $v0, -1
    lw   $s1, 8($sp)
    lw   $s0, 4($sp)
    lw   $ra, 0($sp)
    addiu $sp, $sp, 12
    jr   $ra


# ============================================================
#  strcmp_func: compara dos strings caracter a caracter
#  $a0 = string1 (input usuario)
#  $a1 = string2 (nombre del pais en memoria)
#  Retorna $v0 = 0 si iguales, 1 si diferentes
#  Funcion hoja
# ============================================================
strcmp_func:
loop_cmp:
    lb   $t0, 0($a0)
    lb   $t1, 0($a1)
    bne  $t0, $t1, cmp_diff
    beq  $t0, $zero, cmp_equal        # ambos son '\0' = iguales
    addi $a0, $a0, 1
    addi $a1, $a1, 1
    j    loop_cmp
cmp_equal:
    li   $v0, 0
    jr   $ra
cmp_diff:
    li   $v0, 1
    jr   $ra


# ============================================================
#  ya_seleccionado: verifica si indice $a0 ya esta en seleccion[0..$a1-1]
#  Retorna $v0 = 1 si duplicado, 0 si no
#  Funcion hoja
# ============================================================
ya_seleccionado:
    li   $t0, 0
    la   $t1, seleccion
loop_ya:
    beq  $t0, $a1, no_dup
    sll  $t2, $t0, 2
    add  $t2, $t1, $t2
    lw   $t3, 0($t2)
    beq  $t3, $a0, si_dup
    addi $t0, $t0, 1
    j    loop_ya
no_dup:
    li   $v0, 0
    jr   $ra
si_dup:
    li   $v0, 1
    jr   $ra


# ============================================================
#  rand_lcg: generador congruencial lineal
#  seed = (seed * 1103515245 + 12345) & 0x7FFFFFFF
#  Retorna numero aleatorio en $v0
#  Funcion hoja
# ============================================================
rand_lcg:
    lw   $t0, seed
    li   $t1, 1103515245
    mult $t0, $t1
    mflo $t0
    addiu $t0, $t0, 12345
    li   $t1, 0x7fffffff
    and  $t0, $t0, $t1
    sw   $t0, seed
    move $v0, $t0
    jr   $ra


# ============================================================
#  rand_0_5: retorna numero aleatorio entre 0 y 5
# ============================================================
rand_0_5:
    addiu $sp, $sp, -4
    sw    $ra, 0($sp)
    jal  rand_lcg
    li   $t0, 6
    divu $v0, $t0
    mfhi $v0
    lw   $ra, 0($sp)
    addiu $sp, $sp, 4
    jr   $ra


# ============================================================
#  simular_partidos: genera los 6 partidos todos contra todos
# ============================================================
simular_partidos:
    addiu $sp, $sp, -4
    sw    $ra, 0($sp)

    la   $t0, gf
    sw   $zero, 0($t0)
    sw   $zero, 4($t0)
    sw   $zero, 8($t0)
    sw   $zero, 12($t0)
    la   $t0, gc
    sw   $zero, 0($t0)
    sw   $zero, 4($t0)
    sw   $zero, 8($t0)
    sw   $zero, 12($t0)
    la   $t0, pts
    sw   $zero, 0($t0)
    sw   $zero, 4($t0)
    sw   $zero, 8($t0)
    sw   $zero, 12($t0)

    li   $a0, 1
    li   $a2, 0
    li   $a3, 1
    jal  simular_un_partido

    li   $a0, 2
    li   $a2, 0
    li   $a3, 2
    jal  simular_un_partido

    li   $a0, 3
    li   $a2, 0
    li   $a3, 3
    jal  simular_un_partido

    li   $a0, 4
    li   $a2, 1
    li   $a3, 2
    jal  simular_un_partido

    li   $a0, 5
    li   $a2, 1
    li   $a3, 3
    jal  simular_un_partido

    li   $a0, 6
    li   $a2, 2
    li   $a3, 3
    jal  simular_un_partido

    lw   $ra, 0($sp)
    addiu $sp, $sp, 4
    jr   $ra


# ============================================================
#  simular_un_partido
#  $a0 = numero de partido, $a2 = pos equipo A, $a3 = pos equipo B
# ============================================================
simular_un_partido:
    addiu $sp, $sp, -24
    sw    $ra,  0($sp)
    sw    $s0,  4($sp)
    sw    $s1,  8($sp)
    sw    $s2, 12($sp)
    sw    $s3, 16($sp)
    sw    $s4, 20($sp)

    move $s0, $a0
    move $s1, $a2
    move $s2, $a3

    jal  rand_0_5
    move $s3, $v0                      # goles A
    jal  rand_0_5
    move $s4, $v0                      # goles B

    li   $v0, 4
    la   $a0, msg_partido
    syscall
    li   $v0, 1
    move $a0, $s0
    syscall
    li   $v0, 4
    la   $a0, msg_dos_ptos
    syscall

    la   $t0, seleccion
    sll  $t1, $s1, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    jal  imprimir_nombre_pais

    li   $v0, 4
    la   $a0, msg_vs
    syscall

    la   $t0, seleccion
    sll  $t1, $s2, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    jal  imprimir_nombre_pais

    li   $v0, 4
    la   $a0, msg_nl
    syscall
    li   $v0, 4
    la   $a0, msg_resultado
    syscall
    li   $v0, 1
    move $a0, $s3
    syscall
    li   $v0, 4
    la   $a0, msg_guion
    syscall
    li   $v0, 1
    move $a0, $s4
    syscall
    li   $v0, 4
    la   $a0, msg_nl
    syscall

    # GF
    la   $t0, gf
    sll  $t1, $s1, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    add  $t2, $t2, $s3
    sw   $t2, 0($t1)

    sll  $t1, $s2, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    add  $t2, $t2, $s4
    sw   $t2, 0($t1)

    # GC
    la   $t0, gc
    sll  $t1, $s1, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    add  $t2, $t2, $s4
    sw   $t2, 0($t1)

    sll  $t1, $s2, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    add  $t2, $t2, $s3
    sw   $t2, 0($t1)

    # PUNTOS
    la   $t0, pts
    beq  $s3, $s4, partido_empate

    slt  $t1, $s4, $s3
    beq  $t1, $zero, gana_B

    sll  $t1, $s1, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    addiu $t2, $t2, 3
    sw   $t2, 0($t1)
    j    fin_partido

gana_B:
    sll  $t1, $s2, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    addiu $t2, $t2, 3
    sw   $t2, 0($t1)
    j    fin_partido

partido_empate:
    sll  $t1, $s1, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    addiu $t2, $t2, 1
    sw   $t2, 0($t1)

    sll  $t1, $s2, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)
    addiu $t2, $t2, 1
    sw   $t2, 0($t1)

fin_partido:
    lw   $ra,  0($sp)
    lw   $s0,  4($sp)
    lw   $s1,  8($sp)
    lw   $s2, 12($sp)
    lw   $s3, 16($sp)
    lw   $s4, 20($sp)
    addiu $sp, $sp, 24
    jr   $ra


# ============================================================
#  mostrar_tabla: muestra tabla de posiciones actual
# ============================================================
mostrar_tabla:
    addiu $sp, $sp, -8
    sw    $ra, 0($sp)
    sw    $s0, 4($sp)

    li   $v0, 4
    la   $a0, msg_encabez
    syscall
    li   $v0, 4
    la   $a0, msg_sep_tab
    syscall

    li   $s0, 0
loop_tabla:
    beq  $s0, 4, fin_tabla

    li   $v0, 1
    addi $a0, $s0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_espacio4
    syscall

    la   $t0, seleccion
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    jal  imprimir_nombre_pais
    li   $v0, 4
    la   $a0, msg_tab
    syscall

    li   $v0, 1
    li   $a0, 3
    syscall
    li   $v0, 4
    la   $a0, msg_espacio2
    syscall

    la   $t0, gf
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    li   $v0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_espacio2
    syscall

    la   $t0, gc
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $t2, 0($t0)
    move $a0, $t2
    li   $v0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_espacio2
    syscall

    la   $t0, gf
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $t3, 0($t0)
    sub  $a0, $t3, $t2
    li   $v0, 1
    syscall
    li   $v0, 4
    la   $a0, msg_espacio2
    syscall

    la   $t0, pts
    sll  $t1, $s0, 2
    add  $t0, $t0, $t1
    lw   $a0, 0($t0)
    li   $v0, 1
    syscall

    li   $v0, 4
    la   $a0, msg_nl
    syscall

    addi $s0, $s0, 1
    j    loop_tabla
fin_tabla:
    lw   $s0, 4($sp)
    lw   $ra, 0($sp)
    addiu $sp, $sp, 8
    jr   $ra


# ============================================================
#  bubble_sort: ordena arreglos paralelos por PTS desc, DG desc
# ============================================================
bubble_sort:
    addiu $sp, $sp, -12
    sw    $ra, 0($sp)
    sw    $s0, 4($sp)
    sw    $s1, 8($sp)

    li   $s0, 4
outer_loop:
    addi $s0, $s0, -1
    beq  $s0, $zero, fin_sort

    li   $s1, 0
inner_loop:
    beq  $s1, $s0, end_inner

    la   $t0, pts
    sll  $t1, $s1, 2
    add  $t1, $t0, $t1
    lw   $t2, 0($t1)                   # pts[j]
    lw   $t3, 4($t1)                   # pts[j+1]

    slt  $t4, $t3, $t2                 # 1 si pts[j] > pts[j+1]
    bne  $t4, $zero, no_swap

    slt  $t4, $t2, $t3                 # 1 si pts[j] < pts[j+1]
    bne  $t4, $zero, do_swap

    # Empate en puntos: comparar DG
    la   $t0, gf
    sll  $t4, $s1, 2
    add  $t4, $t0, $t4
    lw   $t4, 0($t4)
    la   $t0, gc
    sll  $t5, $s1, 2
    add  $t5, $t0, $t5
    lw   $t5, 0($t5)
    sub  $t4, $t4, $t5                 # DG[j]

    addi $t6, $s1, 1
    la   $t0, gf
    sll  $t6, $t6, 2
    add  $t0, $t0, $t6
    lw   $t6, 0($t0)
    addi $t7, $s1, 1
    la   $t0, gc
    sll  $t7, $t7, 2
    add  $t0, $t0, $t7
    lw   $t7, 0($t0)
    sub  $t6, $t6, $t7                 # DG[j+1]

    slt  $t0, $t4, $t6                 # 1 si DG[j] < DG[j+1]
    beq  $t0, $zero, no_swap

do_swap:
    move $a0, $s1
    jal  intercambiar

no_swap:
    addi $s1, $s1, 1
    j    inner_loop

end_inner:
    j    outer_loop

fin_sort:
    lw   $s0, 4($sp)
    lw   $s1, 8($sp)
    lw   $ra, 0($sp)
    addiu $sp, $sp, 12
    jr   $ra


# ============================================================
#  intercambiar: swap de posicion $a0 y $a0+1 en los 4 arreglos
#  Funcion hoja
# ============================================================
intercambiar:
    sll  $t0, $a0, 2
    addi $t1, $a0, 1
    sll  $t1, $t1, 2

    la   $t2, seleccion
    add  $t3, $t2, $t0
    add  $t4, $t2, $t1
    lw   $t5, 0($t3)
    lw   $t6, 0($t4)
    sw   $t6, 0($t3)
    sw   $t5, 0($t4)

    la   $t2, gf
    add  $t3, $t2, $t0
    add  $t4, $t2, $t1
    lw   $t5, 0($t3)
    lw   $t6, 0($t4)
    sw   $t6, 0($t3)
    sw   $t5, 0($t4)

    la   $t2, gc
    add  $t3, $t2, $t0
    add  $t4, $t2, $t1
    lw   $t5, 0($t3)
    lw   $t6, 0($t4)
    sw   $t6, 0($t3)
    sw   $t5, 0($t4)

    la   $t2, pts
    add  $t3, $t2, $t0
    add  $t4, $t2, $t1
    lw   $t5, 0($t3)
    lw   $t6, 0($t4)
    sw   $t6, 0($t3)
    sw   $t5, 0($t4)

    jr   $ra
