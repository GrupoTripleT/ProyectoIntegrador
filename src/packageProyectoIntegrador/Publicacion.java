package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	
	private Inmueble inmueble;
	private Usuario propietario;
	
	private List<Reserva> reservas;
	
	public Publicacion(Inmueble inmueble, Usuario propitario) { 
		this.reservas = new ArrayList<Reserva>(); 
		setInmueble(inmueble);
		setPropietario(propitario);
	}
	
	public Inmueble getInmueble() { return inmueble; }
	
	public Usuario getPropietario() { return propietario; }

	public void setPropietario(Usuario propietario) { this.propietario = propietario; }

	public void setInmueble(Inmueble inmueble) { this.inmueble = inmueble; }
	
	public List<Reserva> getReservas() { return reservas; }

	public void setReservas(Reserva r) { this.reservas.add(r);}
	
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
