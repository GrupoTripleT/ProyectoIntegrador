package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.Set;

public class FiltroXCiudad implements IFiltro{
	
	private String cuidadDeseada;

	
	public String getCuidadDeseada() {
		return this.cuidadDeseada;
	}
	
	public FiltroXCiudad(String cuidadElegida) {
		this.cuidadDeseada = cuidadElegida;
	}
	@Override
	public Set<Publicacion>  aplicarFiltro(Set<Publicacion> publicaciones) {
		
		Set<Publicacion> auxSet = new HashSet<Publicacion>();
		for(Publicacion p : publicaciones) {
			if(p.getCiudad() == this.getCuidadDeseada()) {
				auxSet.add(p);
			}
		}
		
		return auxSet;
	}
	
}