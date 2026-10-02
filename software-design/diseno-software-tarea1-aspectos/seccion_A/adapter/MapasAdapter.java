public class MapasAdapter implements ServicioMapas {
    private GoogleMapsAPI googleMapsAPI;

    public MapasAdapter() {
        this.googleMapsAPI = new GoogleMapsAPI();
    }

    @Override
    public void calcularRuta(String calleOrigen, String calleDestino) {
        
        System.out.println("[Adapter]: Recibida dirección en texto plano: '" + calleOrigen + "' hasta '" + calleDestino + "'");
        System.out.println("[Adapter]: Simulando conversión de texto a coordenadas GPS...");
        
        // Simulando las coordenadas GPS 
        double latOrigen = -2.14;
        double lonOrigen = -79.91;
        double latDestino = -2.16; 
        double lonDestino = -79.93;

        
        googleMapsAPI.renderizarRutaConGPS(latOrigen, lonOrigen, latDestino, lonDestino);
    }
}