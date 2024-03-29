package packageProyectoIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InmuebleTest {

	public Inmueble inmuebleDePrueba;
	public TipoDeInmueble departamento;
	public Usuario usuarioDummy;
	
	public Servicio agua;
	public Servicio luz;
	public Servicio internet;
	
	public List<Servicio> servicios;
	
	public LocalTime diezAM;
	public LocalTime trecePM;
	
	@BeforeEach
	void setUp() throws Exception {
		usuarioDummy = mock (Usuario.class);
		
		departamento = mock (TipoDeInmueble.class);
			when(departamento.getTipo()).thenReturn("Departamento");
	
		agua = mock (Servicio.class);
			when (agua.getTipoServicio()).thenReturn("Agua");
			
		luz = mock (Servicio.class);
			when (luz.getTipoServicio()).thenReturn("Luz");
		
		internet = mock (Servicio.class);
			when (internet.getTipoServicio()).thenReturn("Internet");
		
		servicios = new ArrayList<Servicio>(Arrays.asList(internet,agua,luz));

		inmuebleDePrueba = new Inmueble
				(usuarioDummy, departamento, 3, "Argentina", "Buenos Aires", "Calle Argentino Roca 4795", 
						servicios , 12000.00, diezAM, trecePM );
	}
	
	// los Getter 
	@Test
	void testLosGettersDeUnInmuebleTipoDeInmueble() {
		assertEquals(departamento, inmuebleDePrueba.getTipoDeInmueble());
	}
	
	@Test
	void testLosGettersDeUnInmuebleTipoDeInmuebleOptenidoDelTipoDeInmuebleString() {
		assertEquals("Departamento", inmuebleDePrueba.getElTipoDeInmueble());
	}
	
	@Test
	void testLosGettersDeUnInmuebleCapacidad() {
		assertEquals(3, inmuebleDePrueba.getCapacidad());
	}
	
	@Test
	void testLosGettersDeUnInmueblePais() {
		assertEquals("Argentina", inmuebleDePrueba.getPais());
	}
	
	@Test
	void testLosGettersDeUnInmuebleCiudad() {
		assertEquals("Buenos Aires", inmuebleDePrueba.getCiudad());
	}
	
	@Test
	void testLosGettersDeUnInmuebleDireccion() {
		assertEquals("Calle Argentino Roca 4795", inmuebleDePrueba.getDireccion());
	}
	
	@Test
	void testLosGettersDeUnInmueblePropietario() {
		assertEquals(usuarioDummy, inmuebleDePrueba.getPropietario());
	}
	
	@Test
	void testLosGettersDeUnInmuebleCheckIn() {
		assertEquals(diezAM, inmuebleDePrueba.getHorarioCheckIn());
	}
	
	@Test
	void testLosGettersDeUnInmuebleCheckOut() {
		assertEquals(trecePM, inmuebleDePrueba.getHorarioCheckOut());
	}
	
	@Test
	void testServicios() {
		assertTrue(inmuebleDePrueba.poseeEsteServicio(agua));
		assertTrue(inmuebleDePrueba.poseeEsteServicio(internet));
		assertTrue(inmuebleDePrueba.poseeEsteServicio(luz));
		
	}
	
	@Test 
	void testPrecio() {
		assertEquals(12000.00, inmuebleDePrueba.getPrecio());
	}
	
	@Test
	void testGetterHoraCheckIn() {

	}
	
	@Test
	void testGetterHoraCheckOut() {
		
	}
	// Los Setters
	@Test
	void testSettersDeUnInmueble() {
		
	}
	
	
}
