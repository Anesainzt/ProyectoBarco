package clases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SurfTest {
	Surf s1 = new Surf();
	Surf s2 = new Surf("SU009","Surf",15,"Alex","Planta inferior","Clases","images/surf2",14,100);
	
	@Test
	void getCantTablas() {
		assertEquals(100, s2.getCantTablas());
	}
	
	@Test
	void setCantTablas() {
	    int cantidad = 100;
	    s1.setCantTablas(s2.getCantTablas());
	    assertEquals(s1.getCantTablas(), cantidad);
	}
	
}
