package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.List;

public class Publicacion {
	
	private Inmueble inmueble;
	private Usuario propietario;
	
	private List<Reserva> reservas;
	
	
	public String getCiudad() {
		return this.getInmueble().getCiudad();
	}
	
	public Inmueble getInmueble() {
		return this.inmueble;
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}

	public List<Reserva> getTodasLasReservasFinalizadas(){
		return null;
	}
	
	public List<Reserva> getTodasLasReservasAprobadas(){
		return null;
	}
	
	private Boolean hayReservas() {
		return getReservas().size() > 0;
	}	
	
	public Boolean esResevaValida(LocalDate fe, LocalDate fs){
		return reservas.stream().anyMatch(
				rs -> rs.getFechaEntrada().isEqual(fe) || rs.getFechaEntrada().isAfter(fe) &&
					  rs.getFechaSalida().isEqual(fs) || rs.getFechaSalida().isBefore(fs) &&
				      !(rs.getEstado() instanceof EstadoAprobado)
			);
	}
}
