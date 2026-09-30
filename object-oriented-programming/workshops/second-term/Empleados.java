import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Empleados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("empleados.txt", true))) {

            System.out.print("Ingrese cédula (0 para salir): ");
            String cedula = sc.nextLine();

            while (!cedula.equals("0")) {
                boolean cedulaValida = true;
                try {
                    Long.parseLong(cedula);
                } catch (NumberFormatException e) {
                    System.out.println("Error: la cédula debe ser numérica.");
                    cedulaValida = false;
                }

                if (cedulaValida) {
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    double sueldo = 0;
                    boolean sueldoValido = true;
                    try {
                        System.out.print("Ingrese sueldo: ");
                        sueldo = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: el sueldo debe ser un número.");
                        sueldoValido = false;
                    }

                    if (sueldoValido) {
                        System.out.println("----- EMPLEADO -----");
                        System.out.println("Cédula: " + cedula);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Sueldo: " + sueldo);
                        System.out.println("--------------------");
                        escritor.write(cedula + "," + nombre + "," + sueldo);
                        escritor.newLine();
                    }
                }

                System.out.print("Ingrese cédula (0 para salir): ");
                cedula = sc.nextLine();
            }

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
        }

        sc.close();
    }
}
