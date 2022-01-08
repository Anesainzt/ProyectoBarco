package BD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import clases.Usuario;



class BDTest {

	Usuario u1 = new Usuario("a", "a", "a", "a", "a", "a", "a",1, null);
	Usuario u2 = new Usuario("a", "a", "a", "a", "b", "a", "a",0, null);
	

	@Test
	void existeUsuarioTest() {
	}
	
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
	void esAdministrador() {
		
	}
	
	@Test
	void borrarUsuario() {
		
	}
	
	@Test
	void crearUsuario(){

    }
	
	@Test
	void getuActual() {
		
	}
	
	@Test
	void setuActual() {
		
	}
	
	@Test
	void editarUsuario() {
		
	}
	
	@Test
	void comprobarLogin() {
		
	}
	
	@Test
	void registrarCantidad() {
		
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
