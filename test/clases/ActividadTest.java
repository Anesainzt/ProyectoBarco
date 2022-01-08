package clases;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ActividadTest {
	
	Actividad a1 = new Actividad();
	Actividad a2 = new Actividad("008","Natación",5,"Maria","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
	
	@Test
	void testGCodigo() {
		assertEquals("008", a2.getCodigo());
	}
	@Test
	void testSCodigo() {
	    String cod = "008";
	    a1.setCodigo(a2.getCodigo());
	    assertEquals(a1.getCodigo(), cod);
	}
	
	@Test
	void testGNombre() {
		assertEquals("Natación", a2.getNombre());
	}
	@Test
	void testSNombre() {
	    String nom = "Natación";
	    a1.setNombre(a2.getNombre());
	    assertEquals(a1.getNombre(), nom);
	}
	
	@Test
	void testGAforo() {
		assertEquals(5, a2.getAforo());
	}
	@Test
	void testSAforo() {
	    int af = 5;
	    a1.setAforo(a2.getAforo());
	    assertEquals(a1.getAforo(), af);
	}
	
	@Test
	void testGInstructor() {
		assertEquals("Maria", a2.getInstructor());
	}
	@Test
	void testSInstructor() {
	    String inst = "Maria";
	    a1.setInstructor(a2.getInstructor());
	    assertEquals(a1.getInstructor(), inst);
	}
	
	@Test
	void testGUbicacion() {
		assertEquals("En la piscina del barco", a2.getUbicacion());
	}
	@Test
	void testSUbicacion() {
	    String ubi = "En la piscina del barco";
	    a1.setUbicacion(a2.getUbicacion());
	    assertEquals(a1.getUbicacion(), ubi);
	    
	}
	
	@Test
	void testGDescripcion() {
		assertEquals("Curso de natacion para principiantes", a2.getDescripcion());
	}
	@Test
	void testSDescripcion() {
	    String desc = "Curso de natacion para principiantes";
	    a1.setDescripcion(a2.getDescripcion());
	    assertEquals(a1.getDescripcion(), desc);
	    
	}
	@Test
	void testGImagen() {
		assertEquals("pc.PNG", a2.getImagen());
	}
	@Test
	void testSImagen() {
	    String im = "pc.PNG";
	    a1.setImagen(a2.getImagen());
	    assertEquals(a1.getImagen(), im);
	    
	}

	
	
}
