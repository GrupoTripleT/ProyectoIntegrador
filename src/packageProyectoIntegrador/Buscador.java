package packageProyectoIntegrador;


import java.util.HashSet;
import java.util.Set;

public class Buscador {

	private Set <Filtro> filtros;
	
	public Set<Filtro> getFiltros() {
		return filtros;
	}

	public void setFiltros(Set<Filtro> filtros) {
		this.filtros = filtros;
	}
	

	public Buscador() {
		super();
		this.setFiltros(new HashSet<Filtro>());;
	}
	
	public void agregarFiltro(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public Set<Publicacion> buscar(Set<Publicacion> publicaciones) {		
		
		Set<Publicacion> publicacionesFiltradas = publicaciones;
		for(Filtro f : this.getFiltros()) {
				publicacionesFiltradas = f.aplicarFiltro(publicacionesFiltradas);
		}
		
		return publicacionesFiltradas;	
	}
}
