package BD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import clases.Usuario;



class BDTest {

	Usuario u1 = new Usuario("a", "a", "a", "a", "a", "a", "a", null);
	Usuario u2 = new Usuario("a", "a", "a", "a", "b", "a", "a", null);
	

	@Test
	void existeUsuarioTest() {
	}
	
	@Test
	void compararLoginTest() {
		BD bd = new BD();
		System.out.println(u1.getLogin());
		bd.connect();
		boolean existeu1 = false;
		try {
			existeu1 = bd.compararLogin(u1);
			System.out.println(existeu1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean existeu2 = false;
		try {
			existeu2 = bd.compararLogin(u2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, existeu1);
		assertEquals(false, existeu2);
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
