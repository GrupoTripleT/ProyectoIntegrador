package packageProyectoIntegrador;
import java.util.HashSet;
import java.util.Set;


public class Sitio {

	private Set<Usuario> usuarios;
	private Set<Inmueble> inmuebles;
	private Set<Publicacion> publicaciones;
	
	
	
	public Sitio() {
		super();
		this.inmuebles = new HashSet<Inmueble>();
		this.publicaciones = new HashSet<Publicacion>();
		this.usuarios = new HashSet<Usuario>();

	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public Set<Inmueble> getInmuebles() {
		return inmuebles;
	}


	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
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
	
	public Set<Publicacion> buscarPublicaciones(Set<IFiltro> filtros) {			
		Set<Publicacion> publicacionesFiltradas = new HashSet<Publicacion>();
		for(IFiltro f : filtros) {
			publicacionesFiltradas = f.aplicarFiltro(this.getPublicaciones());
		}
		
		return publicacionesFiltradas;
			
		}

}
