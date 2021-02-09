package cuentatarjeta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	Movimiento m;
	@BeforeEach
	void setup() {
		m = new Movimiento();
	}

	@Test
	void testSetConcepto() {
		m.setConcepto("Test");
		assertEquals("Test",m.getConcepto());
	}


	@Test
	void testSetFecha() {
		Date d = new Date();
		m.setFecha(d);
		assertEquals(d,m.getFecha());
	}

	@Test
	void testSetImporte() {
		m.setImporte(100);
		assertEquals(100,m.getImporte());
	}

}
