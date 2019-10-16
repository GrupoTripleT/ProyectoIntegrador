package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusquedaCombinadaTupi implements IBuscadorTupi {
	
	private Set<IBuscadorTupi> busquedas;
	
	/*
	 *   constructor
	 *   se le pasan las busquedas obligatorias que ejecutará por defecto
	 */
	
	public BusquedaCombinadaTupi (Set<IBuscadorTupi> busquedasObligatorias) {
		
		this.busquedas = new HashSet<IBuscadorTupi>();
		
		for (IBuscadorTupi buscador : busquedasObligatorias) {
			
			this.busquedas.add(buscador);
			
		}
		
	}
	
	/*
	 *   implementacion
	 *   recursividad
	 */
	
	@Override
	public List<Publicacion> filtrarBusqueda(List<Publicacion> publicaciones) {
		
		List<Publicacion> aux = publicaciones;
		
		for (IBuscadorTupi buscador : busquedas) {
			
			aux = buscador.filtrarBusqueda(aux);
			
		}
		
		return aux;
		
	}

	/*   composite	 */
	
	public void removerBusqueda(IBuscadorTupi unBuscador) {
		
		this.busquedas.remove(unBuscador);
		
	}
	
	public void agregarBusqueda(IBuscadorTupi unaBusqueda) {
		
		this.busquedas.add(unaBusqueda);
		
	}
	
}
