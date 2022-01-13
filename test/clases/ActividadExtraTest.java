package clases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ActividadExtraTest {
	
	

		ActividadExtra ae1 = new ActividadExtra();
		ActividadExtra ae2 = new ActividadExtra("EX009","Natación",10,"Maria","Piscina","curso para principiantes","images/ski2",4,4);
			
		@Test
		void getCantBombonas() {
			assertEquals(4, ae2.getCantMat());
		}
		@Test
		void setCantBombonas() {
		    int cantidad = 4;
		    ae1.setCantMat(ae2.getCantMat());
		    assertEquals(ae1.getCantMat(), cantidad);
		}
}
