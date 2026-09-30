
// Clase abstracta Vehiculo con atributos marca, placa y color, y un método abstracto encender().
public abstract class Vehiculo <T>{
// Atributos protegidos para que las clases hijas puedan acceder a ellos
protected String marca;
protected String placa;
protected String color;

// Constructor para inicializar los atributos de la clase Vehiculo
public Vehiculo(String marca, String placa, String color) {
    this.marca = marca;
    this.placa = placa;
    this.color = color;
}

// Método abstracto que debe ser implementado por las clases hijas para encender el vehículo
public abstract void encender();

// Método estático para mostrar los datos del vehículo (MARCA, PLACA y COLOR)
public static void mostrarDatos(Vehiculo v){
    System.out.println("Marca: " + v.marca);
    System.out.println("Placa: " + v.placa);
    System.out.println("Color: " + v.color);
}
}