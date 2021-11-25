package clases;

public class Surf extends Actividad {

	protected int cantTablas;

	public Surf(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen, int cantTablas) {
		super(codigo, nombre, aforo, instructor, ubicacion, descripcion);
		this.cantTablas = cantTablas;
	}
	
	public Surf() {
		super();
		this.cantTablas = 0;
	}

	public int getCantTablas() {
		return cantTablas;
	}

	public void setCantTablas(int cantTablas) {
		this.cantTablas = cantTablas;
	}

	@Override
	public String toString() {
		return "Surf [cantTablas=" + cantTablas + "]";
	}
	
	
	
	
	
	
}