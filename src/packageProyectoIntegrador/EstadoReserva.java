package packageProyectoIntegrador;

public abstract class EstadoReserva {

	protected IEmail email;
	
	protected Boolean esEstadoAprobado() {
		return false;
	}
	
	protected Boolean esEstadoFinalizado() {
		return false;
	}
	
	protected Boolean esEstadoCancelado() {
		return false;
	}

	protected void aprobar(Reserva r) {}
	
	protected void finalizar(Reserva r) {}
	
	protected void cancelar(Reserva r) {}

}
