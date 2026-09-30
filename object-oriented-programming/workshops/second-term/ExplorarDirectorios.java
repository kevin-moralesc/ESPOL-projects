import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Sección 5: Exploración y Manejo de Directorios
public class ExplorarDirectorios {

    public static void main(String[] args) {
        Path directorioProyecto = Paths.get("proyecto");
        Path archivoDatos = directorioProyecto.resolve("datos.txt");
        Path archivoLogs = directorioProyecto.resolve("logs.txt");

        try {
            if (Files.notExists(directorioProyecto)) {
                Files.createDirectory(directorioProyecto);
                System.out.println("Directorio 'proyecto' creado satisfactoriamente.");
            }

            escribirEnArchivo(archivoDatos, obtenerContenidoDatos());
            escribirEnArchivo(archivoLogs, obtenerContenidoLogs());

            System.out.println("\n--- Listado de archivos ---");
            try (Stream<Path> flujo = Files.list(directorioProyecto)) {
                flujo.map(Path::getFileName)
                     .forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println("Ha ocurrido un error en la manipulación de archivos: " + e.getMessage());
        }
    }

    private static void escribirEnArchivo(Path ruta, String contenido) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(ruta)) {
            writer.write(contenido);
            System.out.println("Archivo escrito con éxito: " + ruta.getFileName());
        }
    }

    private static String obtenerContenidoDatos() {
        return "# Información de usuarios\n" +
               "ID: 1, Nombre: Juan Pérez, Edad: 30\n" +
               "ID: 2, Nombre: María Gómez, Edad: 25\n" +
               "ID: 3, Nombre: Pedro Ruiz, Edad: 35\n" +
               "ID: 4, Nombre: Ana López, Edad: 28";
    }

    private static String obtenerContenidoLogs() {
        return "[INFO] 2024-12-18 10:00:01 - Directorio 'proyecto' creado exitosamente.\n" +
               "[INFO] 2024-12-18 10:00:02 - Archivo 'datos.txt' creado y escrito.\n" +
               "[INFO] 2024-12-18 10:00:06 - Programa finalizado correctamente.";
    }
}