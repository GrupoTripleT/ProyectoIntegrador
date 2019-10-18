package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusquedaFecha implements IBusqueda {
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	/*
	 *   constructor
	 *   leaf
	 */
	
	public BusquedaFecha (LocalDate unaFechaEntrada, LocalDate unaFechaSalida) {		
		this.fechaEntrada = unaFechaEntrada;
		this.fechaSalida = unaFechaSalida;		
	}
	
	/*
	 *   algoritmo de busqueda
	 */
	
	@Override
	public Set<Publicacion> filtrarBusqueda(List<Publicacion> publicaciones) {
		Set<Publicacion> filtrado = new HashSet<Publicacion>();		
		for (Publicacion unaPublicacion : publicaciones) {
			if (! unaPublicacion.hayReservasEnFecha(fechaEntrada, fechaSalida)) {
				filtrado.add(unaPublicacion);
			}
		}
		return filtrado;
	}

}
