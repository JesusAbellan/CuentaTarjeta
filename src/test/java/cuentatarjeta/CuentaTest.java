package cuentatarjeta;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

	Cuenta c;
	@BeforeEach
	void setup() {
		c = new Cuenta("111","Pepe");
	}
	
	@Test
	void testIngresarDouble() throws Exception {
		c.ingresar(100);
		assertEquals(100,c.getSaldo());
		assertThrows(Exception.class, () -> c.ingresar(-100), "No se puede ingresar una cantidad negativa");
		
	}

	@Test
	void testRetirarDouble() throws Exception{
		c.ingresar(1000);
		c.retirar(100);
		assertEquals(900, c.getSaldo());
		assertThrows(Exception.class, () -> c.retirar(2000));
	}

	@Test
	void testIngresarStringDouble() throws Exception{
		c.ingresar("Jaja Salu2",100);
		assertEquals(100,c.getSaldo());
		assertThrows(Exception.class, () -> c.ingresar("Jaja Salu2",-100), "No se puede ingresar una cantidad negativa");
	}

	@Test
	void testRetirarStringDouble() throws Exception{
		c.ingresar(1000);
		c.retirar("Jaja salu2",100);
		assertEquals(900, c.getSaldo());
		assertThrows(Exception.class, () -> c.retirar("Jaja salu2", 2000));
	}
}
