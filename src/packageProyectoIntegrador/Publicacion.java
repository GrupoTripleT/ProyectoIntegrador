package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	
	public String ciudadDestino;
	public String fechaEntrada;
	public String fechaSalida;
	public Integer precio;
	public Integer cantHuesped;
	
	private List<Reserva> reservas;
	
	public Publicacion() {
		this.reservas = new ArrayList<Reserva>();
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Reserva r) {
		this.reservas.add(r);
	}
	
	public boolean esReservaValida(Reserva r){
		// TODO:
		// realizar un loop en lista de reserva analizando fechas, para disponibilidad y verificando estado
		return true;
	}
	
	public void agregarReserva(Reserva r) {
		if (esReservaValida(r)) {
			this.reservas.add(r);
		}
	}
}
