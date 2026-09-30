import java.util.Scanner;

public class Ejercicio4 {

    // Método para encriptar
    public static String encriptar(String texto) {
        String pares = "";
        String impares = "";

        for (int i = 0; i < texto.length(); i++) {
            if (i % 2 == 0) {
                pares += texto.charAt(i); // índices pares
            } else {
                impares += texto.charAt(i); // índices impares
            }
        }

        return pares + impares;
    }

    // Método para desencriptar
    public static String desencriptar(String encriptado) {
        int longitud = encriptado.length();
        int mitad = (longitud + 1) / 2;

        String pares = encriptado.substring(0, mitad);
        String impares = encriptado.substring(mitad);

        String original = "";

        for (int i = 0; i < encriptado.length(); i++) {
            if (i % 2 == 0) {
                original += pares.charAt(i / 2);
            } else {
                original += impares.charAt(i / 2);
            }
        }

        return original;
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- EJERCICIO 4 ---");
        System.out.println("1. Encriptar mensaje");
        System.out.println("2. Desencriptar mensaje");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            System.out.print("Ingresa el mensaje a encriptar: ");
            String texto = sc.nextLine();
            String resultado = encriptar(texto);
            System.out.println("Mensaje encriptado: " + resultado);
        } else if (opcion == 2) {
            System.out.print("Ingresa el mensaje encriptado: ");
            String texto = sc.nextLine();
            String resultado = desencriptar(texto);
            System.out.println("Mensaje desencriptado: " + resultado);
        } else {
            System.out.println("Opción no válida."); // cuando no escoge 1 o 2

        }

    }
}
