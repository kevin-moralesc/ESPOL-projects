public class Calculation {
    public static int findMax(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        
        int max = arr[0]; // Corrección lógica: iniciar con el primer elemento
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}

