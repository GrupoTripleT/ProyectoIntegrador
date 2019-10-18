package packageProyectoIntegrador;

public class EstadoCancelado extends EstadoReserva {

	@Override
	public void procesarReserva(Reserva r) {
		r.setEstado(this);
	}
}
