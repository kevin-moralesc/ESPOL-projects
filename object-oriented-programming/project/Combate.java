import java.util.Scanner;

public class Combate {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
    
    // Menú interactivo
    private static void mostrarMenuPrincipal() {
        int opcion = 0;
        
        while (opcion != 3) {
            
            System.out.println("\n========================================");
            System.out.println("   BIENVENIDO AL SIMULADOR DE COMBATE ");
            System.out.println("========================================");
            System.out.println("1.   Jugar Combate");
            System.out.println("2.   Ver Tutorial/Reglas");
            System.out.println("3.   Salir");
            System.out.println("----------------------------------------");
            System.out.print("Seleccione una opción: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                scanner.next(); 
                opcion = 0; 
            }
            scanner.nextLine(); 
            
            if (opcion == 1) {
                iniciarCombate();
            } else if (opcion == 2) {
                mostrarTutorial();
            } else if (opcion == 3) {
                System.out.println("\n¡Gracias por jugar! El Juego ha finalizado.");
            } else {
                System.out.println("\nOpción no reconocida. Inténtelo de nuevo.");
            }
        } 
        
        scanner.close();
    }

    private static void mostrarTutorial() {
        System.out.println("\n========================================");
        System.out.println("   TUTORIAL Y REGLAS DE ESTRATEGIA ");
        System.out.println("========================================");
        System.out.println("- Sistema de Combate: máximo 15 rondas.");
        System.out.println("- Cada ronda ataca primero el equipo Rojo y luego el Azul.");
        System.out.println("- Se enfrentan personajes vivos en el orden en que aparecen.");
        System.out.println("  Ej: Guerrero vs Guerrero, luego Mago vs Mago, etc.");
        System.out.println("- Cada personaje tendra probabilidad 50% de esquivar");
        System.out.println("- Guerrero: duplica su ataque temporalmente (FURIA).");
        System.out.println("- Mago: cura a un aliado vivo aleatorio (máx. su vida inicial).");
        System.out.println("- Místico: si adivina el dado (1-6), suma el poder de su equipo.");
        System.out.println("- Gana el equipo que derrote al otro o tenga más vida total al final.");
        System.out.println("\nVolviendo al menú principal.");
    }
    
    private static void mostrarEstadoEquipos(Equipo equipoRojo, Equipo equipoAzul) {
        System.out.println("\n======== ESTADO DE LOS EQUIPOS =========");
        
        System.out.println("[" + equipoRojo.getNombre() + "] (Total PV: " + equipoRojo.getVidaTotalRestante() + ")");
        Personaje[] persRojo = equipoRojo.getPersonajes();
        for (int i = 0; i < persRojo.length; i++) {
            System.out.println("  - " + persRojo[i].getNombre() + ": " + persRojo[i].getVida() + " PV");
        }

        System.out.println("--------- VS --------");

        System.out.println("[" + equipoAzul.getNombre() + "] (Total PV: " + equipoAzul.getVidaTotalRestante() + ")");
        Personaje[] persAzul = equipoAzul.getPersonajes();
        for (int i = 0; i < persAzul.length; i++) {
            System.out.println("  - " + persAzul[i].getNombre() + ": " + persAzul[i].getVida() + " PV");
        }
        System.out.println("========================================");
    }

    // Iniciar batalla
    private static void iniciarCombate() {
        System.out.println("\n========================================");
        System.out.println("            INICIO DEL COMBATE    ");
        System.out.println("========================================");

        // CREACIÓN DE EQUIPOS Y PERSONAJES
        Equipo equipoRojo = new Equipo("Rojo");
        Equipo equipoAzul = new Equipo("Azul");

        // 2 Guerreros, 1 Mago, 1 Místico por equipo (en ese orden)
        equipoRojo.agregarPersonaje(new Guerrero("Guerrero Rojo 1", 100, 20, 10, equipoRojo));
        equipoRojo.agregarPersonaje(new Guerrero("Guerrero Rojo 2", 95, 18, 9, equipoRojo));
        equipoRojo.agregarPersonaje(new Mago("Mago Rojo", 80, 25, 5, equipoRojo));
        equipoRojo.agregarPersonaje(new Mistico("Místico Rojo", 90, 15, 8, equipoRojo)); 
        
        equipoAzul.agregarPersonaje(new Guerrero("Guerrero Azul 1", 90, 18, 12, equipoAzul));
        equipoAzul.agregarPersonaje(new Guerrero("Guerrero Azul 2", 92, 19, 11, equipoAzul));
        equipoAzul.agregarPersonaje(new Mago("Mago Azul", 70, 30, 3, equipoAzul));
        equipoAzul.agregarPersonaje(new Mistico("Místico Azul", 85, 17, 7, equipoAzul)); 

        int ronda = 1;
        final int MAX_RONDAS = 15;

        while (!equipoRojo.estaDerrotado() && !equipoAzul.estaDerrotado() && ronda <= MAX_RONDAS) {
            
            System.out.println("\n================ RONDA " + ronda + " ===============");
            
            mostrarEstadoEquipos(equipoRojo, equipoAzul);

            // Turno del Equipo Rojo
            equipoRojo.atacarOtroEquipo(equipoAzul, scanner);

            // Turno del Equipo Azul (solo si sigue vivo)
            if (!equipoAzul.estaDerrotado()) {
                equipoAzul.atacarOtroEquipo(equipoRojo, scanner);
            }

            ronda = ronda + 1;
        }

        // RESULTADO FINAL
        System.out.println("\n==================================");
        System.out.println("      FIN DEL COMBATE");
        System.out.println("==================================");

        if (equipoRojo.estaDerrotado() && equipoAzul.estaDerrotado()) {
            System.out.println("¡EMPATE! Ambos equipos han sido aniquilados.");
            mostrarEstadoEquipos(equipoRojo, equipoAzul);
        } else if (equipoRojo.estaDerrotado()) {
            System.out.println("El Equipo [Azul] gana (" + equipoAzul.getVidaTotalRestante() + " PV restantes).");
            mostrarEstadoEquipos(equipoRojo, equipoAzul); 
        } else if (equipoAzul.estaDerrotado()) {
            System.out.println("El Equipo [Rojo] gana (" + equipoRojo.getVidaTotalRestante() + " PV restantes).");
            mostrarEstadoEquipos(equipoRojo, equipoAzul); 
        } else {
            // Se acabaron las rondas
            System.out.println("Límite de " + MAX_RONDAS + " rondas alcanzado.");
            int vidaRojo = equipoRojo.getVidaTotalRestante();
            int vidaAzul = equipoAzul.getVidaTotalRestante();

            System.out.println("Vida total [Rojo]: " + vidaRojo);
            System.out.println("Vida total [Azul]: " + vidaAzul);

            if (vidaRojo > vidaAzul) {
                System.out.println("El Equipo [Rojo] gana por puntos de vida restantes.");
            } else if (vidaAzul > vidaRojo) {
                System.out.println("El Equipo [Azul] gana por puntos de vida restantes.");
            } else {
                System.out.println("¡EMPATE! Igualdad de puntos de vida al final de las rondas.");
            }
        }
        System.out.println("==================================");
    }
 
}
