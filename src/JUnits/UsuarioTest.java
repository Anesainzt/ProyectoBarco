package JUnits;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Clases.Usuario;

class UsuarioTest {

	Usuario u1 = new Usuario();
	Usuario u2 = new Usuario("","","","","","","");
	
	@Test
	void testGNombre() {
		assertEquals("", Usuario.getNombre());
	}
	
	@Test
	void testSNombre() {
	    String nombre = "";
	    u1.setNombre(u2.getNombre());
	    assertEquals(u1.getNombre(), nombre);
	}
	
	@Test
	void testGApellido() {
		assertEquals("", Usuario.getApellido());
	}
	
	@Test
	void testSApellido() {
	    String apellido = "";
	    u1.setApellido(u2.getApellido());
	    assertEquals(u1.getApellido(), apellido);
	}
	
	@Test
	void testGDni() {
		assertEquals("", Usuario.getDni());
	}
	
	@Test
	void testSDni() {
	    String dni = "";
	    u1.setDni(u2.getDni());
	    assertEquals(u1.getDni(), dni);
	}
	
	@Test
	void testGTarjeta() {
		assertEquals("", Usuario.getTarjeta());
	}
	
	@Test
	void testSTarjeta() {
	    String tarjeta = "";
	    u1.setTarjeta(u2.getTarjeta());
	    assertEquals(u1.getTarjeta(), tarjeta);
	}
	
	@Test
	void testGLogin() {
		assertEquals("", Usuario.getLogin());
	}
	
	@Test
	void testSLogin() {
	    String login = "";
	    u1.setLogin(u2.getLogin());
	    assertEquals(u1.getNombre(), login);
	}
	
	@Test
	void testGContrasenya() {
		assertEquals("", Usuario.getContrasenya());
	}
	
	@Test
	void testSContrasenya() {
	    String contra = "";
	    u1.setContrasenya(u2.getContrasenya());
	    assertEquals(u1.getContrasenya(), contra);
	}
	
	@Test
	void testGEmail() {
		assertEquals("", Usuario.getEmail());
	}
	
	@Test
	void testSEmail() {
	    String email = "";
	    u1.setEmail(u2.getEmail());
	    assertEquals(u1.getEmail(), email);
	}

}
