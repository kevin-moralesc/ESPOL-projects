import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//Sección 1: Escritura de Archivos de Texto.

public class EscribirArchivo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- Registro de datos ---");
        System.out.print("Ingrese nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese el identificación: ");
        String identificacion = teclado.nextLine();

        System.out.print("Ingrese nombre de curso: ");
        String curso = teclado.nextLine();

        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            
            escritor.write("Nombre: " + nombre);
            escritor.newLine();
            escritor.write("Identificación: " + identificacion);
            escritor.newLine();
            escritor.write("Curso: " + curso);

            System.out.println("\nÉxito: Los datos se han guardado correctamente en 'estudiantes.txt'.");
            teclado.close();

        } catch (IOException e) {
        } 
            }
}