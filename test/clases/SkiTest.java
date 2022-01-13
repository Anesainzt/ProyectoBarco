package clases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SkiTest {
	
	Ski s = new Ski();
	Ski sk = new Ski("SK009","Ski",8,"Mario","Pirineos","Clases para principiantes","images/ski2",5,10);
		
		@Test
		void getCantSkis() {
			assertEquals(10, sk.getCantSkis());
		}
		
		@Test
		void setCantSkis() {
		    int cantidad = 10;
		    s.setCantSkis(sk.getCantSkis());
		    assertEquals(s.getCantSkis(), cantidad);
		}


		
}
