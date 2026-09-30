import java.util.Scanner;

public class Ejercicio3 {

    public static void ejercicio3() {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas direcciones de correo electrónico vas a ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        String[] correos = new String[cantidad];
        int contadorAlumnos = 0;
        int contadorProfesores = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce el correo #" + (i + 1) + ": ");
            correos[i] = sc.nextLine().toLowerCase();
        }

        for (String correo : correos) {
            if (correo.endsWith("@student.college.edu")) {
                contadorAlumnos++;
            } else if (correo.endsWith("@prof.college.edu")) {
                contadorProfesores++;
            } else {
                System.out.println("Correo no reconocido:" + correo);
            }
        }

        System.out.println("---RESULTADOS---");
        System.out.println("Total de correos de estudiantes: " + contadorAlumnos);
        System.out.println("Total de correos de profesores: " + contadorProfesores);

    }

    public static void main(String[] args) {
        System.out.println("--- EJERCICIO 3 ---");
        Ejercicio3.ejercicio3();
    }
}
