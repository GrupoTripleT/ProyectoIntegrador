package packageProyectoIntegrador;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Sitio {

	// Variables
	private Set<Usuario> usuarios;
	private Set<Inmueble> inmuebles;
	private Set<Publicacion> publicaciones;
	private Set<Servicio> servicios;
	private Set<TipoDeInmueble> tiposDeInmuebles;

	// Constructor
	public Sitio() {
		super();
		this.setUsuarios(new HashSet<Usuario>());
		this.setInmuebles(new HashSet<Inmueble>());
		this.setPublicaciones(new HashSet<Publicacion>());
		this.setServicios(new HashSet<Servicio>());
		this.setTiposDeInmuebles(new HashSet<TipoDeInmueble>());;
	}


	// Setter and Getters

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public Set<TipoDeInmueble> getTiposDeInmuebles() {
		return tiposDeInmuebles;
	}

	public void setTiposDeInmuebles(Set<TipoDeInmueble> tiposDeInmuebles) {
		this.tiposDeInmuebles = tiposDeInmuebles;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
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
		this.actualizarPublicaciones();
		return publicaciones;
	}

	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	//Correccion
	private void actualizarPublicaciones() {
	  /* Evalua si existe en Sitio alguna publicacion vencida al dia de la fecha (hoy).
	   * Caso verdadero, publicaciones pasa a contener un nuevo Set sin las publicaciones
	   * vencidas */
	  this.setPublicaciones(
	    this.publicaciones.stream()
	      .filter(publicacion -> publicacion.estaVigente())
	        .collect(Collectors.toSet())
	        );
	}

	public void registrarServicio(Servicio unServicio) {
		this.getServicios().add(unServicio);
	}

	public void registrarTipoDeInmueble(TipoDeInmueble unTipoDeInmueble) {
		this.getTiposDeInmuebles().add(unTipoDeInmueble);
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

	//Correccion
	public Set<Publicacion> buscarPublicaciones(Buscador buscador) {
		return buscador.buscar(this.getPublicaciones());
	}

	public void aprobarReserva(Publicacion publicacion, Reserva reserva) {
		publicacion.aprobarReserva(reserva);
	}
}
