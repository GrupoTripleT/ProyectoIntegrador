package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	
	private String ciudadDestino;
	private Integer precio;
	private Integer cantHuesped;
	private Usuario propietario;
	
	private List<Reserva> reservas;
	
	public Publicacion() { this.reservas = new ArrayList<Reserva>(); }
	
	public List<Reserva> getReservas() { return reservas; }

	public void setReservas(Reserva r) { this.reservas.add(r);}
	
	public String getCiudadDestino() { return ciudadDestino;}

	public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }

	public Integer getPrecio() { return precio;}

	public void setPrecio(Integer precio) { this.precio = precio; }

	public Integer getCantHuesped() { return cantHuesped; }

	public void setCantHuesped(Integer cantHuesped) { this.cantHuesped = cantHuesped; }
	
	public Usuario getPropietario() { return propietario; }

	public void setPropietario(Usuario propietario) { this.propietario = propietario; }
	
	public boolean esReservaValida(LocalDate fe, LocalDate fs){		
		return reservas.stream().anyMatch(
					rs -> rs.getFechaEntrada().isEqual(fe) || rs.getFechaEntrada().isAfter(fe) &&
						  rs.getFechaSalida().isEqual(fs) || rs.getFechaSalida().isBefore(fs) &&
					      !(rs.getEstado() instanceof EstadoAprobado)
				); 
	}
	
	public void agregarReserva(Reserva r) {
		if (!hayReservas() || esReservaValida(r.getFechaEntrada(), r.getFechaSalida())) {
			this.reservas.add(r);
		}
	}
	
	private boolean hayReservas() {
		return getReservas().size() > 0;
	}

}
