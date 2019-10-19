package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Sitio {

	private List<Usuario> usuarios;
	private List<Inmueble> inmuebles;
	private List<Publicacion> publicaciones;
	private IBusqueda buscador;
	
	/*	constructor	*/
	
	public Sitio() {
		super();
		this.inmuebles = new ArrayList<Inmueble>();
		this.publicaciones = new ArrayList<Publicacion>();
		this.usuarios = new ArrayList<Usuario>();
		this.buscador = null;
	}

	/*	getter y setters	*/
	
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
	
	/*	metodos para busquedas	*/
	
	public Set<Publicacion> buscarPublicacion() {
		return (buscador.filtrarBusqueda(publicaciones));	
	}
	
	public void agregarBusqueda(IBusqueda unBuscador) {
		this.buscador = unBuscador;
	}
	
	public void aprobarReserva(Reserva reserva) {
		reserva.aprobarReserva();
	}
	
}
