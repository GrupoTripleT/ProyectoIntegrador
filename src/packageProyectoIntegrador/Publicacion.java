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
	
	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}
	
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
		}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	// #Metodos
	public boolean esCiudadPublicacion(String unaCiudad) {
		return (unaCiudad == this.getInmueble().getCiudad());
	}
	
	public boolean hayReservasEnFecha(LocalDate fe, LocalDate fs){	
		/*	proposito: evaluar si existe alguna reserva een estado aprobado y rango de fechas fe y fs.
		 *  Si existe alguna coincidencia denota true */
		return reservas.stream().anyMatch(rs -> 
			(esFechaIncluidaEnRangoFechas(fe, rs.getFechaEntrada(), rs.getFechaSalida()) ||
			esFechaIncluidaEnRangoFechas(fs, rs.getFechaEntrada(), rs.getFechaSalida())) &&
			rs.getEstado() instanceof EstadoAprobado); 
	}
	
	
	private boolean esFechaIncluidaEnRangoFechas(LocalDate fechaEvaluar, LocalDate rangoInicial, LocalDate rangoFinal) {
		/*	proposito: evaluar si fechaEvaluar esta en el rango de fechas rangoInicial a rangoFinal.
		 *  Si se encuentra en rango o es igual a alguno de sus extremos denota true */
		return  fechaEvaluar.isEqual(rangoInicial) || 
				fechaEvaluar.isEqual(rangoFinal) ||
				(fechaEvaluar.isAfter(rangoInicial) && fechaEvaluar.isBefore(rangoFinal));
	}
	
	public void agregarReserva(Reserva r) {
		if (!hayReservasEnFecha(r.getFechaEntrada(), r.getFechaSalida())) {
			this.reservas.add(r);
		}
	}
	// #endMetodos
}
