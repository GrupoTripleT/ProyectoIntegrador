package packageProyectoIntegrador;

public class EstadoCancelado extends EstadoReserva {

	@Override
	protected Boolean esEstadoCancelado() {
		return true;
	}
	
}
