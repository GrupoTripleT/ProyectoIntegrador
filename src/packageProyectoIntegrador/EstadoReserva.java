package packageProyectoIntegrador;

public abstract class EstadoReserva {

	public EstadoReserva() {
		setEmailManager(new ServicioSMTP());
	}

	private IEmailManager emailManager;

	abstract void procesarReserva(Reserva r);

	protected IEmailManager getEmailManager() {
		return emailManager;
	}

	protected void setEmailManager(IEmailManager emailManager) {
		this.emailManager = emailManager;
	}

}
