package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.Set;

public class Sitio {

	private Set<Usuario> usuarios;
	private Set<Inmueble> inmuebles;
	private Set<Publicacion> publicaciones;

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}
		
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(Set<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	
	public Sitio() {
		super();
		this.setUsuarios(new HashSet<Usuario>());
		this.setInmuebles(new HashSet<Inmueble>());
		this.setPublicaciones(new HashSet<Publicacion>());
	}

	
	public void publicar(Publicacion publi) {
		this.getPublicaciones().add(publi);
	}
	
	public void registrarInmueble(Inmueble inmueble) {
		this.getInmuebles().add(inmueble);
	}
	
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	public Set<Publicacion> buscarPublicaciones(Buscador buscador) {
		return buscador.buscar(this.getPublicaciones());
	}
}
