package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusquedaCombinada implements IBusqueda {
	
	private Set<IBusqueda> busquedas;
	
	/*
	 *   constructor
	 *   se le pasan las busquedas obligatorias que ejecutará por defecto
	 */
	
	public BusquedaCombinada (Set<IBusqueda> busquedasObligatorias) {
		this.busquedas = new HashSet<IBusqueda>();		
		for (IBusqueda buscador : busquedasObligatorias) {
			this.busquedas.add(buscador);
		}
	}
	
	/*
	 *   implementacion
	 *   recursividad
	 */
	
	@Override
	public Set<Publicacion> filtrarBusqueda(List<Publicacion> publicaciones) {	
		Set<Publicacion> aux = new HashSet<Publicacion>();
		for (IBusqueda buscador : busquedas) {
			aux.addAll(buscador.filtrarBusqueda(publicaciones));		
		}	
		return aux;
	}

	/*   composite	 */
	
	public void removerBusqueda(IBusqueda unBuscador) {
		this.busquedas.remove(unBuscador);
	}
	
	public void agregarBusqueda(IBusqueda unaBusqueda) {		
		this.busquedas.add(unaBusqueda);
	}
	
}
