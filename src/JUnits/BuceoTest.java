package JUnits;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Clases.Buceo;


class BuceoTest {

	Buceo bu = new Buceo();
	Buceo buc = new Buceo("","",5,"","","","",4);
		
		@Test
		void getCantBombonas() {
			assertEquals(4, Buceo.getCantBombonas());
		}
		@Test
		void setCantBombonas() {
		    int cantidad = 4;
		    bu.setCantBombonas(buc.getCantBombonas());
		    assertEquals(bu.getCantBombonas(), cantidad);
		}
		
}
