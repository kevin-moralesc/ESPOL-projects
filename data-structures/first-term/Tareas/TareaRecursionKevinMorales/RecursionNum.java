
public class RecursionNum {
    
// Método recursivo para sumar los dígitos de un número entero
public static int SumarDigitos (int n){ 
// caso si n es igual a 0 es 0
if (n==0){
    return 0;
}
else{
    return (n%10) + SumarDigitos(n/10); // El operador % obtiene el último dígito de n
                                        // y el operador / elimina el último dígito de n
}
}

public static void main(String[] args) {
    int n=135;
    int n2=67;
    int n3=1111;
    int n4=4;
   System.out.println("La suma de los dígitos de " + n + " es: " + SumarDigitos(n));
   System.out.println("La suma de los dígitos de " + n2 + " es: " + SumarDigitos(n2));
   System.out.println("La suma de los dígitos de " + n3 + " es: " + SumarDigitos(n3));
   System.out.println("La suma de los dígitos de " + n4 + " es: " + SumarDigitos(n4));
}
}