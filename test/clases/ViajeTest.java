package clases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ViajeTest {

	ArrayList<Actividad> listaActi;
	
	@Before
    public void SetUp() {
		
        listaActi =new ArrayList<Actividad>();
        
        Actividad a1 = new Actividad("008","Natación",5,"Maria","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
        Actividad a2 = new Actividad("009","Buceo",3,"Olatz","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
        
        listaActi.add(a1);
        listaActi.add(a2);

    }

	Viaje v1 = new Viaje();
	Viaje v2 = new Viaje("9109", "Bilbao", "Vigo","22-05-2022", 100, listaActi);
	
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
		assertEquals("22-05-2022", v2.getFecha());
	}
	@Test
	void testSFechaIda() {
	    String FI = "22-05-2022";
	    v1.setFecha(v2.getFecha());
	    assertEquals(v1.getFecha(), FI);
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
	
	@Test
	void testGListaActividades() {
		
		SetUp();
		Viaje v3 = new Viaje("", "", "","", 0, listaActi);
		assertEquals(listaActi, v3.getListaActividades());
		
	}
	@Test
	void testSListaActividades() {
	   
		ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();
	        
		Actividad a1 = new Actividad("008","Natación",5,"Maria","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
		Actividad a2 = new Actividad("009","Buceo",3,"Olatz","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
	        
        listaActividades.add(a1);
        listaActividades.add(a2);
		
        SetUp();
        
	    v1.setListaActividades(listaActi);
	    
	    
	    for (int i = 0; i < 2; i++) {
			
			System.out.println(listaActividades.get(i).getNombre());
			System.out.println(v1.getListaActividades().get(i).getNombre());
			assertEquals(listaActividades.get(i).getNombre(), v1.getListaActividades().get(i).getNombre());
			
			System.out.println(listaActividades.get(i).getCodigo());
			System.out.println(v1.getListaActividades().get(i).getCodigo());
			assertEquals(listaActividades.get(i).getCodigo(), v1.getListaActividades().get(i).getCodigo());
			
			System.out.println(listaActividades.get(i).getAforo());
			System.out.println(v1.getListaActividades().get(i).getAforo());
			assertEquals(listaActividades.get(i).getAforo(),v1.getListaActividades().get(i).getAforo());
			
			System.out.println(listaActividades.get(i).getInstructor());
			System.out.println(v1.getListaActividades().get(i).getInstructor());
			assertEquals(listaActividades.get(i).getInstructor(), v1.getListaActividades().get(i).getInstructor());
			
			System.out.println(listaActividades.get(i).getUbicacion());
			System.out.println(v1.getListaActividades().get(i).getUbicacion());
			assertEquals(listaActividades.get(i).getUbicacion(), v1.getListaActividades().get(i).getUbicacion());
			
			System.out.println(listaActividades.get(i).getDescripcion());
			System.out.println(v1.getListaActividades().get(i).getDescripcion());
			assertEquals(listaActividades.get(i).getDescripcion(), v1.getListaActividades().get(i).getDescripcion());
			
			System.out.println(listaActividades.get(i).getImagen());
			System.out.println(v1.getListaActividades().get(i).getImagen());
			assertEquals(listaActividades.get(i).getImagen(), v1.getListaActividades().get(i).getImagen());
		}
	    
	}
	
	
}
