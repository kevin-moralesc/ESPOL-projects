public class MainAdapterAOP {
    public static void main(String[] args) {
        System.out.println("--- Uso de Patrón Diseño Adapter AOP ---");
    
        ServicioMapas appMapas = new ServiciosMapasImpl();
        
        appMapas.calcularRuta("Calle A", "Av. Principal");
    }
}
