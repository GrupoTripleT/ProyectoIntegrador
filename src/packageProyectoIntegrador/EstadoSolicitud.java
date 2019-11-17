package packageProyectoIntegrador;

public class EstadoSolicitud extends EstadoReserva {
	@Override
	public void cambiarEstado(Reserva r) {
		r.setEstado(new EstadoAprobado());
	}
}
