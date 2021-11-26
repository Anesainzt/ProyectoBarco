package clases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SkiTest {
	
	Ski s = new Ski();
	Ski sk = new Ski("","",5,"","","","",4);
		
		@Test
		void getCantSkis() {
			assertEquals(4, Ski.getCantSkis());
		}
		
		@Test
		void setCantSkis() {
		    int cantidad = 4;
		    s.setCantSkis(sk.getCantSkis());
		    assertEquals(s.getCantSkis(), cantidad);
		}


		
}
