package packageProyectoIntegrador;

import java.util.List;

public class BusquedaCapacidadTupi implements IBuscadorTupi {
	
	private Integer capacidad;
	
	/*
	 *   constructor
	 *   leaf
	 */
	
	public BusquedaCapacidadTupi (Integer unaCapacidad) {
		
		this.capacidad = unaCapacidad;
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
