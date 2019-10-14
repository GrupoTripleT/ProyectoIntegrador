package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.Set;

public class Inmueble {
	
	private String tipoDeInmueble;
	private Integer capacidad;
	private String pais;
	private String ciudad;
	private String direccion;
	private Set<Servicio> servicios;
	private Double precio;
	private LocalDate horarioCheckIn;
	private LocalDate horarioCheckOut;
	
	
	public Inmueble(String tipoDeInmueble, Integer capacidad, String pais, String ciudad, String direccion,
			Set<Servicio> servicios, Double precio, LocalDate horarioCheckIn, LocalDate horarioCheckOut) {
		super();
		this.tipoDeInmueble = tipoDeInmueble;
		this.capacidad = capacidad;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.servicios = servicios;
		this.precio = precio;
		this.horarioCheckIn = horarioCheckIn;
		this.horarioCheckOut = horarioCheckOut;
	}
	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}
	public void setTipoDeInmueble(String tipoDeInmueble) {
		this.tipoDeInmueble = tipoDeInmueble;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Set<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public LocalDate getHorarioCheckIn() {
		return horarioCheckIn;
	}
	public void setHorarioCheckIn(LocalDate horarioCheckIn) {
		this.horarioCheckIn = horarioCheckIn;
	}
	public LocalDate getHorarioCheckOut() {
		return horarioCheckOut;
	}
	public void setHorarioCheckOut(LocalDate horarioCheckOut) {
		this.horarioCheckOut = horarioCheckOut;
	}
	
	

}
