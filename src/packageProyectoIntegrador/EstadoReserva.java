package packageProyectoIntegrador;

public abstract class EstadoReserva {
	
	protected IEmail email;

	abstract void procesarReserva(Reserva r);

}
