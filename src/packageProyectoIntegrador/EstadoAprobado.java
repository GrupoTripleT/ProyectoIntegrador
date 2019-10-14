package packageProyectoIntegrador;

public class EstadoAprobado extends EstadoReserva {
	
	@Override
	public void procesarReserva(Reserva r) {
		r.setEstado(this);
		//this.email.enviar(r.getInquilino(), "Se ha aprobado su solicitud");
	}
	
}
