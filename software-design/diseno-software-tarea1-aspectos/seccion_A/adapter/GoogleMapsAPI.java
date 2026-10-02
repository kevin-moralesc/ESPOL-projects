public class GoogleMapsAPI {
    // Este método es incompatible con nuestra app porque exige parámetros de tipo 'double' (GPS)
    public void renderizarRutaConGPS(double latitudOrigen, double longitudOrigen, double latitudDestino, double longitudDestino) {
        System.out.println("----Mapa----");
        System.out.println("Calculando ruta exacta:");
        System.out.println("Desde GPS: (" + latitudOrigen + ", " + longitudOrigen + ")");
        System.out.println("Hasta GPS: (" + latitudDestino + ", " + longitudDestino + ")");
        System.out.println("Ruta renderizada con éxito en el mapa.");
        System.out.println("---------------------------");
    }
}