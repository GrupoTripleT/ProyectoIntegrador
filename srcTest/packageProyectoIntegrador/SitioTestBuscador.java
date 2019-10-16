package packageProyectoIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SitioTestBuscador {

	public Sitio sitioWeb;
	
	public FiltroFechaEntradaYFechaSalida fechas;
	public FiltroXCiudad cuidad;
	
	@BeforeEach
	void setUp() throws Exception {
		cuidad = new FiltroXCiudad("Buenos Aires");
		//fechas = new FiltroFechaEntradaYFechaSalida();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
