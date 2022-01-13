package clases;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Buceo;


class BuceoTest {

	Buceo bu = new Buceo();
	Buceo buc = new Buceo("BU009","Buceo",11,"Jorge","planta superior","aaaaaa","images/buceo1",5,13);
		
		@Test
		void getCantBombonas() {
			assertEquals(13, buc.getCantBombonas());
		}
		@Test
		void setCantBombonas() {
		    int cantidad = 13;
		    bu.setCantBombonas(buc.getCantBombonas());
		    assertEquals(bu.getCantBombonas(), cantidad);
		}
		
}
