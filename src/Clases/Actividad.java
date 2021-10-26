package Clases;

public abstract class Actividad {
	
	protected String codigo;
	protected String nombre;
	protected int aforo;
	protected String instructor; //nombre del instructor/a
	protected String ubicacion;
	
	public Actividad(String codigo, String nombre, int aforo, String instructor, String ubicacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.aforo = aforo;
		this.instructor = instructor;
		this.ubicacion = ubicacion;
	}
	
	public Actividad() {
		super();
		this.codigo = "";
		this.nombre = "";
		this.aforo = 0;
		this.instructor = "";
		this.ubicacion = "";
	}

	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Actividad [codigo=" + codigo + ", nombre=" + nombre + ", aforo=" + aforo + ", instructor=" + instructor
				+ ", ubicacion=" + ubicacion + "]";
	}
}
