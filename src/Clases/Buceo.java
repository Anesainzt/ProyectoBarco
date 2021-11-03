package Clases;

public class Buceo extends Actividad {
	
	protected int cantBombonas;

	public Buceo(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen, int cantBombonas) {
		super(codigo, nombre, aforo, instructor, ubicacion, descripcion, imagen);
		this.cantBombonas = cantBombonas;
	}
	
	public Buceo() {
		super();
		this.cantBombonas = 0;
	}

	public int getCantBombonas() {
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
