package packageProyectoIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.cglib.core.CollectionUtils;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class SitioTest {

	public Sitio sitioWeb;
	public Inmueble inmuebleDummy;
	public Usuario usuarioDummy;
	public Publicacion publicacionDummy;
	
	@BeforeEach
	void setUp() throws Exception {
		sitioWeb = new Sitio();
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
		assertEquals(true, sitioWeb.getPublicaciones().isEmpty());
		sitioWeb.publicar(publicacionDummy);
		assertEquals(1, sitioWeb.getPublicaciones().size());
	}
	
	@Test
	void testAprobarReserva() { 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate fechaEntrada = LocalDate.now();
		LocalDate fechaSalida = LocalDate.parse("24/10/2019", formatter);
		
		Usuario usuarioInquilinoDummy = mock (Usuario.class);
		Usuario usuarioPropiDummy = mock (Usuario.class);
		inmuebleDummy = mock (Inmueble.class);
		
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida, usuarioPropiDummy);

		Publicacion publicacion = new Publicacion(inmuebleDummy, usuarioInquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		
		sitioWeb.aprobarReserva(reserva);
		
		assertEquals(true, reserva.getEstado() instanceof EstadoAprobado);
		
	}

}
