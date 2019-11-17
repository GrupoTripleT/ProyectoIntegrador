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
		publicacion = new Publicacion(inmuebleDummy, LocalDate.parse("24/10/2020", formatter));
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
	void noSePuedeAgregarReserva() { 
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		
		assertEquals(1, publicacion.getReservas().size());
	}
	
	
	@Test
	void reservaNoValidaFechaEntrada() {
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		
		//nueva reserva 
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy); // intentar ingresar reserva misma fecha con una reserva ya aprobaba
		
		assertEquals(true, publicacion.hayReservasEnFecha(reserva.getFechaEntrada(), reserva.getFechaSalida()));
	}
	
	@Test
	void reservaNoValidaFechaSalida() {
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		
		//nueva reserva 
		fechaEntrada = LocalDate.parse("01/01/0001", formatter); // solo para probar miss branchs test (coverage)
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy); // intentar ingresar reserva misma fecha con una reserva ya aprobaba
		
		
		assertEquals(true, publicacion.hayReservasEnFecha(reserva.getFechaEntrada(), reserva.getFechaSalida()));
	}
	
	@Test
	void reservaNoValidaFechaEntradaEnRango() {
		fechaEntrada = LocalDate.now() ;
		fechaSalida = LocalDate.parse("24/11/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		
		//nueva reserva 
		fechaEntrada = fechaEntrada.plusDays(1); // solo para probar miss branchs test (coverage)
		fechaSalida = fechaSalida.plusDays(1);
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy); // intentar ingresar reserva misma fecha con una reserva ya aprobaba
		
		
		assertEquals(true, publicacion.hayReservasEnFecha(reserva.getFechaEntrada(), reserva.getFechaSalida()));
	}
	
	@Test
	void reservaValidaReservaEncontradaNoAprobada() {
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		
		publicacion.agregarReserva(reserva);
		
		//nueva reserva 
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy); // intentar ingresar reserva misma fecha con una reserva ya aprobaba
		
		assertEquals(false, publicacion.hayReservasEnFecha(reserva.getFechaEntrada(), reserva.getFechaSalida()));
	}
	
	@Test
	void reservaValida() {
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);
		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		
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
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		assertEquals(true, reserva.getEstado().esEstadoAutorizado());
		
	}
	
	@Test 
	void cancelarReserva(){
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		publicacion.agregarReserva(reserva);
		publicacion.cancelarReserva(reserva);
		assertEquals(false, reserva.getEstado() instanceof EstadoCancelado);
	}
	
	@Test 
	void finalizarReserva(){
		fechaEntrada = LocalDate.now();
		fechaSalida = LocalDate.parse("24/10/2019", formatter);

		reserva = new Reserva(fechaEntrada, fechaSalida, inquilinoDummy);
		publicacion.agregarReserva(reserva);
		publicacion.aprobarReserva(reserva);
		publicacion.finalizarReserva(reserva);
		assertEquals(true, reserva.getEstado() instanceof EstadoFinalizado);
	}

}
