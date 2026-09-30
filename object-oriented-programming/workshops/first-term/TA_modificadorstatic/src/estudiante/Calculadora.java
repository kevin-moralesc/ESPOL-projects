package estudiante;

public class Calculadora {

    // Método estático
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Método de instancia que llama al método estático
    public void realizarSuma(int a, int b) {
        int resultado = Calculadora.sumar(a, b);
        System.out.println("La suma de " + a + " y " + b + " es: " + resultado);
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.realizarSuma(8, 5);
    }
}
