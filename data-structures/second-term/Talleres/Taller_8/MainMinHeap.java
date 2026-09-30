public class MainMinHeap {
    public static void main(String[] args) {

        int[] numeros = {15, 4, 21, 20, 1, 10, 3, 5, 9, 12, 6, 13, 2, 7, 11, 121, 77, 66, 55, 44, 33};
        
        // Creamos el MinHeap con capacidad suficiente (21 o más)
        MinHeap minHeap = new MinHeap(25);

        System.out.println("=== INSERTANDO DATOS EN MINHEAP ===");
        // Insertar e Imprimir tras cada inserción
        for (int num : numeros) {
            System.out.println("\nInsertando el número: " + num);
            minHeap.insert(num);
            minHeap.printHeap();
        }

        // Mostrar el mínimo
        System.out.println("\n=== OBTENIENDO EL MÍNIMO ===");
        System.out.println("El elemento mínimo en la raíz es: " + minHeap.getMin());

        //  Extraer todos los elementos hasta vaciarlo
        System.out.println("\n=== VACIANDO EL MINHEAP ===");
        while (!minHeap.isEmpty()) {
            System.out.println("Extrayendo el mínimo: " + minHeap.extractMin());
        }
        System.out.println("El MinHeap ha sido vaciado exitosamente.");
    }
}