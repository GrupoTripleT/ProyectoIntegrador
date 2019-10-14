package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
			
			
		}
		return null;
		//this.getCriterios().stream().map(criterio -> criterio.filtrar(publicaciones).collector(Collectors.toSet()));
		
	}
	
	
	
	
	

}
