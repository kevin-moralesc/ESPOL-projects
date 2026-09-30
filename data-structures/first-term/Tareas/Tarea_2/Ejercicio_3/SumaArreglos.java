public class SumaArreglos {

public static int sumarArregloRecursivo(int[] arreglo, int indice) {
    if (indice >= arreglo.length) {
        return 0; // SI el indice supera el tamaño del arreglo, retorna 0
    }
    //indexamos el arreglos y llamamos la funcion recursiva con el siguiente indice

    return arreglo[indice] + sumarArregloRecursivo(arreglo, indice + 1); 
}

public static void main(String[] args) {
int[] numeros = {4, 7, 2, 9, 3};
// Llamamos a la función recursiva para sumar los elementos del arreglo
int resultado = sumarArregloRecursivo(numeros, 0); 
int resultado2= sumarArregloRecursivo(numeros,1);

System.out.println(resultado); // imprime 25
System.out.println(resultado2);// imprime 21
}    
}
