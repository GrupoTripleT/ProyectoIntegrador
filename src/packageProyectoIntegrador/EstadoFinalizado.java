package packageProyectoIntegrador;

public class EstadoFinalizado extends EstadoReserva {
	
	@Override
	public void procesarReserva(Reserva r) {
		r.setEstado(this);
	}
}