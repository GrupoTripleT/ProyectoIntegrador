package packageProyectoIntegrador;

import java.util.ArrayList;
import java.util.List;

public class Buscador implements IBuscador {


	@Override
	public List<Publicacion> Buscar(List<Publicacion> publicaciones, FiltrosBusqueda filtros) {
		// TODO:
		//return  publicaciones.filter(s => s.ciudadDestino == criterio.ciudadDestino
		//							 s.fechaIngreso == criterio.fechaIngreso											
		//						     s.fechaSalida ==  crioterio.fechaSalida)
		//
		
		List<Publicacion> PublicacionesAux = new ArrayList<Publicacion>();
		for (Publicacion e : publicaciones)  
        { 
            if (e.getCiudadDestino() == filtros.ciudadDestino &&
            	!e.hayReservasEnFecha(filtros.fechaEntrada, filtros.fechaSalida)) 
            { 
            	PublicacionesAux.add(e);
            } 
        } 
		return PublicacionesAux;
	}
}
