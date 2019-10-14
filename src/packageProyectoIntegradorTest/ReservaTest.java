package packageProyectoIntegradorTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packageProyectoIntegrador.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservaTest {
	
	
	Sitio site = new Sitio();
	Publicacion p1 = new Publicacion();

	@BeforeEach
	void setUp() throws Exception {
		
		
		p1.setCiudadDestino("BuenosAires");

		p1.setPrecio(500);
		p1.setCantHuesped(5);
		Usuario prop = new Usuario();
		p1.setPropietario(prop);
		
		site.publicar(p1);
		
	}

	@Test
	void agregarReserva() { 
		LocalDate now = LocalDate.now();
		//LocalDate later = LocalDate.parse(String.format("24/10/2019", LocalDate.now().getDayOfMonth() + 10, LocalDate.now().getMonthValue()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate later = LocalDate.parse("24/10/2019", formatter);
		
		Usuario inq = new Usuario();
		Reserva res = new Reserva(now, later, inq);
		
		
		p1.agregarReserva(res);
		assertEquals(1, p1.getReservas().size());
	}
	
	
	@Test
	void agregarValidarReserva() {
		LocalDate now = LocalDate.now();
		//LocalDate later = LocalDate.parse(String.format("24/10/2019", LocalDate.now().getDayOfMonth() + 10, LocalDate.now().getMonthValue()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate later = LocalDate.parse("24/10/2019", formatter);
		
		Usuario inq = new Usuario();
		Reserva res = new Reserva(now, later, inq);
		res.cambiarEstado(new EstadoAprobado());
		p1.agregarReserva(res);
		
		Usuario inq2 = new Usuario();
		//Reserva res2 = new Reserva(now, later, inq2);
		
		assertEquals(false, p1.esReservaValida(now, later));
	}
	
	@Test 
	void aprobarReserva(){

		
	}

}
