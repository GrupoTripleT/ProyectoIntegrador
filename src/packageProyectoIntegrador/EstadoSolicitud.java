package packageProyectoIntegrador;

public class EstadoSolicitud extends EstadoReserva {
	
	@Override
	protected void aprobar(Reserva r) {
		r.setEstado(new EstadoAprobado());
	}
	
	@Override
	protected void cancelar(Reserva r) {
		r.setEstado(new EstadoCancelado());
	}
}
