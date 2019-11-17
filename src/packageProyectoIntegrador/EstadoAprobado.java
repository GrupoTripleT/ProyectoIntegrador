package packageProyectoIntegrador;

public class EstadoAprobado extends EstadoReserva {
	
	@Override
	protected Boolean esEstadoAprobado() {
		return true;
	}
	
	@Override
	protected void finalizar(Reserva r) {
		r.setEstado(new EstadoFinalizado());
	}
	
	@Override
	protected void cancelar(Reserva r) {
		r.setEstado(new EstadoCancelado());
	}
}
