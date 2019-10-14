package packageProyectoIntegrador;

import java.time.LocalDateTime;
import java.util.Set;

public class Inmueble {
	
	private String ciudad;
	private String tipoInmueble;
	private Set<String> servicios;
	private Integer capacidad;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private Integer precio;
	
	//servicios = new HashSet<String>();
	
	// #Encapsulamiento
	
	public Integer getPrecio() { return precio;}

	public void setPrecio(Integer precio) { this.precio = precio; }

	public String getCiudad() { return ciudad; }

	public void setCiudad(String ciudad) { this.ciudad = ciudad; }
	
	public String getTipoInmueble() { return tipoInmueble;	}

	public void setTipoInmueble(String tipoInmueble) { this.tipoInmueble = tipoInmueble; }

	public Set<String> getServicios() { return servicios; }

	public void setServicios(Set<String> servicios) { this.servicios = servicios; }

	public Integer getCapacidad() { return capacidad; }

	public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
	
	public LocalDateTime getCheckIn() { return checkIn;	}

	public void setCheckIn(LocalDateTime checkIn) { this.checkIn = checkIn; }

	public LocalDateTime getCheckOut() { return checkOut; }

	public void setCheckOut(LocalDateTime checkOut) { this.checkOut = checkOut; }
	// #endEncapsulamiento
}
