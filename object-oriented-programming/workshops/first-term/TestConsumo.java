import Seccion3.Vehiculo;

public class TestConsumo {
    public static void main(String[] args) {
        // Vehiculo v = new Electrico();
        Vehiculo v= new Electrico();
        System.out.println(
            // ¿Cuál sería la salida para cada línea si se ejecuta por separado?
// 
            //   v.calcularConsumo(200, 20)
            //  v.calcularConsumo(100)
            ((Electrico) v).calcularConsumo("eléctrico")
            //  v.calcularConsumo("eléctrico")
        );
    }
}
