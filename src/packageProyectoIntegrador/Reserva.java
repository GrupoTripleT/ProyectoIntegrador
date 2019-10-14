package packageProyectoIntegrador;

import java.util.Date;

public class Reserva {
	
	private Date fechaEntrada;
	private Date fechaSalida;
	private EstadoReserva estado;
	private Usuario inquilino;
	
	public Reserva (Date fEntrada, Date fSalida, Usuario inquilino) {
		
		this.fechaEntrada = fEntrada;
		this.fechaSalida = fSalida;
		this.estado = null;
		this.inquilino = inquilino;
		
	}
	
	public void procesarReserva (EstadoReserva nuevoEstado) {
		
		nuevoEstado.procesar(nuevoEstado, this);
		
	}
	
	public EstadoReserva estadoReserva() {
		
		return this.estado;
		
	}
	
	public void cambiarEstadoReserva (EstadoReserva nuevoEstado) {
		
		this.estado = nuevoEstado;
		
	}
	
}
