package packageProyectoIntegrador;

import java.util.List;

public class BusquedaCiudadTupi implements IBuscadorTupi {

	private String ciudad;
	
	/*
	 *   constructor
	 *   leaf
	 */
	
	public BusquedaCiudadTupi (String unaCiudad) {
		
		this.ciudad = unaCiudad;
		
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
