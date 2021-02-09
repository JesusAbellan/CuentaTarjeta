package cuentatarjeta;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditoTest {
	
	Credito c;
	Cuenta cu;
	@BeforeEach
	void setup() {
		c = new Credito("000","Pepe",new Date(2022, 1, 15), 3000);
		cu = new Cuenta ("111","Pepe");
		c.setCuenta(cu);
	}

	@Test
	void testRetirar() throws Exception {
		c.retirar(100);
		assertEquals(105,c.getSaldo());
		assertThrows(Exception.class, () -> c.retirar(4000),"No tienes suficiente dinero");
	}

	@Test
	void testIngresar() throws Exception{
		c.ingresar(100);
		assertEquals(100,c.getSaldo());
	
	}

	@Test
	void testPagoEnEstablecimiento() throws Exception{
		c.pagoEnEstablecimiento("Test",100);
		assertEquals(100,c.getSaldo());
		assertThrows(Exception.class, () -> c.pagoEnEstablecimiento("Test",4000),"No tienes suficiente dinero");
	}

	@Test
	void testGetSaldo() {
		assertEquals(0,c.getSaldo());
	}

	@Test
	void testGetCreditoDisponible() throws Exception {
		assertEquals(3000,c.getCreditoDisponible());
		c.pagoEnEstablecimiento("Test",100);
		assertEquals(2900,c.getCreditoDisponible());
	}
}
