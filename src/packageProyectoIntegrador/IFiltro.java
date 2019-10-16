package packageProyectoIntegrador;

import java.util.Set;

public abstract interface IFiltro {
	
	public Set<Publicacion> aplicarFiltro(Set<Publicacion> publicaciones);

}
