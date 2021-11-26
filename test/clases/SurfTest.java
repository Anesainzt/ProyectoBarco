package clases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SurfTest {
	Surf s1 = new Surf();
	Surf s2 = new Surf("","",0, "","","","",4);
	
	@Test
	void getCantTablas() {
		assertEquals(4, Surf.getCantTablas());
	}
	
	@Test
	void setCantTablas() {
	    int cantidad = 4;
	    s1.setCantTablas(s2.getCantTablas());
	    assertEquals(s1.getCantTablas(), cantidad);
	}
	
}
