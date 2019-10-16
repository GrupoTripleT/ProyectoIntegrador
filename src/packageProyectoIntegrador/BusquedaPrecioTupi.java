package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BusquedaPrecioTupi implements IBuscadorTupi {
	
	private Integer precioMin;
	private Integer precioMax;
	
	/*
	 *   constructor
	 *   leaf
	 */
	
	public BusquedaPrecioTupi (Integer precioMinimo, Integer precioMaximo) {
		
		this.precioMin = precioMinimo;
		this.precioMax = precioMaximo;
		
	}
	
	/*
	 *   implementacion
	 *   algoritmo de busqueda
	 */
	
	@Override
	public List<Publicacion> filtrarBusqueda(List<Publicacion> publicaciones) {
		
		return publicaciones;
		
	}
	
}
