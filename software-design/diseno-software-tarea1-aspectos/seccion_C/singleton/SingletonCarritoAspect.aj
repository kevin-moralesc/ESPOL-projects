package singleton;

public aspect SingletonCarritoAspect {
    
    // Aquí guardamos de forma centralizada la única instancia en memoria
    private CarritoCompras instanciaUnica;

    // PUNTO DE CORTE (Pointcut): Intercepta cualquier llamada al constructor de CarritoCompras
    pointcut crearCarrito() : call(CarritoCompras.new(..));

    // CONSEJO (Around Advice): Reemplaza la ejecución del constructor original
    CarritoCompras around() : crearCarrito() {
        if (instanciaUnica == null) {
            // 'proceed()' permite que el constructor real se ejecute SOLO la primera vez
            instanciaUnica = proceed();
        }
        // Todas las llamadas subsiguientes recibirán la misma instancia de arriba
        return instanciaUnica;
    }
}
