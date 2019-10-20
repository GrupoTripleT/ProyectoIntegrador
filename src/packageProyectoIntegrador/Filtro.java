package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.Set;

public abstract class Filtro{	
	
	public Set<Publicacion> aplicarFiltro(Set<Publicacion> publicaciones) {
		Set<Publicacion> publicacionesFiltradas = new HashSet<Publicacion>();		
		for (Publicacion unaPublicacion : publicaciones) {
			if (this.esPublicacionFiltrada(unaPublicacion)) {
				publicacionesFiltradas .add(unaPublicacion);
			}
		}
		return publicacionesFiltradas ;	
	}
	
	public abstract Boolean esPublicacionFiltrada(Publicacion publicacion);
	
}
