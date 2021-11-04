package JUnits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Clases.Usuario;

class UsuarioTest {
	
	Usuario u1 = new Usuario("Mikel","Mingo","79223791S","xxxx xxxx xxxx xxxx","mikelmingo","123456789", "mikelmingo@opendeusto.es");
	Usuario u2 = new Usuario();
	@Test
	public void getNombre() {
		
		assertEquals("Mikel", u1.getNombre());
	}
	
	
	@Test
	public void testDni() {

		assertEquals("79223791S", u1.getDni());
		
	}
	@Test
	public void testTarjeta() {
		
		assertEquals("xxxx xxxx xxxx xxxx", u1.getTarjeta());
		
	}
	
	@Test
	public void testLogin() {
		
		assertEquals("mikelmingo", u1.getLogin());
		
	}
	@Test
	public void testContraseña() {
		
		assertEquals("123456789", u1.getContrasenya());
		
	}
	@Test
	public void testApellido() {
		
		assertEquals("Mingo", u1.getApellido());
		
	}
	
	@Test
	public void testemail() {
		
		assertEquals("mikelmingo@opendeusto.es", u1.getEmail());
		
	}
	
	
	

}
