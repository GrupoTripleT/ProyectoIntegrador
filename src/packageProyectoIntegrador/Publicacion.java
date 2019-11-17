package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Publicacion {

	private Inmueble inmueble;
	private Set<Reserva> reservas;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Publicacion(Inmueble inmueble, LocalDate fechaFin) {
		this.setReservas(new HashSet<Reserva>());
		setInmueble(inmueble);
		setFechaInicio(LocalDate.now());
		setFechaFin(fechaFin);
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	private void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	private void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
		}

	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public String getPublicacionCiudad() {
		return this.getInmueble().getCiudad();
	}


	// #Metodos

	public boolean hayReservasEnFecha(LocalDate fe, LocalDate fs){
		/*	proposito: evaluar si existe alguna reserva een estado aprobado y rango de fechas fe y fs.
		 *  Si existe alguna coincidencia denota true */
		return reservas.stream().anyMatch(rs ->
			(esFechaIncluidaEnRangoFechas(fe, rs.getFechaEntrada(), rs.getFechaSalida()) ||
			esFechaIncluidaEnRangoFechas(fs, rs.getFechaEntrada(), rs.getFechaSalida())) &&
			rs.getEstado().esEstadoAprobado());
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

	public void aprobarReserva(Reserva r) {
		r.aprobarReserva();
	}
	
	public void finalizarReserva(Reserva r) {
		r.finalizarReserva();
	}
	
	public void cancelarReserva(Reserva r) {
		r.cancelarReserva();
	}

	public Boolean estaVigente () {
		/*	proposito: evalua si la publicacion está vigente (no finalizo).
		 *  compara fechaFin con la fecha de cuando se llama el metodo */
		 return this.getFechaFin().isAfter(LocalDate.now());
	}

	// #endMetodos
}
