package BD;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import clases.Usuario;


class BDTest {

	Usuario u1 = new Usuario("a", "a", "a", "a", "a", "a", "a",1, null);
	Usuario u2 = new Usuario("a", "a", "13722311Y", "a", "b", "a", "a",0, null);
	Usuario u3 = new Usuario("olatz","arenas","876567822y","1111111111111112", "o","o","olatz@gadlkf.com", 0, null);
	Usuario u4 = new Usuario();
	
	
	

	@Test
	void compararLoginTest() {
		BD bd = new BD();
		bd.connect();
		boolean existeu1 = false;
		try {
			existeu1 = bd.compararLogin(u1);
		} catch (Exception e) {
		}
		boolean existeu2 = false;
		try {
			existeu2 = bd.compararLogin(u2);
		} catch (Exception e) {
		}
		assertEquals(true, existeu1);
		assertEquals(false, existeu2);
		bd.disconnect();
	}
	
	@Test
	void testComprobarLogin() {
		BD bd = new BD();
		bd.connect();
		boolean existeu1 = false;
		try {
			existeu1 = bd.comprobarLogin(u1.getLogin(), u1.getContrasenya());
		} catch (Exception e) {
		}
		
		assertEquals(true, existeu1);
		bd.disconnect();
	}
	
	@Test
	void testEsAdministrador() {
		BD bd = new BD();
		bd.connect();
		boolean esAdmin1 = false;
		try {
			esAdmin1 = bd.esAdministrador(u1.getDni());
		} catch (Exception e) {
		}
		boolean esAdmin2 = false;
		try {
			esAdmin2 = bd.esAdministrador(u2.getDni());
		} catch (Exception e) {
		}
		assertEquals(true, esAdmin1);
		assertEquals(false, esAdmin2);
		bd.disconnect();
		
	}
	
	@Test
	public void testGetActividades() {
		BD bd = new BD();
		bd.connect();
		assertNotNull(bd.getActividades());
	}
	
	
	@Test
	public void testGetUsuarios() {
		BD bd = new BD();
		bd.connect();
		assertNotNull(bd.getUsuarios());
	}
	
	@Test
	public void testGetUActual() {
		BD bd = new BD();
		bd.connect();
		assertNotNull(bd.getuActual());
	}
	
	@Test
	void testSUactual() {
		BD bd = new BD();
		bd.connect();
		bd.setuActual(u4);
		assertEquals(bd.getuActual(), u4);
	}
	
	@Test
	void usuarioTest() {
		
	}
	
	@Test
	void historial() {
		
	}
	
	@Test
	void reservaActividad() {
		
	}
	
	@Test
	void actividad() {
		
	}
	
	@Test
	void getListaSki() {
		
	}
}
