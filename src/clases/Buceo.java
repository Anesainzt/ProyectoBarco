package clases;

public class Buceo extends Actividad {
	
	protected int cantBombonas;

	public Buceo(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen, int precio, int cantBombonas) {
		this.cantBombonas = cantBombonas;
	}
	
	public Buceo() {
		this.cantBombonas = 0;
	}

	public int getCantBombonas() {
		return cantBombonas;
	}

	public void setCantBombonas(int cantBombonas) {
		this.cantBombonas = cantBombonas;
	}
}
