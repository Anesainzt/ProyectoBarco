package Clases;

public class Ski extends Actividad {
	
	protected int cantSkis;

	public Ski(String codigo, String nombre, int aforo, String instructor, String ubicacion, int cantSkis) {
		super(codigo, nombre, aforo, instructor, ubicacion);
		this.cantSkis = cantSkis;
	}
	
	public Ski() {
		super();
		this.cantSkis = 0;
	}

	public int getCantSkis() {
		return cantSkis;
	}

	public void setCantSkis(int cantSkis) {
		this.cantSkis = cantSkis;
	}

	@Override
	public String toString() {
		return "Ski [cantSkis=" + cantSkis + "]";
	}
	
	

}
