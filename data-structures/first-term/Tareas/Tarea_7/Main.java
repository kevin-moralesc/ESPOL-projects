import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Creamos la lista
        Listaimplemente<Persona> lista = new Listaimplemente<>();

        // Agregamos a 10 personas
        lista.agregar(new Persona("Alejandro", 25, "Guayaquil"));
        lista.agregar(new Persona("Maria", 17, "Quito"));
        lista.agregar(new Persona("Carlos", 19, "Cuenca"));
        lista.agregar(new Persona("Ana", 15, "Guayaquil"));
        lista.agregar(new Persona("Juan", 30, "Manta"));
        lista.agregar(new Persona("Sofia", 16, "Quito"));
        lista.agregar(new Persona("Luis", 42, "Cuenca"));
        lista.agregar(new Persona("Diana", 12, "Loja"));
        lista.agregar(new Persona("Pedro", 22, "Guayaquil"));
        lista.agregar(new Persona("Laura", 28, "Manta"));

        // Creamos los comparadores
        ComparadorCompleto compCompleto = new ComparadorCompleto();
        ComparadorEdad compEdad = new ComparadorEdad();

        System.out.println("---Prueba: Buscar Persona de forma exacta----");
        Persona moldeBuscar = new Persona("Carlos", 19, "Cuenca");
        Persona clonEncontrado = lista.find(compCompleto, moldeBuscar);
        System.out.println("Resultado: " + clonEncontrado);

        System.out.println("\n---Prueba: Filtro Primer Menor de Edad---");
        // Pasamos null en el segundo parámetro porque este comparador no necesita un molde, solo evalúa los de la lista
        Persona primeraMenor = lista.find(compEdad, null);
        System.out.println("Resultado: " + primeraMenor);

        System.out.println("\n---findAll (Todos los menores de edad) ---");
        Listaimplemente<Persona> todosLosMenores = lista.findAll(compEdad, null);
        
        // Recorremos la lista resultante usando el iterador de forma limpia
        Iterator<Persona> it = todosLosMenores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}