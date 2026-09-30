
// Clase genérica Triple que puede almacenar tres objetos de tipos diferentes
public class Triple<S, U, V> {
// Atributos para almacenar los tres objetos
private S primero;
private U segundo;
private V tercero;

// Constructor para inicializar los tres objetos
public Triple(S primero, U segundo, V tercero) {
    this.primero = primero;
    this.segundo = segundo;
    this.tercero = tercero;
}

// Métodos para obtener cada uno de los objetos almacenados
public S getS() {
    return primero;
}
public U getU() {
    return segundo;
}
public V getV() {
    return tercero;
}

public static void main(String[] args) {
// Ejemplo de uso de la clase Triple
Triple<String, Integer, Double> miTriple = new Triple<>("Hola", 42, 3.14);
System.out.println("S: " + miTriple.getS()); // Imprime: Hola
System.out.println("U: " + miTriple.getU()); // Imprime: 42
System.out.println("V: " + miTriple.getV()); // Imprime: 3.14

}}