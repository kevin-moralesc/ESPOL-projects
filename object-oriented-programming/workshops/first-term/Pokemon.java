public class Pokemon {
    // Atributos
    private String color;
    private String nombre;
    private int nivel;
    private int puntosCombate;
    private int puntosSalud;

    // Metodos

    public void mostrarInformacion() {
        System.out.println("Nombre:" + nombre + "\n" + "Nivel: " + nivel + "\n" + "Color: " + color + "\n"
                + "Puntos de Salud:" + puntosSalud + "\n" + "Puntos de Combate:" + puntosCombate + "\n" +
                "-------------------------");
    }

    void saludar(int cantidad) {
        int i = 0;
        while (i < cantidad) {
            System.out.println("Hola me llamo: " + nombre);
            i++;
        }
    }

    public boolean esquivar() {
        double variado = Math.random();
        if (variado <= 0.5) {
            return true;
        } else {
            return false;
        }
    }

    public void atacar(Pokemon contrincante) {
        contrincante.puntosSalud -= puntosCombate;
        System.out.print("Daño causado: " + puntosCombate);
    }

    public void comer(Alimento alimento) {
        int puntos = alimento.getValorNutricional();
        puntosSalud += puntos;
    }

    // Constructores
    public Pokemon(String color, String nombre, int nivel, int puntosCombate, int puntosSalud) {
        this.color = color;
        this.nivel = nivel;
        this.nombre = nombre;
        this.puntosCombate = puntosCombate;
        this.puntosSalud = puntosSalud;
    }

    // Constructor por defecto
    public Pokemon() {
        this.nombre = "Sin Nombre";
        this.color = "Sin Color";
        this.puntosCombate = 0;
        this.puntosSalud = 0;
        this.nivel = 1;
    }

    public Pokemon(String nombre) {
        this.nombre = nombre;
        this.color = "Gris";
        this.puntosCombate = 100;
        this.puntosSalud = 1000;
        this.nivel = 10;
    }

    public Pokemon(String color, int nivel) {
        this.color = color;
        this.nivel = nivel;
        this.nombre = "Pikachu";
        this.puntosCombate = 100;
        this.puntosSalud = 1000;
    }
    // Getters y Setters

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    public void setPuntosCombate(int puntosCombate) {
        this.puntosCombate = puntosCombate;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }
}