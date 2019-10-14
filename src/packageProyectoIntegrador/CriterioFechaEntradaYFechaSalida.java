package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CriterioFechaEntradaYFechaSalida extends Criterio {
	
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


	@Override
	public Set<Publicacion> filtrar(Set<Publicacion> publicaciones) {
		// TODO Auto-generated method stub
		return 
		publicaciones.stream().filter(publicacion -> publicacion.esResevaValida(this.getFechaDeEntrada(),
				this.getFechaDeSalida())).collect(Collectors.toSet());
	}

}
