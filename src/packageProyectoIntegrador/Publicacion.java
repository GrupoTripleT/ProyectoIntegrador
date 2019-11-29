package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

	private Set<Reserva> getReservasAprobadas() {
		/* proporsito: retorna una lista de reservas aprbadas */
		return this.getReservas().stream()
			.filter(rs -> rs.estaAprobada())
				.collect(Collectors.toSet());
	}

	private boolean hayReservasEnFecha(LocalDate fe, LocalDate fs){
		/*	proposito: alternativa al check de fechas.
		 *  Si existe alguna coincidencia denota true */
		return this.getReservasAprobadas().stream().anyMatch(rs ->
			this.noHayFechasSolapadas(rs.getFechaEntrada(), rs.getFechaSalida(), fe, fs)
				);
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

	private boolean noHayFechasSolapadas(LocalDate inicio,LocalDate fin, LocalDate fe, LocalDate fs) {
		/*	proposito: verifica (denota "true") que un rango de fechas de "inicion:fin" no esté
		 		contenido dentro dentro de otro rango de fechas "fe:fs"*/
		return fs.isBefore(inicio) || fe.isAfter(fin);
	}

	public Boolean estaVigente () {
		/*	proposito: evalua si la publicacion está vigente (no finalizo).
		 *  compara fechaFin con la fecha de cuando se llama el metodo */
		 return this.getFechaFin().isAfter(LocalDate.now());
	}

	public boolean esReservaValida(Reserva rs) {
		/*	proposito: verifica (denota "true") que las fechas de la reserva esten contenidas
				dentro del rango de fechas de la publicacion	*/
		return !this.noHayFechasSolapadas(this.getFechaInicio(), this.getFechaFin(), rs.getFechaEntrada(), rs.getFechaSalida());
	}

	// #endMetodos
}
