package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	
	private String ciudadDestino;
	private String fechaEntrada;
	private String fechaSalida;
	private Integer precio;
	private Integer cantHuesped;
	
	private List<Reserva> reservas;
	
	public Publicacion() { this.reservas = new ArrayList<Reserva>(); }
	
	public List<Reserva> getReservas() { return reservas; }

	public void setReservas(Reserva r) { this.reservas.add(r);}
	
	public String getCiudadDestino() { return ciudadDestino;}

	public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }

	public String getFechaEntrada() { return fechaEntrada;}

	public void setFechaEntrada(String fechaEntrada) { this.fechaEntrada = fechaEntrada ;}

	public String getFechaSalida() { return fechaSalida;}

	public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }

	public Integer getPrecio() { return precio;}

	public void setPrecio(Integer precio) { this.precio = precio; }

	public Integer getCantHuesped() { return cantHuesped; }

	public void setCantHuesped(Integer cantHuesped) { this.cantHuesped = cantHuesped; }
	
	
	public boolean esReservaValida(Reserva r){		
		return reservas.stream().anyMatch(
					rs -> rs.getFechaEntrada().isEqual(r.getFechaEntrada()) || rs.getFechaEntrada().isAfter(r.getFechaEntrada()) &&
						  rs.getFechaSalida().isEqual(r.getFechaSalida()) || rs.getFechaSalida().isBefore(r.getFechaSalida()) &&
					      !(rs.getEstado() instanceof EstadoAprobado)
				); 
	}
	
	public void agregarReserva(Reserva r) {
		if (esReservaValida(r)) {
			this.reservas.add(r);
		}
	}

}
