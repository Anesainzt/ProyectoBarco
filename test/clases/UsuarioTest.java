package clases;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Usuario;

class UsuarioTest {

	Usuario u1 = new Usuario();
	Usuario u2 = new Usuario("","","","","","","",0, null);
	
	@Test
	void testGNombre() {
		assertEquals("", u2.getNombre());
	}
	
	@Test
	void testSNombre() {
	    String nombre = "";
	    u1.setNombre(u2.getNombre());
	    assertEquals(u1.getNombre(), nombre);
	}
	
	@Test
	void testGApellido() {
		assertEquals("", u2.getApellido());
	}
	
	@Test
	void testSApellido() {
	    String apellido = "";
	    u1.setApellido(u2.getApellido());
	    assertEquals(u1.getApellido(), apellido);
	}
	
	@Test
	void testGDni() {
		assertEquals("", u2.getDni());
	}
	
	@Test
	void testSDni() {
	    String dni = "";
	    u1.setDni(u2.getDni());
	    assertEquals(u1.getDni(), dni);
	}
	
	@Test
	void testGTarjeta() {
		assertEquals("", u2.getTarjeta());
	}
	
	@Test
	void testSTarjeta() {
	    String tarjeta = "";
	    u1.setTarjeta(u2.getTarjeta());
	    assertEquals(u1.getTarjeta(), tarjeta);
	}
	
	@Test
	void testGLogin() {
		assertEquals("", u2.getLogin());
	}
	
	@Test
	void testSLogin() {
	    String login = "";
	    u1.setLogin(u2.getLogin());
	    assertEquals(u1.getNombre(), login);
	}
	
	@Test
	void testGContrasenya() {
		assertEquals("", u2.getContrasenya());
	}
	
	@Test
	void testSContrasenya() {
	    String contra = "";
	    u1.setContrasenya(u2.getContrasenya());
	    assertEquals(u1.getContrasenya(), contra);
	}
	
	@Test
	void testGEmail() {
		assertEquals("", u2.getEmail());
	}
	
	@Test
	void testSEmail() {
	    String email = "";
	    u1.setEmail(u2.getEmail());
	    assertEquals(u1.getEmail(), email);
	}
	
	@Test
	void testGAdmin() {
		assertEquals(0, u2.getAdministrador());
	}
	
	@Test
	void testSAdmin() {
	   int admin = 0;
	    u1.setAdministrador(u2.getAdministrador());
	    assertEquals(u1.getAdministrador(), admin);
	}

}
