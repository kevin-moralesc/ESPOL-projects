from conexion import conectar
import mysql.connector

# CREATE
def crear_cliente(nombre, apellido, correo, ciudad):
    conexion = conectar()
    cursor = conexion.cursor()
    # Verificar correo repetido
    cursor.execute("Select count(*) from cliente where correo=%s", (correo,))
    if cursor.fetchone()[0] > 0:
        cursor.close()
        conexion.close()
        return False

    sql = """
    Insert into cliente(nombre, apellido, correo, ciudad, fecha_registro)
    VALUES (%s, %s, %s, %s, DATE(NOW()))
    """
    cursor.execute(sql, (nombre, apellido, correo, ciudad))
    conexion.commit()

    cursor.close()
    conexion.close()
    return True


# READ
def obtener_clientes():
    conexion = conectar()
    cursor = conexion.cursor()

    cursor.execute("""
        SELECT
            id_cliente,
            nombre,
            apellido,
            correo,
            creditos,
            fecha_registro,
            reputacion,
            ciudad
        FROM Cliente
        ORDER BY id_cliente
    """)

    datos = cursor.fetchall()
    cursor.close()
    conexion.close()
    return datos

# UPDATE
def actualizar_cliente(id_cliente, nombre, apellido, correo, ciudad):
    conexion = conectar()
    cursor = conexion.cursor()

    sql = """
    UPDATE Cliente
    SET nombre=%s,
        apellido=%s,
        correo=%s,
        ciudad=%s
    WHERE id_cliente=%s
    """
    cursor.execute(sql, (nombre, apellido, correo, ciudad, id_cliente))
    conexion.commit()

    cursor.close()
    conexion.close()


# DELETE
def eliminar_cliente(id_cliente):
    conexion = conectar()
    cursor = conexion.cursor()

    try:
        cursor.execute(
            "DELETE FROM Cliente WHERE id_cliente=%s",
            (id_cliente,)
        )
        conexion.commit()
        return True

    except mysql.connector.IntegrityError:
        # Tiene tutorías asociadas
        return False

    finally:
        cursor.close()
        conexion.close()
