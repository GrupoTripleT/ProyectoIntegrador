package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiltroFecha extends Filtro {
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
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

	public FiltroFecha (LocalDate unaFechaEntrada, LocalDate unaFechaSalida) {		
		this.setFechaEntrada(unaFechaEntrada);
		this.setFechaSalida(unaFechaSalida);		
	}
	
	/*
	 *   algoritmo de busqueda
	 */

	@Override
	public Boolean esPublicacionFiltrada(Publicacion publicacion) {
		return publicacion.hayReservasEnFecha(this.getFechaEntrada(),this.getFechaSalida());
	}
	

}
