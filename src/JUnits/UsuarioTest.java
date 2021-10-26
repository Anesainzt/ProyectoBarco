package JUnits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Clases.Usuario;

class UsuarioTest {
	Usuario u1 = new Usuario("Mikel","Mingo","79223791S","xxxxx","mikelmingo","123456789");
	@Test
	public void testNombre() {
		
		assertEquals("Mikel", u1.getNombre());
		
	}
	@Test
	public void testDni() {
		
		assertEquals("79223791S", u1.getDni());
		
	}
	@Test
	public void testTarjeta() {
		
		assertEquals("xxxxx", u1.getTarjeta());
		
	}
	
	@Test
	public void testLogin() {
		
		assertEquals("mikelmingo", u1.getLogin());
		
	}
	@Test
	public void testContraseña() {
		
		assertEquals("123456789", u1.getContraseña());
		
	}
	@Test
	public void testApellido() {
		
		assertEquals("Mingo", u1.getApellido());
		
	}
	
	

}
