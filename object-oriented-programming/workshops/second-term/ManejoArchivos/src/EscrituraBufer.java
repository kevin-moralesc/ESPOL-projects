import java.io.*;

public class EscrituraBufer {
    public static void main(String[] args) {
       try {
        FileWriter escritura = new FileWriter("EstudiantesAP.txt");
        BufferedWriter buferEscritura = new BufferedWriter(escritura);
        buferEscritura.write("Estudiantes aprobados: ");
        buferEscritura.newLine();
        buferEscritura.write("Ninguno");
        buferEscritura.newLine();
        buferEscritura.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
       }
    
    }
}
