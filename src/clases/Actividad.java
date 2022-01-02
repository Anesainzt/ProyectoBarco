package clases;

public class Actividad {
	
	protected String codigo;
	protected String nombre;
	protected int aforo;
	protected String instructor; //nombre del instructor/a
	protected String ubicacion;
	protected String descripcion; 
	protected String imagen;
	

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
