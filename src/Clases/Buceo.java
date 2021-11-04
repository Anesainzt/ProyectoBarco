package Clases;

public class Buceo extends Actividad {
	
	protected static int cantBombonas;

	public Buceo(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen, int cantBombonas) {
		this.cantBombonas = cantBombonas;
	}
	
	public Buceo() {
		this.cantBombonas = 0;
	}

	public static int getCantBombonas() {
		return cantBombonas;
	}

	public void setCantBombonas(int cantBombonas) {
		this.cantBombonas = cantBombonas;
	}

	@Override
	public String toString() {
		return "Buceo [cantBombonas=" + cantBombonas + "]";
	}
	
	

}
