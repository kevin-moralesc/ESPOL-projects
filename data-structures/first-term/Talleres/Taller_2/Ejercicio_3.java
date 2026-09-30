import java.util.LinkedHashMap;

import java.util.Map;

public class Ejercicio_3 {
    
public static void main(String[] args) {

// Cree un programa que reciba una frase y cuente cuántas veces aparece cada palabra.
// Para este ejercicio debe usar un Map<String, Integer>.

// Ejemplo de entrada
// java es facil java es util

// Resultado esperado
// java aparece 2 veces
// es aparece 2 veces
// facil aparece 1 vez
// util aparece 1 vez
// Requerimientos
// Separar la frase en palabras.
// Usar un mapa para contar la frecuencia de cada palabra.
// Usar getOrDefault() o una validación equivalente.
// Mostrar cada palabra con su frecuencia.
String frase = "java es facil java es util";
Map<String, Integer> frPalabras = new LinkedHashMap<>();

String[] palabras = frase.split(" ");
for (String palabra : palabras) {
    frPalabras.put(palabra, frPalabras.getOrDefault(palabra, 0) + 1);
}
for (Map.Entry<String, Integer> palabra : frPalabras.entrySet()) {
    if (palabra.getValue() == 1) {
        System.out.println(palabra.getKey() + " aparece " + palabra.getValue() + " vez");
    } else {
    System.out.println(palabra.getKey() + " aparece " + palabra.getValue() + " veces");
}
}   }}