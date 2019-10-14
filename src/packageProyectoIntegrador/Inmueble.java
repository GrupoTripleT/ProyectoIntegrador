package packageProyectoIntegrador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class Inmueble {
	
	private TipoDeInmueble tipoDeInmueble;
	private Integer capacidad;
	private String pais;
	private String ciudad;
	private String direccion;
	private List<Servicio> servicios;
	private Double precio;
	private LocalTime horarioCheckIn;
	private LocalTime horarioCheckOut;
	
	
	public Inmueble(TipoDeInmueble tipoDeInmueble, Integer capacidad, String pais, String ciudad, String direccion,
			List<Servicio> servicios, Double precio, LocalTime horarioCheckIn, LocalTime horarioCheckOut) {
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
	public TipoDeInmueble getTipoDeInmueble() {
		return tipoDeInmueble;
	}
	
	public String saberTipoDeInmueble() {
		return this.getTipoDeInmueble().getTipo();
		}
	
	public void setTipoDeInmueble(TipoDeInmueble tipoDeInmueble) {
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
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public LocalTime getHorarioCheckIn() {
		return horarioCheckIn;
	}
	public void setHorarioCheckIn(LocalTime horarioCheckIn) {
		this.horarioCheckIn = horarioCheckIn;
	}
	public LocalTime getHorarioCheckOut() {
		return horarioCheckOut;
	}
	public void setHorarioCheckOut(LocalTime horarioCheckOut) {
		this.horarioCheckOut = horarioCheckOut;
	}
	
	
	public Boolean poseeEsteServicio(Servicio servicio) {
		return this.getServicios().contains(servicio);
	}

}
