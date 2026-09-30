/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante;

/**
 * Clase que modela la informacion de un Estudiante
 * @author rociomera
 */
public class Estudiante {
    private String nombre; //variable de instancia, valor por defecto ""
    private int codigo; //variable de instancia, valor por defecto 0
    public static int counter; //variable de clase, todos los objetos de la clase Estudiante 
                                //comparten esta variable
    private static final double passGrade=6.0;
    
    /**
     * Constructor vacio
     */
    public Estudiante(){
    }
    
    /**
     * Constructor de la clase Estudiante
     * @param nombre : nombre del Estudiante
     */
    public Estudiante(String nombre){
        this.nombre = nombre;
        this.codigo = counter+1;
        counter++;
    }

    /**
     * Metodo que muestra los valores de las variables del objeto
     */
    public void mostrarInformacion(){
        System.out.println("Nombre = "+nombre);
        System.out.println("Codigo = "+codigo);
        System.out.println("Counter = "+counter);
    }
    
    
    public static void modificarCounter(int value){
        counter = value;
    }
    /*
    public static void modificarNombre(String nombre){
        this.nombre = nombre;
    }*/
    /*public void test1(){
        modificarCounter(0); 
    }*/
    /*public static void test2(){
        test1(); 
    } */
    /*public static void test3(){
        modificarCounter(0); 
    }*/
}
