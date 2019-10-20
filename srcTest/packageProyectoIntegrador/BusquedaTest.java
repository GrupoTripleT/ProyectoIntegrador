package packageProyectoIntegrador;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class BusquedaTest {
	
	public Publicacion publicacionUbicacionCordoba;
	public Publicacion publicacionUbicacionCordoba2;
	public Publicacion publicacionUbicacionBuenosAires;
	public Publicacion publicacionUbicacionBuenosAires2;
	
	public Usuario usuarioDammy;
	public Inmueble inmuebleDammyCiudadCordoba;
	public Inmueble inmuebleDammyCiudadBA;
	
	public Usuario inquilinoDummy;
	
	public Buscador buscador;  //El objeto a testear
	
	public FiltroCiudad filtroCiudadPrueba;
	public FiltroFecha filtroFechaPrueba;
	
	public LocalDate fechaEntrada;
	public LocalDate fechaSalida;
	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	public Sitio sitio = new Sitio();
	
	public Reserva reserva;
	public Reserva reserva2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		usuarioDammy = mock(Usuario.class);
		inquilinoDummy = mock(Usuario.class);
		
		inmuebleDammyCiudadCordoba = mock(Inmueble.class);
			when(inmuebleDammyCiudadCordoba.getCiudad()).thenReturn("Cordoba");
			
		inmuebleDammyCiudadBA = mock(Inmueble.class);
			when(inmuebleDammyCiudadBA.getCiudad()).thenReturn("Buenos Aires");
			
		
		publicacionUbicacionCordoba = new Publicacion(inmuebleDammyCiudadCordoba, usuarioDammy);
			
		publicacionUbicacionCordoba2 = new Publicacion(inmuebleDammyCiudadCordoba, usuarioDammy);
			
		publicacionUbicacionBuenosAires = new Publicacion(inmuebleDammyCiudadBA, usuarioDammy);
		publicacionUbicacionBuenosAires2 = new Publicacion(inmuebleDammyCiudadBA, usuarioDammy);

		buscador = new Buscador();		
	}
	
	@Test
	void testDeBusquedaXCiuedad() {
		sitio.publicar(publicacionUbicacionBuenosAires);
		sitio.publicar(publicacionUbicacionCordoba);
		sitio.publicar(publicacionUbicacionCordoba2);
		
		filtroCiudadPrueba = new FiltroCiudad("Buenos Aires");
		buscador.agregarFiltro(filtroCiudadPrueba);
		
		assertTrue(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionBuenosAires));
		assertFalse(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionCordoba));
		assertFalse(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionCordoba));
		
	}
	
	@Test
	void testDeBusquedaXFechas() {
		
		fechaEntrada = LocalDate.parse("02/09/2019", formatter);
		fechaSalida = LocalDate.parse("10/10/2019", formatter);
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacionUbicacionBuenosAires.agregarReserva(reserva);
		publicacionUbicacionBuenosAires.aprobarReserva(reserva);
		
		sitio.publicar(publicacionUbicacionBuenosAires);
		
		filtroFechaPrueba = new FiltroFecha(LocalDate.parse("20/10/2019", formatter), LocalDate.parse("25/10/2019", formatter));
		buscador.agregarFiltro(filtroFechaPrueba);
		
		assertTrue(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionBuenosAires));
	}
	
	@Test
	void testDeBusquedaXFechasFalso() {
		
		fechaEntrada = LocalDate.parse("02/10/2019", formatter);
		fechaSalida = LocalDate.parse("22/10/2019", formatter);
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacionUbicacionBuenosAires.agregarReserva(reserva);
		publicacionUbicacionBuenosAires.aprobarReserva(reserva);
		
		sitio.publicar(publicacionUbicacionBuenosAires);
		
		filtroFechaPrueba = new FiltroFecha(LocalDate.parse("20/10/2019", formatter), LocalDate.parse("25/10/2019", formatter));
		buscador.agregarFiltro(filtroFechaPrueba);
		
		assertFalse(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionBuenosAires));
		assertTrue(sitio.buscarPublicaciones(buscador).isEmpty());
	}
	
	@Test
	void testDeBusquedaConbinadaEntreCiudadYFecha() {
		reserva = new Reserva(LocalDate.parse("02/10/2019", formatter), LocalDate.parse("18/10/2019", formatter), inquilinoDummy);

		publicacionUbicacionBuenosAires.agregarReserva(reserva);
		publicacionUbicacionBuenosAires.aprobarReserva(reserva);
		
		reserva2 = new Reserva(LocalDate.parse("20/10/2019", formatter), LocalDate.parse("25/10/2019", formatter), inquilinoDummy);
		publicacionUbicacionBuenosAires2.agregarReserva(reserva2);
		publicacionUbicacionBuenosAires2.aprobarReserva(reserva2);
		
		sitio.publicar(publicacionUbicacionBuenosAires);
		sitio.publicar(publicacionUbicacionCordoba);
		sitio.publicar(publicacionUbicacionCordoba2);
		sitio.publicar(publicacionUbicacionBuenosAires2);
		
		filtroCiudadPrueba = new FiltroCiudad("Buenos Aires");
		filtroFechaPrueba = new FiltroFecha(LocalDate.parse("20/10/2019", formatter), LocalDate.parse("25/10/2019", formatter));
		
		buscador.agregarFiltro(filtroFechaPrueba);
		buscador.agregarFiltro(filtroCiudadPrueba);
		
		assertTrue(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionBuenosAires));
		assertFalse(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionCordoba));
		assertFalse(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionCordoba2));
		assertFalse(sitio.buscarPublicaciones(buscador).contains(publicacionUbicacionBuenosAires2));
	}

}
