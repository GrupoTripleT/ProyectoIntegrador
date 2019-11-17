package packageProyectoIntegrador;

public class FiltroCiudad extends Filtro {

	private String ciudad;
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public FiltroCiudad (String unaCiudad) {
		this.setCiudad(unaCiudad);
	}
	
	
	public Boolean esPublicacionFiltrada(Publicacion publicacion) {
		return publicacion.getPublicacionCiudad().equals(this.getCiudad());
	}

}
