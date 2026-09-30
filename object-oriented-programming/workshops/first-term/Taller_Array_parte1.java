import java.util.Scanner;

public class Taller_Array_parte1 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        System.out.println(numeros);
        System.out.println("La longitud del arreglo es: " + numeros.length);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrse valor " + (i + 1) + ":");
            numeros[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int k = 0; k < numeros.length; k++) {
            if (numeros[k] > 5) {
                numeros[k] = 100;
            }
        }
        for (int j = 0; j < numeros.length; j++) {
            System.out.println("Areglo en la posicion" + (j + 1) + "es:" + numeros[j]);
        }
    }
}
