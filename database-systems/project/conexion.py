import mysql.connector

def conectar():
    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="Kjmc1905**",
        database="timeskill"
    )
