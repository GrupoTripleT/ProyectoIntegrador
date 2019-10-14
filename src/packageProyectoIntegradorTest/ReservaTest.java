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
		LocalDate fechaEntrada = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate fechaSalida = LocalDate.parse("24/10/2019", formatter);
		
		Usuario inq = new Usuario();
		Reserva res = new Reserva(fechaEntrada, fechaSalida, inq);
		
		
		p1.agregarReserva(res);
		assertEquals(1, p1.getReservas().size());
	}
	
	
	@Test
	void reservaNoValida() {
		LocalDate fechaEntrada = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate fechaSalida = LocalDate.parse("24/10/2019", formatter);
		
		Usuario inq = new Usuario();
		Reserva res = new Reserva(fechaEntrada, fechaSalida, inq);
		
		res.cambiarEstado(new EstadoAprobado());
		p1.agregarReserva(res);
		
		
		Usuario inq2 = new Usuario();
		Reserva res2 = new Reserva(fechaEntrada, fechaSalida, inq2); // intentar ingresar reserva misma fecha con una reserva ya aprobaba
		
		assertEquals(true, p1.hayReservasEnFecha(res2.getFechaEntrada(), res2.getFechaSalida()));
	}
	
	@Test
	void reservaValida() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		LocalDate now = LocalDate.now();
		LocalDate later = LocalDate.parse("24/10/2019", formatter);
		
		Usuario inq = new Usuario();
		Reserva res = new Reserva(now, later, inq);
		res.cambiarEstado(new EstadoAprobado());
		p1.agregarReserva(res);
		
		LocalDate nowReserva3 = LocalDate.parse("20/10/2020", formatter);
		LocalDate laterReserva3 = LocalDate.parse("30/10/2020", formatter);
		
		Usuario inq2 = new Usuario();
		Reserva res3 = new Reserva(nowReserva3, laterReserva3, inq2); // no existe reserva previamente agregada en esta fecha
		
		assertEquals(false, p1.hayReservasEnFecha(res3.getFechaEntrada(), res3.getFechaSalida()));
		
		p1.agregarReserva(res3);
		
		assertEquals(2, p1.getReservas().size());
		
	}
	
	@Test 
	void aprobarReserva(){

		
	}

}
