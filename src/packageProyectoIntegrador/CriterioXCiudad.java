package packageProyectoIntegrador;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CriterioXCiudad extends Criterio {
	
	private String cuidadDeseada;

	
	public String getCuidadDeseada() {
		return this.cuidadDeseada;
	}
	@Override
	public Set<Publicacion>  filtrar(Set<Publicacion> publicaciones) {
		// TODO Auto-generated method stub
		return 
		publicaciones.stream().filter(p -> p.getCiudad() == this.getCuidadDeseada()).collect(Collectors.toSet());
	}

}
