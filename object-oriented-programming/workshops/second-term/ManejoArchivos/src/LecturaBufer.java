import java.io.*;
public class LecturaBufer {
    public static void main(String[] args) {
        try {
            FileReader archivo = new FileReader("ManejoArchivos\\Informacion.txt");
            BufferedReader buferLectura = new BufferedReader(archivo); // Bufer para lectura
            
            String linea;
            while((linea = buferLectura.readLine())!= null){
                System.out.println(linea);
            }
            buferLectura.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Archivo no Existe");
        }
        System.out.println("Programa Finalizado");

    }
}
