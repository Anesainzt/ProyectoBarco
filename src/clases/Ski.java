package clases;

public class Ski extends Actividad {
	
	protected int cantSkis;

	public Ski(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen, int cantSkis) {
		super(codigo, nombre, aforo, instructor, ubicacion, descripcion);
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
}
