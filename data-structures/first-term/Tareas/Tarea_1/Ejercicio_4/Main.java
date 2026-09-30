public class Main {
    public static void main(String[] args) {
    // Crear instancias de Carro y Moto con sus respectivos atributos
    Carro<String> miCarro = new Carro<>("ABC-123", "Toyota","Rojo");
    Moto<String> miMoto = new Moto<>("XYZ-789", "Honda","Azul");
        
        // Encender los vehículos y mostrar sus datos utilizando el método mostrarDatos()
        miCarro.encender();
        miCarro.mostrarDatos(miCarro);
        System.out.println("----------------");
        miMoto.encender();            
        miMoto.mostrarDatos(miMoto);
    }
}
