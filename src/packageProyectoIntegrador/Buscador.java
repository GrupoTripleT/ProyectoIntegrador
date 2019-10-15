import packageProyectoIntegrador.*;

import java.util.HashSet;
import java.util.Set;

public class Buscador {
	
	private Set<Criterio> criterios;
	
	public Set<Criterio> getCriterios() {
		return criterios;
	}
	
	public void setCriterios(Set<Criterio> criterios) {
		this.criterios = criterios;
	}

	public Set<Publicacion> buscar(Set<Publicacion> publicaciones){
		
		for(Criterio c : criterios) {
			//Set<Publicacion> publicacionesFiltradasXCadaCriterio = HashSet<Publicacion>();
			publicaciones = c.filtrar(publicaciones);
		}
		return publicaciones;
		//this.getCriterios().stream().map(criterio -> criterio.filtrar(publicaciones).collector(Collectors.toSet()));
		
	}
	
	
	
	
	

}
