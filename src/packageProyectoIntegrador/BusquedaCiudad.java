package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusquedaCiudad implements IBusqueda {

	private String ciudad;
	
	/*
	 *   constructor
	 *   leaf
	 */
	
	public BusquedaCiudad (String unaCiudad) {
		this.ciudad = unaCiudad;
	}
	
	/*
	 *   implementacion
	 *   algoritmo de busqueda
	 */
	
	@Override
	public Set<Publicacion> filtrarBusqueda(List<Publicacion> publicaciones) {
		Set<Publicacion> filtrado = new HashSet<Publicacion>();		
		for (Publicacion unaPublicacion : publicaciones) {
			if (unaPublicacion.esCiudadPublicacion(ciudad)) {
				filtrado.add(unaPublicacion);
			}
		}
		return filtrado;	
	}

}
