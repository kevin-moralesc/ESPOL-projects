public class SimularBatalla {
    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon("Squirtle", "Agua", 143, 600, 1);
        pokemon1.mostrarInformacion();

        Pokemon pokemon2 = new Pokemon("Charmander", "Fuego", 122, 580, 1);
        pokemon2.mostrarInformacion();
        System.out.println("La batalla Empieza:");

        int turnos = 0;

        while (pokemon1.puntosSalud > 0 && pokemon2.puntosSalud > 0) {
            turnos += 1;
            System.out.println("Turno: " + turnos);
            if (turnos % 2 != 0) {
                System.out.println(pokemon1.nombre + " se prepara para atacar a " + pokemon2.nombre);
                boolean esquiva = pokemon2.esquivar();
                if (esquiva) {
                    System.out.println(pokemon2.nombre + " ha esquivado el ataque");

                } else {
                    System.out.println(pokemon1.nombre + " ataca a " + pokemon2.nombre);
                    pokemon1.atacar(pokemon2);
                }
                System.out.println(" ");
                System.out.println("Estadísticas de la batalla:" + "\n" + "Nombre:" + pokemon2.nombre + "\n"
                        + "Puntos de Salud:" + pokemon2.puntosSalud + "\n" + "Puntos de Combate:"
                        + pokemon2.puntosCombate + "\n" + "-------------------");

            } else {
                System.out.println(pokemon2.nombre + " se prepara para atacar a " + pokemon1.nombre);
                boolean esquiva = pokemon1.esquivar();
                if (esquiva) {
                    System.out.println(pokemon1.nombre + " ha esquivado el ataque");

                } else {
                    System.out.println(pokemon2.nombre + " ataca a " + pokemon1.nombre);
                    pokemon2.atacar(pokemon1);

                }
                System.out.println(" ");
                System.out.println("Estadísticas de la batalla:" + "\n" + "Nombre:" + pokemon1.nombre + "\n"
                        + "Puntos de Salud:" + pokemon1.puntosSalud + "\n" + "Puntos de Combate:"
                        + pokemon1.puntosCombate + "\n" + "-------------------");

            }

        }
        if (pokemon1.puntosSalud <= 0) {
            System.out.println(pokemon1.nombre + " ha sido derrotado");
            System.out.println(pokemon2.nombre + " es el ganador");
        } else {
            System.out.println(pokemon2.nombre + " ha sido derrotado");
            System.out.println(pokemon1.nombre + " es el ganador");

        }

    }
}
