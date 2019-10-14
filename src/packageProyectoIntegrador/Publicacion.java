package packageProyectoIntegrador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Publicacion {
	
	private String ciudad;
	private String tipoInmueble;
	private Set<String> servicios;
	private Integer capacidad;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private Integer precio;
	private Usuario propietario;
	
	private List<Reserva> reservas;
	
	public Publicacion() { 
		this.reservas = new ArrayList<Reserva>(); 
		servicios = new HashSet<String>();
	}
	
	// #Encapsulamiento
	public List<Reserva> getReservas() { return reservas; }

	public void setReservas(Reserva r) { this.reservas.add(r);}

	public Integer getPrecio() { return precio;}

	public void setPrecio(Integer precio) { this.precio = precio; }
	
	public Usuario getPropietario() { return propietario; }

	public void setPropietario(Usuario propietario) { this.propietario = propietario; }

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
	
	// #Metodos
	public boolean hayReservasEnFecha(LocalDate fe, LocalDate fs){		
		return reservas.stream().anyMatch(rs -> 
			(rs.getFechaEntrada().isEqual(fe) || rs.getFechaEntrada().isAfter(fe)) &&
			(rs.getFechaSalida().isEqual(fs) || rs.getFechaSalida().isBefore(fs)) &&
			rs.getEstado() instanceof EstadoAprobado); 
	}
	
	public void agregarReserva(Reserva r) {
		if (!hayReservasEnFecha(r.getFechaEntrada(), r.getFechaSalida())) {
			this.reservas.add(r);
		}
	}
	// #endMetodos
}
