/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante;

/**
 * Clase de prueba de la clase Estudiante
 * @author rociomera
 */
public class DemoEstudiante {
    public static void main(String[] arg){
        Estudiante est1 = new Estudiante("Rocio");
        est1.mostrarInformacion();
        Estudiante est2 = new Estudiante("Carlos");
        est2.mostrarInformacion();
        
        Estudiante.counter = 25;
        System.out.println(est1.counter);
        
        int maximo = Math.max(23, 45);
        
        //Estudiante.nombre = "carlos";
        
        
        //Estudiante.modificarCounter(5);
        //est1.mostrarInformacion(); //mostrar informacion de 
        //Estudiante.modificarNombre("Jose"); 
    }
}
