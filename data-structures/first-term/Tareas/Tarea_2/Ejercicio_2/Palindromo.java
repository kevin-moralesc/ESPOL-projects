import java.util.*;
public class Palindromo {

public static boolean esPalindromoRecursivo(String frase) {
    //  Limpiamos la cadena: convertir a minúsculas, eliminar espacios y acentos
        String cadenaLimpia = frase.toLowerCase().replace('á', 'a').replace('é', 'e').replace('í', 'i')
        .replace('ó', 'o')
        .replace('ú', 'u')
        .replace(" ", "")
        .replace("ñ","n")
        // .replaceAll("[^a-z0-9]", "") indica q debe remplazar todo lo q NO(^) sea a-z o 0-9 por ""
        .replaceAll("[^a-z0-9]", ""); // Elimina espacios, comas, puntos, etc. 


         //  Si la cadena se quedó con una letra entonces es un palíndromo
        if (cadenaLimpia.length() <= 1) {
            return true;
        }
        //Caso contrario, hay q evualuar la primera y la última letra utilizando recursividad
        //Obtenemos la primera y la última letra
        char primeraLetra = cadenaLimpia.charAt(0); 
        char ultimaLetra = cadenaLimpia.charAt(cadenaLimpia.length() - 1);
        //comparamos si ambas letras son iguales y si no lo son entonces no es Palidromo
        if (primeraLetra != ultimaLetra) {
            return false;
        }
        // Si son iguales omite el if y avanza y recortamos la cadena para evaluar el siguiente par de letras
        String subCadena = cadenaLimpia.substring(1, cadenaLimpia.length() - 1);
        //Utilizamos recursividad para evaluar la subcadena        
        return esPalindromoRecursivo(subCadena);
    }


public static void main(String[]args){
boolean resultado = esPalindromoRecursivo("Anita lava ,la tina");
boolean resultado2 = esPalindromoRecursivo("Adán no calla con nada");
boolean resultado3 = esPalindromoRecursivo("oso");

System.out.println(resultado);
System.out.println(resultado2);
System.out.println(resultado3);
}}