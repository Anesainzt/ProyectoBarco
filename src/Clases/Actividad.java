package Clases;

public abstract class Actividad {
	
	//QUITAR ABSTRACT?? ->Si no es abstracta se pone static y se podria hacer junit (Abstract != Herencia)
	protected static String codigo;
	protected static String nombre;
	protected static int aforo;
	protected static String instructor; //nombre del instructor/a
	protected static String ubicacion;
	protected static String descripcion; 
	protected static String imagen; //Porque hay un String de imagen?
	
	public Actividad(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.aforo = aforo;
		this.instructor = instructor;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	
	public Actividad() {
		super();
		this.codigo = "";
		this.nombre = "";
		this.aforo = 0;
		this.instructor = "";
		this.ubicacion = "";
		this.descripcion = "";
		this.imagen = "";
	}

	public static String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public static String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public static String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public static String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen= imagen;
	}

	@Override
	public String toString() {
		return "Actividad [codigo=" + codigo + ", nombre=" + nombre + ", aforo=" + aforo + ", instructor=" + instructor
				+ ", ubicacion=" + ubicacion + ", descripcion=" + descripcion + ", imagen=" + imagen + "]";
	}
	
}
