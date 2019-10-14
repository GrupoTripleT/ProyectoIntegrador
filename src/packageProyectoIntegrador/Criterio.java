package packageProyectoIntegrador;

import java.util.List;
import java.util.Set;

public abstract class Criterio {
	
	public abstract Set<Publicacion> filtrar(Set<Publicacion> publicaciones);

}
