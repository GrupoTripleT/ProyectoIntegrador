package packageProyectoIntegrador;

public class EstadoSolicitud extends EstadoReserva {
	
	@Override
	public void procesarReserva(Reserva r) {
		r.setEstado(this);
	}
}
