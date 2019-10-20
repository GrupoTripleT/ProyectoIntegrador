package packageProyectoIntegrador;

public class EstadoAprobado extends EstadoReserva {

	@Override
	public void procesarReserva(Reserva r) {
		r.setEstado(this);
		//this.IEmail.enviar(r.getInquilino().getMail(), "Se ha aprobado su solicitud");
		r.getInquilino();
	}
}
