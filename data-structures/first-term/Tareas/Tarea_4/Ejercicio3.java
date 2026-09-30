package Tarea_4;
import java.util.*;


public class Ejercicio3 {
    public static void main(String[]args){
        int [] Areglo={2, 4, 4, 4, 6, 8, 10};
        // Pedimos ingresar un número a buscar
        Scanner teclado = new Scanner(System.in); 
        System.out.print("Ingrese un numero a buscar: "); // usamos print para q salga lo que escribimos a lado
        int numero = teclado.nextInt();
        // cerramos el scanner
        teclado.close();
        ///Busqueda del primer indice////
        //Creamos la busqueda binaria
        int posinicio = 0; //posicion inicial
        int posfin = Areglo.length - 1;   //posicion final
        int primerIndice = -1; // la posición del primer número encontrado

       while (posinicio <= posfin) {
            int mitad = (posinicio + posfin) / 2;
            // Caso q si encontramos el numero
            if (Areglo[mitad] == numero) {
                primerIndice = mitad;
                // Forzamos el fin del ciclo modificando los índices lógicamente
                posfin = mitad - 1; 
            }
            // Si el número es menor  al elemento en la posicion n=mitad, descartamos la derecha
            else if (numero < Areglo[mitad]) {
                posfin = mitad - 1;
            }
            // Si el número es mayor al elemento en la posicion n=mitad, descartamos la izquierda
            else {
                posinicio = mitad + 1;
            }
        }
        ///Busqueda del ultimo indice///
        /// Reiniciamos los índices para la búsqueda del último índice
        posinicio=0; 
        posfin=Areglo.length-1; //
        int ultimoIndice=-1; // la posición del último número encontrado
            
        while (posinicio <= posfin) {
            int mitad = (posinicio + posfin) / 2;
            // Caso que si encontramos el ultimo numero
            if (Areglo[mitad] == numero) {
                ultimoIndice = mitad; // Guardamos la posición del último número encontrado
                // Forzamos el fin del ciclo modificando los índices lógicamente para seguir buscando
                posinicio = mitad + 1; 
            }
            else if (numero < Areglo[mitad]) {
                posfin = mitad - 1; // Descartamos la mitad derecha
            }
            else {
                posinicio = mitad + 1;  // Descartamos la mitad izquierda
            }
        }
        

        if (primerIndice != -1) {
            System.out.println("Primer índice de " + numero + ": " + primerIndice);
            System.out.println("Último índice de " + numero + ": " + ultimoIndice);
        } else {
            System.out.println("El número " + numero + " no se encuentra en el arreglo.");
        }
    }
}