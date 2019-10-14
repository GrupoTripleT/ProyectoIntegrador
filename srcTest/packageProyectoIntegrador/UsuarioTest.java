package packageProyectoIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packageProyectoIntegrador.*;

class UsuarioTest {

	public  Usuario usuarioPrueba;
	
	@BeforeEach
	void setUp() throws Exception {
		usuarioPrueba = new Usuario("Nicolas","Tancredi","prueba@hotmail.com", 1135234355);
		
	}

	//Testeo  el constructor de usuario
	@Test
	void testNombre() {
		assertEquals("Nicolas",usuarioPrueba.getNombre());
	}

	@Test
	void testApellido() {
		assertEquals("Tancredi",usuarioPrueba.getApellido());
	}
	
	@Test
	void testMail() {
		assertEquals("prueba@hotmail.com",usuarioPrueba.getMail());
	}
	
	
	@Test
	void testNumero() {
		assertEquals(1135234355,usuarioPrueba.getNumero());
	}
	
}
