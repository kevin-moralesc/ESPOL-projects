import java.io.*;
// Sección 4: Procesamiento de Datos desde un Archivo
public class ProcesarDatos {
    public static void main(String[] args) {
        String archivoEntrada = "Calificaciones.txt";
        String archivoSalida = "resultados.txt";

        double suma = 0;
        int contador = 0;
        
        String mejorEstudiante = "";
        int notaMax = Integer.MIN_VALUE;
        
        String peorEstudiante = "";
        int notaMin = Integer.MAX_VALUE;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            String linea;

            while ((linea = lector.readLine()) != null) {

               String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int calificacion = Integer.parseInt(partes[1].trim());
                    suma += calificacion;
                    contador++;

                    if (calificacion > notaMax) {
                        notaMax = calificacion;
                        mejorEstudiante = nombre;
                    }

                    if (calificacion < notaMin) {
                        notaMin = calificacion;
                        peorEstudiante = nombre;
                    }
                }
            }
            lector.close();

            if (contador > 0) {
                double promedio = suma / contador;

                BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));
                
                escritor.write("Resultados del análisis de calificaciones:");
                escritor.newLine();
                escritor.write("Promedio de calificaciones: " + String.format("%.2f", promedio));
                escritor.newLine();
                escritor.write("Estudiante con la calificación más alta:");
                escritor.newLine();
                escritor.write("Nombre: " + mejorEstudiante);
                escritor.newLine();
                escritor.write("Calificación: " + notaMax);
                escritor.newLine();
                escritor.newLine();
                escritor.write("Estudiante con la calificación más baja:");
                escritor.newLine();
                escritor.write("Nombre: " + peorEstudiante);
                escritor.newLine();
                escritor.write("Calificación: " + notaMin);
                
                escritor.close();
                System.out.println("Análisis completado. Resultados guardados en " + archivoSalida);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo " + archivoEntrada);
        } catch (IOException e) {
            System.out.println("Error al procesar los datos.");
        } catch (NumberFormatException e) {
            System.out.println("Error: El formato de las calificaciones no es válido.");
        }
    }
}