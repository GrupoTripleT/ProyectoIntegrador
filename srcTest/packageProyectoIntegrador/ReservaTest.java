package packageProyectoIntegrador;

import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservaTest {
	
	
	Sitio site = new Sitio();
	Publicacion publicacion;
	Inmueble inmuebleDummy = mock(Inmueble.class);
	Usuario propiatarioDummy = mock(Usuario.class);
	Usuario inquilinoDummy = mock(Usuario.class);
	
	LocalDate fechaEntrada;
	LocalDate fechaSalida;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	Reserva reserva;
	
	@BeforeEach
	void setUp() throws Exception {
		publicacion = new Publicacion(inmuebleDummy, propiatarioDummy);
		site.publicar(publicacion);
	}

	@Test
	void agregarReserva() { 
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		assertEquals(1, publicacion.getReservas().size());
	}
	
	
	@Test
	void reservaNoValida() {
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		reserva.cambiarEstado(new EstadoAprobado());
		publicacion.agregarReserva(reserva);
		
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy); // intentar ingresar reserva misma fecha con una reserva ya aprobaba
		
		assertEquals(true, publicacion.hayReservasEnFecha(reserva.getFechaEntrada(), reserva.getFechaSalida()));
	}
	
	@Test
	void reservaValida() {
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		reserva.cambiarEstado(new EstadoAprobado()); // aprobacion de reserva
		
		publicacion.agregarReserva(reserva);
		
		fechaEntrada = LocalDate.parse("20/10/2020", formatter);
		fechaSalida = LocalDate.parse("30/10/2020", formatter);
		
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy); // no existe reserva previamente agregada en esta fecha
		
		assertEquals(false, publicacion.hayReservasEnFecha(reserva.getFechaEntrada(), reserva.getFechaSalida()));
		
		publicacion.agregarReserva(reserva);
		
		assertEquals(2, publicacion.getReservas().size());
	}
	
	@Test 
	void aprobarReserva(){
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		reserva.cambiarEstado(new EstadoAprobado());
		assertEquals(true, reserva.getEstado() instanceof EstadoAprobado);
		
	}

}
