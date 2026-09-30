import java.io.FileReader;
import java.io.IOException;

public class Lectura {
    public static void main(String[] args) {
        try {
            FileReader texto = new FileReader("Archivo.txt");
            int bandera;
            while((bandera = texto.read())!=-1){
                System.out.print((char)bandera);
            }
            texto.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Archivo no existe");
        }
        System.out.println("Programa Finalizado");
   
    }
}
