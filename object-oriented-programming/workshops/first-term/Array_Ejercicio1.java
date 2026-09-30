import java.util.ArrayList;
import java.util.Scanner;

public class Array_Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        // Solicitar 10 números al usuario
        System.out.println("Ingrese 10 números enteros:");
        for (int j = 0; j < 10; j++) {
            System.out.print("Número " + (j + 1) + ": ");
            int num = sc.nextInt();
            numeros.add(num);
        }

        int suma = sumaPares(numeros);
        System.out.println("La suma de los números pares es: " + suma);
    }

    public static int sumaPares(ArrayList<Integer> lista) {
        int sum = 0;
        for (Integer i : lista) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
    // 1.- Ejemplos de Boxing
    // Al agregar un número int al ArrayList<Integer>, Java realiza boxing
    // automático:
    // int num = sc.nextInt();
    // numeros.add(num); // Boxing automático: int → Integer

    // También se podría hacer:
    // Integer numeroObjeto = Integer.valueOf(num);
    // numeros.add(numeroObjeto); // Boxing explícito

    // 2.- Ejemplos de Unboxing:
    // Al sumar los elementos Integer de la lista a una variable int, se realiza
    // unboxing:
    // sum += i; // Unboxing automático: Integer --> int

    // También se podría hacer:
    // sum += i.intValue(); // Unboxing explícito

}
