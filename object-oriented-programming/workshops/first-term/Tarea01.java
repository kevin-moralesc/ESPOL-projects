public class Tarea01 {
    public static void main(String[] args) {
        int horadada = 1000;
        Tarea01 resultado = new Tarea01();
        resultado.horasTotales(horadada);

        Tarea01 precios = new Tarea01();
        precios.calcularPrecio(450, 5 );
    }

    // Tarea Practica 1
    // Construir un programa que, dado un número total de horas, devuelva el número
    // de
    // semanas, días y horas equivalentes. Para probar el funcionamiento de su
    // código utilice una
    // variable para las horas con un valor de 1000, el programa debe mostrar 5
    // semanas, 6 días y
    // 16 horas.
    void horasTotales(int horadada) {

        System.out.println("Hora dada:" + horadada);
        int semanas = horadada / 168;
        int dias = (horadada % 168) / 24;
        int horas = ((horadada % 168) % 24);

        System.out.println("En " + horadada + " horas hay " + semanas + " semanas, " + dias + " días y " + horas
                + " horas." + "\n" + "-------------------");

    }

    // Tarea Practica 2
    // Una línea de autobuses cobra un mínimo de $20 por persona y trayecto. Si el
    // trayecto es mayor
    // de 200 km el ticket tiene un recargo de 0.10 por km adicional. Sin embargo,
    // para trayectos de más
    // de 400 km el ticket tiene un descuento del 15 %. Por otro lado, para grupos
    // de 3 o más personas
    // el billete tiene un descuento del 10 %. Con las consideraciones anteriores,
    // escriba en Java un
    // programa que recibe por parámetros la distancia del viaje a realizar, así
    // como el número de
    // personas que viajan juntas. Con ello se debe calcular tanto el precio del
    // billete individual como el
    // total a pagar si viaja más de una persona.

    void calcularPrecio(int distancia, int nPersonas) {
        System.out.println("Distancia del viaje: " + distancia + " km" + "\n" + "Número de personas: " + nPersonas);
        double precioindividual = 20.0;
        if (distancia > 200) {
            precioindividual += (distancia - 200) * 0.10;
        }
        if (distancia > 400) {
            precioindividual -= precioindividual * 0.15;
        }
        double precioTotal = precioindividual * nPersonas;
        if (nPersonas >= 3) {
            precioTotal -= precioTotal * 0.10;

        }

        System.out.println("El precio individual es: " + precioindividual);
        System.out.println("El precio total es: " + precioTotal);
    }

}
