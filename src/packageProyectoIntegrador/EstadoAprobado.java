package packageProyectoIntegrador;

public class EstadoAprobado extends EstadoReserva {

	@Override
	public void cambiarEstado(Reserva r) {
		r.setEstado(new EstadoFinalizado());
		//this.email.enviar(r.getInquilino(), "Se ha aprobado su solicitud");
		r.getInquilino();
	}
	
	@Override
	public Boolean esEstadoAutorizado() {
		return true;
	}

}
