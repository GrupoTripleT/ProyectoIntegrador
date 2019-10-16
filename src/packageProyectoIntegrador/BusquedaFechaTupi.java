package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.List;

public class BusquedaFechaTupi implements IBuscadorTupi {
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	/*
	 *   constructor
	 *   leaf
	 */
	
	public BusquedaFechaTupi (LocalDate unaFechaEntrada, LocalDate unaFechaSalida) {
		
		this.fechaEntrada = unaFechaEntrada;
		this.fechaSalida = unaFechaSalida;
		
	}
	
	/*
	 *   implementacion
	 *   algoritmo de busqueda
	 */
	
	@Override
	public List<Publicacion> filtrarBusqueda(List<Publicacion> publicaciones) {
		
		return publicaciones;

	}

}
