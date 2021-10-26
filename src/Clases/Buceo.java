package Clases;

public class Buceo extends Actividad {
	
	protected int cantBonbonas;

	public Buceo(String codigo, String nombre, int aforo, String instructor, String ubicacion, int cantBonbonas) {
		super(codigo, nombre, aforo, instructor, ubicacion);
		this.cantBonbonas = cantBonbonas;
	}
	
	public Buceo() {
		super();
		this.cantBonbonas = 0;
	}

	public int getCantBonbonas() {
		return cantBonbonas;
	}

	public void setCantBonbonas(int cantBonbonas) {
		this.cantBonbonas = cantBonbonas;
	}

	@Override
	public String toString() {
		return "Buceo [cantBonbonas=" + cantBonbonas + "]";
	}
	
	

}
