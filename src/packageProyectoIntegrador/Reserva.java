package packageProyectoIntegrador;

import java.time.LocalDate;

public class Reserva {
	private EstadoReserva estado;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Usuario inquilino;
	
	public Reserva(LocalDate fe, LocalDate fs, Usuario in) {
		this.setEstado(new EstadoSolicitud());
		this.setFechaEntrada(fe);
		this.setFechaSalida(fs);
		this.setInquilino(in);
	}
	
	public void cambiarEstado(EstadoReserva e) {
		e.procesarReserva(this);
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Usuario getInquilino() {
		return inquilino;
	}

	private void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}
	


}
