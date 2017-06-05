package Ahorcado;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PalabraTest {

	private Palabra palabraOculta;
	
	@Before
	public void setUp() throws Exception {
		palabraOculta = new Palabra();
		palabraOculta.elegirPalabra();
	}


	@Test
	public void testComprobarLetraUsada() {
		palabraOculta.comprobarLetra('j');
		assertTrue(palabraOculta.comprobarLetraUsada('j'));
	}

}
