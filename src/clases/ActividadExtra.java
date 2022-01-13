package clases;

public class ActividadExtra extends Actividad {
	protected int cantMat;

	public ActividadExtra(String codigo, String nombre, int aforo, String instructor, String ubicacion,
			String descripcion, String imagen, int precio, int cantMat) {
		this.cantMat = cantMat;
	}
	
	public ActividadExtra() {
		this.cantMat = 0;
	}

	public int getCantMat() {
		return cantMat;
	}

	public void setCantMat(int cantMat) {
		this.cantMat = cantMat;
	}
	

}
