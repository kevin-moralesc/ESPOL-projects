public class Taller_Array_parte2 {
    public static void main(String[] args) {
        int[][] matriz1 = new int[3][3];
        int[][] matriz2 = new int[3][3];

        int[] dato1 = { 2, 4, 0, 6, 2, 3, 5, 2, 1 };
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz1[i][j] = dato1[k++];
            }
        }

        int[] dato2 = { 1, 1, 2, 2, 1, 1, 1, 2, 1 };
        k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz2[i][j] = dato2[k++];
            }
        }

        System.out.println("Resultado:");
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int resultado = matriz1[i][j] * matriz2[i][j];
                System.out.println("R" + count + ": " + resultado);
                count++;
            }
        }

    }
}
