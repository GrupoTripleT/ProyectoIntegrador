package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Sitio {

	private List<Usuario> usuarios;
	private List<Inmueble> inmuebles;
	private List<Publicacion> publicaciones;
	
	
	
	public Sitio() {
		super();
		this.inmuebles = new ArrayList<Inmueble>();
		this.publicaciones = new ArrayList<Publicacion>();
		this.usuarios = new ArrayList<Usuario>();

	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}


	public List<Publicacion> getPublicaciones() {
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
	
	/*		
	 * 		TUPI
	 * 		metodo para buscar permite un unico criterio de busqueda
	 * 		si es combinado, agregarlos a BusquedaCombinadaTupi y utlizar ese
	 */
	
	public List<Publicacion> filtrarBusqueda (List<Publicacion> publicaciones, IBuscadorTupi buscador) {
		
		return (buscador.filtrarBusqueda(publicaciones));
		
	}
	
}
