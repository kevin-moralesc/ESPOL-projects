package Tarea_4;
import java.util.*;


public class Ejercicio2 {
    public static void main(String[]args){
        int [] Areglo={1,3,5,7,9,11,13};
        // Pedimos ingresar un número a buscar
        Scanner teclado = new Scanner(System.in); 
        System.out.print("Ingrese un numero a buscar: "); // usamos print para q salga lo que escribimos a lado
        int numero = teclado.nextInt();
        // cerramos el scanner
        teclado.close();
        
        //Creamos la busqueda binaria
        int posinicio = 0; //posicion inicial
        int posfin = Areglo.length - 1;   //posicion final
        int posicionEncontrada = -1; // la posición del número encontrado
        int comparaciones=0; // contador de comparaciones

       while (posinicio <= posfin) {
            int mitad = (posinicio + posfin) / 2;
            comparaciones++; // incrementamos el contador de comparaciones por cada iteración del ciclo while
            // Caso de q si encontramos el numero
            if (Areglo[mitad] == numero) {
                posicionEncontrada = mitad; 
                // Forzamos el fin del ciclo modificando los índices lógicamente
                posinicio = posfin + 1; 
            }
            
            // Si el número es menor  al elemento en la posicion n=mitad, descartamos la derecha
            else {
                comparaciones++; // Sumamos porque la máquina va a evaluar el if
                if (numero < Areglo[mitad]) {
                    posfin = mitad - 1;
                }
            // Si el número es mayor al elemento en la posicion n=mitad, descartamos la izquierda
            else {
                posinicio = mitad + 1;
                }
            }
        }
        // si tenemos un numero q no entra al while solo validamos si  posicion encontrada es -1 o no
        if (posicionEncontrada != -1) {
            System.out.println("Valor buscado: " + numero);
            System.out.println("Comparaciones realizadas: " + comparaciones);
            System.out.println("Resultado: Elemento encontrado en el indice " + posicionEncontrada);

        } else {
            System.out.println("Valor buscado: " + numero);
            System.out.println("El número " + numero + " no se encuentra en el arreglo.");
            System.out.println("Comparaciones realizadas: " + comparaciones);

        }

    }
}
