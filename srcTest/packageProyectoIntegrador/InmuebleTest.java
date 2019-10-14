package packageProyectoIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.util.converter.LocalTimeStringConverter;
import packageProyectoIntegrador.*;

import static org.mockito.Mockito.*;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.LocalTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class InmuebleTest {

	public Inmueble inmuebleDePrueba;
	public TipoDeInmueble departamento;
	
	public Servicio agua;
	public Servicio luz;
	public Servicio internet;
	
	public List<Servicio> servicios;
	
	public LocalTime diezAM;
	public LocalTime trecePM;
	
	@BeforeEach
	void setUp() throws Exception {
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
				(departamento, 3, "Argentina", "Buenos Aires", "Calle Argentino Roca 4795", 
						servicios , 12000.00, diezAM, trecePM );
	}
	
	
	
	

	//Testeo  el constructor de inmueble
	@Test
	void test() {
		
	}

	// los Getter 
	@Test
	void testLosGettersDeUnInmuebleTipoDeInmueble() {
		assertEquals("Departamento", inmuebleDePrueba.saberTipoDeInmueble());
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
