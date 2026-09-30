public class PruebaNatacion implements Comparable<PruebaNatacion> {
    private String codigo;
    private String estilo; // Libre, Mariposa, Espalda, Pecho, etc.
    private int distanciaMetros;
    private int minutosEsperandoJuez;
    private double distanciaPiscinaKm;

    // Constructor
    public PruebaNatacion(String codigo, String estilo, int distanciaMetros, int minutosEsperandoJuez, double distanciaPiscinaKm) {
        this.codigo = codigo;
        this.estilo = estilo;
        this.distanciaMetros = distanciaMetros;
        this.minutosEsperandoJuez = minutosEsperandoJuez;
        this.distanciaPiscinaKm = distanciaPiscinaKm;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getEstilo() { return estilo; }
    public int getDistanciaMetros() { return distanciaMetros; }
    public int getMinutosEsperandoJuez() { return minutosEsperandoJuez; }
    public double getDistanciaPiscinaKm() { return distanciaPiscinaKm; }

    // CRITERIO DE PRIORIDAD: Mayor tiempo esperando = Mayor prioridad
    @Override
    public int compareTo(PruebaNatacion otra) {
        // Multiplicamos por -1 o invertimos el orden para que sea descendente (mayor a menor)
        return Integer.compare(otra.minutosEsperandoJuez, this.minutosEsperandoJuez);
    }

    @Override
    public String toString() {
        return "Prueba{" + "codigo='" + codigo + '\'' + ", estilo='" + estilo + '\'' + 
               ", espera=" + minutosEsperandoJuez + " min, dist=" + distanciaPiscinaKm + " km}";
    }
}