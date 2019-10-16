package packageProyectoIntegrador;

import java.util.List;

public interface IBuscador {
	List<Publicacion> Buscar(List<Publicacion> publicaciones, FiltrosBusqueda criterio);
}
