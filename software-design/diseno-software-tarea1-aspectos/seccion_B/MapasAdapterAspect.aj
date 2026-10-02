public aspect MapasAdapterAspect{
	private GoogleMapsAPI googleMaps = new GoogleMapsAPI();

	//Intercepta cualquier llamada al método calcularRuta()
	pointcut calcularRuta(String origen, String destino):
		call(void ServicioMapas.calcularRuta(String, String))
		&& args(origen, destino);

	//Reemplaza la ejecución original del método
	void around(String origen, String destino) : calcularRuta(origen, destino) {
		System.out.println("-----Aspect Adapter-----");
		System.out.println("Convirtiendo direcciones a coordenadas GPS...");

		//Simulando las coordenadas GPS
		double latOrigen = -2.14;
		double lonOrigen = -79.91;
		double latDestino = -2.16;
		double lonDestino = -79.93;

		googleMaps.renderizarRutaConGPS(latOrigen, lonOrigen, latDestino, lonDestino);
	}
}
