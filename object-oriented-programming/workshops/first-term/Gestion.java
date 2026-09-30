public class Gestion {
     public static void main(String[] args) {
         Biblioteca.totalLibros = 500;   //totallibros es privado
        Biblioteca.agregarLibro();
         System.out.println("Total libros: " + Biblioteca.getTotalLibros());  // no es statico
         Biblioteca.setNombre("Central");
         System.out.println("Nombre: " + Biblioteca.nombre);//
     }
 }
