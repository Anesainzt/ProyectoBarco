package clases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ViajeTest {

	ArrayList<Actividad> listaActi;
	
	@Before
    public void SetUp() {
		
        listaActi =new ArrayList<Actividad>();
        

        Actividad a1 = new Actividad();
        Actividad a2 = new Actividad();
        Actividad a3 = new Actividad();

        listaActi.add(a1);
        listaActi.add(a2);
        listaActi.add(a3);

    }

	Viaje v1 = new Viaje();
	Viaje v2 = new Viaje("9109", "Bilbao", "Vigo","22-05-2022","30-05-2022", 100, listaActi);
	
	@Test
	void testGLocalizador() {
		assertEquals("9109", v2.getLocalizador());
	}
	@Test
	void testSLocalizador() {
	    String lc = "9109";
	    v1.setLocalizador(v2.getLocalizador());
	    assertEquals(v1.getLocalizador(), lc);
	}
	
	@Test
	void testGOrigen() {
		assertEquals("Bilbao", v2.getOrigen());
	}
	@Test
	void testSOrigen() {
	    String orig = "Bilbao";
	    v1.setOrigen(v2.getOrigen());
	    assertEquals(v1.getOrigen(), orig);
	}
	
	@Test
	void testGDestino() {
		assertEquals("Vigo", v2.getDestino());
	}
	@Test
	void testSDestino() {
	    String dest = "Vigo";
	    v1.setDestino(v2.getDestino());
	    assertEquals(v1.getDestino(), dest);
	}
	
	@Test
	void testGFechaIda() {
		assertEquals("22-05-2022", v2.getFechaIda());
	}
	@Test
	void testSFechaIda() {
	    String FI = "22-05-2022";
	    v1.setFechaIda(v2.getFechaIda());
	    assertEquals(v1.getFechaIda(), FI);
	}
	@Test
	void testGFechaVuelta() {
		assertEquals("30-05-2022", v2.getFechaVuelta());
	}
	@Test
	void testSFechaVuelta() {
	    String FV = "30-05-2022";
	    v1.setFechaVuelta(v2.getFechaVuelta());
	    assertEquals(v1.getFechaVuelta(), FV);
	}
	
	@Test
	void testGAforo() {
		assertEquals(100, v2.getAforo());
	}
	@Test
	void testSAforo() {
	    int af = 100;
	    v1.setAforo(v2.getAforo());
	    assertEquals(v1.getAforo(), af);
	}
	
}
