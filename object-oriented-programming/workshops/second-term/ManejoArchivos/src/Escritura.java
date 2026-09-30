import java.io.*;
public class Escritura {
    public static void main(String[] args) {
        try {
            FileWriter escritura = new FileWriter("ArchivoLivi.txt",true);
            //escritura.write("Esta es una prueba de escritura\n");
            //escritura.write("Esta es la segunda linea\n");
            escritura.write("Escuela Superior Politécnica del Litoral\n"+
                "Nombre: Livington Miranda\n"+
                "Matricula: 2009138595\n"+
                "Materia: Programación Orientada a Objetos\n");
            escritura.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }

    }
}
