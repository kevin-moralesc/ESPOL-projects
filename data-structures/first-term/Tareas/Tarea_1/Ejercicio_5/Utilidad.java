
import java.util.*;

public class Utilidad {
// Método genérico para sumar elementos de una lista de números
public static Number sumarElementos(List<? extends Number> lista) {
        double suma = 0.0;
        
        for (Number numero : lista) {
            suma += numero.doubleValue(); // Convertir a double para sumar correctamente
        }
        if (suma % 1 == 0) {   // Validar si suma es un entero 
            return (int) suma; 
        } else {
            return suma; 
        }
    }





public static void main (String[]args){
// Ejemplo de uso
List<Integer> listaEnteros = Arrays.asList(1, 2, 3);
System.out.println(Utilidad.sumarElementos(listaEnteros));
// Ejemplo con números decimales
List<Double> listaDoubles = Arrays.asList(1.1, 2.2, 3.3);
System.out.println(Utilidad.sumarElementos(listaDoubles)); 

}
    
}
