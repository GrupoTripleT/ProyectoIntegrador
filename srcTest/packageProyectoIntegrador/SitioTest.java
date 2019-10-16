package packageProyectoIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

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
	
	

}
