public class Fibonacci {
    
    // Método  para calcular el n-ésimo número de Fibonacci
    public static int fibonacciRecursivo(int n){
        if (n<=0){ // Caso F(0) = 0 
            return 0;
        }else if(n==1){ // Caso F(1) = 1
            return 1;
        } else { // Caso recursivo: F(n) = F(n-1) + F(n-2)
            return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
        }
    }
    
public static void main(String[] args){
    // Prueba con un valor negativo
    int resultado = fibonacciRecursivo(-1);
    // Prueba con un valor positivo
    int resultado2 = fibonacciRecursivo(6);
    int resultado3 = fibonacciRecursivo(2);
    System.out.println(resultado);
    System.out.println(resultado2);
    System.out.println(resultado3);
    }
}
