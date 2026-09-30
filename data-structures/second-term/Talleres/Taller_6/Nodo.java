package ESPOL.Estructura_Datos.SegundoParcial.Talleres.Taller_6;

public class Nodo {

    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}