import java.util.Scanner;

public class Ejercicio1 {
    
    public static void ejercicio1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();

        // a) Número total de caracteres
        System.out.println("a) Número total de caracteres: " + cadena.length());

        // b) Cadena repetida 10 veces
        int cantidad = 10;
        String repetida = " ";
        while (cantidad > 0) {
            repetida += cadena;
            cantidad -= 1;
        }
        // otra forma cadena.repeat(10)
        System.out.println("b) Cadena repetida 10 veces: " + repetida);

        // c) Primer carácter de la cadena
        if (cadena.length() > 0) {
            System.out.println("c) Primer carácter: " + cadena.charAt(0));
        } else {
            System.out.println("c) La cadena está vacía.");
        }

        // d) Tres primeros caracteres
        if (cadena.length() >= 3) {
            System.out.println("d) Tres primeros caracteres: " + cadena.substring(0, 3));
        } else {
            System.out.println("d) La cadena tiene menos de 3 caracteres: " + cadena);
        }

        // e) Tres últimos caracteres
        if (cadena.length() >= 3) {
            System.out.println("e) Tres últimos caracteres: " + cadena.substring(cadena.length() - 3));
        } else {
            System.out.println("e) La cadena tiene menos de 3 caracteres: " + cadena);
        }

        // f) Séptimo carácter si existe
        if (cadena.length() >= 7) {
            System.out.println("f) Séptimo carácter: " + cadena.charAt(6));
        } else {
            System.out.println("f) La cadena no tiene suficiente longitud (menos de 7)");
        }

        // g) Cadena sin primer y último caracteres
        if (cadena.length() >= 2) {
            System.out.println("g) Cadena sin primer y último caracteres: " + cadena.substring(1, cadena.length() - 1));
        } else {
            System.out.println("g) La cadena es demasiado corta para eliminar primer y último carácter.");
        }

        // h) Cadena en mayúsculas
        System.out.println("h) Cadena en mayúsculas: " + cadena.toUpperCase());

        // i) Cadena con 'a' reemplazada por 'e'
        System.out.println("i) Cadena con 'a' reemplazada por 'e': " + cadena.replace('a', 'e'));
    }

    public static void main(String[] args) {
        System.out.println("----Ejercicio1----");
        Ejercicio1.ejercicio1();
    }
}
