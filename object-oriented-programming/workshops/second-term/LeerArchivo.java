import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
// Sección 2: Lectura de Archivos de Texto

public class LeerArchivo {
    public static void main(String[] args) {
        
        try {
            FileReader archivo = new FileReader("estudiantes.txt");
            BufferedReader buferLectura = new BufferedReader(archivo);

            System.out.println("--- Contenido del archivo ---");

            String linea;

            while ((linea = buferLectura.readLine()) != null) {
                System.out.println(linea);
            }

            buferLectura.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'estudiantes.txt' no existe.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar leer el archivo.");
        }

        System.out.println("-------------------------------------------");
        System.out.println("Programa Finalizado");
    }
}