package POO.GestionNotas.GestionNotas.src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorNotas {
    
    //Implemente Método que valida que la nota ingresada sea de tipo numérico (no cadena)
    
    //Implemente Método que valida la nota ingresada del estudiante se encuentre entre 0 y 10.
    public static void validarNota(double nota) throws NotaInvalidaException {
        if (nota < 0 || nota > 10) {
            throw new NotaInvalidaException("La nota debe estar entre 0 y 10.");
        }
    }

    //Implemente Método que guarda la información en el archivo "notas.txt".
    public static void guardarEnArchivo(String nombre, double nota)throws IOException {
        FileWriter writer = new FileWriter("notas.txt", true);
        writer.write(nombre + " - Nota: " + nota + "\n");
        writer.close();
    }

    //Metodo principal de la clase
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        Double inputNota;

        System.out.println("SISTEMA DE REGISTRO DE NOTAS");

        
        try {
            // Solicitar nombre
            System.out.print("Nombre: ");
            nombre = sc.nextLine().trim();

            // Solicitar nota
            System.out.print("Nota: ");
            inputNota = sc.nextDouble();

            // Validar rango de nota
            validarNota(inputNota);

            // Guardar en archivo
            guardarEnArchivo(nombre, inputNota);

            System.out.println("Nota registrada correctamente.");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: La nota ingresada no es un número.");

        } catch (NotaInvalidaException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");

        } finally {
            sc.close();
        }
    }
}


