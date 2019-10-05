package packageProyectoIntegrador;

import java.util.Set;

public class Sitio {
	
	private Set<Publicacion> publicaciones;
	private Buscador buscador;
	private Set<Inmueble> inmuebles;
	private Set<Usuario> usuarios;
	
	
	
	public Set<Publicacion> getPublicaciones(){
		return this.publicaciones;
	}
	
	public Set<Publicacion> buscarPublicaciones() {
		return buscador.buscar(this.getPublicaciones());
		
	}
	public void cancelarReserva(Publicacion publicacion) {
		
	}
	
	
	

}
