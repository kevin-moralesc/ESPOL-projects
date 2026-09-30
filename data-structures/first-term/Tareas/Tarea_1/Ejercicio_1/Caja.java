// Creamos la clase genérica Caja que puede recibir cualquier tipo de objeto <T>
public class Caja<T> {
    // Atributo privado para guardar el objeto, sea del tipo que sea
    private T contenido; 

    // Método set que sirve para guardar el objeto dentro de la caja
    public void set(T contenido) {      
        this.contenido = contenido;    
    }
    
    // Método get que sirve para recuperar o sacar el objeto guardado
    public T get() {
        return contenido;
    }
    
    // Método mostrarTipo que nos dice el nombre de la clase del objeto que esta en la caja
    public void mostrarTipo() {
        if (contenido != null) {
            System.out.println(contenido.getClass().getSimpleName());
        }     
    }
    
    // Bloque principal para probar que todo funciona
    public static void main(String[] args) {
        // Probando la caja con un tipo compuesto (String)
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.set("Hola Mundo");
        cajaTexto.mostrarTipo();

        // Probando la caja con un tipo primitivo usando su wrapper (Integer)
        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.set(42);
        cajaNumero.mostrarTipo();
    }
}