package packageProyectoIntegrador;

public class EstadoFinalizado extends EstadoReserva {
	
	@Override
	protected Boolean esEstadoFinalizado() {
		return true;
	}
}
