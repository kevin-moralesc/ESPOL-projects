public class Biblioteca {
     private String nombre;
     private static int totalLibros;

     public static void setNombre(String nombre) {  
         this.nombre = nombre;                      //errror this en metodo estatico
     }

     public static void agregarLibro() {
         totalLibros++;
     }

     public int getTotalLibros() {
         return totalLibros;
     }
 }

