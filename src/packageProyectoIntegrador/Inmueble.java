package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.Set;

public class Inmueble {
	
	private String tipoDeInmueble;
	private Integer capacidad;
	private String pais;
	private String ciudad;
	private String direccion;
	private Set<Servicio> servicios;
	private Double precio;
	private LocalDate horarioCheckIn;
	private LocalDate horarioCheckOut;
	
}
