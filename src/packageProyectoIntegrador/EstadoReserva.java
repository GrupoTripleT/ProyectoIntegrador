package packageProyectoIntegrador;

public abstract class EstadoReserva {

	public IEmailManager emailManager;

	abstract void procesarReserva(Reserva r);

}
