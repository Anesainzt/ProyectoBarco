package clases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class BilleteTest {
	ArrayList<Actividad> listaActi;

	@Before
	public void SetUp() {
		
	    listaActi =new ArrayList<Actividad>();
	    
	    Actividad a1 = new Actividad("008","Natación",5,"Maria","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
	    Actividad a2 = new Actividad("009","Buceo",3,"Olatz","En la piscina del barco","Curso de natacion para principiantes","pc.PNG");
	    
	    listaActi.add(a1);
	    listaActi.add(a2);
	
	}

	
	Billete b1 = new Billete();
	Billete b2 = new Billete("91jda09","9109", listaActi);
	
	
	@Test
	void testGLocalizadorBillete() {
		assertEquals("91jda09", b2.getLocalizadorBillete());
	}
	@Test
	void testSLocalizadorBillete() {
	    String lcbillete = "91jda09";
	    b1.setLocalizadorBillete(b2.getLocalizadorBillete());
	    assertEquals(b1.getLocalizadorBillete(), lcbillete);
	}
	@Test
	void testGLocalizadorViaje() {
		assertEquals("9109", b2.getLocalizadorViaje());
	}
	@Test
	void testSLocalizadorViaje() {
	    String lcviaje = "9109";
	    b1.setLocalizadorViaje(b2.getLocalizadorViaje());
	    assertEquals(b1.getLocalizadorViaje(), lcviaje);
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
        
	    b1.setListaActividades(listaActi);
	    
	    
	    for (int i = 0; i < 2; i++) {
			
			System.out.println(listaActividades.get(i).getNombre());
			System.out.println(b1.getListaActividades().get(i).getNombre());
			assertEquals(listaActividades.get(i).getNombre(), b1.getListaActividades().get(i).getNombre());
			
			System.out.println(listaActividades.get(i).getCodigo());
			System.out.println(b1.getListaActividades().get(i).getCodigo());
			assertEquals(listaActividades.get(i).getCodigo(), b1.getListaActividades().get(i).getCodigo());
			
			System.out.println(listaActividades.get(i).getAforo());
			System.out.println(b1.getListaActividades().get(i).getAforo());
			assertEquals(listaActividades.get(i).getAforo(),b1.getListaActividades().get(i).getAforo());
			
			System.out.println(listaActividades.get(i).getInstructor());
			System.out.println(b1.getListaActividades().get(i).getInstructor());
			assertEquals(listaActividades.get(i).getInstructor(), b1.getListaActividades().get(i).getInstructor());
			
			System.out.println(listaActividades.get(i).getUbicacion());
			System.out.println(b1.getListaActividades().get(i).getUbicacion());
			assertEquals(listaActividades.get(i).getUbicacion(), b1.getListaActividades().get(i).getUbicacion());
			
			System.out.println(listaActividades.get(i).getDescripcion());
			System.out.println(b1.getListaActividades().get(i).getDescripcion());
			assertEquals(listaActividades.get(i).getDescripcion(), b1.getListaActividades().get(i).getDescripcion());
			
			System.out.println(listaActividades.get(i).getImagen());
			System.out.println(b1.getListaActividades().get(i).getImagen());
			assertEquals(listaActividades.get(i).getImagen(), b1.getListaActividades().get(i).getImagen());
		}
	    
	}
	
	
	
}
