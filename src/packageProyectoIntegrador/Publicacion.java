package packageProyectoIntegrador;

import java.time.LocalDate;
import java.util.List;

public class Publicacion {
	
	private Inmueble inmueble;
	private Usuario propietario;
	
	
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	public Usuario getPropietario() {
		return propietario;
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	
	
}
