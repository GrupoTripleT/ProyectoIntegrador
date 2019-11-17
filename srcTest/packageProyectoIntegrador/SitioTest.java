package packageProyectoIntegrador;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class SitioTest {

	public Sitio sitioWeb;
	public Inmueble inmuebleDummy;
	public Usuario usuarioDummy;
	public Publicacion publicacionDummy;
	public TipoDeInmueble unTipoInmueble;
	public TipoDeInmueble tipoInmuebleDummy1;
	public TipoDeInmueble tipoInmuebleDummy2;
	public Servicio unServicio;
	public Servicio tipoServicioDummy1;
	public Servicio tipoServicioDummy2;
	
	@BeforeEach
	void setUp() throws Exception {
		sitioWeb = new Sitio();
	}
	
	@Test
	void testCrearNuevosTipoDeInmueble() {
		unTipoInmueble = new TipoDeInmueble("Casa");
		
		assertEquals("Casa", unTipoInmueble.getTipo());
	}
	
	@Test
	void testAgregarTiposDeInmuebles() {
		tipoInmuebleDummy1 = mock (TipoDeInmueble.class);
		tipoInmuebleDummy2 = mock (TipoDeInmueble.class);
		
		sitioWeb.registrarTipoDeInmueble(tipoInmuebleDummy1);
		sitioWeb.registrarTipoDeInmueble(tipoInmuebleDummy2);
		
		assertEquals(2, sitioWeb.getTiposDeInmuebles().size());
		assertTrue(sitioWeb.getTiposDeInmuebles().contains(tipoInmuebleDummy1));
	}
	
	@Test
	void testCrearNuevosServicios() {
		unServicio = new Servicio("WiFi");
		
		assertEquals("WiFi", unServicio.getTipoServicio());
	}
	
	@Test
	void testAgregarTiposDeServicios() {
		tipoServicioDummy1 = mock (Servicio.class);
		tipoServicioDummy2 = mock (Servicio.class);
		
		sitioWeb.registrarServicio(tipoServicioDummy1);
		sitioWeb.registrarServicio(tipoServicioDummy2);
		
		assertEquals(2, sitioWeb.getServicios().size());
		assertTrue(sitioWeb.getServicios().contains(tipoServicioDummy2));	
	}
	
	@Test
	void testPoderAgregarInmueble() { //testeo que creado el inmueble el sitio lo pueda guardar correctamente
		inmuebleDummy = mock (Inmueble.class);
		assertEquals(true, sitioWeb.getInmuebles().isEmpty());

		sitioWeb.registrarInmueble(inmuebleDummy);
		assertEquals(1, sitioWeb.getInmuebles().size());
	}
	
	@Test
	void testPoderAgregarUnUsuarioAlSitio() {
		usuarioDummy = mock(Usuario.class);
		assertEquals(true, sitioWeb.getUsuarios().isEmpty());
		sitioWeb.registrarUsuario(usuarioDummy);
		assertEquals(1,sitioWeb.getUsuarios().size());
	}
	
	@Test
	void testPodePublicarInmueble() { // Testeo que creado la publicacion el sitio lo pueda guardar correctamente
		publicacionDummy = mock (Publicacion.class);
			when(publicacionDummy.estaVigente()).thenReturn(true);
		assertEquals(true, sitioWeb.getPublicaciones().isEmpty());
		sitioWeb.publicar(publicacionDummy);
		assertEquals(1, sitioWeb.getPublicaciones().size());
	}
	
	@Test
	void testAprobarReserva() { 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate fechaEntrada = LocalDate.now();
		LocalDate fechaSalida = LocalDate.parse("24/10/2019", formatter);
		
		Usuario usuarioPropiDummy = mock (Usuario.class);
		inmuebleDummy = mock (Inmueble.class);
		
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida, usuarioPropiDummy);

		Publicacion publicacion = new Publicacion(inmuebleDummy, LocalDate.parse("24/10/2020", formatter));
		
		publicacion.agregarReserva(reserva);
		
		sitioWeb.aprobarReserva(publicacion, reserva);
		
		assertEquals(true, reserva.getEstado().esEstadoAprobado());
		
	}

}
