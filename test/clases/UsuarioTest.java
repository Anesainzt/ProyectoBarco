package clases;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Usuario;

class UsuarioTest {
	
	List<Billete> listaBilletes;
	List<Actividad> listaActi;
	
	void SetUp() {
		
       listaBilletes =new ArrayList<Billete>();
       listaActi =new ArrayList<Actividad>();
       
       Actividad a1 = new Actividad("008","Natación",5,"Maria","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
       Actividad a2 = new Actividad("009","Buceo",3,"Olatz","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
       
       listaActi.add(a1);
       listaActi.add(a2);
       
       Billete b1 = new Billete("7487a", "986980f", listaActi);
       Billete b2 = new Billete("7487ss", "214131f", listaActi);
        
        
       listaBilletes.add(b1);
       listaBilletes.add(b2);

    }

	Usuario u1 = new Usuario();
	Usuario u2 = new Usuario("Iker","Martinez","67780775Y","1234123412341234","imartinez","12345A","imartinez@gmail.com",0, listaBilletes);
	
	@Test
	void testGNombre() {
		assertEquals("Iker", u2.getNombre());
	}
	
	@Test
	void testSNombre() {
	    String nombre = "Iker";
	    u1.setNombre(u2.getNombre());
	    assertEquals(u1.getNombre(), nombre);
	}
	
	@Test
	void testGApellido() {
		assertEquals("Martinez", u2.getApellido());
	}
	
	@Test
	void testSApellido() {
	    String apellido = "Martinez";
	    u1.setApellido(u2.getApellido());
	    assertEquals(u1.getApellido(), apellido);
	}
	
	@Test
	void testGDni() {
		assertEquals("67780775Y", u2.getDni());
	}
	
	@Test
	void testSDni() {
	    String dni = "67780775Y";
	    u1.setDni(u2.getDni());
	    assertEquals(u1.getDni(), dni);
	}
	
	@Test
	void testGTarjeta() {
		assertEquals("1234123412341234", u2.getTarjeta());
	}
	
	@Test
	void testSTarjeta() {
	    String tarjeta = "1234123412341234";
	    u1.setTarjeta(u2.getTarjeta());
	    assertEquals(u1.getTarjeta(), tarjeta);
	}
	
	@Test
	void testGLogin() {
		assertEquals("imartinez", u2.getLogin());
	}
	
	@Test
	void testSLogin() {
	    String login = "imartinez";
	    u1.setLogin(u2.getLogin());
	    assertEquals(u1.getLogin(), login);
	}
	
	@Test
	void testGContrasenya() {
		assertEquals("12345A", u2.getContrasenya());
	}
	
	@Test
	void testSContrasenya() {
	    String contra = "12345A";
	    u1.setContrasenya(u2.getContrasenya());
	    assertEquals(u1.getContrasenya(), contra);
	}
	
	@Test
	void testGEmail() {
		assertEquals("imartinez@gmail.com", u2.getEmail());
	}
	
	@Test
	void testSEmail() {
	    String email = "imartinez@gmail.com";
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
	@Test
	void testGListaBilletes() {
		
		SetUp();
		Usuario u3 = new Usuario("","","","","","","",0, listaBilletes);
		assertEquals(listaBilletes, u3.getListaBilletes());
		
	}
	@Test
	void testSListaBilletes() {
	   
		ArrayList<Billete> listaBillete = new ArrayList<Billete>();
	        
		SetUp();
		
		Billete b1 = new Billete("7487a", "986980f", listaActi);
	    Billete b2 = new Billete("7487ss", "214131f", listaActi);
	    
        listaBillete.add(b1);
        listaBillete.add(b2);
		
        
	    u1.setListaBilletes(listaBilletes);
	    
	    
	    for (int i = 0; i < 2; i++) {
			
			System.out.println(listaBillete.get(i).getLocalizadorBillete());
			System.out.println(u1.getListaBilletes().get(i).getLocalizadorBillete());
			assertEquals(listaBillete.get(i).getLocalizadorBillete(), u1.getListaBilletes().get(i).getLocalizadorBillete());
			
			System.out.println(listaBillete.get(i).getLocalizadorViaje());
			System.out.println(u1.getListaBilletes().get(i).getLocalizadorViaje());
			assertEquals(listaBillete.get(i).getLocalizadorViaje(),u1.getListaBilletes().get(i).getLocalizadorViaje());
			
			System.out.println(listaBillete.get(i).getListaActividades());
			System.out.println(u1.getListaBilletes().get(i).getListaActividades());
			assertEquals(listaBillete.get(i).getListaActividades(),u1.getListaBilletes().get(i).getListaActividades());
			
			
		}
	    
	}
	

}
