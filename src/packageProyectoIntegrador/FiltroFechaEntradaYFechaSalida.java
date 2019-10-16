package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class FiltroFechaEntradaYFechaSalida implements IFiltro {
	
	private LocalDate fechaDeEntrada;
	private LocalDate fechaDeSalida;
	

	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
	}


	public void setFechaDeEntrada(LocalDate fechaDeEntrada) {
		this.fechaDeEntrada = fechaDeEntrada;
	}


	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}


	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	

	public FiltroFechaEntradaYFechaSalida(LocalDate fechaDeEntrada, LocalDate fechaDeSalida) {
		super();
		this.fechaDeEntrada = fechaDeEntrada;
		this.fechaDeSalida = fechaDeSalida;
	}


	@Override
	public Set<Publicacion> aplicarFiltro(Set<Publicacion> publicaciones) {		
		Set<Publicacion> auxSet = new HashSet<Publicacion>();
		
		for(Publicacion p : publicaciones) {
			if(p.hayReservasEnFecha(this.getFechaDeEntrada(),this.getFechaDeSalida())) {
				auxSet.add(p);
			}
			
		}
		return auxSet;
	}

}