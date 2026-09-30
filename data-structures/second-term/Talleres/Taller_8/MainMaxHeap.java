public class MainMaxHeap {
    public static void main(String[] args) {

        int[] numeros = {15, 4, 21, 20, 1, 10, 3, 5, 9, 12, 6, 13, 2, 7, 11, 121, 77, 66, 55, 44, 33};
        
        // Creamos el MaxHeap con capacidad suficiente (21 o más)
        MaxHeap maxHeap = new MaxHeap(25);

        System.out.println("=== INSERTANDO DATOS EN MAXHEAP ===");
        //  Insertar e Imprimir tras cada inserción
        for (int num : numeros) {
            System.out.println("\nInsertando el número: " + num);
            maxHeap.insert(num);
            maxHeap.printHeap();
        }

        // Mostrar el máximo
        System.out.println("\n=== OBTENIENDO EL MÁXIMO ===");
        System.out.println("El elemento máximo en la raíz es: " + maxHeap.getMax());

        // Extraer todos los elementos hasta vaciarlo
        System.out.println("\n=== VACIANDO EL MAXHEAP ===");
        while (!maxHeap.isEmpty()) {
            System.out.println("Extrayendo el máximo: " + maxHeap.extractMax());
        }
        System.out.println("El MaxHeap ha sido vaciado exitosamente.");
    }
}