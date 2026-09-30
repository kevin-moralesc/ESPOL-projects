public class Alimento {
    // Integrantes:
    // -Kevin Morales
    // -Alvarez Jorge
    // -Luis Santamaría
    private String nombreAlimento;
    private int valorNutricional;

    public Alimento(String nombreAlimento, int valorNutricional) {
        this.nombreAlimento = nombreAlimento;

        if (valorNutricional >= 1 && valorNutricional <= 20) {
            this.valorNutricional = valorNutricional;
        } else {
            this.valorNutricional = 10;
        }
    }

    public Alimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
        this.valorNutricional = 10;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public int getValorNutricional() {
        return valorNutricional;
    }

    public void mostrarAlimento() {
        System.out.println("Informacion del alimento:");
        System.out.println("Nombre del alimento: " + nombreAlimento);
        System.out.println("Valor nutricional: " + valorNutricional);
    }
}
