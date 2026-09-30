import java.util.Scanner;

public class Ejercicio2 {

    public static void ejercicio2() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la primera cadena: ");
        String cadena1 = sc.nextLine();

        System.out.print("Introduce la segunda cadena: ");
        String cadena2 = sc.nextLine();

        // Comparación ignorando si tiene mayúsculas o minúsculas
        if (cadena1.equalsIgnoreCase(cadena2)) {
            System.out.println("Las cadenas son iguales.");
        } else {
            System.out.println("Las cadenas son diferentes.");
        }

    }

    public static void main(String[] args) {
        System.out.println("--- EJERCICIO 2 ---");
        Ejercicio2.ejercicio2();
    }
}
