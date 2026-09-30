import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


//Sección 3: Escritura y Lectura de Archivos Binarios

public class CopiarArchivoBinario {

    public static void main(String[] args) {
        String origen = "LeonKennedy.jpg";
        String destino = "copia_LeonKennedy.jpg";
        try {
            FileInputStream entrada = new FileInputStream(origen);
            FileOutputStream salida = new FileOutputStream(destino);

            int byteLeido;
            System.out.println("Iniciando copia del archivo: " + origen + "...");

            while ((byteLeido = entrada.read()) != -1) {
                salida.write(byteLeido);
            }

            entrada.close();
            salida.close();

            System.out.println("El archivo fue copiado correctamente como '" + destino + "'.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo de origen '" + origen + "' no existe.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error técnico durante el proceso de copiado.");
        }

        System.out.println("Programa Finalizado.");
    }
}